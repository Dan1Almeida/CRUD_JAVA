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

import br.com.dnl.AppContatos.Dto.MalaDiretaDto;
import br.com.dnl.AppContatos.model.Pessoas;
import br.com.dnl.AppContatos.service.PessoasService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/pessoas") //http://localhost:8080/api/pessoas
public class PessoasResource {

	@Autowired
	PessoasService pessoaService;
	
	// ----- SALVAR -----
	
	@PostMapping //POST http://localhost:8080/api/pessoas
	@Operation(summary = "Gravar uma nova pessoa")
	public ResponseEntity<Pessoas> save(@RequestBody Pessoas pessoa) {
		Pessoas newPessoa = pessoaService.save(pessoa);
		
		if(newPessoa == null) {
			return ResponseEntity.badRequest().build();
		}
		else {
			return ResponseEntity.ok(newPessoa); 
		}
	}
	
	// ----- ENCONTRAR POR ID -----
	
	@GetMapping("/{id}") // GET http://localhost:8080/api/pessoas/{id}
	@Operation(summary = "Encontrar uma pessoa por ID")
		public ResponseEntity<Optional<Pessoas>> findById(@PathVariable Long id){
			Optional<Pessoas> pessoa = pessoaService.findById(id);
			if(pessoa.isEmpty()) { 
				return ResponseEntity.notFound().build(); 
			}else {
				return ResponseEntity.ok(pessoa);
			}
	}
	
	// ----- LISTAGEM -----
	
	@GetMapping //GET http://localhost:8080/api/pessoas
	@Operation(summary = "Listar pessoas cadastradas")
		public ResponseEntity<List<Pessoas>> findAll(){
			List<Pessoas> pessoa = pessoaService.findAll();
			if(pessoa == null)
				return ResponseEntity.badRequest().build();
			if(pessoa.size() == 0)
				return ResponseEntity.notFound().build();
			return ResponseEntity.ok(pessoa);
	}
	
	// ----- ATUALIZAR -----
	
	@PutMapping("/{id}") //PUT http://localhost:8080/api/pessoas/{id}
	@Operation(summary = "Atualizar atributo de uma pessoa")
		public ResponseEntity<Pessoas> update(@PathVariable Long id, @RequestBody Pessoas pessoa){
			Pessoas updPessoa = pessoaService.update(id, pessoa);
			if(updPessoa == null) {
				return ResponseEntity.badRequest().build();
			}else {
				return ResponseEntity.ok(updPessoa); 
			}
	}
	
	// ----- DELETAR -----
	
	@DeleteMapping("/{id}") //DELETE http://localhost:8080/api/pessoas/{id}
	@Operation(summary = "Deletar uma pessoa por ID")
		public ResponseEntity<?> delete(@PathVariable Long id){
			pessoaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// ----- MALA DIRETA ----- 
    @GetMapping("/maladireta/{id}")
    public ResponseEntity<MalaDiretaDto> buscarMalaDireta(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }
    
    // ----- LISTAGEM MALA DIRETA -----
    @GetMapping("/maladireta")
    public ResponseEntity<List<MalaDiretaDto>> listarMalaDireta() {
        return ResponseEntity.ok(pessoaService.listarTodos());
    }
    
}
