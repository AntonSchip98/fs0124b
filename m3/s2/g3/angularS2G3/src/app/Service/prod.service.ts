import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IProductArr } from '../Models/i-product-arr';
import { IProd } from '../Models/i-prod';

@Injectable({
  providedIn: 'root',
})
export class ProdService {
  apiUrl: string = 'https://dummyjson.com/products';
  private favourites: IProd[] = [];

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get<IProductArr>(this.apiUrl);
  }

  addToFavourites(prod: IProd) {
    this.favourites.push(prod);
  }

  getFavourties() {
    return this.favourites;
  }
}
