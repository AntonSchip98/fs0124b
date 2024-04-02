import { Component } from '@angular/core';
import { IPost } from '../../Interface/i-post';
import { PostService } from '../../Service/post.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  posts: IPost[] = [];

  constructor(private postSvc: PostService) {}

  ngOnInit() {
    this.postSvc.$posts.subscribe((post) => {
      this.posts = post;
    });
  }
}
