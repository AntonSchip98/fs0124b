import { Component } from '@angular/core';
import { iPost } from '../../../../../../g3/angularG3/src/app/Models/post';
import { PostService } from '../../post.service';

@Component({
  selector: 'app-active-post',
  templateUrl: './active-post.component.html',
  styleUrl: './active-post.component.scss',
})
export class ActivePostComponent {
  postArr: iPost[] = [];

  constructor(private postSvc: PostService) {}

  ngOnInit() {
    this.postSvc.getActivePost().then((res) => {
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
