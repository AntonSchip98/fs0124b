import { Component } from '@angular/core';
import { ICar } from '../../Models/i-car';
import { CarService } from '../../Service/car.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  carArr: ICar[] = [];

  constructor(private carSvc: CarService) {}

  ngOnInit() {
    this.carSvc.getAllCars().then((res) => {
      this.carArr = res.filter((el) => el.available).slice(0, 2);
    });
  }
}
