package com.apprest.web.controller;

import java.util.List;

import com.apprest.web.model.Usuario;
import com.apprest.web.model.UsuarioDao;

public class UsuarioController {
	
private Usuario usuario = new Usuario();
	
	public String irPara(Usuario usuario) {
		String irPara = "erro_login";
		Usuario usuarioConsultado = new UsuarioDao().selectLoginAndSenha(usuario);
		if (usuarioConsultado != null) {
			irPara = "login";
		}
		System.out.println("Controller: "+ irPara);
		return irPara;
	}
	public void salvar(Usuario usuario) {
		if (usuario.getId() == null) {
			new UsuarioDao().insertUsuario(usuario);
		} else {
			new UsuarioDao().updateUsuario(usuario);
		}
	}
	
	public void apagar(Usuario usuario) {
		new UsuarioDao().deleteUsuario(usuario);
	}
	
	public List<Usuario> listarTodos() {
		return new UsuarioDao().selectAll();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
