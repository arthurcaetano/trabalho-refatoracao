package br.com.nf.view;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.util.Clients;

public class View {
	
	public void Informar(String AMensagem){
		Messagebox.show(AMensagem);
	}
	
	public void Atencao(String AMensagem){
		Clients.showNotification(AMensagem);
	}
	
	public void InformarAguarde(String AMensagem){
		Clients.showBusy(AMensagem);		
	}
}
