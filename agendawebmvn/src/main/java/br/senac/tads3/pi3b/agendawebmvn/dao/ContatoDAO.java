/*
 * The MIT License
 *
 * Copyright 2017 fernando.tsuda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.senac.tads3.pi3b.agendawebmvn.dao;

import br.senac.tads3.pi3b.agendawebmvn.model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.tsuda
 */
public class ContatoDAO extends ConexaoBD {

  public Contato obterContato(long idContato) {
    PreparedStatement stmt = null;
    Connection conn = null;
    Contato p = null;

    String sql = "SELECT ID_CONTATO, NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL "
	    + "FROM TB_CONTATO WHERE ID_CONTATO = ?";
    try {
      conn = obterConexao();
      stmt = conn.prepareStatement(sql);
      stmt.setLong(1, idContato);
      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {
	Long id = resultados.getLong("ID_CONTATO");
	String nome = resultados.getString("NM_CONTATO");
	Date dataNasc = resultados.getDate("DT_NASCIMENTO");
	String email = resultados.getString("VL_EMAIL");
	String telefone = resultados.getString("VL_TELEFONE");
	p = new Contato(id, nome, dataNasc, email, telefone);
	break;
      }
    } catch (SQLException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      // Código colocado aqui para garantir que a conexão com o banco
      // seja sempre fechada, independentemente se executado com sucesso
      // ou erro.
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conn != null) {
	try {
	  conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
    return p;
  }
/*
  public ListaResultados listarComColunas() {
    String sql = "SELECT ID_CONTATO, NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL "
	    + "FROM TB_CONTATO";
    List<Contato> lista = new ArrayList<>();
    List<String> nomesColunas = new ArrayList<>();
    try (Connection conn = obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      try (ResultSet resultados = stmt.executeQuery()) {

	// Obtem os nomes das colunas
	ResultSetMetaData md = resultados.getMetaData();
	int qtdeColunas = md.getColumnCount();
	for (int i = 1; i <= qtdeColunas; i++) {
	  nomesColunas.add(md.getColumnName(i));
	}

	while (resultados.next()) {
	  Long id = resultados.getLong("ID_CONTATO");
	  String nome = resultados.getString("NM_CONTATO");
	  Date dataNasc = resultados.getDate("DT_NASCIMENTO");
	  String email = resultados.getString("VL_EMAIL");
	  String telefone = resultados.getString("VL_TELEFONE");
//                System.out.println(String.valueOf(id) + ", " + nome + ", "
//                        + formatadorData.format(dataNasc) + ", " + email + ", "
//                        + telefone);
	  Contato contato = new Contato(id, nome, dataNasc,
		  email, telefone);
	  lista.add(contato);
	}
      }

    } catch (SQLException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return new ListaResultados(lista, nomesColunas);

  }
*/
  public List<Contato> listar() {
    Statement stmt = null;
    Connection conn = null;

    String sql = "SELECT ID_CONTATO, NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL "
	    + "FROM TB_CONTATO";

    List<Contato> lista = new ArrayList<>();
    try {
      conn = obterConexao();
      stmt = conn.createStatement();
      ResultSet resultados = stmt.executeQuery(sql);

      DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

      while (resultados.next()) {
	Long id = resultados.getLong("ID_CONTATO");
	String nome = resultados.getString("NM_CONTATO");
	Date dataNasc = resultados.getDate("DT_NASCIMENTO");
	String email = resultados.getString("VL_EMAIL");
	String telefone = resultados.getString("VL_TELEFONE");
//                System.out.println(String.valueOf(id) + ", " + nome + ", "
//                        + formatadorData.format(dataNasc) + ", " + email + ", "
//                        + telefone);
	Contato contato = new Contato(id, nome, dataNasc,
		email, telefone);
	lista.add(contato);
      }

    } catch (SQLException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      // Código colocado aqui para garantir que a conexão com o banco
      // seja sempre fechada, independentemente se executado com sucesso
      // ou erro.
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conn != null) {
	try {
	  conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
    return lista;
  }

  // http://stackoverflow.com/questions/17459094/getting-id-after-insert-within-a-transaction-oracle
  // http://www.mkyong.com/jdbc/jdbc-transaction-example/
  public void incluirComTransacao(Contato contato) {
    PreparedStatement stmt = null;
    Connection conn = null;

    String sql = "INSERT INTO TB_CONTATO "
	    + "(NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO) "
	    + "VALUES (?, ?, ?, ?, ?)";
    try {
      conn = obterConexao();

      conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
      stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, contato.getNome());
      stmt.setDate(2, new java.sql.Date(contato.getDtNascimento().getTime()));
      stmt.setString(3, contato.getTelefone());
      stmt.setString(4, contato.getEmail());
      stmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));

      stmt.executeUpdate();

      // ResultSet para recuperar o ID gerado automaticamente no banco de dados.
      // Neste exemplo, o ID é gerado automaticamente.
      ResultSet generatedKeys = stmt.getGeneratedKeys();
      if (generatedKeys.next()) {
	long idNovo = generatedKeys.getLong(1);
	contato.setId(idNovo);
	System.out.println("***** ID NOVO CADASTRADO: " + String.valueOf(idNovo));

	// Executar próximos INSERTs USANDO O ID novo.
      }
      conn.commit();
    } catch (SQLException ex) {
      try {
	// Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
	if (conn != null & !conn.isClosed()) {
	  conn.rollback();
	}
      } catch (SQLException ex1) {
	Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex1);
      }
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      try {
	// Caso ocorra algum erro, tenta desfazer todas as ações realizadas no BD.
	if (conn != null & !conn.isClosed()) {
	  conn.rollback();
	}
      } catch (SQLException ex1) {
	Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex1);
      }
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conn != null) {
	try {
	  conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
  }

  public void incluir(Contato contato) {
    PreparedStatement stmt = null;
    Connection conn = null;

    String sql = "INSERT INTO TB_CONTATO "
	    + "(NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO) "
	    + "VALUES (?, ?, ?, ?, ?)";
    try {
      conn = obterConexao();
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, contato.getNome());
      stmt.setDate(2, new java.sql.Date(contato.getDtNascimento().getTime()));
      stmt.setString(3, contato.getTelefone());
      stmt.setString(4, contato.getEmail());
      stmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
      stmt.executeUpdate();
      //System.out.println("Registro incluido com sucesso.");

    } catch (SQLException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conn != null) {
	try {
	  conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
  }

}
