package br.com.diego.nf;

import org.zkoss.bind.AnnotateBinder;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

public class CIndex extends GenericForwardComposer {
	private Textbox txtbxNomeCliente;
	private Decimalbox dcmlbxValorFatura;
	private Radiogroup rdgrpTipoImposto;

	public void doAfterCompose(Component componente) throws Exception {
		super.doAfterCompose(componente);
	}

	public void onClick$btnGerarNotaFiscal() {
		Clients.showBusy("Gerando nota fiscal");
		Events.echoEvent("onGerarNotaFiscal", this.self, null);
	}

	private String getNomeDoCliente(){ 
		return this.txtbxNomeCliente.getValue();
	}
	
	private double getValorDoImposto(){ 
		return this.dcmlbxValorFatura.getValue().doubleValue();
	}
	
	private String getTipoDeImposto(){
		return this.rdgrpTipoImposto.getSelectedItem().getValue().toString();
	}
	
	public void onGerarNotaFiscal() {
		Fatura fatura = new Fatura(getNomeDoCliente(), getValorDoImposto());
		ImpostoFiscal imposto = ImpostoFiscal.crie(getTipoDeImposto());
		new GeradorNotaFiscal().geraNota(fatura, imposto);		
		Clients.clearBusy();
		
		Messagebox.show("Nota Fiscal gerada com sucesso");
	}
}
