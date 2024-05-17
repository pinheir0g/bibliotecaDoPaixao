package br.org.serratec.bibliotecaPaixao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.bibliotecaPaixao.entities.Aluno;
import br.org.serratec.bibliotecaPaixao.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno update(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public Aluno findById(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public Aluno deleteById(Integer id) {
		var aluno0 = findById(id);
		try {
			if (aluno0 != null) {
				alunoRepository.delete(aluno0);
				return aluno0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aluno0;
	}

}