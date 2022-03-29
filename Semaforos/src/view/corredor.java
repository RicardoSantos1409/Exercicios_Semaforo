package view;

import java.util.concurrent.Semaphore;

import controller.corredorController;

public class corredor {

	public static void main(String[] args) {
			int permissao = 1;
			Semaphore semaforo = new Semaphore(permissao);
		
		for (int idPessoa = 0; idPessoa < 5; idPessoa++) {
			Thread corredor = new corredorController(idPessoa, semaforo);
			corredor.start();
		}
		
		
	}

}
