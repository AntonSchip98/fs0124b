import { Component } from '@angular/core';
import { PostService } from '../../Service/post.service';
import { IPost } from '../../Interface/i-post';

@Component({
  selector: 'app-inactive',
  templateUrl: './inactive.component.html',
  styleUrl: './inactive.component.scss',
})
export class InactiveComponent {
  posts: IPost[] = [];

  constructor(private postSvc: PostService) {}

  ngOnInit() {
    this.postSvc.$posts.subscribe((post) => {
      this.posts = post.filter((p) => !p.active);
    });
  }
}
