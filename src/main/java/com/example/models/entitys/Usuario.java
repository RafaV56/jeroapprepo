package com.example.models.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.recursos.Fecha;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Column(name = "anno")
	private Integer annoNacimiento;
	@Column(name = "dia")
	private Integer diaNacimiento;
	@Column(name = "hora")
	private Integer horaNacimiento;
	@Column(name = "mes")
	private Integer mesNacimiento;
	@Column(name = "minuto")
	private Integer minutoNacimiento;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
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

	public Integer getAnnoNacimiento() {
		return annoNacimiento;
	}

	public Integer getDiaNacimiento() {
		return diaNacimiento;
	}

	public Integer getHoraNacimiento() {
		return horaNacimiento;
	}

	public Long getId() {
		return id;
	}

	public Integer getMesNacimiento() {
		return mesNacimiento;
	}
	public Integer getMinutoNacimiento() {
		return minutoNacimiento;
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
	
	public void setAnnoNacimiento(Integer annoNacimiento) {
		this.annoNacimiento = annoNacimiento;
	}
	
	public void setDiaNacimiento(Integer diaNacimiento) {
		this.diaNacimiento = diaNacimiento;
	}
	public void setHoraNacimiento(Integer horaNacimiento) {
		this.horaNacimiento = horaNacimiento;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMesNacimiento(Integer mesNacimiento) {
		this.mesNacimiento = mesNacimiento;
	}
	public void setMinutoNacimiento(Integer minutoNacimiento) {
		this.minutoNacimiento = minutoNacimiento;
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
	
	public String verFechaNacimiento() {
		return new Fecha(getDiaNacimiento(),getMesNacimiento(),getAnnoNacimiento(),getHoraNacimiento(),getMinutoNacimiento()).toString();
	}
	
	public Long edad() {
		return new Fecha(getDiaNacimiento(),getMesNacimiento(),getAnnoNacimiento(),getHoraNacimiento(),getMinutoNacimiento()).calcularAnnos();
	}
}
