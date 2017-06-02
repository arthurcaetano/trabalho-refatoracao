package br.com.nf.model.bo;

import br.com.nf.model.vo.ICMS;
import br.com.nf.model.vo.ISS;

public abstract class ImpostoFiscalBo {
	
	public static ImpostoFiscalBo crie(String tipo){
		if(tipo.equals("1")){
			return new ISS();
		}else{
			return new ICMS();
		}
	}
	
	public abstract Double getValor(Double fatura);
}
