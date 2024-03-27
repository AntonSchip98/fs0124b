import { Component } from '@angular/core';
import { IProd } from '../../../Models/i-prod';
import { ProdService } from '../../../Service/prod.service';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrl: './favourites.component.scss',
})
export class FavouritesComponent {
  favourites: IProd[] = [];

  constructor(private prodSvc: ProdService) {}

  ngOnInit() {
    this.favourites = this.prodSvc.getFavourties();
  }
}
