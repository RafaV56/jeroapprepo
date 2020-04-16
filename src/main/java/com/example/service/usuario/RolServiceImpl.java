package com.example.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.usuario.IRolDao;
import com.example.models.entitys.Rol;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolDao rolDao;
	
	@Override
	public List<Rol> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional//escritura
	public Rol guardar(Rol rol) {
		return rolDao.save(rol);

	}

	@Override
	public Rol buscarUno(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Rol rol) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub

	}

}
