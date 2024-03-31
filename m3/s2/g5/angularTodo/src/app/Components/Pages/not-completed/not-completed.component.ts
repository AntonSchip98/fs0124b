import { Component } from '@angular/core';
import { TodoService } from '../../../Service/todo.service';
import { ITodo } from '../../../Interfaces/i-todo';

@Component({
  selector: 'app-not-completed',
  templateUrl: './not-completed.component.html',
  styleUrl: './not-completed.component.scss',
})
export class NotCompletedComponent {
  todos: ITodo[] = [];

  constructor(private todoSvc: TodoService) {}

  ngOnInit() {
    this.todoSvc.$todos.subscribe((todo) => {
      this.todos = todo.filter((todo) => !todo.completed);
    });
  }
}
