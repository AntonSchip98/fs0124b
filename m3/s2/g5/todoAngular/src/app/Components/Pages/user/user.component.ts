import { Component } from '@angular/core';
import { ITodo } from '../../../Models/i-todo';
import { IUser } from '../../../Models/i-user';
import { TodoService } from '../../../Service/todo.service';
import { UserService } from '../../../Service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.scss',
})
export class UserComponent {
  todos: ITodo[] = [];
  users: IUser[] = [];

  constructor(private todoSvc: TodoService, private userSvc: UserService) {}

  ngOnInit() {
    this.todos = this.todoSvc.getAllTasks();
    this.users = this.userSvc.getAllUsers();
    this.users.forEach((user) => {
      user.todos = this.getTodoById(user.id);
    });
  }

  getTodoById(id: number): ITodo[] {
    return this.todos.filter((todo) => todo.userId == id);
  }

  toggleTodoCompleted(todo: ITodo): void {
    this.todoSvc.updateTodoToggle(todo, !todo.completed);
  }
}
