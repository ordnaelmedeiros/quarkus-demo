package com.github.ordnaelmedeiros.quarkusdemo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class GreetingService {

	@Inject @ConfigProperty(name = "greeting.message")
	String base = null;
	
	public void changeBase(String newBase) {
		if (newBase==null) {
			this.base = "";
		} else {
			this.base = newBase.trim();
		}
	}
	
	public String getBase() {
		return this.base + " ";
	}
	
	public String greeting(String name) {
		return getBase() + name;
	}

}
