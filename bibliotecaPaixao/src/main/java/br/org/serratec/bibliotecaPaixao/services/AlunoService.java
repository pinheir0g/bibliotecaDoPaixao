package br.org.serratec.bibliotecaPaixao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.bibliotecaPaixao.entities.Aluno;
import br.org.serratec.bibliotecaPaixao.repositories.AlunoRepository;
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
	public Aluno delete(Aluno aluno) {
		var aluno0 = findById(aluno.getAlunoMatricula());
		try {
			if (aluno0 != null) {
				alunoRepository.delete(aluno);
				return aluno0;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return aluno0;
	}

}