import { Component } from '@angular/core';
import { IPhoto } from '../../../Models/i-photo';
import { PhotoService } from '../../../Service/photo.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  photoArr: IPhoto[] = [];
  liked: IPhoto[] = [];

  constructor(private photoSvc: PhotoService) {}

  ngOnInit() {
    this.photoSvc.$photos.subscribe((photos) => {
      this.photoArr = photos;
    });

    this.photoSvc.$like.subscribe((like) => {
      this.liked = like;
    });
  }

  deletePhoto(id: number) {
    this.photoSvc.delete(id).subscribe();
  }

  addLike(id: number): void {
    this.photoSvc.pushPhoto(id);
  }
}
