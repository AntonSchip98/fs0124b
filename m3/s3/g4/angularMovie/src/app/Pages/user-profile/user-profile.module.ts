import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserProfileRoutingModule } from './user-profile-routing.module';
import { UserProfileComponent } from './user-profile.component';
import { GenericService } from '../../Service/generic.service';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CapitilizePipe } from '../../Pipe/capitilize.pipe';

@NgModule({
  declarations: [UserProfileComponent, CapitilizePipe],
  imports: [CommonModule, UserProfileRoutingModule, FontAwesomeModule],
  providers: [GenericService],
  exports: [CapitilizePipe],
})
export class UserProfileModule {}
