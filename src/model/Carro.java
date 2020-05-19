package model;

public class Carro {
	private int id;
	private int escuderia;
	private int velocidade;
	private double tempo;
	
	public Carro() {
		this.id = 0;
		this.escuderia = 0;
		this.velocidade = 0;
		this.tempo = 0;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(int escuderia) {
		this.escuderia = escuderia;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
}
