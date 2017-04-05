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
    <h1>Exemplo JSP</h1>
    <table>
      <tr>
	<th>ID</th>
	<th>Nome</th>
	<th>E-mail</th>
	<th>Telefone</th>
      </tr>
      <%
	Contato c1 = new Contato(1L, "Fulano da Silva", new Date(),
		"fulano@zmail.com", "(11) 91234-5678");
	Contato c2 = new Contato(2L, "Ciclano de Souza", new Date(),
		"ciclano@zmail.com", "(11) 92345-6789");
	Contato c3 = new Contato(3L, "Beltrana Maria", new Date(),
		"beltrana@zmail.com", "(11) 93456-7890");
	List<Contato> contatos = Arrays.asList(c1, c2, c3);

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
