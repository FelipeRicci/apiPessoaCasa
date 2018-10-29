import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pessoa } from '../model/Pessoa';

//url responsavel para listar todas as pessoas do banco
const URL_GP: string = '';
//url responsavel para inserir uma pessoa no banco
const URL_PP: string = '';
//url responsavel para deletar uma pessoa do banco
const URL_DP: string = '';
//url responsavel para pegar uma pessoa do banco atravez de seu cpf
const URL_GPC: string = '';
//url responsavel para alterar uma pessoa do banco
const URL_PPC: string = '';

@Injectable({
  providedIn: 'root'
})
export class TipoPessoaService {

  constructor(private http: HttpClient) { }

  //pegando uma pessoa no banco
  getPessoaBanco(): Observable<Pessoa[]>{
    console.log('pegando uma pessoa do banco!');
    return this.http.get<Pessoa[]>(URL_GP);
  }

  //inserindo uma pessoa no banco
  postPessoaBanco(pessoa: Pessoa): Observable<Pessoa>{
    console.log('inserindo uma pessoa no banco');
    return this.http.post<Pessoa>(URL_PP, pessoa);
  }

  //deletando uma pessoa no banco
  deletePessoaBanco(cpf: string): Observable<Pessoa>{
    console.log('deletando uma pessoa do banco atravez de seu cpf');
    return this.http.delete<Pessoa>(URL_DP + cpf);
  }

  //pegando uma pessoa no banco atravez de seu cpf
  getPessoaCpf(cpf: string): Observable<Pessoa>{
    console.log('Pegando uma pessoa no banco atravez de seu cpf');
    return this.http.get<Pessoa>(URL_GPC + cpf);
  }

  //alterando uma pessoa no banco atravez de seu cpf
  //putPessoaCpf(cpf: number): Observable<number>{
  //  console.log('alterando uma pessoa no banco atravez de seu cpf');
  //  return this.http.put<number>(URL_PPC + cpf);
  //}
}
