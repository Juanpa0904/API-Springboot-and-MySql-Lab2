package com.pooii.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import com.pooii.api.service.UsuarioService;
import com.pooii.api.config.JWTAuthenticationConfig;
import com.pooii.api.entities.Usuario;
import com.pooii.api.model.JwtRequest;
import com.pooii.api.model.JwtResponse;


@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	JWTAuthenticationConfig jwtAuthtenticationConfig;
	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	@RequestMapping(
			value = "/authenticate",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest, @RequestHeader("APIkey") String APIKey )
			throws Exception {
		System.out.println("********************************************************************");
		System.out.println("authenticationRequest.getUsername():["+authenticationRequest.getUsername()+"]");
		System.out.println("authenticationRequest.getPassword():["+authenticationRequest.getPassword()+"]");
		System.out.println("APIKey:["+APIKey+"]");
		System.out.println("********************************************************************");
		Usuario user = usuarioService.findByUsernameANDAPIKey(authenticationRequest.getUsername(), APIKey);
		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(user.getId().getLogin());
		final String token = jwtAuthtenticationConfig.getJWTToken(user.getId().getLogin());
		System.out.println("********************************************************************");
		System.out.println("token:["+token+"]");
		System.out.println("********************************************************************");
		return ResponseEntity.ok(new JwtResponse(token));
	}
}