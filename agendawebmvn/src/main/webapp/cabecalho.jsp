<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="text-center">
  <h1>Agenda de contatos</h1>
  <nav class="menu">
    <ul>
      <li><a href="#">Opção 1</a></li>
      <li><a href="#">Opção 2</a></li>
      <li><a href="#">Opção 3</a></li>
      <li><a href="#">Opção 4</a></li>
    </ul>
  </nav>
  <c:if test="${not empty sessionScope.usuario}">
    <p>
      Usuário: <c:out value="${sessionScope.usuario.nomeCompleto}" />
    </p>
    <p>
      Hash da senha: <c:out value="${sessionScope.usuario.hashSenha}" />
    </p>
  </c:if>
</header>
