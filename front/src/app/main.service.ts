import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class MainService {
  constructor(private httpClient: HttpClient) {
  }

  public get(url: string): Observable<any> {
    return this.httpClient.get(url);
  }
}
