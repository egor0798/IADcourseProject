import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HttpClient, HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { TechComponent } from './tech/tech.component';
import { UnitsComponent } from './units/units.component';
import { WondersComponent } from './wonders/wonders.component';
import { NationsComponent } from './nations/nations.component';
import { RanksComponent } from './ranks/ranks.component';
import { FeedComponent } from './feed/feed.component';

const childRoutes: Routes = [
  {
    path: 'feed', component: FeedComponent
  },
  {
    path: 'tech', component: TechComponent
  },
  {
    path: 'units', component: UnitsComponent
  },
  {
    path: 'nations', component: NationsComponent
  },
  {
    path: 'ranks', component: RanksComponent
  },
  {
    path: 'wonders', component: WondersComponent
  }
];
const routes: Routes = [
  {
    path: 'home', component: HomeComponent, children: childRoutes
  },
  {
    path: '**', redirectTo: '/home/feed', pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    FeedComponent,
    HomeComponent,
    TechComponent,
    UnitsComponent,
    WondersComponent,
    NationsComponent,
    RanksComponent,
    FeedComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
