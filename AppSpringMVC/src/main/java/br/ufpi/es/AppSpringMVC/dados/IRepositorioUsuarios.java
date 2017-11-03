package br.ufpi.es.AppSpringMVC.dados;

import java.util.List;

public interface IRepositorioUsuarios {
	
	public void inserir(Usuario u);
	public Usuario buscar(String login, String senha);
	public void alterar(Usuario original, Usuario alterado);
	public void remover(Usuario u);
	public List <Usuario> listar();
	public void popularRepositorio();
	public Usuario buscarPorId(int id);
	public Usuario buscarPorEmail(String email);
	public Usuario buscarPorLogin(String login);
	public int proximoId();

}
