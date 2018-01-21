package com.apprest.web.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.apprest.web.controller.UsuarioController;
import com.apprest.web.model.Usuario;

@Path("/usuario")
public class UsuarioService {
	
	UsuarioController controller = new UsuarioController();
	
	@GET
	@Path("/lista")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Usuario> listagem() {
		return controller.listarTodos();
	}
	
	@POST
	@Path("/salvar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void salvar(Usuario usuario) {
		controller.salvar(usuario);
	}
	
	// TODO retorna a palavra Unexpected 'l'
	@POST
	@Path("/logar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String logar(Usuario usuario) {
//		Usuario usuarioLogado = new Usuario();
//		UsuarioDao dao = new UsuarioDao();
		return controller.irPara(usuario);
	}

	@POST
	@Path("/deletar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void deletar(Usuario usuario) {
		controller.apagar(usuario);
	}
	


}
