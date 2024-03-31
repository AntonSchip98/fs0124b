import { Component } from '@angular/core';
import { IUser } from '../../../Interfaces/i-user';
import { ITodo } from '../../../Interfaces/i-todo';
import { TodoService } from '../../../Service/todo.service';
import { UserService } from '../../../Service/user.service';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrl: './user-page.component.scss',
})
export class UserPageComponent {
  todos: ITodo[] = [];
  users: IUser[] = [];

  constructor(private todoSvc: TodoService, private userSvc: UserService) {}

  ngOnInit() {
    this.todoSvc.$todos.subscribe((todo) => {
      this.todos = todo;
    });
    this.userSvc.$users.subscribe((user) => {
      this.users = user;
    });

    this.users.forEach((user) => {
      user.todos = this.todoSvc.getTodoById(user.id);
    });
  }
}
