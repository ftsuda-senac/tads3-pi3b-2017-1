<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Exemplo JSP</h1>
    <%
      for (int i = 1; i < 1001; i++) {
    %>
    <h2>Teste <%= i %></h2>
    <%
      }
    %>
      
  </body>
</html>
