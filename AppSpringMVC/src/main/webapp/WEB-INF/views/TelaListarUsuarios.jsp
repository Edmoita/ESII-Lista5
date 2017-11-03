<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@ page import="br.ufpi.es.AppSpringMVC.dados.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AppSpringMVC - Listar Usuários</title>
</head>
<body>

<%
		 
		List<Usuario> list = (List<Usuario>) session.getAttribute("usuarios");
		if (list.size() > 0) {
			for (Usuario u : list) {
				out.println(u.getId() + " - ");
				out.println(u.getNome() + " - ");
				out.println(u.getEmail());%>
				<a href="formularioAlterar?id=<%=u.getId()%>"><button>Alterar</button></a>
				<a href="removerUsuario?id=<%=u.getId()%>"><button>Remover</button></a><br>
			<%}
		} else {
			out.println("Nenhum resultado encontrado!");
		}
%>

<a href="principal"><button>Página Principal</button></a>

</body>
</html>