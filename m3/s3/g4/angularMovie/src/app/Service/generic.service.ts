import { BehaviorSubject, Observable, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IMovie } from '../Interface/i-movie';
import { environment } from '../../environments/environment.development';
import { JwtHelperService } from '@auth0/angular-jwt';
import { IUser } from '../Interface/i-user';

@Injectable({
  providedIn: 'root',
})
export class GenericService {
  movieUrl: string = environment.moviesUrl;
  userUrl: string = environment.usersUrl;

  movieArr: IMovie[] = [];

  jwtHelper: JwtHelperService = new JwtHelperService();

  movieSubject = new BehaviorSubject<IMovie[]>([]);

  movie$ = this.movieSubject.asObservable();

  constructor(private http: HttpClient) {
    this.getAll().subscribe((data) => {
      this.movieSubject.next(data);
      this.movieArr = data;
    });
  }

  getAll() {
    return this.http.get<IMovie[]>(this.movieUrl);
  }

  getById(id: number) {
    return this.movieArr.find((m) => m.id == id);
  }

  create(newMovie: Partial<IMovie>) {
    return this.http.post<IMovie>(this.movieUrl, newMovie).pipe(
      tap((movie) => {
        this.movieArr.push(movie);
        this.movieSubject.next(this.movieArr);
      })
    );
  }

  delete(id: number) {
    return this.http.delete<IMovie>(this.movieUrl + '/' + id).pipe(
      tap(() => {
        this.movieArr = this.movieArr.filter((p) => p.id != id);
        this.movieSubject.next(this.movieArr);
      })
    );
  }
  // getAllSmart<T>(): Observable<T[]> {
  //   return this.http.get<T[]>(this.apiUrl);
  // }

  // getAll<T>(): Observable<[]> {
  //   return this.http.get<[]>(this.apiUrl);
  // }
  // getById<T>(id: number) {
  //   return this.http.get<T>(this.apiUrl + '/' + id);
  // }

  // getByAttribute<T>(attribute: string, value: string | number | boolean) {
  //   return this.http.get(`${this.apiUrl}?${attribute}=${value}`);
  // }

  // updateMovie<T>(movie: IMovie): Observable<T> {
  //   return this.http.put<T>(`${this.apiUrl}/${movie.id}`, movie);
  // }
}
