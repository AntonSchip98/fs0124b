import { Injectable } from '@angular/core';
import { IUser } from '../Interface/i-user';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, Observable, map, tap } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ILogData } from '../Interface/i-log-data';

type AccessData = {
  accessToken: string;
  user: IUser;
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  registerUrl: string = environment.registerUrl;
  loginUrl: string = environment.loginUrl;

  syncIsLoggedIn: boolean = false;

  jwtHelper: JwtHelperService = new JwtHelperService();

  authSubject = new BehaviorSubject<IUser | null>(null);

  user$ = this.authSubject.asObservable();

  isLoggedIn$ = this.user$.pipe(
    map((user) => !!user),
    tap((user) => (this.syncIsLoggedIn = user))
  );

  constructor(private http: HttpClient, private router: Router) {}

  register(newUser: Partial<IUser>): Observable<AccessData> {
    return this.http.post<AccessData>(this.registerUrl, newUser);
  }

  login(loginData: ILogData): Observable<AccessData> {
    return this.http.post<AccessData>(this.loginUrl, loginData).pipe(
      tap((data) => {
        this.authSubject.next(data.user);
        localStorage.setItem('accessData', JSON.stringify(data));

        this.autoLogout(data.accessToken);
      })
    );
  }

  logout() {
    this.authSubject.next(null);
    localStorage.removeItem('accessData');

    this.router.navigate(['/']);
  }

  autoLogout(jwt: string) {
    const expDate = this.jwtHelper.getTokenExpirationDate(jwt) as Date;
    const expMs = expDate.getTime() - new Date().getTime();

    setTimeout(() => {
      this.logout();
    }, expMs);
  }

  restoreUser() {
    const userJson = localStorage.getItem('accessData');
    if (!userJson) return;

    const accessData: AccessData = JSON.parse(userJson);
    if (this.jwtHelper.isTokenExpired(accessData.accessToken)) return;

    this.authSubject.next(accessData.user);
    this.autoLogout(accessData.accessToken);
  }

  getAccessToken(): string {
    const userJson = localStorage.getItem('accessData');
    if (!userJson) return '';

    const accessData: AccessData = JSON.parse(userJson);
    if (this.jwtHelper.isTokenExpired(accessData.accessToken)) return '';

    return accessData.accessToken;
  }

  errors(err: any) {
    switch (err.error) {
      case 'Email and Password are required':
        return new Error('Email e password obbligatorie');
        break;
      case 'Email already exists':
        return new Error('Utente esistente');
        break;
      case 'Email format is invalid':
        return new Error('Email scritta male');
        break;
      case 'Cannot find user':
        return new Error('utente inesistente');
        break;
      default:
        return new Error('Errore');
        break;
    }
  }
}
