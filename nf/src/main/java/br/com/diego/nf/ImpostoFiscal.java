package br.com.diego.nf;

public abstract class ImpostoFiscal {
	
	public static ImpostoFiscal crie(String tipo){
		if(tipo.equals("1")){
			return new ISS();
		}else{
			return new ICMS();
		}
	}
	
	public abstract Double getValor(Double fatura);
}
