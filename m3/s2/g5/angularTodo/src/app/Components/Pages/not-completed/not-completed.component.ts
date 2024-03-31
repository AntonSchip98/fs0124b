import { Component } from '@angular/core';
import { TodoService } from '../../../Service/todo.service';
import { ITodo } from '../../../Interfaces/i-todo';
import { IUser } from '../../../Interfaces/i-user';
import { UserService } from '../../../Service/user.service';

@Component({
  selector: 'app-not-completed',
  templateUrl: './not-completed.component.html',
  styleUrl: './not-completed.component.scss',
})
export class NotCompletedComponent {
  todos: ITodo[] = [];
  users: IUser[] = [];

  constructor(private todoSvc: TodoService, private userSvc: UserService) {}

  ngOnInit() {
    this.todoSvc.$todos.subscribe((todo) => {
      this.todos = todo.filter((todo) => !todo.completed);
    });

    this.userSvc.$users.subscribe((user) => {
      this.users = user;

      this.todos.forEach((todo) => {
        this.todoSvc.getUsername(todo, user);
      });
    });
  }

  handleTodoCheckedChange() {
    this.todoSvc.$todos.subscribe((todo) => {
      this.todos = todo.filter((todo) => !todo.completed);
    });
  }
}
