import { Component } from '@angular/core';
import { ICar } from '../../Models/i-car';
import { CarService } from '../../Service/car.service';

@Component({
  selector: 'app-audi',
  templateUrl: './audi.component.html',
  styleUrl: './audi.component.scss',
})
export class AudiComponent {
  carArr: ICar[] = [];

  constructor(private carSvc: CarService) {}

  ngOnInit() {
    this.carSvc.getBrandCars('Audi').then((res) => (this.carArr = res));
  }
}
