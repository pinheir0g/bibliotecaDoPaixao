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

import br.org.serratec.bibliotecaPaixao.entities.Editora;
import br.org.serratec.bibliotecaPaixao.services.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	EditoraService editoraService;

	@PostMapping
	public ResponseEntity<Editora> saveEditora(@RequestBody Editora editora){
		return ResponseEntity.status(HttpStatus.CREATED).body(editoraService.save(editora));
	}

	@GetMapping
	public ResponseEntity<List<Editora>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(editoraService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id){
		Editora editora = editoraService.findById(id);
		if(editora != null) {
			return ResponseEntity.status(HttpStatus.OK).body(editoraService.findById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Editora não encontrada'}");
	}

	@PutMapping
	public ResponseEntity<Editora> update(@RequestBody Editora editora){
		return ResponseEntity.status(HttpStatus.OK).body(editoraService.update(editora));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Integer id){
		if (editoraService.findById(id) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(editoraService.deleteById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Editora não encontrada'}");
	}
}