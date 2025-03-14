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

	// ----- SALVAR -------------------------------------------------------------
	
	public Pessoas save(Pessoas pessoa) {
		
		if(pessoa.getNome() == null
				|| pessoa.getNome().length() >= 150 
				|| pessoa.getNome().matches(".*\\d.*") 
				|| pessoa.getNome().split("\\s+").length < 2)
		{
			System.out.println("Nome inserido de forma inválida.");
			return null;
		}
	//-------------------------------------------------------------------------------------------
				
		if(pessoa.getCpf() == null 
				||  !pessoa.getCpf().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
			System.out.println("CPF inserido de forma inválida.");
			return null;
		}
		
		if(pessoaRepository.existsByCpf(pessoa.getCpf())){
			System.out.println("Pessoa já cadastrada no sistema.");
			return null;
		}
	//-------------------------------------------------------------------------------------------
		
		if(pessoa.getOrderLogradouro() == null ) 
		{
			System.out.println("Tipo de Logradouro inserido de forma inválida.");
			return null;
		}
		
	//-------------------------------------------------------------------------------------------

		if(pessoa.getEndereco() == null 
				|| pessoa.getEndereco().length() >= 100 
				|| pessoa.getEndereco().matches(".*\\d.*")) 
		{
			System.out.println("Endereço inserido de forma inválida.");
			return null;
		}
		
	//-------------------------------------------------------------------------------------------
		
		if (pessoa.getNumero() < 1 || pessoa.getNumero() > 9999) {
			System.out.println("Número inserido de forma inválida.");
			return null;
		}
		
	//-------------------------------------------------------------------------------------------
		if(pessoa.getCep() == null 
				|| !pessoa.getCep().matches("\\d{5}-\\d{3}"))   
		{
			System.out.println("CEP inserido de forma inválida.");
			return null;
		}
		
	//-------------------------------------------------------------------------------------------

		if(pessoa.getCidade() == null 
				|| pessoa.getCidade().length() >= 35  
				|| pessoa.getCidade().matches(".*\\d.*")) {
			System.out.println("Cidade inserido de forma inválida.");
			return null;
		}
		
	//-------------------------------------------------------------------------------------------
		
		if(pessoa.getOrderUf() == null ) 
		{
			System.out.println("Estado inserido de forma inválida.");
			return null;
		}
		
	//-------------------------------------------------------------------------------------------
		
		System.out.println("Pessoa gravada com sucesso [" +
				"Nome:" +	pessoa.getNome() +	"," +
				" CPF:" +	pessoa.getCpf() + 	"," +
				" Tipo de Log:" +	pessoa.getOrderLogradouro() +	"," +
				" Endereço:" +	pessoa.getEndereco() +	"," +
				" Número:" +	pessoa.getNumero() +	"," +
				" CEP:" +	pessoa.getCep() + 	"," +
				" Cidade:" +	pessoa.getCidade() + 	"," +
				" UF:" +	pessoa.getOrderUf() + 	"]");
		return pessoaRepository.save(pessoa);

	}
	
	// ----- ENCONTRAR POR ID -------------------------------------------------------------
	public Optional<Pessoas> findById(Long id){
		return pessoaRepository.findById(id); 
	}
	
	// ----- LISTAGEM -------------------------------------------------------------
	public List<Pessoas> findAll() {
		System.out.println("Lista retornada com sucesso");
		return pessoaRepository.findAll();
	}
	    
	// ----- ATUALIZAR -------------------------------------------------------------
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
    //-------------------------------------------------------------------------------------------
	        	        
			if(pessoa.getCpf() == null 
					||  !pessoa.getCpf().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
				System.out.println("CPF inserido de forma inválida.");
				return null;
			}
			
			if(pessoaRepository.existsByCpf(pessoa.getCpf())){
				System.out.println("Pessoa já cadastrada no sistema.");
				return null;
			}
			updPessoa.setCpf(pessoa.getCpf());
	//-------------------------------------------------------------------------------------------
	        
			if(pessoa.getOrderLogradouro() == null ) // Caso não listado em ENUM - Logradouro = NULL
			{
				System.out.println("Tipo de Logradouro inserido de forma inválida.");
				return null;
			}
			updPessoa.setOrderLogradouro(pessoa.getOrderLogradouro());
	//-------------------------------------------------------------------------------------------

	        if (pessoa.getEndereco() == null 
	                || pessoa.getEndereco().length() >= 100 
	                || pessoa.getEndereco().matches(".*\\d.*")) {
	        	System.out.println("Endereço inserido de forma inválida.");
	            return null;
	        }
	        updPessoa.setEndereco(pessoa.getEndereco());
    //-------------------------------------------------------------------------------------------
	        
	        if (pessoa.getNumero() < 1 || pessoa.getNumero() > 9999) {
				System.out.println("Numero inserido de forma inválida.");
				return null;
			}
			updPessoa.setNumero(pessoa.getNumero());
	//-------------------------------------------------------------------------------------------
			
	        if (pessoa.getCep() == null 
	                || !pessoa.getCep().matches("\\d{5}-\\d{3}")) {
	        	System.out.println("CEP inserido de forma inválida.");
	            return null;
	        }
	        updPessoa.setCep(pessoa.getCep());
    //-------------------------------------------------------------------------------------------
	        
	        if (pessoa.getCidade() == null 
	                || pessoa.getCidade().length() >= 35 
	                || pessoa.getCidade().matches(".*\\d.*")) {
	        	System.out.println("Cidade inserido de forma inválida.");
	            return null;
	        }
	        updPessoa.setCidade(pessoa.getCidade());
    //-------------------------------------------------------------------------------------------
	        
	        if (pessoa.getOrderUf() == null) {
	        	return null;
	        }
	        updPessoa.setOrderUf(pessoa.getOrderUf());
    //-------------------------------------------------------------------------------------------
	        
			System.out.println("Pessoa atualizada com sucesso [" +
					"Nome:" + 			pessoa.getNome() + 				"," +
					" CPF:" + 			pessoa.getCpf() + 				"," +
					" Tipo de Log:" + 	pessoa.getOrderLogradouro() + 	"," +
					" Endereço:" + 		pessoa.getEndereco() + 			"," +
					" Número:" + 		pessoa.getNumero() + 			"," +
					" CEP:" + 			pessoa.getCep() + 				"," +
					" Cidade:" + 		pessoa.getCidade() + 			"," +
					" UF:" + 			pessoa.getOrderUf() + 			"]");
	        return pessoaRepository.save(updPessoa); 
	    }
    //-------------------------------------------------------------------------------------------


		System.out.println("ID não encontrado, Pessoa gravada com sucesso [" +
				"Nome:" + 			pessoa.getNome() + 				"," +
				"CPF:" + 			pessoa.getCpf() + 				"," +
				" Tipo de Log:" + 	pessoa.getOrderLogradouro() + 	"," +
				" Endereço:" + 		pessoa.getEndereco() + 			"," +
				" Número:" + 		pessoa.getNumero() + 			"," +
				" CEP:" + 			pessoa.getCep() + 				"," +
				" Cidade:" + 		pessoa.getCidade() + 			"," +
				" UF:" + 			pessoa.getOrderUf() + 			"]");
	    return pessoaRepository.save(pessoa);         
	}
	
	// ----- DELETAR -------------------------------------------------------------	
	public void delete(Long id) {
		System.out.println("Id " + "[" + id +"]"+ " Deletado com sucesso");
		pessoaRepository.deleteById(id);
	}
	
	// ----- MALA DIRETA -------------------------------------------------------------
	
	public MalaDiretaDto buscarPorId(Long id) {
		Optional<Pessoas> pessoa = pessoaRepository.findById(id);
		if (pessoa.isEmpty()) {
			System.out.println("Não encontrado pessoa no ID: ["+ id +"]");
			return null; 
		}
		System.out.println("Mala direta retornada com sucesso");
		return new MalaDiretaDto(pessoa.get());
	}
    
    // ----- LISTAGEM MALA DIRETA -------------------------------------------------------------
	public List<MalaDiretaDto> listarTodos() {
		System.out.println("Listagem de Mala direta retornada com sucesso");
		return pessoaRepository.findAll().stream().map(MalaDiretaDto::new).toList();
	}
		
}

