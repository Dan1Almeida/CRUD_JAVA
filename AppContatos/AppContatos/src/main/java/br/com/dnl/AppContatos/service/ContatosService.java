package br.com.dnl.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dnl.AppContatos.model.Contatos;
import br.com.dnl.AppContatos.model.Pessoas;
import br.com.dnl.AppContatos.repository.ContatosRepository;
import br.com.dnl.AppContatos.repository.PessoasRepository;

@Service
public class ContatosService {
	
	@Autowired
	private ContatosRepository contatoRepository;
	
	

	@Autowired
	private PessoasRepository pessoaRepository;

	
	
		public Contatos save(Contatos contato) {		
		
		if(contato.getPessoa().getId() != null) {
			
			Optional<Pessoas> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());
			if(findPessoa.isEmpty()) {
				System.out.println("Pessoa não encontrado");
				return null;
			}else {
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			}			
		}else {
			System.out.println("Pessoa nula");
			return null;
		}		
	}

	
	
	// ------- ENCONTRAR PELO ID
	public Optional<Contatos> findById(Long id){
		return contatoRepository.findById(id);
	}
	
	// ---------- LISTAGEM
	public List<Contatos> findAll(){
		return contatoRepository.findAll();
	}
	
	public Contatos update(Contatos contato) {
		Optional<Contatos> findContato = contatoRepository.findById(contato.getId());
		if(findContato.isPresent()) {

			Contatos updContato = findContato.get();
			updContato.setTipo(contato.getTipo());
			updContato.setContato(contato.getContato());

			return contatoRepository.save(updContato);
		}
		return contatoRepository.save(contato);
	}
	
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
	
}
