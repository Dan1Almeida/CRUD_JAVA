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
				|| pessoa.getNome().length() >= 150 // Tamanho Total
				|| pessoa.getNome().matches(".*\\d.*") // Não pode Numeros
				|| pessoa.getNome().split("\\s+").length < 2) // Tamanho mínimo de duas palavras
		{
			System.out.println("Nome inserido de forma incorreta.");
			return null;
		}
		
		if(pessoa.getEndereco() == null 
				|| pessoa.getEndereco().length() >= 100 
				|| pessoa.getEndereco().matches(".*\\d.*")) {
			System.out.println("Endereço inserido de forma incorreta.");
			return null;
		}
		
		if(pessoa.getCep() == null 
				|| !pessoa.getCep().matches("\\d{5}-\\d{3}")) {
			System.out.println("CEP inserido de forma incorreta.");
			return null;
		}
		
		if(pessoa.getCidade() == null 
				|| pessoa.getCidade().length() >= 100 
				|| pessoa.getCidade().matches(".*\\d.*")) {
			System.out.println("Cidade inserido de forma incorreta.");
			return null;
		}
		
		if(pessoa.getUf() == null) {
			System.out.println("Estado inserido de forma incorreta.");
			return null;
		}

		System.out.println("[" +
				"Nome:" + 		pessoa.getNome() + 		"," +
				" Endereço:" + 	pessoa.getEndereco() + 	"," +
				" CEP:" + 		pessoa.getCep() + 		"," +
				" Cidade:" + 	pessoa.getCidade() + 	"," +
				" UF:" + 		pessoa.getUf() + 		"]");
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
		
		if(findPessoa.isPresent()) {
			Pessoas updPessoa = findPessoa.get(); 
			updPessoa.setNome(pessoa.getNome()); 
			updPessoa.setEndereco(pessoa.getEndereco());
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setCidade(pessoa.getCidade());
			updPessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updPessoa); 
		}
		return pessoaRepository.save(pessoa); 		
	}
	
	// ----- DELETAR -----	
	public void delete(Long id) {
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
        return pessoaRepository.findAll()
            .stream()
            .map(MalaDiretaDto::new)
            .toList();
    }
		
}

