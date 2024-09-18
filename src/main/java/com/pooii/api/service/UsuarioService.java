package com.pooii.api.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.pooii.api.entities.Usuario;
import com.pooii.api.entities.UsuarioPK;
import com.pooii.api.repository.UsuarioRepository;
import com.pooii.api.service.interfaces.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService, UserDetailsService {

	// INYECCIÓN DE DEPENDENCIAS

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

	// LOGS DE ERROR
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(PersonaService.class);

	// INSERT

	@Override
	public boolean save(Usuario usuario) {
		try {
			if (usuario == null) {
				logger.error("ERROR AGREGAR_USUARIO: EL USUARIO ES NULO");
				return false;
			} else {
				usuarioRepository.save(usuario);
				return true;
			}
		} catch (Exception e) {
			logger.error("ERROR AGREGAR_USUARIO: EL USUARIO NO SE HA GUARDADO");
			return false;
		}
	}

	// UPDATE

	@Override
	public boolean update(Usuario usuario) {
		try {
			if (usuario == null || (usuario.getId().getPersona() == 0) || (usuario.getId().getLogin().isEmpty())
					|| (usuario.getId().getLogin() == null)) {
				logger.error("ERROR EDITAR_USUARIO: EL USUARIO ES NULO O EL ID ES 0 EL LOGIN ES NULL!");
				return false;
			} else {
				usuarioRepository.save(usuario);
				return true;
			}
		} catch (Exception e) {
			logger.error("ERROR EDITAR_USUARIO: EL USUARIO NO SE HA EDITADO");
			return false;
		}
	}

	// DELETE

	@Override
	public boolean delete(UsuarioPK id) {
		try {
			if (id.getPersona() == 0 || (id.getLogin().isEmpty()) || (id.getLogin() == null)) {
				logger.error("ERROR ELIMINAR_PERSONA: EL USUARIO ES NULO O EL ID ES 0 NULL!");
				return false;
			} else {
				Usuario usuario = usuarioRepository.getUsuarioANDPersona(id.getLogin(), id.getPersona());
				usuarioRepository.delete(usuario);
				return true;
			}
		} catch (Exception e) {
			logger.error("ERROR ELIMINAR_PERSONA: EL USUARIO NO SE HA ELIMINADO");
			return false;
		}
	}
	
	// READ
	@Override
	public List<Usuario> getUsuarios(Pageable pageable) {
		return  usuarioRepository.findAll(pageable).getContent();  
	}
   
	@Override
	public Usuario getUsuarioById(UsuarioPK id) {
		return usuarioRepository.getUsuarioANDPersona(id.getLogin(), id.getPersona());
	}
	
	public Usuario findByUsernameANDAPIKey(String login, String apikey) {
		return usuarioRepository.findByUsernameANDAPIKey(login, apikey);
	}
	
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario appUser = usuarioRepository.findByUsername(username);
		List grantList = new ArrayList();
		System.out.println("Crear el objeto UserDetails que va ir en sesion y retornarlo");
		UserDetails user = (UserDetails) new User(appUser.getId().getLogin(), appUser.getPassword(), grantList);
		return user;
		
	}
	
}
