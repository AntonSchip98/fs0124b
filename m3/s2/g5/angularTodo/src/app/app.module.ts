import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Components/Main-components/header/header.component';
import { HomeComponent } from './Components/Pages/home/home.component';
import { CompletedComponent } from './Components/Pages/completed/completed.component';
import { NotCompletedComponent } from './Components/Pages/not-completed/not-completed.component';
import { UserPageComponent } from './Components/Pages/user-page/user-page.component';
import { CardComponent } from './Components/Atoms/card/card.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CompletedComponent,
    NotCompletedComponent,
    UserPageComponent,
    CardComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
