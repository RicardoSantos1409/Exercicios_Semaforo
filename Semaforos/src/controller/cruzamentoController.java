package controller;

import java.util.concurrent.Semaphore;

public class cruzamentoController extends Thread {
	private int idCarro;
	private Semaphore semaforo;
	
	public cruzamentoController(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		chegando();
		
		try {
			semaforo.acquire();
			passando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}

	private void chegando() {
		int tempo = 1000;
			try {
				sleep (tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#"+idCarro+" chegou");
		}
	
	private void passando() {
		String direcao[] = {"por cima", "por baixo", "pela direita", "pela esquerda"};
		int tempo =(int) (Math.random()* 2000) + 1000;
		int i = (int) (Math.random()*4);
		try {
			sleep (tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Carro #"+idCarro+" passou pelo cruzamento "+ direcao[i]);
	}
}
