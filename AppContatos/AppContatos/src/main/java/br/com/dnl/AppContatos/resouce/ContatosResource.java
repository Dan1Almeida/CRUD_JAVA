package br.com.dnl.AppContatos.resouce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dnl.AppContatos.model.Contatos;
import br.com.dnl.AppContatos.service.ContatosService;


@RestController
@RequestMapping("/api/contatos")
public class ContatosResource {
	
	@Autowired
	private ContatosService contatoService;
	
	
	@PostMapping //POST http://localhost:8080/api/contatos
	public ResponseEntity<Contatos> save(@RequestBody Contatos contato){
		Contatos newContato = contatoService.save(contato);
		if(newContato == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(newContato);
	}
	
	// ------- ENCONTRAR PELO ID
	
	@GetMapping("/{id}") // GET http://localhost:8080/api/contatos/1
	public ResponseEntity<Optional<Contatos>> findById(@PathVariable Long id){
		Optional<Contatos> findContato = contatoService.findById(id);
		if(findContato == null)
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(findContato);
	}
	
	
	// ------- LISTAR CONTATOS
	@GetMapping // GET http://localhost:8080/api/contatos
	public ResponseEntity<List<Contatos>> findAll(){
		List<Contatos> findContato = contatoService.findAll();
		if(findContato == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(findContato); //200
		}
	
	// --------- LISTAR CONTATOS POR PESSOA
	@GetMapping("/pessoas/{idPessoa}") // GET http://localhost:8080/api/contatos/pessoa/1
    public ResponseEntity<List<Contatos>> listarContatos(@PathVariable Long idPessoa) {
        List<Contatos> contato = contatoService.listarContatosPorPessoa(idPessoa);
        
        if (contato.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(contato);
    }
	
	
	// ------ ATUALIZAR
	
	@PutMapping("/{id}") // PUT http://localhost:8080/api/contatos/
	public ResponseEntity<Contatos> update(@PathVariable Long id, @RequestBody Contatos contato){
		Contatos updContato = contatoService.update(id, contato);
		if(updContato == null)
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(updContato);
	}
	
	
	// ----- DELETAR
	
	@DeleteMapping("/{id}") // DELETE http://localhost:8080/api/contatos/1
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
	}
	
}
