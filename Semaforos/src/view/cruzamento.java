package view;

import java.util.concurrent.Semaphore;

import controller.cruzamentoController;

public class cruzamento {

	public static void main(String[] args) {
			int permissao = 1;
			Semaphore semaforo = new Semaphore(permissao);
		
		for (int idCarro = 0; idCarro < 5; idCarro++) {
			Thread cruzamento = new cruzamentoController(idCarro, semaforo);
			cruzamento.start();
		}
		
		
	}

}
