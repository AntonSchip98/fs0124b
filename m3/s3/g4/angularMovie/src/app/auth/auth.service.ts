import { IUser } from './../Interface/i-user';
import { Injectable } from '@angular/core';

import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, Observable, map, of, tap } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ILogData } from '../Interface/i-log-data';
import { IMovie } from '../Interface/i-movie';

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
  userUrl: string = environment.usersUrl;

  syncIsLoggedIn: boolean = false;

  apiUrl!: string;

  jwtHelper: JwtHelperService = new JwtHelperService();

  authSubject = new BehaviorSubject<IUser | null>(null);

  user$ = this.authSubject.asObservable();

  isLoggedIn$ = this.user$.pipe(
    map((user) => !!user),
    tap((user) => (this.syncIsLoggedIn = user))
  );

  isUserRegisteredSubject = new BehaviorSubject<boolean>(false);
  isUserRegistered$ = this.isUserRegisteredSubject.asObservable();

  constructor(private http: HttpClient, private router: Router) {}

  register(newUser: Partial<IUser>): Observable<AccessData> {
    return this.http.post<AccessData>(this.registerUrl, newUser).pipe(
      tap((data) => {
        this.authSubject.next(data.user);
        localStorage.setItem('accessData', JSON.stringify(data));

        this.autoLogout(data.accessToken);

        this.isUserRegisteredSubject.next(true);
      })
    );
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

  getAll() {
    return this.http.get<IUser[]>(this.userUrl);
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

  // UPDATE DELL USER
  updateUser(user: IUser): Observable<IUser> {
    return this.http.patch<IUser>(`${this.userUrl}/${user.id}`, user);
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

  addToFavorites(movie: IMovie, user: IUser): Observable<IUser> {
    if (!user.favourites.some((movieFav) => movieFav.id === movie.id)) {
      user.favourites.push(movie);
      return this.updateUser(user);
    }

    return new Observable<IUser>();
  }

  updateMovie(movie: IMovie): Observable<IMovie> {
    return this.http.put<IMovie>(`${this.apiUrl}/${movie.id}`, movie);
  }

  removeFromFavorites(movieId: number, user: IUser): Observable<IUser> {
    user.favourites = user.favourites.filter((movie) => movie.id !== movieId);
    return this.updateUser(user);
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
