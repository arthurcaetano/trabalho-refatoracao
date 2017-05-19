package br.com.diego.nf;

public class Fatura {
	private String nome;
	private double valor;

	public Fatura(String nome, double valor){
		this.nome = nome;
		this.valor = valor;
	}
	public String getN() {
		return nome;
	}

	public void setN(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
