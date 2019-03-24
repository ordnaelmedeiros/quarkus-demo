package com.github.ordnaelmedeiros.quarkusdemo.api.office;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.github.ordnaelmedeiros.quarkusdemo.api.office.validation.ValidOffice;

@Entity
@Table(name = "office")
@SequenceGenerator(name="seq_office", sequenceName = "seq_office", allocationSize=1)
@ValidOffice
public class Office {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_office")
	private Long id;
	
	@Column
	@NotNull
	private String name;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
