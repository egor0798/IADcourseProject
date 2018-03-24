import { Component, OnChanges, DoCheck, AfterViewInit} from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
declare var window: any;
declare var FB: any;
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  FB: any;
  logged: boolean = false;
  user: User = new User();
  constructor(private http: HttpClient) {
    (function(d, s, id) {
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) {return; }
      js = d.createElement(s); js.id = id;
      js.src = '//connect.facebook.net/en_US/sdk.js';
      fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));


    window.fbAsyncInit = () => {

      FB.init({
        appId            : '202537560336731',
        autoLogAppEvents : true,
        xfbml            : true,
        version          : 'v2.12',
        scope            : 'user_posts'
      });
      FB.AppEvents.logPageView();
      FB.Event.subscribe('auth.statusChange', (response => {
        if (response.status === 'connected') {
          this.logged = true;
          this.http.get('https://graph.facebook.com/' + response.authResponse.userID + '/picture?height=20&width=20&redirect=false')
            .subscribe((resp: any) => {
              this.user.img_url = resp.data.url;
            });
          FB.api('/me', (resp => {
            this.user.username = resp.name;
            this.user.facebook = response.authResponse.userID;
            const p = new HttpParams().set('username', resp.name)
              .set('id', response.authResponse.userID).set('token', response.authResponse.accessToken);
            http.get('http://localhost:8080/user/save', {params: p}).subscribe(() => console.log('LOGGED USER: \n' + this.logged + '|||||') );
          }));
        }
      }));
    };
  }
}

class User {
  username: string;
  facebook: string;
  img_url: string;
  constructor() {}
}
