import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'
import { TipoPessoaRoutingModule } from './components/tipopessoa/tipo-pessoa-routing.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    TipoPessoaRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
