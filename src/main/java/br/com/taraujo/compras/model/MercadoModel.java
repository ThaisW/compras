package br.com.taraujo.compras.model;
import javax.persistence.Entity;



@Entity(name="Mercado")

public class MercadoModel {

	String nome;
	int idMercado;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdMercado() {
		return idMercado;
	}
	public void setIdMercado(int idMercado) {
		this.idMercado = idMercado;
	}
	
	@Override
	public String toString() {
		
		return "Id: " + getIdMercado() + "\n" + "Nome do Mercado: "+ getNome()+ "\n"  ;
	}
}
