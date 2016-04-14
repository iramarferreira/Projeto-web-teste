package br.com.projeto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table
public class Endereco implements Serializable{

	private int id_endereco;
	private String nome_rua;
	private String bairro; 
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	public int getId_endereco() {
		return id_endereco;
	}
	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
	
	public String getNome_rua() {
		return nome_rua;
	}
	public void setNome_rua(String nome_rua) {
		this.nome_rua = nome_rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
