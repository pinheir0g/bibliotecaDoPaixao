package br.org.serratec.bibliotecaPaixao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.org.serratec.bibliotecaPaixao.entities.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
	
}
