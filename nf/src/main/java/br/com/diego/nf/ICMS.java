package br.com.diego.nf;

public class ICMS extends ImpostoFiscal {
	
	public Double getValor(Double fatura) {
		return fatura*0.11;
	}

}
