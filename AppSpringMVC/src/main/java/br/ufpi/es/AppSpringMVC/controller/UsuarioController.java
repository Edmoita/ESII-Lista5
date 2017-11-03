package br.ufpi.es.AppSpringMVC.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufpi.es.AppSpringMVC.dados.Usuario;
import br.ufpi.es.AppSpringMVC.dados.UsuariosDAO;

@Controller
public class UsuarioController {
	
	UsuariosDAO dao;
	
	public UsuarioController() {
		super();
		dao = new UsuariosDAO(AcessoController.repositorio);
	}
	
	@RequestMapping(value="/buscarUsuario", method=RequestMethod.POST)
	public String processarBusca(HttpServletRequest request, HttpSession session, Model model) {
		if (session.getAttribute("usuario") != null) {
			String consulta = request.getParameter("consulta");
			String campo = request.getParameter("opcaoCampo");
			
			Usuario usuarioBuscado; 
			if(campo.equals("login")) {
				usuarioBuscado = dao.buscaPorLogin(consulta);
			} else {
				usuarioBuscado = dao.buscaPorEmail(consulta);
			}
			
			List<Usuario> lista = new LinkedList<Usuario>();
			
			if (usuarioBuscado != null) {
				lista.add(usuarioBuscado);
			}
			
			
			session.setAttribute("usuarios", lista);
			return "TelaListarUsuarios";
		}else {
			return "TelaLogin";
		}
	}
	
	@RequestMapping(value="/formularioBusca")
	public String carregarFormularioBusca(HttpSession session) {
		if (session.getAttribute("usuario") != null) {
    		return "TelaBuscarUsuario";
    	}else {
    		return "TelaLogin";
    	}
	}
	
	
	@RequestMapping(value="/listarUsuarios")
	public String processarLista(HttpSession session) {
		if (session.getAttribute("usuario") != null) {
			List<Usuario> lista = dao.listar();
			
			session.setAttribute("usuarios", lista);
			return "TelaListarUsuarios";
		}else {
			return "TelaLogin";
		}
	}
	
	@RequestMapping(value="/formularioInserir")
	public String carregarFormularioInserir(HttpSession session) {
		if (session.getAttribute("usuario") != null) {
    		return "TelaInserirUsuario";
    	}else {
    		return "TelaLogin";
    	}
	}
	
	@RequestMapping(value="/inserirUsuario", method=RequestMethod.POST)
	public String salvarUsuario(Usuario usuario, HttpSession session, Model model) {
		if (session.getAttribute("usuario") != null) {
			
			
			int id = dao.proximoId();
			String nome = usuario.getNome();//request.getParameter("nome");
			String email = usuario.getEmail();//request.getParameter("email");
			String login = usuario.getLogin();//request.getParameter("username");
			String senha = usuario.getSenha();//request.getParameter("senha");
			
			Usuario novoUsuario = new Usuario();
			
			novoUsuario.setId(id);
			novoUsuario.setNome(nome);
			novoUsuario.setEmail(email);
			novoUsuario.setLogin(login);
			novoUsuario.setSenha(senha);
			
			dao.inserir(novoUsuario);
			
			List<Usuario> lista = dao.listar();
			
			session.setAttribute("usuarios", lista);
			return "TelaListarUsuarios";
		}else {
			return "TelaLogin";
		}

	}
	
	@RequestMapping(value="/removerUsuario")
	public String removerUsuario(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("usuario") != null) {
    		int id = Integer.parseInt(request.getParameter("id"));
        	
    		Usuario u = dao.buscaPorId(id);
    		session.setAttribute("usuarioADeletar", u);
    		
			return "TelaExcluirUsuarios";
    	}else {
    		return "TelaLogin";
    	}
	}
	
	@RequestMapping(value="/confirmarRemover", method=RequestMethod.POST)
	public String confirmarRemover(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("usuario") != null) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Usuario u = dao.buscaPorId(id);
			
			dao.remover(u);
			
			List<Usuario> lista = dao.listar();
			
			session.setAttribute("usuarios", lista);
			return "TelaListarUsuarios";
		}else {
			return "TelaLogin";
		}
	}
	
	@RequestMapping(value="/formularioAlterar")
	public String carregarFormularioAlterar(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("usuario") != null) {
    		int id = Integer.parseInt(request.getParameter("id"));
        	
    		Usuario u = dao.buscaPorId(id);
    		session.setAttribute("usuarioAAlterar", u);
    		
			return "TelaAlterarUsuario";
    	}else {
    		return "TelaLogin";
    	}
	}
	
	@RequestMapping(value="/alterarUsuario")
	public String alterarUsuario(Usuario novoUsuario, HttpSession session, Model model){ {
		if (session.getAttribute("usuario") != null) {
			
			
			Usuario antigoUsuario = dao.buscaPorId(novoUsuario.getId());
			
			dao.alterar(antigoUsuario, novoUsuario);
			
			List<Usuario> lista = dao.listar();
			
			session.setAttribute("usuarios", lista);
			return "TelaListarUsuarios";
		}else {
			return "TelaLogin";
		}
}
	}

}
