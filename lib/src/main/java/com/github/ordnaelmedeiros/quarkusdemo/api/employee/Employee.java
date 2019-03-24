package com.github.ordnaelmedeiros.quarkusdemo.api.employee;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.github.ordnaelmedeiros.quarkusdemo.api.office.Office;

@Entity
@Table(name = "employee")
@SequenceGenerator(name="seq_employee", sequenceName = "seq_employee", allocationSize=1)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_employee")
    private Long id;

    @NotNull
    @Column(length = 40)
    private String name;
    
    @Past
    @NotNull
    @Column
    private LocalDate started;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="officeid")
    @Valid
    private Office office;
    
    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

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

	public LocalDate getStarted() {
		return started;
	}

	public void setStarted(LocalDate started) {
		this.started = started;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
    
}
