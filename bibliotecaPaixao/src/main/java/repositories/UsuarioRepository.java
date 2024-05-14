package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Usuario;

public interface UsuarioRepository
	extends JpaRepository<Usuario, Integer> {
}