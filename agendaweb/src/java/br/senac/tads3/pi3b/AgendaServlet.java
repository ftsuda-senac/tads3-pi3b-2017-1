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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
    
    request.setAttribute("listaContatos", contatos);
    RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("agenda2.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (IOException ex) {
      
    }
  }
}
