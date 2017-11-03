<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.ufpi.es.AppSpringMVC.dados.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AppSpringMVC - Alterar Usuário</title>
</head>
<body>
<%
	Usuario u = (Usuario) session.getAttribute("usuarioAAlterar");
%>
<form method="post" action="alterarUsuario">
	<label>Id:</label>
	<input type="text" disabled value="<%=u.getId()%>"><br>
	<label>Nome:</label>
	<input type="text" name="nome" value="<%=u.getNome()%>"><br>
	<label>Email:</label>
	<input type="text" name="email" value="<%=u.getEmail()%>"><br>
	<label>Login:</label>
	<input type="text" name="login" value="<%=u.getLogin()%>"><br>
	<label>Senha:</label>
	<input type="password" disabled value="<%=u.getSenha()%>"><br>
	<input type="hidden"  name="id" value="<%=u.getId()%>"><br>
	<input type="hidden"  name="senha" value="<%=u.getSenha()%>"><br>
	<button type="submit">Alterar</button>
</form>

<a href="principal"><button>Cancelar</button></a>
</body>
</html>