import { Component } from '@angular/core';
import { ITodo } from '../../../Interfaces/i-todo';
import { TodoService } from '../../../Service/todo.service';
import { IUser } from '../../../Interfaces/i-user';
import { UserService } from '../../../Service/user.service';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrl: './completed.component.scss',
})
export class CompletedComponent {
  todos: ITodo[] = [];
  users: IUser[] = [];

  constructor(private todoSvc: TodoService, private userSvc: UserService) {}

  ngOnInit() {
    this.todoSvc.$todos.subscribe((todo) => {
      this.todos = todo.filter((todo) => todo.completed);
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
      this.todos = todo.filter((todo) => todo.completed);
    });
  }
}
