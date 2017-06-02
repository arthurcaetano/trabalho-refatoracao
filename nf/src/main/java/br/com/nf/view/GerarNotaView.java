package br.com.nf.view;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import br.com.nf.controller.ControllerNotaFiscal;

public class GerarNotaView extends GenericForwardComposer {
	
	private Textbox txtbxNomeCliente;
	private Decimalbox dcmlbxValorFatura;
	private Radiogroup rdgrpTipoImposto;
	
	private View view = new View();

	public void doAfterCompose(Component componente) throws Exception {
		super.doAfterCompose(componente);
	}

	public void onClick$btnGerarNotaFiscal() {		
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
		
		new ControllerNotaFiscal().Gerar(getNomeDoCliente(), getValorDoImposto(), getTipoDeImposto());				
		
	}
}
