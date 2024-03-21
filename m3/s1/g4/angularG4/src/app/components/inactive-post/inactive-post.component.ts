import { Component } from '@angular/core';
import { iPost } from '../../../../../../g3/angularG3/src/app/Models/post';
import { PostService } from '../../post.service';

@Component({
  selector: 'app-inactive-post',
  templateUrl: './inactive-post.component.html',
  styleUrl: './inactive-post.component.scss',
})
export class InactivePostComponent {
  postArr: iPost[] = [];

  constructor(private postSvc: PostService) {}

  ngOnInit() {
    this.postSvc.getInactivePost().then((res) => {
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
