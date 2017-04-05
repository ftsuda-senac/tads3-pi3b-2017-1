<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Arrays"%>
<%@page import="br.senac.tads3.pi3b.Contato"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Exemplo Servlet + JSP + JSTL + EL</h1>
    <table>
      <tr>
	<th>ID</th>
	<th>Nome</th>
	<th>E-mail</th>
	<th>Telefone</th>
      </tr>
      <c:forEach items="${listaContatos}" var="contato">
	<tr>
	  <td><c:out value="${contato.id}" /></td>
	  <td><c:out value="${contato.nome}" /></td>
	  <td><c:out value="${contato.email}" /></td>
	  <td><c:out value="${contato.telefone}" /></td>
	</tr>
      </c:forEach>
    </table>
  </body>
</html>
