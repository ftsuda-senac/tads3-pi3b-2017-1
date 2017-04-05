<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Contato novo</h1>
    <h1><c:out value="${novoContato.nome}" /></h1>
    <p><c:out value="${novoContato.email}" /></p>
    <p><c:out value="${novoContato.telefone}" /></p>
    <a href="agenda">Voltar</a>
  </body>
</html>
