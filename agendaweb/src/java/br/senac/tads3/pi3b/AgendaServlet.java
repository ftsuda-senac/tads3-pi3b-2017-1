/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3b;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet("/agenda")
public class AgendaServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException {

    Contato c1 = new Contato(1L, "Fulano da Silva", new Date(),
	    "fulano@zmail.com", "(11) 91234-5678");
    Contato c2 = new Contato(2L, "Ciclano de Souza", new Date(),
	    "ciclano@zmail.com", "(11) 92345-6789");
    Contato c3 = new Contato(3L, "Beltrana Maria", new Date(),
	    "beltrana@zmail.com", "(11) 93456-7890");
    List<Contato> contatos = Arrays.asList(c1, c2, c3);

    response.setContentType("text/html");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"utf-8\" />");
      out.println("<title>Exemplo Servlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<div class=\"conteudo\">");
      out.println("<h1>Agenda</h1>");
      out.println("<table>");
      out.println("<tr>");
      out.println("<th>ID</th>");
      out.println("<th>Nome</th>");
      out.println("<th>E-mail</th>");
      out.println("<th>Telefone</th>");
      out.println("</tr>");
      for (Contato c : contatos) {
	out.println("<tr>");
	out.println("<td>" + c.getId() + "</td>");
	out.println("<td>" + c.getNome() + "</td>");
	out.println("<td>" + c.getEmail() + "</td>");
	out.println("<td>" + c.getTelefone() + "</td>");
	out.println("</tr>");
      }
      out.println("</table>");
      out.println("</div></body></html>");
      out.flush();
    } catch (IOException e) {

    }
  }
}
