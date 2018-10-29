import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TipoPessoaRoutingModule } from './tipo-pessoa-routing.module';
import { TipoPessoaFormComponent } from './form/tipo-pessoa-form.component';
import { TipoPessoaListComponent } from './list/tipo-pessoa-list.component';

@NgModule({
  imports: [
    CommonModule,
    TipoPessoaRoutingModule
  ],
  declarations: [TipoPessoaFormComponent, TipoPessoaListComponent]
})
export class TipoPessoaModule { }
