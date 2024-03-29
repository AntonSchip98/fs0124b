import { TodoService } from './../../../Service/todo.service';
import { Component } from '@angular/core';
import { ITodo } from '../../../Models/i-todo';
import { UserService } from '../../../Service/user.service';
import { IUser } from '../../../Models/i-user';

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
    this.todos = this.todoSvc.getAllTasks();
    this.users = this.userSvc.getAllUsers();

    this.todos.forEach((todo) => {
      todo.username = this.getAuthorById(todo.userId);
    });
  }
  toggleTodoCompleted(todo: ITodo): void {
    this.todoSvc.updateTodoToggle(todo, !todo.completed);
  }

  getAuthorById(id: number): string {
    const user = this.users.find((user) => user.id === id);
    return user ? user.firstName : '';
  }
  searchUserName() {
    this.todos = this.todoSvc
      .getAllTasks()
      .filter((todo) =>
        todo.username!.toLowerCase().includes(this.inputValue.toLowerCase())
      );
  }
}
