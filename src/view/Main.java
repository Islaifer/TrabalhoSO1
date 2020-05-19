package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCorrida;
import model.Carro;

public class Main {

	public static void main(String[] args) {
		Semaphore pista = new Semaphore(5);
		Semaphore escuderias [] = new Semaphore[7];
		int escuderia = 1;
		for(int i = 0; i<escuderias.length; i++) {
			escuderias[i] = new Semaphore(1);
		}
		for(int i =1; i<15; i++) {
			Carro carro = new Carro();
			if(escuderia==8) {
				escuderia = 1;
			}
			carro.setEscuderia(escuderia);
			carro.setId(i);
			Thread corrida = new ThreadCorrida(carro, pista, escuderias);
			corrida.start();
			escuderia++;
		}
	}

}
