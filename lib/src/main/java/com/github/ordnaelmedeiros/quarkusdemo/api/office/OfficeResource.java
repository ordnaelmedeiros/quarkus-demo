package com.github.ordnaelmedeiros.quarkusdemo.api.office;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RequestScoped
public class OfficeResource {

	@PersistenceContext
	EntityManager em;
	
	public Office read(Long id) {
		return em.find(Office.class, id);
	}
	
	@Transactional
	public Long create(@Valid Office entity) {
		em.persist(entity);
		return entity.getId();
	}
	
	@Transactional
	public void update(@Valid Office entity) {
		em.merge(entity);
	}
	
	@Transactional
	public void delete(Long id) {
		em.remove(this.read(id));
	}
	
	public List<Office> all(String search) {
		if (search==null || search.isEmpty()) {
			return em.createQuery("select o from Office o", Office.class).getResultList();
		} else {
			return em.createQuery("select o from Office o where upper(o.name) like :search", Office.class)
					.setParameter("search", "%"+search.toUpperCase()+"%")
					.getResultList();
		}
	}

}
