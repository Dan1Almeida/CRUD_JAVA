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
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/contatos")
public class ContatosResource {
	
	@Autowired
	private ContatosService contatoService;
		
	// ----- SALVAR CONTATO -------------------------------------------------------------
	
	@PostMapping //POST http://localhost:8080/api/contatos
	@Operation(summary = " Grava um contato e liga a uma pessoa.")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Pessoa não encontrada"),
		@ApiResponse(responseCode = "400", description = "Erro ao cadastrar Contato"),
		@ApiResponse(responseCode = "201", description = "Contato cadastrado com sucesso")
	})
	public ResponseEntity<Contatos> save(@RequestBody Contatos contato) {
		if (contato.getPessoa() == null ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	
		Contatos newContato = contatoService.save(contato);
		if (newContato == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(newContato);
	}
	
	// ----- ATUALIZAR ------------------------------------------------------------- 
	
		@PutMapping("/{id}") // PUT http://localhost:8080/api/contatos/1
		@Operation(summary = "Atualiza um contato com o {ID} requisitado.")
		@ApiResponses({
		    @ApiResponse(responseCode = "404", description = "Contato não encontrado"),
		    @ApiResponse(responseCode = "400", description = "Atualização não aceita"),
		    @ApiResponse(responseCode = "200", description = "Contato atualizado")
		})
		public ResponseEntity<Contatos> update(@PathVariable Long id, @RequestBody Contatos contato) {

		    Optional<Contatos> contatoExistente = contatoService.findById(id);
		    if (contatoExistente.isEmpty()) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		    }

		    Contatos updContato = contatoService.update(id, contato);

		    if (updContato == null) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		    }

		    return ResponseEntity.status(HttpStatus.OK).body(updContato);
		}
		
		// ----- DELETAR -------------------------------------------------------------
		
		@DeleteMapping("/{id}") // DELETE http://localhost:8080/api/contatos/1
		@Operation(summary = "Deleta um contato com o {ID} requisitado.")
		@ApiResponse(responseCode = "204", description = "Contato deletado com sucesso")

		public ResponseEntity<?> delete(@PathVariable Long id){
			contatoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}

	
	// ----- ENCONTRAR POR ID -------------------------------------------------------------
	
	@GetMapping("/{id}") // GET http://localhost:8080/api/contatos/1
	@Operation(summary = "Encontra um contato com o {ID} requisitado.")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Contato não encontrada"),
		@ApiResponse(responseCode = "200", description = "Contato encontrado")
	})
	public ResponseEntity<Optional<Contatos>> findById(@PathVariable Long id) {
		Optional<Contatos> findContato = contatoService.findById(id);

		if (findContato.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
		}

		return ResponseEntity.status(HttpStatus.OK).body(findContato); // 200
	}
	
	// ----- LISTAGEM -------------------------------------------------------------
	
	@GetMapping // GET http://localhost:8080/api/contatos
	@Operation(summary = "Lista todos contatos cadastrados.")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Contato não encontrado"),
		@ApiResponse(responseCode = "200", description = "Contato deletado")
	})
	public ResponseEntity<List<Contatos>> findAll() {
		List<Contatos> findContato = contatoService.findAll();

		if (findContato.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}

		return ResponseEntity.status(HttpStatus.OK).body(findContato); 
	}

	
	// ------ CONTATOS POR PESSOA -------------------------------------------------------------
	
	@GetMapping("/pessoas/{idPessoa}") // GET http://localhost:8080/api/contatos/pessoa/1
	@Operation(summary = "Lista todos contatos de uma Pessoa.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Pessoa encontrado"),
		@ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
	})

	public ResponseEntity<List<Contatos>> listarContatos(@PathVariable Long idPessoa) {
		List<Contatos> contato = contatoService.listarContatosPorPessoa(idPessoa);

		if (contato.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		}

		return ResponseEntity.status(HttpStatus.OK).body(contato);
	}

}
