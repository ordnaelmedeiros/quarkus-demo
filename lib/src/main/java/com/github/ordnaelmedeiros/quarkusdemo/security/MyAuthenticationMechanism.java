package com.github.ordnaelmedeiros.quarkusdemo.security;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.undertow.UndertowLogger;
import io.undertow.security.api.AuthenticationMechanism;
import io.undertow.security.api.SecurityContext;
import io.undertow.security.idm.Account;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.util.StatusCodes;

public class MyAuthenticationMechanism implements AuthenticationMechanism {

	@Override
	public AuthenticationMechanismOutcome authenticate(HttpServerExchange exchange, SecurityContext securityContext) {
		
		List<String> authHeaders = exchange.getRequestHeaders().get(Headers.AUTHORIZATION);
		Account account = new Account() {
			
			@Override
			public Set<String> getRoles() {
				HashSet<String> roles = new HashSet<String>();
				roles.add("ADMIN");
				return roles;
			}
			
			@Override
			public Principal getPrincipal() {
				Principal principal = new Principal() {
					
					@Override
					public String getName() {
						return "leandro";
					}
				};
				return principal;
			}
		};
		securityContext.authenticationComplete(account, "MY-AUTH", false);
		return AuthenticationMechanismOutcome.AUTHENTICATED;
		
	}

	@Override
	public ChallengeResult sendChallenge(HttpServerExchange exchange, SecurityContext securityContext) {
		exchange.getResponseHeaders().add(Headers.WWW_AUTHENTICATE, "Bearer {token}");
		UndertowLogger.SECURITY_LOGGER.debugf("Sending Bearer {token} challenge for %s", exchange);
		return new ChallengeResult(true, StatusCodes.UNAUTHORIZED);
	}

}
