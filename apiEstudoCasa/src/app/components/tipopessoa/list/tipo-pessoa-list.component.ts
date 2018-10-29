import { Component, OnInit } from '@angular/core';
import { TipoPessoaService } from '../../service/tipo-pessoa.service';
import { Pessoa } from '../../model/Pessoa';
import { Endereco } from '../../model/Endereco';

@Component({
  selector: 'app-tipo-pessoa-list',
  templateUrl: './tipo-pessoa-list.component.html',
  styleUrls: ['./tipo-pessoa-list.component.css']
})
export class TipoPessoaListComponent implements OnInit {

  pessoa: Pessoa;
  endereco: Endereco;
  cpf: string;
  pessoas: Array<Pessoa>;

  constructor(private service: TipoPessoaService) { }

  ngOnInit() {
    this.pessoa = new Pessoa();
    this.pessoas = new Array();
    this.buscarPessoaBanco();
  }

  public buscarPessoaBanco(): void{
    this.service.getPessoaBanco().subscribe(resp => this.pessoas = resp);
  }

  public deletarPessoaBanco(cpf: string): void{
    this.service.deletePessoaBanco(cpf).subscribe(resp => this.pessoa = resp);
  }

}
