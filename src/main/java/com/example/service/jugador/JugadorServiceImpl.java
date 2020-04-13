package com.example.service.jugador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.usuario.IJugadorDao;
import com.example.models.entitys.Jugador;

@Service
public class JugadorServiceImpl implements IJugadorService {

	@Autowired
	private IJugadorDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Jugador> buscarTodos() {
		return (List<Jugador>)usuarioDao.findAll();
	}

	@Override
	@Transactional//escritura
	public void guardar(Jugador usuario) {
		usuarioDao.save(usuario);

	}

	@Override
	@Transactional
	public Jugador buscarUno(Long id) {
		return usuarioDao.findById(id).orElseGet(null);
	}

	@Override
	@Transactional
	public void editar(Jugador usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void borrar(Long id) {
		usuarioDao.deleteById(id);

	}

}
