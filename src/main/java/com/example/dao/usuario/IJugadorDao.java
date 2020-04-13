package com.example.dao.usuario;

import org.springframework.data.repository.CrudRepository;

import com.example.models.entitys.Jugador;

public interface IJugadorDao extends CrudRepository<Jugador, Long> {

}
