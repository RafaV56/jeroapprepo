package com.example.dao.usuario;

import org.springframework.data.repository.CrudRepository;

import com.example.models.entitys.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	public Usuario findByAlias(String alias);

}
