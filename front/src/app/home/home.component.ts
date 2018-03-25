import {ApplicationRef, ChangeDetectorRef, Component, ElementRef, ViewChild} from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import {MainService} from '../main.service';

declare var window: any;
declare var FB: any;
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  public user: User = new User();
  img_url: string;
  @ViewChild('mda') mda: ElementRef;

  increase(): void {}
  constructor(private http: HttpClient) {
    // метод для создания фейсбуковской кнопки
    (function(d, s, id) {
      let js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) {return; }
      js = d.createElement(s); js.id = id;
      js.src = '//connect.facebook.net/en_US/sdk.js';
      fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));


    window.fbAsyncInit = () => {
      // кофигурация фейсбука
      FB.init({
        appId            : '202537560336731',
        autoLogAppEvents : true,
        status           : true,
        xfbml            : true,
        version          : 'v2.12',
        scope            : 'user_posts'
      });
      FB.AppEvents.logPageView();
      FB.Event.subscribe('auth.statusChange', (response => {
        this.increase();
        console.log('status changed:');
        if (response.status === 'connected') {
          console.log('connected');
          this.http.get('http://graph.facebook.com/' + response.authResponse.userID + '/picture?height=30&width=30&redirect=false')
            .subscribe((resp: any) => {
              this.img_url = resp.data.url;
              this.mda.nativeElement.click();
              console.log(this.img_url);
            });
          FB.api('/me', (resp => {
            console.log('getting frofile infromation');
            this.user.username = resp.name;
            this.mda.nativeElement.click();
            this.user.facebook = response.authResponse.userID;
            const p = new HttpParams().set('username', resp.name)
              .set('id', response.authResponse.userID).set('token', response.authResponse.accessToken);
            http.get('http://localhost:8080/user/save', {params: p}).subscribe(() => console.log('saving user'));
          }));
        } else {
          console.log('disconnected');
          console.log(JSON.stringify(response));
          this.http.delete('http://localhost:8080/user/logout/' + this.user.facebook).subscribe( () => console.log('deleting user'));
          this.user = new User();
          this.img_url = null;
          this.mda.nativeElement.click();
        }
      }));
    };
  }
}

class User {
  username: string;
  facebook: string;
  constructor() {}
}
