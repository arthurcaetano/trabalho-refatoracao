package br.com.diego.nf;

public class GeradorNotaFiscal {
	
	public void geraNota(Fatura fatura, ImpostoFiscal imposto) {
		NotaFiscal notaFiscal = geraNotaFiscal(fatura, imposto);
		new DaoNotaFiscal().insira(notaFiscal);
		new EnvioDeEmail().enviar("tiulo", "mensagem");
	}

	private NotaFiscal geraNotaFiscal(Fatura fatura, ImpostoFiscal imposto) {
		double valorImposto = 0;

		valorImposto = imposto.getValor(fatura.getValor());

		NotaFiscal notaFiscal = new NotaFiscal(valorImposto, fatura.getValor());
		return notaFiscal;
	}
}
