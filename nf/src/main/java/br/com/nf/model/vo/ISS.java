package br.com.nf.model.vo;

import br.com.nf.model.bo.ImpostoFiscalBo;

public class ISS extends ImpostoFiscalBo {
	
	public Double getValor(Double fatura) {
		return fatura * 0.1;
	}

}
