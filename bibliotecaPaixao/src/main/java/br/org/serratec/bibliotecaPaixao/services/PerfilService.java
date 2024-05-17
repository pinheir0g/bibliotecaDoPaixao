package br.org.serratec.bibliotecaPaixao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.bibliotecaPaixao.entities.Perfil;
import br.org.serratec.bibliotecaPaixao.repositories.PerfilRepository;
import jakarta.transaction.Transactional;

@Service
public class PerfilService {

	@Autowired
	PerfilRepository perfilRepository;

	public List<Perfil> findAll() {
		return perfilRepository.findAll();
	}

	public Perfil findById(Integer id) {
		return perfilRepository.findById(id).orElse(null);
	}

	public Perfil save(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public Perfil update(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public Perfil deletePerfil(Perfil perfil) {
		try {
			if(perfilRepository.existsById(perfil.getPerfilID())) {

			perfilRepository.deleteById(perfil.getPerfilID());
			return perfil;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return perfil;
	}

	@Transactional
	public Perfil deleteById(Integer id) {
		Perfil perfil = perfilRepository.findById(id).orElse(null);
		try {
			if(perfil != null)
				perfilRepository.deleteById(id);
				return perfil;

		}catch(Exception e) {
			System.out.println(e);
		}
		return perfil;
	}

	public long count() {
		return perfilRepository.count();
	}

}

