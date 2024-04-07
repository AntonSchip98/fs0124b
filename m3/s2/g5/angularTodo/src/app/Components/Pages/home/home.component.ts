import { Component } from '@angular/core';
import { ITodo } from '../../../Interfaces/i-todo';
import { IUser } from '../../../Interfaces/i-user';
import { TodoService } from '../../../Service/todo.service';
import { UserService } from '../../../Service/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  todos: ITodo[] = [];
  users: IUser[] = [];

  inputValue: string = '';

  constructor(private todoSvc: TodoService, private userSvc: UserService) {}

  ngOnInit() {
    this.todoSvc.$todos.subscribe((todo) => {
      this.todos = todo;
    });
    this.userSvc.$users.subscribe((user) => {
      this.users = user;

      this.todos.forEach((todo) => {
        this.todoSvc.getUsername(todo, user);
      });
    });
  }

  searchUserName() {
    this.todoSvc.$todos.subscribe((todo) => {
      this.todos = todo.filter((todo) =>
        todo.username!.toLowerCase().includes(this.inputValue.toLowerCase())
      );
    });
  }
}
