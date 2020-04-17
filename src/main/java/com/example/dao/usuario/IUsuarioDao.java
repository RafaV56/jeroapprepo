package com.example.dao.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.entitys.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

	Usuario findByAlias(String username);
	

}
