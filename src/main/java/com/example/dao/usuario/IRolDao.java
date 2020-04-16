package com.example.dao.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.models.entitys.Rol;

public interface IRolDao extends JpaRepository<Rol, Long> {

}
