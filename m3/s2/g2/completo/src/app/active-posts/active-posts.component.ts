import { Component, OnInit } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';
import { PostService } from '../post.service';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrls: ['./active-posts.component.scss'],
})
export class ActivePostsComponent {
  active!: PostInterface[];

  constructor(private postSvc: PostService) {}

  ngOnInit() {
    this.active = this.postSvc.activePosts;
  }
}
