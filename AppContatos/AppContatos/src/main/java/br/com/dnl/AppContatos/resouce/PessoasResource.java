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

import br.com.dnl.AppContatos.model.Pessoas;
import br.com.dnl.AppContatos.service.PessoasService;


@RestController
@RequestMapping("/api/pessoas") //http://localhost:8080/api/pessoas
public class PessoasResource {

	@Autowired
	PessoasService pessoaService;
	
	@PostMapping //POST http://localhost:8080/api/pessoas
	public ResponseEntity<Pessoas> save(@RequestBody Pessoas pessoa) {
		Pessoas newPessoa = pessoaService.save(pessoa);
		
		if(newPessoa == null) {
			return ResponseEntity.badRequest().build(); //dê status code 400
		}
		else {
			return ResponseEntity.ok(newPessoa); //dê status code 200 e retorna objeto
		}
	}
	
	
	// --------- ENCONTRAR POR ID
	
	@GetMapping("/{id}") // GET http://localhost:8080/api/pessoas/{id}
		public ResponseEntity<Optional<Pessoas>> findById(@PathVariable Long id){
			Optional<Pessoas> pessoa = pessoaService.findById(id);
			if(pessoa.isEmpty()) { 
				return ResponseEntity.notFound().build(); //404
			}else {
				return ResponseEntity.ok(pessoa); //200
			}
	}
	
	// -------- LISTAGEM
	
	@GetMapping //GET http://localhost:8080/api/pessoas
		public ResponseEntity<List<Pessoas>> findAll(){
			List<Pessoas> produtos = pessoaService.findAll();
			if(produtos == null)
				return ResponseEntity.badRequest().build();
			if(produtos.size() == 0)
				return ResponseEntity.notFound().build();
			return ResponseEntity.ok(produtos);
	}
	
	// --------- UPDATE
	
	@PutMapping("/{id}") //PUT http://localhost:8080/api/pessoas/{id}
		public ResponseEntity<Pessoas> update(@PathVariable Long id, @RequestBody Pessoas pessoa){
			Pessoas updPessoa = pessoaService.update(id, pessoa);
			if(updPessoa == null) {
				return ResponseEntity.badRequest().build(); //dê status code 400
			}else {
				return ResponseEntity.ok(updPessoa); //dê status code 200 e retorna objeto
			}
	}
	
	// --------- DELETAR
	
	@DeleteMapping("/{id}") //DELETE http://localhost:8080/api/pessoas/{id}
		public ResponseEntity<?> delete(@PathVariable Long id){
			pessoaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
	}
	
	
}
