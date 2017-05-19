package br.com.diego.nf;

public class ISS extends ImpostoFiscal {
	
	public Double getValor(Double fatura) {
		return fatura * 0.1;
	}

}
