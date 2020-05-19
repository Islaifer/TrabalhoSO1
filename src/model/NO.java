package model;

public class NO {
	private Carro carro;
	private NO next;
	public NO(Carro carro) {
		this.carro = carro;
		this.next = null;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public NO getNext() {
		return next;
	}
	public void setNext(NO next) {
		this.next = next;
	}
}
