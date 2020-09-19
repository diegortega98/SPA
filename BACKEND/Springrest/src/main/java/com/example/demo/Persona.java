package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
@Entity
@Table(name="personas")
public class Persona {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private int iddocumento;
	@Column
	private String residencia;
	@Column
	private String telefono;
	@Column
	private String usuario;
	@Column
	private String pass;
	
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public Persona() {
		
	}
	public long getId() {
		return id;
	}
	
	public void setID(long id) {
		this.id=id;
	}
	public String getName() {
		return nombres;
	}
	public void setName(String nombres) {
		this.nombres=nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos=apellidos;
	}
	
	public int getiddoc() {
		return iddocumento;
	}
	public void setiddoc(int iddocumento) {
		this.iddocumento=iddocumento;
	}
	public String gettelef() {
		return telefono;
	}
	public void settelef(String telefono) {
		this.telefono=telefono;
	}
	public String getresidencia() {
		return residencia;
	}
	public void setresidencia(String residencia) {
		this.residencia=residencia;
	}
	public String getuser() {
		return usuario;
	}
	public void setuser(String usuario) {
		this.usuario=usuario;
	}
	public String getpass() {
		return pass;
	}
	public void setpass(String pass) {
		this.pass=pass;
	}
	
	
}