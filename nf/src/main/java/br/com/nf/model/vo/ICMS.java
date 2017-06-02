package br.com.nf.model.vo;

import br.com.nf.model.bo.ImpostoFiscalBo;

public class ICMS extends ImpostoFiscalBo {
	
	public Double getValor(Double fatura) {
		return fatura * 0.11;
	}

}
