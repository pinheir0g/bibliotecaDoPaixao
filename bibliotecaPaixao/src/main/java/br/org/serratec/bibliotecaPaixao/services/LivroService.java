package br.org.serratec.bibliotecaPaixao.services;

import br.org.serratec.bibliotecaPaixao.entities.Livro;
import br.org.serratec.bibliotecaPaixao.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;

	public Livro save(Livro livro) {
		return livroRepository.save(livro);
	}

	public Livro update(Livro livro) {
		return livroRepository.save(livro);
	}

	public List<Livro> findAll() {
		return livroRepository.findAll();
	}

	public Livro findById(Integer id) {
		return livroRepository.findById(id).orElse(null);
	}

	public Livro delete(Livro livro) {
		var livro0 = findById(livro.getLivroId());
		try {
			if (livro0 != null) {
				livroRepository.delete(livro);
				return livro0;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return livro0;
	}
}
