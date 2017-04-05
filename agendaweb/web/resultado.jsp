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
    <h1><c:out value="${sessionScope.novoContato.nome}" /></h1>
    <p><c:out value="${sessionScope.novoContato.email}" /></p>
    <p><c:out value="${sessionScope.novoContato.telefone}" /></p>
    <c:remove scope="session" var="novoContato" />
    <a href="agenda">Voltar</a>
  </body>
</html>
