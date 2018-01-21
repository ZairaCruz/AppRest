package com.apprest.web.controller;

import java.util.List;

import com.apprest.web.model.Usuario;
import com.apprest.web.model.UsuarioDao;
import com.apprest.web.model.Valor;

public class UsuarioController {
	
private Usuario usuario = new Usuario();
	
	public Valor irPara(Usuario usuario) {
		Valor valor = new Valor();
		valor.setValor(false); 
		Usuario usuarioConsultado = new UsuarioDao().selectLoginAndSenha(usuario);
		if (usuarioConsultado != null) {
			valor.setValor(true); 
		}
		System.out.println("Controller: "+ valor.isValor());
		return valor;
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
