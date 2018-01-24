package com.apprest.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.apprest.web.util.ConnectionFactory;

public class UsuarioDao extends ConnectionFactory{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	private Usuario usuario;
	
	public Usuario selectLoginAndSenha(Usuario usuario){
		
		String sql = "SELECT id, login, senha FROM usuario WHERE login = ? AND senha = ?";
		Usuario user = null;
		try {
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			rs = ps.executeQuery();
			if (rs.next()){
				user = new Usuario();
				user.setId(rs.getLong("id"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
			}
		}catch (Exception e){
			System.err.println("Erro: ");
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, rs);
		}
		return user;
	}
	
public Usuario buscarPorId(Long id){
		
		String sql = "SELECT id, login, senha FROM usuario WHERE id = ? ";
		Usuario user = null;
		try {
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()){
				user = new Usuario();
				user.setId(rs.getLong("id"));
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
			}
		}catch (Exception e){
			System.err.println("Erro: ");
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, rs);
		}
		return user;
	}
	
	public void insertUsuario(Usuario usuario){
		String sql = "INSERT INTO usuario (login, senha) "
				+ "VALUES (?, ?)";
		try {
			Connection con;
			PreparedStatement ps;
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
	
	public void updateUsuario(Usuario usuario){
		String sql = "UPDATE usuario SET login =?, senha = ? "
				+ "WHERE id = ?";	
		try {
			Connection con;
			PreparedStatement ps;
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.setLong(3, usuario.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
	
	
	public void deleteUsuario(Usuario usuario){
		String sql = "DELETE FROM usuario WHERE id = ?";
		try {
			Connection con;
			PreparedStatement ps;
			con = openConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(1, usuario.getId());
			ps.executeUpdate();
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps);
		}
	}
	
	public List<Usuario> selectAll(){
		List<Usuario> listagem = null;
		String sql = "SELECT id, login, senha "
				+ "FROM usuario order by login";
		try {
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			con = openConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			listagem = new ArrayList<Usuario>();
			while (rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				listagem.add(usuario);
			}
		}catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} finally {
			closeConnection(con, ps, rs);
		}
		return listagem;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}