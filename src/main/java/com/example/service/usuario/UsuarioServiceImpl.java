package com.example.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.usuario.IUsuarioDao;
import com.example.models.entitys.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscarTodos() {
		return (List<Usuario>)usuarioDao.findAll();
	}

	@Override
	@Transactional//escritura
	public void guardar(Usuario usuario) {
		usuarioDao.save(usuario);

	}

	@Override
	@Transactional
	public Usuario buscarUno(Long id) {
		return usuarioDao.findById(id).orElseGet(null);
	}

	@Override
	@Transactional
	public void editar(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void borrar(Long id) {
		usuarioDao.deleteById(id);

	}

}
