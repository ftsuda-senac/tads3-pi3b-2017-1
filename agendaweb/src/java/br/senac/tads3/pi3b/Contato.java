/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3b;

import java.util.Date;

/**
 *
 * @author fernando.tsuda
 */
public class Contato {

  private Long id;

  private String nome;

  private String email;

  private String telefone;

  private Date dtNascimento;

  private Date dtCadastro;

  public Contato() {
  }

  public Contato(String nome, Date dtNascimento, String email, String telefone) {
    this.nome = nome;
    this.dtNascimento = dtNascimento;
    this.email = email;
    this.telefone = telefone;
  }

  public Contato(Long id, String nome, Date dtNascimento, String email, String telefone) {
    this.id = id;
    this.nome = nome;
    this.dtNascimento = dtNascimento;
    this.email = email;
    this.telefone = telefone;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public Date getDtNascimento() {
    return dtNascimento;
  }

  public void setDtNascimento(Date dtNascimento) {
    this.dtNascimento = dtNascimento;
  }

  public Date getDtCadastro() {
    return dtCadastro;
  }

  public void setDtCadastro(Date dtCadastro) {
    this.dtCadastro = dtCadastro;
  }
}
