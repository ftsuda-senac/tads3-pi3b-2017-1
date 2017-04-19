/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3b;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "EntradaServlet", urlPatterns = {"/entrada"})
public class EntradaServlet extends HttpServlet {

  /**
   * Neste exemplo, somente apresenta a tela do formulário
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    RequestDispatcher dispatcher
	    = request.getRequestDispatcher("entrada.jsp");
    dispatcher.forward(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    boolean erro = false;

    String nome = request.getParameter("nome");
    if (nome == null || nome.length() < 1) {
      erro = true;
      request.setAttribute("erroNome", true);
    }
    String email = request.getParameter("email");
    if (email == null || email.length() < 1) {
      erro = true;
      request.setAttribute("erroEmail", true);
    }
    String telefone = request.getParameter("telefone");
    if (telefone == null || telefone.length() < 1) {
      erro = true;
      request.setAttribute("erroTelefone", true);
    }
    if (!erro) {
      // Os dados foram preenchidos corretamente
      // Faz o fluxo POST-REDIRECT-GET para a tela de resultados
      Contato novo = new Contato(nome, new Date(), email, telefone);
      HttpSession sessao = request.getSession();
      sessao.setAttribute("novoContato", novo);
      response.sendRedirect("resultado.jsp");
    } else {
      // Tem erro no preenchimento dos dados.
      // Reapresenta o formulário para o usuário indicando os erros.
      RequestDispatcher dispatcher = request.getRequestDispatcher("entrada.jsp");
      dispatcher.forward(request, response);
    }
  }

}
