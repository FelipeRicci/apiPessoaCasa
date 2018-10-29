import { Endereco } from "./Endereco";

export class Pessoa{

    public cpf:string;
    public nome:string;
    public email:string;
    public endereco:Endereco = new Endereco();
}