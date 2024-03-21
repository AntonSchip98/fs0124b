import { PostService } from '../../post.service';
import { iPost } from './../../../../../../g3/angularG3/src/app/Models/post';
import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  postArr: iPost[] = [];

  constructor(private postSvc: PostService) {}

  ngOnInit() {
    this.postSvc.getAllPost().then((res) => {
      this.postArr = res;
    });
  }

  truncateText(text: string, maxLength: number): string {
    if (text.length <= maxLength) {
      return text;
    } else {
      return text.substring(0, maxLength) + '...';
    }
  }
}
