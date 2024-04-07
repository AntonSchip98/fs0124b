import { Component } from '@angular/core';
import { GenericService } from '../../Service/generic.service';
import { environment } from '../../../environments/environment.development';
import { IMovie } from '../../Interface/i-movie';

import { faHeart } from '@fortawesome/free-solid-svg-icons';
import { IUser } from '../../Interface/i-user';
import { AuthService } from '../../auth/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrl: './movie-list.component.scss',
})
export class MovieListComponent {
  movieArr: IMovie[] = [];
  private user: IUser | undefined;
  private userSubscription: Subscription | undefined;
  private moviesSubscription: Subscription | undefined;
  private userLoaded = false;
  private moviesLoaded = false;

  faHeart = faHeart;

  constructor(
    private genericSvc: GenericService,
    private authSvc: AuthService
  ) {}
  ngOnInit() {
    this.loadMovies();
  }
  ngOnDestroy() {
    if (this.userSubscription) {
      this.userSubscription.unsubscribe();
    }
    if (this.moviesSubscription) {
      this.moviesSubscription.unsubscribe();
    }
  }

  loadMovies() {
    this.userSubscription = this.authSvc.user$.subscribe((user) => {
      this.user = user || undefined;
      this.userLoaded = true;
      this.checkFavorites();
    });

    this.moviesSubscription = this.genericSvc.movie$.subscribe((movies) => {
      this.movieArr = movies;
      this.moviesLoaded = true;
      this.checkFavorites();
    });
  }

  toggleFavourite(movie: IMovie) {
    movie.favourites = !movie.favourites;
    if (this.user) {
      if (movie.favourites) {
        this.authSvc.addToFavorites(movie, this.user).subscribe(() => {
          console.log("Film aggiunto nei preferiti dell'utente.");
        });
      } else {
        this.authSvc.removeFromFavorites(movie.id, this.user).subscribe(() => {
          console.log("Film rimosso dai preferiti dell'utente.");
        });
      }
    }
  }

  checkFavorites() {
    if (
      this.userLoaded &&
      this.moviesLoaded &&
      this.user &&
      this.movieArr.length > 0
    ) {
      this.movieArr.forEach((movie) => {
        movie.favourites = this.user?.favourites.some(
          (favMovie) => favMovie.id === movie.id
        );
      });
    }
  }
}
