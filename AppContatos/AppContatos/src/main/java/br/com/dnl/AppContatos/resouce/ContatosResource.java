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
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos")
public class ContatosResource {
	
	@Autowired
	private ContatosService contatoService;
	
	
	@PostMapping //POST http://localhost:8080/api/estoque
	@Operation(summary = "Este endpoint é para gravar um registro de estoque e tem que ter o produto!")
	public ResponseEntity<Contatos> save(@RequestBody Contatos contato){
		Contatos newContato = contatoService.save(contato);
		if(newContato == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(newContato);
	}
	
	// ------- ENCONTRAR PELO ID
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contatos>> findById(@PathVariable Long id){
		Optional<Contatos> findContato = contatoService.findById(id);
		if(findContato == null)
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(findContato);
	}
	
	
	// ------- LISTAR CONTATOS
	@GetMapping
	public ResponseEntity<List<Contatos>> findAll(){
		List<Contatos> findContato = contatoService.findAll();
		if(findContato == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(findContato); //200
		}
	
	// ------ ATUALIZAR
	
	@PutMapping
	public ResponseEntity<Contatos> update(@RequestBody Contatos contato){
		Contatos updContato = contatoService.update(contato);
		if(updContato == null)
			return ResponseEntity.badRequest().build(); //400
		return ResponseEntity.ok(updContato); //200
	}
	
	
	// ----- DELETAR
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
	}
	
}
