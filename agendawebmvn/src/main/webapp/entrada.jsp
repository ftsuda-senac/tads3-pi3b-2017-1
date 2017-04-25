<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <meta name="description" content="">
    <title>Entrada</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/estilos.css" rel="stylesheet" />
    <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
  </head>
  <body>
    <div class="contato">
      <c:import url="./cabecalho.jsp" />
      <h2>Inclusão de contato</h2>
      <div class="formulario">
	<form action="entrada" method="post">
	  <div>
	    <c:if test="${erroNome}">
	      <div class="erro">O nome é obrigatório</div>
	    </c:if>
	    <label for="txtnome">Nome</label>
	    <input type="text" name="nome" id="txtnome" />
	  </div>
	  <div>
	    <c:if test="${erroEmail}">
	      <div class="erro">O e-mail é obrigatório</div>
	    </c:if>
	    <label for="txtemail">E-mail</label>
	    <input type="text" name="email" id="txtemail" />
	  </div>
	  <div>
	    <c:if test="${erroTelefone}">
	      <div class="erro">O telefone é obrigatório</div>
	    </c:if>
	    <label for="txttelefone">Telefone</label>
	    <input type="text" name="telefone" id="txttelefone" />
	  </div>
	  <div>
	    <input type="submit" value="Salvar" />
	  </div>
	</form>
      </div>
    </div>
    <c:import url="./rodape.jsp" />
  </body>
</html>
