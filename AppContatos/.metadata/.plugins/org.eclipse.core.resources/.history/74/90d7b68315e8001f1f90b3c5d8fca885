package br.com.dnl.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dnl.AppContatos.model.Pessoas;
import br.com.dnl.AppContatos.repository.PessoasRepository;

@Service
public class PessoasService {
	
	@Autowired
	private PessoasRepository pessoaRepository;
	
	
	// ----- SALVAR -----
	
	public Pessoas save(Pessoas pessoa) {
		if(pessoa.getNome() == null || pessoa.getNome().length() >= 2) {
			System.out.println("Nome inserido de forma incorreta");
			return null;
		}
		if(pessoa.getEndereco() == null) {
			System.out.println("Endereço está vazio.");
			return null;
		}
		if(pessoa.getCep() == null) {
			System.out.println("CEP está vazio.");
			return null;
		}
		if(pessoa.getCidade() == null) {
			System.out.println("Cidade está vazio.");
			return null;
		}
		if(pessoa.getUf() == null) {
			System.out.println("Estado está vazio.");
			return null;
		}
		try {
			return pessoaRepository.save(pessoa);
		} catch (Exception e) {
			System.out.println("Erro ao inserir pessoa " + 
                    pessoa.toString() + ": " + e.getMessage());
					return null;
		}	
	}
	
	// ----- ENCONTRAR POR ID -----
	public Optional<Pessoas> findById(Long id){
		return pessoaRepository.findById(id); 
	}
	
	
	// ----- LISTAGEM -----
	public List<Pessoas> findAll(){
		return pessoaRepository.findAll();
	}
	
	
	// ----- ATUALIZAR -----
	public Pessoas update(Long id, Pessoas pessoa) {

		Optional<Pessoas> findPessoa = pessoaRepository.findById(id);
		
		if(findPessoa.isPresent()) {
			Pessoas updPessoa = findPessoa.get(); 
			updPessoa.setNome(pessoa.getNome()); 
			updPessoa.setEndereco(pessoa.getEndereco());
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setCidade(pessoa.getCidade());
			updPessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updPessoa); //UPDATE
		}
		return pessoaRepository.save(pessoa); //INSERT		
		}
	
	// ----- DELETAR -----	
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
		
}

