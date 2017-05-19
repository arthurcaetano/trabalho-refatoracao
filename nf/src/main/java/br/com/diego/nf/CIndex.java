package br.com.diego.nf;

import org.zkoss.bind.AnnotateBinder;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

public class CIndex extends GenericForwardComposer {
	private DataBinder binder;
	private Textbox txtbxNomeCliente;
	private Decimalbox dcmlbxValorFatura;
	private Radiogroup rdgrpTipoImposto;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		binder.loadAll();
	}

	public void onClick$btnGerarNotaFiscal() {
		Clients.showBusy("Gerando nota fiscal");
		Events.echoEvent("onGerarNotaFiscal", this.self, null);
	}

	public void onGerarNotaFiscal() {
		Fatura fatura = new Fatura(this.txtbxNomeCliente.getValue(), this.dcmlbxValorFatura.getValue().doubleValue());
		
		ImpostoFiscal imposto = ImpostoFiscal.crie(this.rdgrpTipoImposto.getSelectedItem().getValue().toString());

		new GeradorNotaFiscal().geraNota(fatura, imposto);		
		Clients.clearBusy();
		
		Messagebox.show("Nota Fiscal gerada com sucesso");
	}
}
