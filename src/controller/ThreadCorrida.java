package controller;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.Semaphore;

import model.Carro;

public class ThreadCorrida extends Thread{
	
	private int sizePista;
	private Carro carro;
	private Semaphore pista;
	private Semaphore [] escuderia;
	private static ListaDeGrid grid = new ListaDeGrid();
	private static int finish;
	
	public ThreadCorrida(Carro carro, Semaphore pista, Semaphore [] escuderia) {
		this.carro = carro;
		this.pista = pista;
		this.escuderia = escuderia;
		this.sizePista = 6000;
	}
	
	@Override
	public void run() {
		try {
			this.escuderia[this.carro.getEscuderia() - 1].acquire();
			Largada();
			this.pista.acquire();
			Corrida();
			Terminar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.escuderia[this.carro.getEscuderia() - 1].release();
			this.pista.release();
		}
	}
	
	private void Largada() {
		System.out.println("O carro " + this.carro.getId() + " da escuderia " + this.carro.getEscuderia()
		+ " está esperando confirmação para largar");
	}
	
	private void Corrida() {
		double tempof;
		double tempoi; 
		double tempototal;
		DecimalFormat df = new DecimalFormat("0.00");
		String total[];
		String transicao;
		System.out.println("O carro " + this.carro.getId() + " vai dar a largada");
		tempoi = System.nanoTime();
		
		Random random = new Random();
		for(int i=0; i<3; i++) {
			this.carro.setVelocidade(random.nextInt(100) + 150);
			int volta = this.sizePista;
			while(volta>0) {
				volta = volta - this.carro.getVelocidade();
				try {
					sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		tempof = System.nanoTime();
		tempototal = (tempof-tempoi)/Math.pow(1000, 3);
		total = df.format(tempototal).split("[,]");
		transicao = total[0] + "." + total[1];
		tempototal = Double.parseDouble(transicao);
		this.carro.setTempo(tempototal);
	}
	
	private void Terminar() {
		System.out.println("O carro " + this.carro.getId() + " terminou a prova!");
		grid.Adicionar(this.carro);
		finish++;
		VerifFinish();
	}
	
	private void VerifFinish() {
		if(finish==14) {
			grid.Ordenar();
			System.out.println(grid.Mostrar());
		}
	}

}
