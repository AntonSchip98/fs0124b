import { Injectable } from '@angular/core';
import { IPhoto } from '../Models/i-photo';
import { BehaviorSubject, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class PhotoService {
  apiUrl: string = 'http://localhost:3000/photo';

  photoArr: IPhoto[] = [];
  likeArr: IPhoto[] = [];

  photoSubject = new BehaviorSubject<IPhoto[]>([]);
  likeSubject = new BehaviorSubject<IPhoto[]>([]);

  $photos = this.photoSubject.asObservable();
  $like = this.likeSubject.asObservable();

  constructor(private http: HttpClient) {
    this.getAllPhotos().subscribe((data) => {
      this.photoSubject.next(data);
      this.photoArr = data;
    });
  }

  getAllPhotos() {
    return this.http.get<IPhoto[]>(this.apiUrl);
  }

  getPhotoById(id: number) {
    return this.photoArr.find((p) => p.id == id);
  }

  createPhoto(newPhoto: Partial<IPhoto>) {
    return this.http.post<IPhoto>(this.apiUrl, newPhoto).pipe(
      tap((photo) => {
        this.photoArr.push(photo);
        this.photoSubject.next(this.photoArr);
      })
    );
  }

  delete(id: number) {
    return this.http.delete<IPhoto>(this.apiUrl + '/' + id).pipe(
      tap(() => {
        this.photoArr = this.photoArr.filter((p) => p.id != id);
        this.photoSubject.next(this.photoArr);
      })
    );
  }

  pushPhoto(id: number): void {
    const photoToAdd = this.getPhotoById(id);
    if (photoToAdd) {
      this.likeArr.push(photoToAdd);
      this.likeSubject.next(this.likeArr);
    }
  }
}
