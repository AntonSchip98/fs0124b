import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PostService } from '../post.service';
import { PostInterface } from 'src/interfaces/post.interface';

@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.scss'],
})
export class TagsComponent {
  tagArr: PostInterface[] = [];

  constructor(private router: ActivatedRoute, private postSvc: PostService) {}
  editPost() {
    alert('Edit successful!');
  }
  ngOnInit() {
    this.router.params.subscribe((tagParams: any) => {
      this.tagArr = this.postSvc.getTagPost(tagParams.tagName);
    });
  }
}
