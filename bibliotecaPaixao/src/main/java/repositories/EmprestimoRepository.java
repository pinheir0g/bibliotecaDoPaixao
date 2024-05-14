package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer>{

}
