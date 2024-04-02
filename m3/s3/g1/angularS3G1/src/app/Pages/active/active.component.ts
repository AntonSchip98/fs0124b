import { Component } from '@angular/core';
import { PostService } from '../../Service/post.service';
import { IPost } from '../../Interface/i-post';

@Component({
  selector: 'app-active',
  templateUrl: './active.component.html',
  styleUrl: './active.component.scss',
})
export class ActiveComponent {
  posts: IPost[] = [];

  constructor(private postSvc: PostService) {}

  ngOnInit() {
    this.postSvc.$posts.subscribe((post) => {
      this.posts = post.filter((p) => p.active);
    });
  }
}
