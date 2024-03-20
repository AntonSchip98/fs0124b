import { Component } from '@angular/core';
import { iPost } from '../../Models/post';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  postArr: iPost[] = [];

  ngOnInit() {
    fetch('../assets/db.json')
      .then((posts) => posts.json())
      .then((post) => (this.postArr = post.posts));
  }

  truncateText(text: string, maxLength: number): string {
    if (text.length <= maxLength) {
      return text;
    } else {
      return text.substring(0, maxLength) + '...';
    }
  }

  home() {
    this.ngOnInit();
  }

  onlyActive() {
    fetch('../assets/db.json')
      .then((posts) => posts.json())
      .then(
        (post) => (this.postArr = post.posts.filter((el: any) => el.active))
      );
  }

  onlyInactive() {
    fetch('../assets/db.json')
      .then((posts) => posts.json())
      .then(
        (post) => (this.postArr = post.posts.filter((el: any) => !el.active))
      );
  }
}
