import { Injectable } from '@angular/core';
import { ICar } from '../Models/i-car';

@Injectable({
  providedIn: 'root',
})
export class CarService {
  getAllCars(): Promise<ICar[]> {
    return fetch('../../assets/db.json')
      .then((res) => res.json())
      .then((res: ICar[]) => res);
  }

  getBrandCars(brand: string): Promise<ICar[]> {
    return this.getAllCars().then((res) =>
      res.filter((el) => el.brand == brand)
    );
  }

  getCarById(id: string): Promise<ICar | undefined> {
    return this.getAllCars().then((res) => res.find((el) => el.id == id));
  }
}
