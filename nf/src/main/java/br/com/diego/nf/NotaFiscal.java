package br.com.diego.nf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NotaFiscal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int identificador;
	private double valorDoImposto;
	private double valorBruto;

	public NotaFiscal(double valorDoImposto, double valorBruto) {
		this.valorDoImposto = valorDoImposto;
		this.valorBruto = valorBruto;
	}
	
	public NotaFiscal(){
		
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public double getValorDoImposto() {
		return valorDoImposto;
	}

	public void setValorDoImposto(double valorDoImposto) {
		this.valorDoImposto = valorDoImposto;
	}

	public double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}

}
