package br.org.serratec.bibliotecaPaixao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.bibliotecaPaixao.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

}
