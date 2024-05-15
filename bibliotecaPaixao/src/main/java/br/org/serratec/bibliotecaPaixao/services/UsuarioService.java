package br.org.serratec.bibliotecaPaixao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.bibliotecaPaixao.entities.Usuario;
import br.org.serratec.bibliotecaPaixao.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario delete(Usuario usuario) {
		Usuario usuarioExcluido = usuarioRepository.findById(usuario.getUserId()).orElse(null);
		try {
			usuarioRepository.delete(usuarioExcluido);
			if(usuarioExcluido != null) {
				return usuarioExcluido;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usuarioExcluido;
	}
	
	public Usuario deleteById(Integer id) {
		Usuario usuarioExcluido = usuarioRepository.findById(id).orElse(null);
		try {
			usuarioRepository.delete(usuarioExcluido);
			if(usuarioExcluido != null) {
				return usuarioExcluido;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usuarioExcluido;
	}
	
	public long count() {
		return usuarioRepository.count();
	}
}