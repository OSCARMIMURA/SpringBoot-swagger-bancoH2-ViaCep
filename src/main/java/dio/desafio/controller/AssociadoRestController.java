package dio.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.desafio.model.Associado;
import dio.desafio.service.AssociadoService;

@RestController
@RequestMapping("/")
public class AssociadoRestController {

	@Autowired
	private AssociadoService associadoService;
	
	@GetMapping
	public ResponseEntity<Iterable<Associado>> buscarTodos(){
		return ResponseEntity.ok(associadoService.buscarTodos());
	}
	
	@GetMapping("/associados/{id}")
	public ResponseEntity<Associado> buscarPorId(@PathVariable Long id ){
		
		return ResponseEntity.ok(associadoService.buscarPorId(id));
	}
	
	@PostMapping("/associados")
	public ResponseEntity<Associado> inserir (@RequestBody Associado associado){
		associadoService.inserir(associado);
		return ResponseEntity.ok(associado);
	}
	
	@PutMapping("/associados/atualizar/{id}")
	public ResponseEntity<Associado> atualizar(@PathVariable Long id, @RequestBody Associado associado ){
		associadoService.atualizar(id, associado);
		return ResponseEntity.ok(associado);
		
	}
	
	@DeleteMapping("/associados/deletar/{id}")
	public ResponseEntity<Associado> deletar (@PathVariable Long id ){
		associadoService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
