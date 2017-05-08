package br.com.diego.nf;

public class GeradorNotaFiscal {
	public void geraNota(Fatura f, Imposto imposto) {
		NotaFiscal notaFiscal = geraNotaFiscal(f, imposto);
		new DaoNotaFiscal().insira(notaFiscal);
		new EnvioDeEmail().enviar("tiulo", "mensagem");
	}

	private NotaFiscal geraNotaFiscal(Fatura f, Imposto imposto) {
		double valorImposto = 0;

		valorImposto = imposto.getValor(f.getV());

		NotaFiscal notaFiscal = new NotaFiscal(valorImposto, f.getV());
		return notaFiscal;
	}
}
