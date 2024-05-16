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

import br.org.serratec.bibliotecaPaixao.entities.Aluno;
import br.org.serratec.bibliotecaPaixao.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@PostMapping
	public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
	}

	@PutMapping
	public ResponseEntity<Aluno> update(@RequestBody Aluno aluno) {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.update(aluno));
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.findById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
		if (alunoService.findById(id) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(alunoService.deleteById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Aluno não encontrado'}");
	}
}
