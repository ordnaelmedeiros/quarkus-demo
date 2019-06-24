package com.github.ordnaelmedeiros.restls.api.employee;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;

import com.github.ordnaelmedeiros.restls.hibernate.HibernateUtil;

@RequestScoped
public class TesteResource {

	public Long create(String bancoDeDados, String name) {
		
		try {

			EntityManager em = HibernateUtil.getSessionFactory(bancoDeDados).createEntityManager();
			em.getTransaction().begin();
			
			Teste teste = new Teste(name);
			
			em.persist(teste);
			
			em.getTransaction().commit();
			em.close();
			
			return teste.getId();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0l;
		}
		
	}

	public Teste read(String bancoDeDados, Long id) {
		try {

			EntityManager em = HibernateUtil.getSessionFactory(bancoDeDados).createEntityManager();
			
			Teste teste = em.find(Teste.class, id);
			
			em.close();
			
			return teste;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Teste("Não encontrou");
		}
	}

	public List<Teste> all(String bancoDeDados) {
		
		try {

			EntityManager em = HibernateUtil.getSessionFactory(bancoDeDados).createEntityManager();
			
			List<Teste> lista = em.createQuery("select t from Teste t", Teste.class).getResultList();
			
			em.close();
			
			return lista;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
