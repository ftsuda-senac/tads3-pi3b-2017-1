/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3b;

import java.io.IOException;
import java.io.PrintWriter;
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
    
    response.setContentType("text/plain");
    try (PrintWriter out = response.getWriter()) {
      out.print("Olá mundo web");
      out.flush();
    } catch (IOException e) {
      
    }
  }
}
