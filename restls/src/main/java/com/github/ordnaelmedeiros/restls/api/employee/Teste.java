package com.github.ordnaelmedeiros.restls.api.employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "teste")
@SequenceGenerator(name="seq_teste", sequenceName = "seq_teste", allocationSize=1)
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_teste")
    private Long id;

    @NotNull
    @Column(length = 40)
    private String name;
    
    public Teste() {
    }
    
    public Teste(String name) {
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

}
