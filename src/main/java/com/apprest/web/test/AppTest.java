package com.apprest.web.test;

import java.util.List;

import org.junit.Test;

import com.apprest.web.controller.UsuarioController;
import com.apprest.web.model.Usuario;
import com.apprest.web.model.Valor;

import junit.framework.Assert;

public class AppTest {
	
//	@Test
//	public void inserirUsuario() {
//		Usuario usuario = new Usuario();
//		usuario.setId(1L);
//		usuario.setLogin("nome");
//		usuario.setSenha("senha");
//		UsuarioController controller = new UsuarioController();
//		controller.salvar(usuario);
//		Assert.assertEquals("nome", usuario.getLogin());
//	}
//	
//	@Test
//	public void alterarUsuario() {
//		Usuario usuario = new Usuario();
//		usuario.setId(4L);
//		usuario.setLogin("tia");
//		usuario.setSenha("123");
//		UsuarioController controller = new UsuarioController();
//		controller.salvar(usuario);
//		Assert.assertEquals("tia", usuario.getLogin());
//	}
//	
//	@Test
//	public void listarUsuarios() {
//		UsuarioController controller = new UsuarioController();
//		List lista = controller.listarTodos();
//		Assert.assertEquals(lista.size(), 5);
//		System.out.println(lista);
//	}
//	
//	@Test
//	public void buscarUsuario() {
//		Usuario usuario = new Usuario();
//		usuario.setId(5l);
//		UsuarioController controller = new UsuarioController();
//		Usuario usuarioConsultado = controller.buscar(5L);
//		System.out.println(usuarioConsultado);
//		Assert.assertEquals("eu", usuarioConsultado.getLogin());
//	}
	
	@Test
	public void logar() {
		Usuario usuario = new Usuario();
		usuario.setLogin("tia");
		usuario.setSenha("123");
		UsuarioController controller = new UsuarioController();
		Usuario usuarioConsultado = controller.login(usuario);
		Assert.assertEquals("tia", usuarioConsultado.getLogin());
	}
	

}
