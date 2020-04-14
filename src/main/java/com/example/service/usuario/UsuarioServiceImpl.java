package com.example.service.usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.usuario.IUsuarioDao;
import com.example.models.entitys.Rol;
import com.example.models.entitys.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	@Transactional//escritura
	public Usuario guardar(Usuario usuario) {	
		//tomamos el usuario y codificamos su con contraseña
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		//Insertamis el rol user
		List<Rol> roles=new ArrayList<Rol>();
		Rol rolUser=new Rol();
		rolUser.setNombre("ROLE_USER");
		
		roles.add(rolUser);
		usuario.setRoles(roles);	
		return usuarioDao.save(usuario);

	}

	@Override
	public Usuario buscarUno(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub

	}

}
