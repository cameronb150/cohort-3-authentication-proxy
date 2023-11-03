import { Injectable } from '@angular/core';
import { HttpParams, HttpHeaders, HttpClient } from "@angular/common/http";
import { Router } from '@angular/router';

type LoginResponse = {
    location: Location | (string & Location)
}

@Injectable({
  providedIn: 'root'
})
export class AccountsService {

      constructor(private http: HttpClient, private router: Router) { }
      public login(username: string, password: string): void {
        const data = new FormData();
        data.append('username', username);
        data.append('password', password);
        this.http.post("/process-login", data)
            .subscribe(
                () => { /** this will be run due to 302 redirect **/ },
                ({ url }) => {
//                     if (url.endsWith('?error=true')) {
//                         console.log('there was an error signing in');
//                         return;
//                     }
                    window.location = url;
                });
      }
}
