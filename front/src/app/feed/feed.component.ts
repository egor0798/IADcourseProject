///<reference path="../../../node_modules/@angular/core/src/metadata/directives.d.ts"/>
import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {
  posts: Post[] = [];
  constructor(private http: HttpClient) { }
  //TODO обновлять ленту, если в родительском компоненте юзер залогинился
  ngOnInit() {
    this.http.get('http://localhost:8080/user/getall').subscribe((data: User[]) => {
      data.forEach((user) => {
        this.http.get('https://graph.facebook.com/' + user.facebook + '/picture?height=100&width=100&redirect=false')
          .subscribe((resp: any) => {
            user.img_url = resp.data.url;
          });
        this.http.get('https://graph.facebook.com/' + user.facebook + '/posts?access_token=' + user.token)
          .subscribe((userposts: any) => {
            userposts.data.forEach((post) => {
              if (post.message  && (post.message.indexOf('#civ\n') !== -1 || post.message.indexOf('#civ ') !== -1)) {
                post.message = post.message.replace('#civ ', '');
                post.message = post.message.replace('#civ\n', '');
                this.posts.push(new Post(user, post.message, post.created_time));
                debugger;
              }
            });
            this.posts.sort((b, a) => {
              return a.time.getTime() - b.time.getTime();
            });
          });
      });
    });
  }
}

class Post {
  user: User;
  message: string;
  time: Date;
  constructor(usr: User, msg: string, tm: string) {
    this.user = usr;
    this.message = msg;
    this.time = new Date(tm);
  }
}


class User {
  username: string;
  facebook: string;
  token: string;
  img_url: string;
}

