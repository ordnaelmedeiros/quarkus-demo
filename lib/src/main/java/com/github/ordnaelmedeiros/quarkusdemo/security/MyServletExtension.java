package com.github.ordnaelmedeiros.quarkusdemo.security;

import java.util.Map;

import javax.servlet.ServletContext;

import io.undertow.security.api.AuthenticationMechanism;
import io.undertow.security.api.AuthenticationMechanismFactory;
import io.undertow.server.handlers.form.FormParserFactory;
import io.undertow.servlet.ServletExtension;
import io.undertow.servlet.api.AuthMethodConfig;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.LoginConfig;

public class MyServletExtension implements ServletExtension {

	public void handleDeployment(final DeploymentInfo deploymentInfo, final ServletContext servletContext) {

		LoginConfig loginConfig = new LoginConfig("MY-REALM");
		loginConfig.addFirstAuthMethod(new AuthMethodConfig("MY-AUTH"));
		
		deploymentInfo.setLoginConfig(loginConfig);

		deploymentInfo.addAuthenticationMechanism("MY-AUTH", new AuthenticationMechanismFactory() {
			@Override
			public AuthenticationMechanism create(String mechanismName, FormParserFactory formParserFactory,
					Map<String, String> properties) {
				return new MyAuthenticationMechanism();
			}
		});

	}

}
