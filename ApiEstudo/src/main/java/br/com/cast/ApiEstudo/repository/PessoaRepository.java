package br.com.cast.ApiEstudo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.cast.ApiEstudo.model.Pessoa;

@Repository
public class PessoaRepository {
	
	private EntityManager em;
	
	public void inserir(Pessoa pessoa) {
		em.persist(pessoa);
	}
	
	public void alterar(Pessoa pessoa) {
		em.merge(pessoa);
	}
	
	public void excluir(Pessoa pessoa) {
		em.remove(pessoa);
	}

	public Pessoa buscarPorCpf(String cpf) {
		return em.find(Pessoa.class, cpf);
	}
	
	public List<Pessoa> buscarTodos() {
		return em.createQuery(
				"SELECT P " +
				"From Pessoa p " +
				"join fetch p.endereco").getResultList();
	}
	
}
