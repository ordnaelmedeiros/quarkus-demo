package com.github.ordnaelmedeiros.quarkusdemo;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
//@Disabled
public class Main {

	@Test
	public void run() {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Running in test");
				while (true) {
					try {
						Thread.sleep(100000);
					} catch (Exception e) {
					}
				}
			}
		}).run();
		
	}
	
}
