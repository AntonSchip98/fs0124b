import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CarService } from '../../Service/car.service';
import { ICar } from '../../Models/i-car';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrl: './car-details.component.scss',
})
export class CarDetailsComponent {
  singleCar: ICar | undefined;

  constructor(private router: ActivatedRoute, private carSvc: CarService) {}

  ngOnInit() {
    this.router.params.subscribe((resRoutParameter: any) => {
      console.log(resRoutParameter.id);
      this.carSvc
        .getCarById(resRoutParameter.id)
        .then((res) => (this.singleCar = res));
    });
  }
}
