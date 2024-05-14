package br.org.serratec.bibliotecaPaixao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.bibliotecaPaixao.entities.Emprestimo;
import br.org.serratec.bibliotecaPaixao.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimoRepository;

	public Emprestimo save(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo update(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	public List<Emprestimo> findAll() {
		return emprestimoRepository.findAll();
	}

	public Emprestimo findById(Integer id) {
		return emprestimoRepository.findById(id).orElse(null);
	}

	public Emprestimo delete(Emprestimo emprestimo) {
		Emprestimo emprestimoExcluido = emprestimoRepository.findById(emprestimo.getEmprestimoId()).orElse(null);
		try {
			if (emprestimo != null)
				emprestimoRepository.delete(emprestimoExcluido);
			return emprestimoExcluido;
		} catch (Exception e) {
			System.out.println(e);
		}
		return emprestimoExcluido;
	}

	public Emprestimo deleteById(Integer id) {
		Emprestimo emprestimo = emprestimoRepository.findById(id).orElse(null);
		try {
			if (emprestimo != null)
				emprestimoRepository.deleteById(id);
			return emprestimo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return emprestimo;
	}

	public long count() {
		return emprestimoRepository.count();
	}
}
