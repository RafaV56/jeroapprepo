package com.example.models.entitys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private Double peso;
	private Double talla;
	
	public Usuario() {
	}
	public Usuario(String nombre, Double peso, Double talla) {
		setNombre(nombre);
		setPeso(peso);
		setTalla(talla);
	}
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Double getPeso() {
		return peso;
	}
	public Double getTalla() {
		return talla;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public void setTalla(Double talla) {
		this.talla = talla;
	}
	
	
	
	
	
}
//private Fecha fechaNacimiento;
//private String nombre;
//
//@Autowired
//@Qualifier("funcionales")
//public List<PruebasFuncionales> pruebasFuncionales;
//
//private double talla, peso;
//
//public Usuario() {
//}
//
//public Usuario(String nombre, Fecha fechaNacimiento, double talla, double peso) {
//	setNombre(nombre);
//	setFechaNacimiento(fechaNacimiento);
//	setTalla(talla);
//	setPeso(peso);
//}
//
//public Fecha getFechaNacimiento() {
//	return fechaNacimiento;
//}
//
//public String getNombre() {
//	return nombre;
//}
//
//public double getPeso() {
//	return peso;
//}
//
//public List<PruebasFuncionales> getPruebasFuncionales() {
//	return pruebasFuncionales;
//}
//
//public double getTalla() {
//	return talla;
//}
//
//public void setFechaNacimiento(Fecha fechaNacimiento) {
//	if (fechaNacimiento == null) {
//		throw new RuntimeException("La fecha de nacimiento del usuario es nula");
//	}
//
//	this.fechaNacimiento = fechaNacimiento;
//}
//
//public void setNombre(String nombre) {
//
//	if (nombre.isEmpty() || nombre == null) {
//		this.nombre = "Sin nombre conocido";
//	}
//	this.nombre = nombre;
//}
//
//public void setPeso(double peso) {
//	if (peso <= 0 || peso > 350) {
//		throw new RuntimeException("El peso del usuario es 0 o inferior, o supera los 350 kg.");
//	}
//	this.peso = peso;
//}
//
//public void setPruebasFuncionales(List<PruebasFuncionales> pruebasFuncionales) {
//	this.pruebasFuncionales = pruebasFuncionales;
//}
//
//public void setTalla(double talla) {
//	if (talla < 0 || talla > 2.50) {
//		throw new RuntimeException("La estatura no es correcta, [0mts - 2.50mts]");
//	}
//	this.talla = talla;
//}
//
//public String toString() {
//	return "Usuario [nombre : " + getNombre() + ", Fecha de Nacimiento : " + getFechaNacimiento() + ", talla : "
//			+ talla + "mts.  Años : " + fechaNacimiento.calcularAnnos() + " Peso: " + getPeso()
//			+ "kg, Pruebas Funcionales : " + pruebasFuncionales + "]";
//}
