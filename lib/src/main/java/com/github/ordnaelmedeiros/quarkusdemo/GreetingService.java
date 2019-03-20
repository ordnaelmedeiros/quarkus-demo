package com.github.ordnaelmedeiros.quarkusdemo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

	private String base = "hello ";
	
	public void changeBase(String newBase) {
		if (newBase==null) {
			this.base = "";
		} else {
			this.base = newBase.trim() + " ";
		}
	}
	
	public String getBase() {
		return base;
	}
	
	public String greeting(String name) {
		return base + name;
	}

}
