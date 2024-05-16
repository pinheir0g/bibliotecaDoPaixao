package br.org.serratec.bibliotecaPaixao.controllers;

import java.util.List;

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

import br.org.serratec.bibliotecaPaixao.entities.Livro;
import br.org.serratec.bibliotecaPaixao.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroService livroService;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Livro livro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livro));
	}

	@GetMapping
	public ResponseEntity<List<Livro>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(livroService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> find(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(livroService.findById(id));
	}

	@PutMapping
	public ResponseEntity<Livro> update(@RequestBody Livro livro) {
		return ResponseEntity.status(HttpStatus.OK).body(livroService.update(livro));
	}

	@DeleteMapping
	public ResponseEntity<Object> delete(@RequestBody Livro livro) {
		var livro0 = livroService.findById(livro.getLivroId());
		if (livroService.delete(livro) != null)
			return ResponseEntity.status(HttpStatus.OK)
					.body("{'Status': 'Deletado com sucesso', " + livro0.toString() + "}");
		return ResponseEntity.status(HttpStatus.OK).body("{'Status': 'Deletado com sucesso' }");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
		if (livroService.findById(id) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(livroService.deleteById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Livro não encontrado!'}");
	}

}
