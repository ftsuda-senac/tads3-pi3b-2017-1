<%-- 
    Document   : login
    Created on : 25/04/2017, 20:27:32
    Author     : fernando.tsuda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Login</h1>
    <form action="login" method="post">
      <div>
	<label for="txtusuario">Nome de usuário</label>
	<input type="text" name="usuario" id="txtusuario" />
      </div>
      <div>
	<label for="txtsenha">Senha</label>
	<input type="password" name="senha" id="txtsenha" />
      </div>
      <div>
	<input type="submit" value="Entrar" />
      </div>
    </form>

  </body>
</html>
