package com.github.ordnaelmedeiros.quarkusdemo.api.access;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.github.ordnaelmedeiros.quarkusdemo.api.role.Role;

@Entity
@Table(name = "access")
@SequenceGenerator(name="seq_access", allocationSize=1)
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_access")
    @Column(name="accessid")
    private Long id;
    
    @Column
    @NotNull
    private String name;
    
    @Column
    @NotNull
    private String password;
    
    @Column
    private String token;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
		name = "accessrole",
	    joinColumns = { @JoinColumn(name = "accessid") }, 
	    inverseJoinColumns = { @JoinColumn(name = "roleid") }
	)
    private List<Role> roles;
    
    public Access() {
	}
    
    public Access(String name, String password) {
    	this.name = name;
    	this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
