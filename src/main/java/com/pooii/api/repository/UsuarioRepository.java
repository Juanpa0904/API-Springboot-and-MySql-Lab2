package com.pooii.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pooii.api.entities.Usuario;
import com.pooii.api.entities.UsuarioPK;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioPK>, CrudRepository<Usuario, UsuarioPK> {

		@Query("SELECT usr FROM UsrANDPer usr WHERE usr.id.login = :login AND usr.id.persona = :persona")
		public abstract Usuario getUsuarioANDPersona(@Param("login") String login, @Param("persona") int persona);

		//usr.id.login, usr.id.persona, usr.apikey, usr.password
		@Query("SELECT usr FROM UsrANDPer usr WHERE usr.id.login = :login")
		public abstract Usuario findByUsername(@Param("login") String login);
		
		@Query("SELECT usr FROM UsrANDPer usr WHERE usr.id.login = :login AND usr.apikey = :apikey ")
		public abstract Usuario findByUsernameANDAPIKey(@Param("login") String login, @Param("apikey") String APIKey);
	}

