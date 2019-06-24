package com.github.ordnaelmedeiros.restls.hibernate;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.github.ordnaelmedeiros.restls.api.employee.Teste;

public class HibernateUtil {
	
	private static Map<String, SessionFactory> sessionFactorys = new HashMap<String, SessionFactory>();
	
	
	public static SessionFactory getSessionFactory(String banco) {
		
		SessionFactory sessionFactory = sessionFactorys.get(banco);
		
		if (sessionFactory == null) {
			
			try {

				
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/"+banco);
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "123456");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				settings.put(Environment.C3P0_MIN_SIZE, "5");
				settings.put(Environment.C3P0_MAX_SIZE, "50");
				
				
				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Teste.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties())
						.build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
				sessionFactorys.put(banco, sessionFactory);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sessionFactory;
		
	}
	
}
