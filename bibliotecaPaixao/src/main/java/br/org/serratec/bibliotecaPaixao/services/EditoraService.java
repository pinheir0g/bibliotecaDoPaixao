package br.org.serratec.bibliotecaPaixao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.bibliotecaPaixao.entities.Editora;
import br.org.serratec.bibliotecaPaixao.repositories.EditoraRepository;
import jakarta.transaction.Transactional;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository editoraRepository;

	public List<Editora> findAll(){
		return editoraRepository.findAll();
	}

	public Editora findById(Integer id) {
		return editoraRepository.findById(id).orElse(null);
	}

	public Editora save(Editora editora) {
		return editoraRepository.save(editora);
	}

	public Editora update(Editora editora) {
		return editoraRepository.save(editora);
	}

	public Editora delete(Editora editora) {
		Editora editoraExcluido = editoraRepository.findById(editora.getEditoraId()).orElse(null);
		try {
			if(editoraExcluido != null) {
				editoraRepository.delete(editoraExcluido);
				return editoraExcluido;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return editoraExcluido;
	}
	
	
	@Transactional
	public Editora deleteById(Integer id) {
		Editora editoraExcluido = editoraRepository.findById(id).orElse(null);
		try {
			if(editoraExcluido != null) {
				editoraRepository.delete(editoraExcluido);
				return editoraExcluido;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return editoraExcluido;
	}

	public long count() {
		return editoraRepository.count();
	}
}
