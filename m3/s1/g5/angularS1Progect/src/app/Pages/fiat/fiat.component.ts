import { ICar } from '../../Models/i-car';
import { CarService } from './../../Service/car.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-fiat',
  templateUrl: './fiat.component.html',
  styleUrl: './fiat.component.scss',
})
export class FiatComponent {
  carArr: ICar[] = [];

  constructor(private carSvc: CarService) {}

  ngOnInit() {
    this.carSvc.getBrandCars('Fiat').then((res) => (this.carArr = res));
  }
}
