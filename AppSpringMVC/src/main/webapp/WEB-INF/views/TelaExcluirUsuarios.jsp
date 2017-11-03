<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.ufpi.es.AppSpringMVC.dados.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AppSpringMVC - Remover Usuário</title>
</head>
<body>
<%
	Usuario u = (Usuario) session.getAttribute("usuarioADeletar");
%>
<form method="post" action="confirmarRemover">

	<p>Deseja remover o usuário <%=u.getNome()%>?<br>
	<input type="hidden"  name="id" value="<%=u.getId()%>"><br>
	<button type="submit">Sim</button>

</form>
<a href="principal"><button>Cancelar</button></a>

</body>
</html>