import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url= 'http://127.0.0.1:9093/';
  constructor(private http: HttpClient) { 
  }
  signup(user:any){


    return this.http.post(this.url +'api/auth/signup', user);
  }
  signin(user:any){
    console.log(user);

    return this.http.post(this.url +'api/auth/signin', user);
  }
}
