import { Component, ViewChild } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';
import { SinglePostComponent } from '../single-post/single-post.component';
import { PostService } from '../post.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss'],
})
export class HomepageComponent {
  posts: PostInterface[] = [];
  post!: PostInterface;
  related: PostInterface[] = [];
  tags: string[] = [];

  // @ViewChild('singlePost') singlePost!: SinglePostComponent;

  editPost() {
    alert('Edit successful!');
  }

  constructor(private postSvc: PostService) {}

  ngOnInit() {
    this.posts = this.postSvc.posts;
    this.post = this.postSvc.topPost;
    this.related = this.postSvc.getRandomPosts(4);
    this.tags = this.postSvc.getTags();
  }
}
