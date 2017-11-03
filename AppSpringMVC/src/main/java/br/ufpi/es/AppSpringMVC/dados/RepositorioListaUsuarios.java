package br.ufpi.es.AppSpringMVC.dados;

import java.util.LinkedList;
import java.util.List;

public class RepositorioListaUsuarios implements IRepositorioUsuarios {

	private List<Usuario> lista = new LinkedList<Usuario>();

	public void inserir(Usuario u) {
		lista.add(u);
		
	}

	public Usuario buscar(String username, String senha) {
		Usuario usuario = null;
		
		for (Usuario u : lista) {
			if(u.getLogin().equals(username) && u.getSenha().equals(senha)) {
				return u;
			}
		}
		
		return usuario;
	}

	public void alterar(Usuario original, Usuario alterado) {
		remover(original);
		inserir(alterado);
	}

	public void remover(Usuario u) {
		lista.remove(u);
		
	}

	public List<Usuario> listar() {
		return lista;
	}

	public void popularRepositorio() {
		Usuario u1 = new Usuario();
		Usuario u2 = new Usuario();
		Usuario u3 = new Usuario();
		Usuario u4 = new Usuario();
		
		u1.setId(1);
		u1.setNome("Alan Turing");
		u1.setEmail("turing@cs.com");
		u1.setLogin("turing");
		u1.setSenha("máquina");
		
		u2.setId(2);
		u2.setNome("Ada Lovelace");
		u2.setEmail("ada@cs.com");
		u2.setLogin("ada");
		u2.setSenha("software");
		
		u3.setId(3);
		u3.setNome("Edsger Dijkstra");
		u3.setEmail("dijkstra@cs.com");
		u3.setLogin("dijkstra");
		u3.setSenha("caminho");
		
        u4.setId(4);
		u4.setNome("Admin");
		u4.setEmail("admin@hotmail.com");
		u4.setLogin("admin");
		u4.setSenha("admin");
		
		this.lista.add(u1);
		this.lista.add(u2);
		this.lista.add(u3);
		this.lista.add(u4);
		
	}
	
	
	public Usuario buscarPorId(int id) {
		Usuario usuario = new Usuario();
		
		for (Usuario u : lista) {
			if(u.getId() == id) {
				return u;
			}
		}
		
		return usuario;
	}

	public int proximoId() {
		
		int maiorId = 1;
		
		for (Usuario usuario : lista) {
			if(usuario.getId() > maiorId) {
				maiorId = usuario.getId();
			}
		}
		
		return maiorId + 1;
}

	@Override
	public Usuario buscarPorEmail(String email) {
		Usuario usuario = null;
		
		for (Usuario u : lista) {
			if(u.getEmail().equals(email)) {
				return u;
			}
		}
		
		return usuario;
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		Usuario usuario = null;
		
		for (Usuario u : lista) {
			if(u.getLogin().equals(login)) {
				return u;
			}
		}
		
		return usuario;
	}
}
