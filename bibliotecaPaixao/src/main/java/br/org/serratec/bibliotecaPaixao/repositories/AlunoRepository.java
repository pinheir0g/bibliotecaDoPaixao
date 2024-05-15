package br.org.serratec.bibliotecaPaixao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.bibliotecaPaixao.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}