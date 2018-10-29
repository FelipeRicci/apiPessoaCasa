package br.com.cast.ApiEstudo.dto;

import br.com.cast.ApiEstudo.model.Pessoa;

public class PessoaDTO {

	private String nome;
	private String cpf;
	private String email;

	private EnderecoDTO endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public static PessoaDTO fromPessoa(Pessoa p) {
		PessoaDTO dto = new PessoaDTO();
		dto.setCpf(p.getCpf());
		dto.setNome(p.getNome());
		dto.setEmail(p.getEmail());
		
		EnderecoDTO enderecoDTO = EnderecoDTO.fromEndereco(p.getEndereco());
		
		dto.setEndereco(enderecoDTO);
		
		return dto;
	}
	
}
