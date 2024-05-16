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

import br.org.serratec.bibliotecaPaixao.entities.Perfil;
import br.org.serratec.bibliotecaPaixao.services.PerfilService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

	@Autowired
	PerfilService perfilService;

	@GetMapping
	public ResponseEntity <List<Perfil>> findAll() {
		return new ResponseEntity<>(perfilService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id) {
		Perfil perfil = perfilService.findById(id);

		if(perfil == null) {
			return new ResponseEntity<>("{Erro: Usuário não encontrado}", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(perfil, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Perfil> save(@RequestBody Perfil perfil) {
		return new ResponseEntity<>(perfilService.save(perfil), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Perfil> update(@RequestBody Perfil perfil) {
		return new ResponseEntity<>(perfilService.update(perfil), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePerfilById(@PathVariable Integer id) {
		Perfil perfilDeletado = perfilService.deleteById(id);
		if (perfilDeletado != null) {
			return new ResponseEntity<>(perfilDeletado, HttpStatus.OK);
		}
		return new ResponseEntity<>("{Erro: Perfil não encontrado}", HttpStatus.NOT_FOUND);
	}
}

