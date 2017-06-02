package br.com.nf.model.bo;

import br.com.nf.model.dao.NotaFiscalDao;
import br.com.nf.model.vo.Fatura;
import br.com.nf.model.vo.NotaFiscal;

public class GeradorNotaFiscalBo {
	
	public void geraNota(Fatura fatura, ImpostoFiscalBo imposto) {
	
		try {		
		
			NotaFiscal notaFiscal = geraNotaFiscal(fatura, imposto);
			new NotaFiscalDao().inserir(notaFiscal);
			//new EnvioDeEmailBo().enviar(notaFiscal);
		
		} catch (Exception ex) {
	        ex.printStackTrace();	        
	    }		
	}

	private NotaFiscal geraNotaFiscal(Fatura fatura, ImpostoFiscalBo imposto) {
		
		try {
			
			double valorImposto = 0;
			valorImposto = imposto.getValor(fatura.getValor());
			
			return new NotaFiscal(valorImposto, fatura.getValor());
		
		} catch (Exception ex) {
	        ex.printStackTrace();
	        return  null;
	    }		
	}
}
