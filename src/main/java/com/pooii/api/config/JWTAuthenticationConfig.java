package com.pooii.api.config;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.pooii.api.model.Constans;

@Configuration
public class JWTAuthenticationConfig {

	public String getJWTToken(String username) {

		List<GrantedAuthority> granteAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("PPOOII_JWT").setSubject(username)
				.claim("authorities",
						granteAuthorities.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + Constans.TOKEN_EXPIRATION_TIME))
				.signWith(Constans.getSigningKey(Constans.SUPER_SECRET_KEY), SignatureAlgorithm.HS512).compact();

		return "Bearer " + token;

	}

}
