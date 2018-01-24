package com.apprest.web.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.apprest.web.controller.UsuarioController;
import com.apprest.web.model.Usuario;
import com.apprest.web.model.Valor;

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
	
	@POST
	@Path("/logar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Usuario login(Usuario usuario) {
		Usuario usuarioConsultado = controller.login(usuario);
		return usuarioConsultado;
	}

	@POST
	@Path("/deletar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void deletar(Usuario usuario) {
		controller.apagar(usuario);
	}
	
	@GET
	@Path("/buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Usuario buscar(@QueryParam("id") Long id) {
		Usuario usuarioBuscado = controller.buscar(id);
		return usuarioBuscado;
	}
	


}
