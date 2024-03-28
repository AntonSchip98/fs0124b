import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Components/Main-components/header/header.component';
import { HomeComponent } from './Components/Pages/home/home.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { HttpClassInterceptor } from './http-class.interceptor';
import { DetailsComponent } from './Components/Pages/details/details.component';
import { CreateComponent } from './Components/Pages/create/create.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    DetailsComponent,
    CreateComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpClassInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
