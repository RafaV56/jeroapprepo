package com.example.service.jugador;

import java.util.List;

import com.example.models.entitys.Jugador;



public interface IJugadorService {
	
	public List<Jugador> buscarTodos();
	
	public void guardar(Jugador usuario);
	
	public Jugador buscarUno(Long id);
	
	public void editar(Jugador usuario);
	
	public void borrar(Long id);


}
