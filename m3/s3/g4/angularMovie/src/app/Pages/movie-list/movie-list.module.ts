import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MovieListRoutingModule } from './movie-list-routing.module';
import { MovieListComponent } from './movie-list.component';
import { GenericService } from '../../Service/generic.service';
import { TruncateHtmlPipe } from '../../Pipe/truncate-html.pipe';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [MovieListComponent, TruncateHtmlPipe],
  imports: [CommonModule, MovieListRoutingModule, FontAwesomeModule],
  providers: [GenericService],
  exports: [TruncateHtmlPipe],
})
export class MovieListModule {}
