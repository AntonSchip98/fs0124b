import { Component } from '@angular/core';
import { ITodo } from '../../../Models/i-todo';
import { IUser } from '../../../Models/i-user';
import { TodoService } from '../../../Service/todo.service';
import { UserService } from '../../../Service/user.service';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrl: './completed.component.scss',
})
export class CompletedComponent {
  todos: ITodo[] = [];
  users: IUser[] = [];

  inputValue: string = '';

  constructor(private todoSvc: TodoService, private userSvc: UserService) {}

  ngOnInit() {
    this.todos = this.todoSvc.getComplitedTasks();
    this.users = this.userSvc.getAllUsers();
  }

  toggleTodoCompleted(todo: ITodo): void {
    this.todoSvc.updateTodoToggle(todo, !todo.completed);
    this.todos = this.todoSvc.getComplitedTasks();
  }
}
