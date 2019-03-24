package com.github.ordnaelmedeiros.quarkusdemo.api.access;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
public class AccessResource {

	@PersistenceContext
	EntityManager em;
	
	public Access read(Long id) {
		return em.find(Access.class, id);
	}
	
	@Transactional
	public Long create(Access entity) {
		em.persist(entity);
		return entity.getId();
	}
	
	@Transactional
	public void update(Access entity) {
		em.merge(entity);
	}
	
	@Transactional
	public void delete(Long id) {
		em.remove(this.read(id));
	}
	
}
