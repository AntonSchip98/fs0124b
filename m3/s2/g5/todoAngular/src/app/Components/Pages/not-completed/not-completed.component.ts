import { Component } from '@angular/core';
import { ITodo } from '../../../Models/i-todo';
import { IUser } from '../../../Models/i-user';
import { TodoService } from '../../../Service/todo.service';
import { UserService } from '../../../Service/user.service';

@Component({
  selector: 'app-not-completed',
  templateUrl: './not-completed.component.html',
  styleUrl: './not-completed.component.scss',
})
export class NotCompletedComponent {
  todos: ITodo[] = [];
  users: IUser[] = [];

  inputValue: string = '';

  constructor(private todoSvc: TodoService, private userSvc: UserService) {}

  ngOnInit() {
    this.todos = this.todoSvc.getNotComplitedTasks();
    this.users = this.userSvc.getAllUsers();
  }
  toggleTodoCompleted(todo: ITodo): void {
    this.todoSvc.updateTodoToggle(todo, !todo.completed);
    this.todos = this.todoSvc.getNotComplitedTasks();
  }
}
