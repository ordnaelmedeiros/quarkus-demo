package com.github.ordnaelmedeiros.quarkusdemo.api.employee;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RequestScoped
public class EmployeeResource {

	@PersistenceContext
	EntityManager em;
	
	public Employee read(Long id) {
		return em.find(Employee.class, id);
	}
	
	@Transactional
	public Long create(@Valid Employee employee) {
		em.persist(employee);
		return employee.getId();
	}
	
	@Transactional
	public void update(@Valid Employee employee) {
		em.merge(employee);
	}
	
	@Transactional
	public void delete(Long id) {
		em.remove(this.read(id));
	}
	
}
