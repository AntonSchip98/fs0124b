import { Component } from '@angular/core';
import { IPhoto } from '../../../Models/i-photo';
import { PhotoService } from '../../../Service/photo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrl: './create.component.scss',
})
export class CreateComponent {
  newPhoto: IPhoto | undefined;

  constructor(private photoSvc: PhotoService, private router: Router) {}

  savePhoto() {
    this.photoSvc.createPhoto(this.newPhoto!).subscribe(() => {
      this.newPhoto;

      setTimeout(() => {
        this.router.navigate(['/']);
      }, 2000);
    });
  }
}
