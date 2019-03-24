package com.github.ordnaelmedeiros.quarkusdemo.user;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
public class UserService {

	@PersistenceContext
	EntityManager em;
	
	public User get(Long id) {
		User user = em.find(User.class, id);
		return user;
	}

	@Transactional
	public Long post(User user) {
		em.persist(user);
		return user.getId();
	}
	
	@Transactional
	public void put(User user) {
		em.merge(user);
	}

	@Transactional
	public void delete(Long id) {
		User user = this.get(id);
		em.remove(user);
	}
	
}
