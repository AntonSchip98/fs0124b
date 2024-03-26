import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Pages/home/home.component';
import { HeaderComponent } from './Main-components/header/header.component';
import { FooterComponent } from './Main-components/footer/footer.component';
import { CarDetailsComponent } from './Pages/car-details/car-details.component';
import { Page404Component } from './Pages/page404/page404.component';
import { FiatComponent } from './Pages/fiat/fiat.component';
import { FordComponent } from './Pages/ford/ford.component';
import { AudiComponent } from './Pages/audi/audi.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    CarDetailsComponent,
    Page404Component,
    FiatComponent,
    FordComponent,
    AudiComponent,
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
