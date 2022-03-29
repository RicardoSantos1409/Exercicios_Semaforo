package controller;

import java.util.concurrent.Semaphore;

public class corredorController extends Thread {
	private int idPessoa;
	private Semaphore semaforo;
	
	public corredorController(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		caminhando();
		
		try {
			semaforo.acquire();
			passando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}

	private void caminhando() {
		int caminhada = 0;
		int tempo = 1000;
		while (caminhada < 200){
			try {
				sleep (tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			caminhada += (int) (Math.random() * 5000) + 2000;
			System.out.println("#"+idPessoa+" andou: "+caminhada+"m");
		}
		
	}
	
	private void passando() {
		int tempo =(int) (Math.random()* 2000) + 1000;
		try {
			sleep (tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Pessoa #"+idPessoa+" passou pela porta");
	}
}
