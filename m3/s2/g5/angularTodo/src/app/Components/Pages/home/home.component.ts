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

  constructor(private todoSvc: TodoService, private userSvc: UserService) {}

  ngOnInit() {
    this.todoSvc.$todos.subscribe((todo) => {
      this.todos = todo;
    });
    console.log(this.todos);
    // this.todos = this.todoSvc.getAllTasks();
    // this.users = this.userSvc.getAllUsers();
  }
}
