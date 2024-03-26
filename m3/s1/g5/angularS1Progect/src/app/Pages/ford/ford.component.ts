import { Component } from '@angular/core';
import { ICar } from '../../Models/i-car';
import { CarService } from '../../Service/car.service';

@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrl: './ford.component.scss',
})
export class FordComponent {
  carArr: ICar[] = [];

  constructor(private carSvc: CarService) {}

  ngOnInit() {
    this.carSvc.getBrandCars('Ford').then((res) => (this.carArr = res));
  }
}
