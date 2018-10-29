package br.com.cast.ApiEstudo.business;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.ApiEstudo.dto.PessoaDTO;
import br.com.cast.ApiEstudo.model.Pessoa;
import br.com.cast.ApiEstudo.repository.PessoaRepository;

@Service
public class PessoaBusiness {
	
	@Autowired
	private PessoaRepository pr;
	
	
	//METODO RESPONSAVEL PARA BUSCAR TODOS E RESULTAR UMA LISTA DE PESSOADTO
	public List<PessoaDTO> buscarTodos(){
		List<Pessoa> pessoas = pr.buscarTodos();
		List<PessoaDTO> dtos = new ArrayList<>();
		
		for (Pessoa p : pessoas) {
			dtos.add(PessoaDTO.fromPessoa(p));
		}
		return dtos;
	}
	
	//METODO RESPONSAVEL POR BUSCAR POR CPF
	@Transactional
	public PessoaDTO buscarPorCpf(String cpf) {
		Pessoa pessoa = pr.buscarPorCpf(cpf);
		PessoaDTO dto = new PessoaDTO();
		dto = PessoaDTO.fromPessoa(pessoa);
		return dto;
	}
	
	//METODO RESPONSAVEL PARA INSERIR UMA PESSOA AO BANCO	
	@Transactional
	public void inserir(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		Pessoa.fromDTO(pessoa, dto);
		pr.inserir(pessoa);
	}
	
	//METODO RESPONSAVEL PARA ALTERAR UMA PESSOA AO BANCO	
	@Transactional
	public void alterar(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		Pessoa.fromDTO(pessoa, dto);
		pr.alterar(pessoa);
	}
	
	//METODO RESPONSAVEL PARA EXCUIR UMA PESSOA DO BANCO
	@Transactional
	public void excluir(String cpf) {
		Pessoa pessoa = pr.buscarPorCpf(cpf);
		pr.excluir(pessoa);
	}

	
}
