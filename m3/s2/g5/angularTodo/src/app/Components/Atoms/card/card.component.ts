import { Component, Input } from '@angular/core';
import { ITodo } from '../../../Interfaces/i-todo';

@Component({
  selector: '.app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss',
})
export class CardComponent {
  @Input() snglTodo!: ITodo;

  toggleTodoCompleted() {}
}
