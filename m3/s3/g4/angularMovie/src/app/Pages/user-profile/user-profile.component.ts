import { IMovie } from './../../Interface/i-movie';
import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { GenericService } from '../../Service/generic.service';
import { IUser } from '../../Interface/i-user';
import { environment } from '../../../environments/environment.development';
import { faTrashCan, faUserXmark } from '@fortawesome/free-solid-svg-icons';
import { tap } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.scss',
})
export class UserProfileComponent {
  movieUrl: string = environment.moviesUrl;
  userUrl: string = environment.usersUrl;

  moviesArr: IMovie[] = [];
  user: IUser | undefined;

  constructor(
    private authSvc: AuthService,
    private genericSvc: GenericService,
    private router: Router
  ) {}
  ngOnInit() {
    this.authSvc.user$.subscribe((user) => {
      this.user = user || undefined;

      if (this.user) {
        this.loadUserFavoriteMovies();
      }
    });
  }
  faBucket = faTrashCan;
  faUserDelete = faUserXmark;

  loadUserFavoriteMovies(): void {
    this.genericSvc.getAll().subscribe((movies) => {
      this.moviesArr = movies.filter((movie) =>
        this.user?.favourites?.some((favMovie) => favMovie.id === movie.id)
      );
    });
  }
  toggleFavourite(movie: IMovie) {
    if (!this.user) return;

    this.authSvc.removeFromFavorites(movie.id, this.user).subscribe(() => {
      console.log("Film rimosso dai preferiti dell'utente.");
      this.moviesArr = this.moviesArr.filter((m) => m.id !== movie.id);
    });
  }

  onDeleteCurrentUserClick() {
    this.authSvc.deleteCurrentUser().subscribe({
      next: () => {
        console.log('Utente eliminato con successo');
      },
      error: (err) => {
        console.error(
          "Si è verificato un errore durante l'eliminazione dell'utente:",
          err
        );
      },
    });
  }
}
