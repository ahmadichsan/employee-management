// Lib
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

// Models
import { User } from '../../models/user';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient,
  ) { }

  public login(userInfo: User){
    return new Promise((resolve, reject) => {
      try {
        console.log(userInfo)
        const { email, password } = userInfo;
        const body = { username: email, password }
        this.http.post('http://localhost:4000/users/authenticate', body, httpOptions).subscribe((data: any) => {
          console.log('res: ', data);
          localStorage.setItem('ACCESS_TOKEN', data.token);
          resolve('ok');
        })
      } catch (e) {
        console.log('reason why login in authService error is: ', e);
        reject(e);
      }
    })
  }

  public isLoggedIn(){
    return localStorage.getItem('ACCESS_TOKEN') !== null;

  }

  public logout(){
    localStorage.removeItem('ACCESS_TOKEN');
  }
}
