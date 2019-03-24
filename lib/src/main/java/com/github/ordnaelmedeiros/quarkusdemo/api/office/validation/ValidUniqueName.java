package com.github.ordnaelmedeiros.quarkusdemo.api.office.validation;

import java.util.List;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.ordnaelmedeiros.quarkusdemo.api.office.Office;

public class ValidUniqueName implements ConstraintValidator<ValidOffice, Office>{

	@Override
	public boolean isValid(Office value, ConstraintValidatorContext context) {
		
		try {
			
			if (value!=null && value.getName()!=null) {
				
				EntityManager em = CDI.current().select(EntityManager.class).get();
				
				List<Office> offices = em.createQuery("select o from Office o where o.id != :id and upper(o.name) like :name", Office.class)
					.setParameter("id", value.getId()==null?0:value.getId())
					.setParameter("name", value.getName().toUpperCase())
					.getResultList();
				
				if (offices!=null && !offices.isEmpty()) {
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate("Exists Office with same name: " + offices.get(0).getId()).addConstraintViolation();
					return false;
				}
				
			}
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}

}
