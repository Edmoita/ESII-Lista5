package br.ufpi.es.AppSpringMVC.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufpi.es.AppSpringMVC.dados.RepositorioListaUsuarios;
import br.ufpi.es.AppSpringMVC.dados.Usuario;
import br.ufpi.es.AppSpringMVC.dados.UsuariosDAO;

@Controller
public class AcessoController {
	
	UsuariosDAO dao;
	public static RepositorioListaUsuarios repositorio;
	
	public AcessoController() {
		super();
		repositorio = new RepositorioListaUsuarios();
        repositorio.popularRepositorio();
        dao = new UsuariosDAO(repositorio);
	}
	
	@RequestMapping(value="/efetuarLogin", method=RequestMethod.POST)
	public String processarLogin(Usuario usuario, HttpSession session, Model model) {
		String login;
		String senha;
		
		login = usuario.getLogin();
		senha = usuario.getSenha();
		Usuario usuarioBuscado = dao.buscar(login, senha);
		
		
		if (usuarioBuscado != null){
			session.setAttribute("email", usuarioBuscado.getEmail());
			Date criacaoSessaoUsuario = new Date(session.getCreationTime());
			session.setAttribute("usuario", usuarioBuscado);
			System.out.println("Usuario " + session.getAttribute("email") + " logado as" + criacaoSessaoUsuario);
			usuario = usuarioBuscado;
			return "TelaPrincipal";
		}else{
			return "TelaLogin";
		}
		
	}
	
	@RequestMapping(value="/logout")
	public String processarLogout(HttpSession session) {
		Date tempoUltimaSessao = new Date(session.getLastAccessedTime());
		System.out.println("Usuário" + session.getAttribute("email") + " deslogado as " + tempoUltimaSessao);
		
		if (session.getAttribute("usuario") != null){
			session.invalidate();
		}
		return "TelaLogin";
	}

	@RequestMapping(value="/formularioLogin")
	public String carregarFormulario(HttpSession session) {
		if (session.getAttribute("usuario") != null){
			return "TelaPrincipal";
		} else {
			return "TelaLogin";
		}
	}
	
	@RequestMapping(value="/principal")
	public String checarSessaoUsuario(HttpSession session) {
		if (session.getAttribute("usuario") != null){
			return "TelaPrincipal";
		} else {
			return "TelaLogin";
		}
	}
	
	
}
