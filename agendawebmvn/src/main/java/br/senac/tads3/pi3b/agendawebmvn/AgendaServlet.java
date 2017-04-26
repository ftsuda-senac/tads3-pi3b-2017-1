/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3b.agendawebmvn;

import br.senac.tads3.pi3b.agendawebmvn.dao.ContatoDAO;
import br.senac.tads3.pi3b.agendawebmvn.model.Contato;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "AgendaServlet", urlPatterns = {"/agenda"})
public class AgendaServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException {

    ContatoDAO dao = new ContatoDAO();
    List<Contato> contatos = dao.listar();

    request.setAttribute("listaContatos", contatos);
    RequestDispatcher dispatcher
	    = request.getRequestDispatcher("agenda.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (IOException ex) {

    }
  }
}
