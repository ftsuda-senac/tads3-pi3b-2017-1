<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Arrays"%>
<%@page import="br.senac.tads3.pi3b.Contato"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Exemplo Servlet + JSP</h1>
    <table>
      <tr>
	<th>ID</th>
	<th>Nome</th>
	<th>E-mail</th>
	<th>Telefone</th>
      </tr>
      <%
	List<Contato> contatos = (List<Contato>) 
		request.getAttribute("listaContatos");
	for (Contato c : contatos) {
      %>
      <tr>
	<td><%= c.getId() %></td>
	<td><%= c.getNome() %></td>
	<td><%= c.getEmail() %></td>
	<td><%= c.getTelefone() %></td>
      </tr>
      <%
	}
      %>
    </table>

  </body>
</html>
