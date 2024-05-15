package br.org.serratec.bibliotecaPaixao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.bibliotecaPaixao.entities.Usuario;


public interface UsuarioRepository
	extends JpaRepository<Usuario, Integer> {
}
