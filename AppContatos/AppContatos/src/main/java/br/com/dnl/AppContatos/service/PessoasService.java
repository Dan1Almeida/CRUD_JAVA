package br.com.dnl.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dnl.AppContatos.Dto.MalaDiretaDto;
import br.com.dnl.AppContatos.model.Pessoas;
import br.com.dnl.AppContatos.repository.PessoasRepository;

@Service
public class PessoasService {
	
	@Autowired
	private PessoasRepository pessoaRepository;

	// ----- SALVAR -----
	
	public Pessoas save(Pessoas pessoa) {
		if(pessoa.getNome() == null // Não Nulo
				|| pessoa.getNome().length() >= 150 // Tamanho máximo
				|| pessoa.getNome().matches(".*\\d.*") // Nagação de números
				|| pessoa.getNome().split("\\s+").length < 2) // Tamanho mínimo de duas palavras
		{
			System.out.println("Nome inserido de forma inválida.");
			return null;
		}
		
		if(pessoa.getOrderLogradouro() == null ) // Caso não listado em ENUM - Logradouro = NULL
		{
			System.out.println("Tipo de Logradouro inserido de forma inválida.");
			return null;
		}

		if(pessoa.getEndereco() == null // Não Nulo
				|| pessoa.getEndereco().length() >= 100 // Tamanho máximo
				|| pessoa.getEndereco().matches(".*\\d.*")) // Nagação de números
		{
			System.out.println("Endereço inserido de forma inválida.");
			return null;
		}
		
		if(pessoa.getNumero() == null 
				|| pessoa.getNumero() < 0) 
		{
			System.out.println("Número inserido de forma inválida.");
			return null;
		}

		if(pessoa.getCep() == null 
				|| !pessoa.getCep().matches("\\d{5}-\\d{3}"))  // Aceita Apenas padrão CEP 
		{
			System.out.println("CEP inserido de forma inválida.");
			return null;
		}

		if(pessoa.getCidade() == null 
				|| pessoa.getCidade().length() >= 35 // Tamanho máximo em referência a cidade com maior nome - Vila Bela da Santíssima Trindade 
				|| pessoa.getCidade().matches(".*\\d.*")) {
			System.out.println("Cidade inserido de forma inválida.");
			return null;
		}
		
		if(pessoa.getOrderUf() == null ) // Caso não listado em ENUM - uf = NULL
		{
			System.out.println("Estado inserido de forma inválida.");
			return null;
		}
		
		System.out.println("Pessoa gravada com sucesso [" +
				"Nome:" + 			pessoa.getNome() + 				"," +
				" Tipo de Log:" + 	pessoa.getOrderLogradouro() + 	"," +
				" Endereço:" + 		pessoa.getEndereco() + 			"," +
				" Número:" + 		pessoa.getNumero() + 			"," +
				" CEP:" + 			pessoa.getCep() + 				"," +
				" Cidade:" + 		pessoa.getCidade() + 			"," +
				" UF:" + 			pessoa.getOrderUf() + 			"]");
		return pessoaRepository.save(pessoa);

	}
	
	// ----- ENCONTRAR POR ID -----
	public Optional<Pessoas> findById(Long id){
		return pessoaRepository.findById(id); 
	}
	
	// ----- LISTAGEM -----
	public List<Pessoas> findAll() {
		return pessoaRepository.findAll();
	}
	    
	// ----- ATUALIZAR -----
	public Pessoas update(Long id, Pessoas pessoa) {
	    Optional<Pessoas> findPessoa = pessoaRepository.findById(id);

	    if (findPessoa.isPresent()) {
	        Pessoas updPessoa = findPessoa.get();

	        if (pessoa.getNome() == null 
	                || pessoa.getNome().length() >= 150 
	                || pessoa.getNome().matches(".*\\d.*") 
	                || pessoa.getNome().split("\\s+").length < 2) {
	        	System.out.println("Nome inserido de forma inválida.");
	            return null;
	        }
	        updPessoa.setNome(pessoa.getNome());
	        
			if(pessoa.getOrderLogradouro() == null ) // Caso não listado em ENUM - Logradouro = NULL
			{
				System.out.println("Tipo de Logradouro inserido de forma inválida.");
				return null;
			}
			updPessoa.setOrderLogradouro(pessoa.getOrderLogradouro());


	        if (pessoa.getEndereco() == null 
	                || pessoa.getEndereco().length() >= 100 
	                || pessoa.getEndereco().matches(".*\\d.*")) {
	        	System.out.println("Endereço inserido de forma inválida.");
	            return null;
	        }
	        updPessoa.setEndereco(pessoa.getEndereco());
	        
			if(pessoa.getNumero() == null 
					|| pessoa.getNumero() < 0) {
				System.out.println("Numero inserido de forma inválida.");
				return null;
			}
			updPessoa.setNumero(pessoa.getNumero());
	        
	        if (pessoa.getCep() == null 
	                || !pessoa.getCep().matches("\\d{5}-\\d{3}")) {
	        	System.out.println("CEP inserido de forma inválida.");
	            return null;
	        }
	        updPessoa.setCep(pessoa.getCep());

	        if (pessoa.getCidade() == null 
	                || pessoa.getCidade().length() >= 35 
	                || pessoa.getCidade().matches(".*\\d.*")) {
	        	System.out.println("Cidade inserido de forma inválida.");
	            return null;
	        }
	        updPessoa.setCidade(pessoa.getCidade());
	        
	        
	        if (pessoa.getOrderUf() == null) {
	        	return null;
	        }
	        updPessoa.setOrderUf(pessoa.getOrderUf());
			System.out.println("Pessoa atualizada com sucesso [" +
					"Nome:" + 			pessoa.getNome() + 				"," +
					" Tipo de Log:" + 	pessoa.getOrderLogradouro() + 	"," +
					" Endereço:" + 		pessoa.getEndereco() + 			"," +
					" Número:" + 		pessoa.getNumero() + 			"," +
					" CEP:" + 			pessoa.getCep() + 				"," +
					" Cidade:" + 		pessoa.getCidade() + 			"," +
					" UF:" + 			pessoa.getOrderUf() + 			"]");
	        return pessoaRepository.save(updPessoa); 
	    }
		System.out.println("ID não encontrado, Pessoa gravada com sucesso [" +
				"Nome:" + 			pessoa.getNome() + 				"," +
				" Tipo de Log:" + 	pessoa.getOrderLogradouro() + 	"," +
				" Endereço:" + 		pessoa.getEndereco() + 			"," +
				" Número:" + 		pessoa.getNumero() + 			"," +
				" CEP:" + 			pessoa.getCep() + 				"," +
				" Cidade:" + 		pessoa.getCidade() + 			"," +
				" UF:" + 			pessoa.getOrderUf() + 			"]");
	    return pessoaRepository.save(pessoa);         
	}
	
	// ----- DELETAR -----	
	public void delete(Long id) {
		System.out.println("Id " + "[" + id +"]"+ " Deletado com sucesso");
		pessoaRepository.deleteById(id);
	}
	
	// ----- MALA DIRETA -----
	
	public MalaDiretaDto buscarPorId(Long id) {
		Optional<Pessoas> pessoa = pessoaRepository.findById(id);
		if (pessoa.isEmpty()) {
			return null; 
		}
		return new MalaDiretaDto(pessoa.get());
	}
    
    // ----- LISTAGEM MALA DIRETA -----
	public List<MalaDiretaDto> listarTodos() {
		return pessoaRepository.findAll().stream().map(MalaDiretaDto::new).toList();
	}
		
}

