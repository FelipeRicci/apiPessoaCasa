package br.com.cast.ApiEstudo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.ApiEstudo.business.PessoaBusiness;
import br.com.cast.ApiEstudo.dto.PessoaDTO;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaApi {

	@Autowired
	private PessoaBusiness pb;


	//METODO RESPONSAVEL PARA BUSCAR TODOS
	@RequestMapping(method=RequestMethod.GET)
	public List<PessoaDTO> buscarTodos(){
		return pb.buscarTodos();
	}
	
	//METODO RESPONSAVEL PARA BUSCAR PELO CPF
	@RequestMapping(path="/{cpf}", method = RequestMethod.GET)
	public PessoaDTO buscarPorCpf(@PathVariable("cpf") String cpf) {
		System.out.println("mostrando qual cpf ele buscou" + cpf);
		return pb.buscarPorCpf(cpf);
	}
	
	//METODO RESPONSAVEL PARA BUSCAR POR //CPF E NOME //
	@RequestMapping(path="{/cpf}{/nome}", method= RequestMethod.GET)
	public String buscarPorCpfENome(@PathVariable("cpf") String cpf, 
									@PathVariable("nome") String nome) {
		System.out.println("buscar por cpf: " + cpf + " E " + "Buscou por Nome: " + nome);
		return "buscou por cpf e nome";		
	}
	
	//METODO RESPONSAVEL PARA INSERIR UMA PESSOA AO BANCO
	@RequestMapping(method=RequestMethod.POST)
	public void inserir(@RequestBody PessoaDTO dto) {
		pb.inserir(dto);
	}
	
	//METODO RESPONSAVEL PARA ALTERAR UMA PESSOA DO BANCO	
	@RequestMapping(path="{/cpf}", method=RequestMethod.PUT)
	public void alterar(@RequestBody PessoaDTO dto) {
		pb.alterar(dto);
	}
	
	//METODO RESPONSAVEL PARA EXCLUIR UMA PESSOA DO BANCO
	@RequestMapping(path="{/cpf}", method=RequestMethod.DELETE)
	public void excluir(@PathVariable("cpf") String cpf) {
		pb.excluir(cpf);
	}
	
	
}
