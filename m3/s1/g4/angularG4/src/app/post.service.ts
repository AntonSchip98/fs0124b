import { Injectable } from '@angular/core';
import { iPost } from '../../../../g3/angularG3/src/app/Models/post';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  // constructor() { }
  getAllPost(): Promise<iPost[]> {
    return fetch('../assets/db.json')
      .then((res) => res.json())
      .then((posts) => posts.posts);
  }

  getActivePost(): Promise<iPost[]> {
    return this.getAllPost().then((posts) =>
      posts.filter((el: iPost) => el.active)
    );
  }

  getInactivePost(): Promise<iPost[]> {
    return this.getAllPost().then((posts) =>
      posts.filter((el: iPost) => !el.active)
    );
  }
}
