package br.com.nf.controller;

import org.zkoss.zk.ui.util.Clients;

import br.com.nf.model.bo.GeradorNotaFiscalBo;
import br.com.nf.model.bo.ImpostoFiscalBo;
import br.com.nf.model.vo.Fatura;
import br.com.nf.view.View;

public class ControllerNotaFiscal {
	
	View view = new View();
	
	public boolean Gerar(String ANomeCliente, Double AValorImposto, String ATipoImposto) {
		
		if (ANomeCliente.isEmpty()) {
			view.Atencao("Informe o nome do cliente!");
			return false;
		} 
		else if (AValorImposto <= 0)  {
		    view.Atencao("Informe o imposto!");
		    return false;
		}
		else if (ATipoImposto.isEmpty()) {
			view.Atencao("Informe o tipo do imposto!");
			return false;
		}
		else {
		   view.InformarAguarde("Gerando nota fiscal");	
	       Fatura fatura = new Fatura(ANomeCliente, AValorImposto);		
		   ImpostoFiscalBo imposto = ImpostoFiscalBo.crie(ATipoImposto);		
		   new GeradorNotaFiscalBo().geraNota(fatura, imposto);
		   Clients.clearBusy();		
		   view.Informar("Nota Fiscal gerada com sucesso!");
		   
		   return true;
		}
	}
}
