package controller;

import model.Carro;
import model.NO;

public class ListaDeGrid {
	private NO inicio;
	
	public ListaDeGrid() {
		this.inicio = null;
	}
	
	public void Adicionar(Carro data) {
		NO n = new NO(data);
		if(inicio==null) {
			this.inicio = n;
		}else {
			NO aux = this.inicio;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
		}
	}
	
	public void Ordenar() {
		NO aux = inicio;
		while(aux!=null) {
			NO aux2 = aux.getNext();
			while(aux2!=null) {
				if(aux!=null && aux2!=null) {
					if(aux.getCarro().getTempo()>aux2.getCarro().getTempo()) {
						Carro aux3 = aux.getCarro();
						aux.setCarro(aux2.getCarro());
						aux2.setCarro(aux3);
					}
				}
				aux2 = aux2.getNext();
			}
			aux = aux.getNext();
		}
	}
	
	public String Mostrar() {
		NO aux = inicio;
		int pos = 1;
		StringBuffer mostra = new StringBuffer("O rank é: \n");
		while(aux!=null) {
			mostra.append(pos + "º Lugar = carro " + aux.getCarro().getId() + " da escuderia "
					+ aux.getCarro().getEscuderia() + " com tempo de " + aux.getCarro().getTempo()
					+ " segundos!\n");
			aux = aux.getNext();
			pos++;
		}
		return mostra.toString();
	}
}
