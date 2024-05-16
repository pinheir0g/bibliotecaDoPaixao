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

import br.org.serratec.bibliotecaPaixao.entities.Emprestimo;
import br.org.serratec.bibliotecaPaixao.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	EmprestimoService emprestimoService;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Emprestimo emprestimo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoService.save(emprestimo));
	}

	@PutMapping
	public ResponseEntity<Emprestimo> update(@RequestBody Emprestimo emprestimo) {
		try {
			emprestimoService.update(emprestimo);
			return new ResponseEntity<>(emprestimo, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(emprestimo, HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<List<Emprestimo>> findAll() {
		return new ResponseEntity<>(emprestimoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id) {
		if (emprestimoService.findById(id) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.findById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Emprestimo não encontrado!'}");
	}

	@DeleteMapping
	public ResponseEntity<Object> delete(@RequestBody Emprestimo emprestimo) {
		if (emprestimoService.findById(emprestimo.getEmprestimoId()) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.delete(emprestimo));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Emprestimo não encontrado!'}");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
		if (emprestimoService.findById(id) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.deleteById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Emprestimo não encontrado!'}");
	}
}
