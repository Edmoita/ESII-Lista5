<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AppSpringMVC - Buscar Usuário</title>
</head>
<body>
<div>
		<form action="buscarUsuario" method="post">
			<p>Buscar usuário</p>
			<p>
				<select name="opcaoCampo">
					<option selected="selected" value="email">E-mail</option>
					<option value="login">Login</option>
				</select>
			</p>

			<p>
				Consulta<input maxlength="50" name="consulta" size="50"
					type="text" />
			</p>
			<p>
				<input type="submit" value="Buscar" />
			</p>
		</form>
		<a href="principal"><button>Cancelar</button></a>
		
	</div>

</body>
</html>