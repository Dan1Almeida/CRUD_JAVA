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
	
	// ----- SALVAR CONTATO -----
	public Contatos save(Contatos contato) {		
		
		if(contato.getPessoa().getId() != null) {
			
			Optional<Pessoas> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());
			if(findPessoa.isEmpty()) {
				System.out.println("Pessoa não encontrada");
				return null;
			}		
			
			else {
				contato.setPessoa(findPessoa.get());
				System.out.println("[" +
						" Nome:" + 		contato.getOrderTipo()	+	 "," +
						" Endereço:" + 	contato.getContato() 	+ 	"]" );
				return contatoRepository.save(contato);
			}			
			}else {
			System.out.println("Contato inserido de forma incorreta.");
			return null;
		}		
	}

	// ----- ENCONTRAR POR ID -----
	public Optional<Contatos> findById(Long id){
		return contatoRepository.findById(id);
	}
	
	// ----- LISTAGEM -----
	public List<Contatos> findAll(){
		return contatoRepository.findAll();
	}
	
	// ------ CONTATOS POR PESSOA -----
    public List<Contatos> listarContatosPorPessoa(Long idPessoa) {
        return contatoRepository.findByPessoaId(idPessoa);
    }
	
	
	// ----- ATUALIZAR ----- ARRUMAR
	public Contatos update(Long id,Contatos contato) {
		
		Optional<Contatos> findContato = contatoRepository.findById(id);
		
		if(findContato.isPresent()) {

			Contatos updContato = findContato.get();
			updContato.setContato(contato.getContato());

			return contatoRepository.save(updContato);
		}
		return contatoRepository.save(contato);
	}
	
	// ----- DELETAR -----
	
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
	
}
