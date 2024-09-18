package com.pooii.api.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pooii.api.entities.Usuario;
import com.pooii.api.entities.UsuarioPK;

public interface IUsuarioService {

	//METODOS CRUD
	
	boolean save(Usuario usuario);
	boolean update(Usuario usuario);
	boolean delete(UsuarioPK id);
	
	List<Usuario> getUsuarios(Pageable pageable);
	
	Usuario getUsuarioById(UsuarioPK id);
	
}
