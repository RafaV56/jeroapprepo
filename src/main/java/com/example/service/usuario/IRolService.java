package com.example.service.usuario;

import java.util.List;

import com.example.models.entitys.Rol;

public interface IRolService {

	public List<Rol> buscarTodos();
	
	public Rol guardar(Rol rol);
	
	public Rol buscarUno(Long id);
	
	public void editar(Rol rol);
	
	public void borrar(Long id);
}
