package br.unicamp.ecommerce.model;

import javax.xml.bind.annotation.XmlElement;

public class Encomenda {

	@XmlElement(name = "idEncomenda")
	private int idEncomenda;
	
	@XmlElement(name = "statusEncomenda")
	private StatusEncomenda statusEncomenda;
	
	public int getIdEncomenda() {
		return idEncomenda;
	}

	public void setIdEncomenda(int idEncomenda) {
		this.idEncomenda = idEncomenda;
	}

	public StatusEncomenda getStatusEncomenda() {
		return statusEncomenda;
	}

	public void setStatusEncomenda(StatusEncomenda statusEncomenda) {
		this.statusEncomenda = statusEncomenda;
	}

	
	
	
	
	
}
