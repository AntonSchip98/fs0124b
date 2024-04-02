import { Component, Input } from '@angular/core';
import { IPost } from '../../Interface/i-post';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss',
})
export class CardComponent {
  @Input() snglPost!: IPost;
}
