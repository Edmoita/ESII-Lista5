package br.ufpi.es.AppSpringMVC.dados;

import java.util.List;

public class UsuariosDAO {
	
	private IRepositorioUsuarios repositorio;
	
	public UsuariosDAO(IRepositorioUsuarios tipo){
		this.repositorio = tipo;
	}
	
	public void inserir(Usuario u){
		repositorio.inserir(u);
	}
	
	public Usuario buscar(String username, String senha) {
		return repositorio.buscar(username, senha);
	}
	
	public void alterar(Usuario original, Usuario alterado) {
		repositorio.alterar(original, alterado);
	}
	
	public void remover(Usuario u) {
		repositorio.remover(u);
	}
	
	public List<Usuario> listar(){
		return repositorio.listar();
	}
	
	public Usuario buscaPorEmail(String email) {
		return repositorio.buscarPorEmail(email);
	}
	
	public Usuario buscaPorLogin(String login) {
		return repositorio.buscarPorLogin(login);
	}
	
	
	public Usuario buscaPorId(int id) {
		return repositorio.buscarPorId(id);
	}
	
	public int proximoId() {
		return repositorio.proximoId();
	}
	

}
