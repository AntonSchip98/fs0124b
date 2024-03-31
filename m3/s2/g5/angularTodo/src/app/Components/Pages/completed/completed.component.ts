import { Component } from '@angular/core';
import { ITodo } from '../../../Interfaces/i-todo';
import { TodoService } from '../../../Service/todo.service';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrl: './completed.component.scss',
})
export class CompletedComponent {
  todos: ITodo[] = [];

  constructor(private todoSvc: TodoService) {}

  ngOnInit() {
    this.todoSvc.$todos.subscribe((todo) => {
      this.todos = todo.filter((todo) => todo.completed);
    });
  }
}
