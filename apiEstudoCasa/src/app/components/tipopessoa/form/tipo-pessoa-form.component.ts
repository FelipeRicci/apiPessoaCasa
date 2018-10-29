import { Component, OnInit } from '@angular/core';
import { TipoPessoaService } from '../../service/tipo-pessoa.service';
import { Pessoa } from '../../model/Pessoa';

@Component({
  selector: 'app-tipo-pessoa-form',
  templateUrl: './tipo-pessoa-form.component.html',
  styleUrls: ['./tipo-pessoa-form.component.css']
})
export class TipoPessoaFormComponent implements OnInit {

  pessoa: Pessoa;

  constructor(private service: TipoPessoaService) { }

  ngOnInit() {
    this.pessoa = new Pessoa();
  }

  public inserirPessoa(){
    this.service.postPessoaBanco(this.pessoa).subscribe(resp => this.pessoa = new Pessoa());
  }

}
