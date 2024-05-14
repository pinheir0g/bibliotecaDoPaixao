package br.org.serratec.bibliotecaPaixao.repository;

import br.org.serratec.bibliotecaPaixao.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
