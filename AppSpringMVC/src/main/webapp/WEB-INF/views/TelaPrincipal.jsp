<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.ufpi.es.AppSpringMVC.dados.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AppSpringMVC - Principal</title>
</head>
<body>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");
out.println("Login: " + usuario.getLogin() + "<br>");
out.println("Nome: " + usuario.getNome() + "<br>");
out.println("E-mail: " + usuario.getEmail() + "<br>");
out.println("Você acessou o sistema com sucesso!");
%>
<br>
<a href="formularioInserir">Inserir Usuário</a><br>
<a href="formularioBusca">Buscar Usuário</a><br>
<a href="listarUsuarios">Listar Usuários</a><br>
<a href="logout">Logout</a>
</body>
</html>