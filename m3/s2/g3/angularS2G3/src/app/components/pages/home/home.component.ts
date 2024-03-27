import { Component } from '@angular/core';
import { ProdService } from '../../../Service/prod.service';
import { IProd } from '../../../Models/i-prod';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  product: IProd[] = [];
  // favourites: IProd[] = [];
  cart: IProd[] = [];

  constructor(private prodSvc: ProdService) {}

  ngOnInit() {
    this.prodSvc.getAll().subscribe((post) => {
      this.product = post.products;
    });
  }

  addToFavourites(id: number) {
    const product = this.product.find((prod) => prod.id == id);
    if (product) {
      this.prodSvc.addToFavourites(product);
    }
    // this.favourites.push(product!);
  }
}
