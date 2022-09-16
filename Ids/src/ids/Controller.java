

package ids;

import java.util.concurrent.Semaphore;

public class Ids extends Thread {
	private int id;
	private Semaphore semaforo;

	public Ids(int _id, Semaphore _semaforo) {
		id = _id;
		semaforo = _semaforo;
	}

	public void run() {
		switch (id % 3) {
		case 1:
		
			executarTransacao(1000, 200, 801);
			break;
		case 2:
			
			executarTransacao(1500, 500, 1001);
			break;
		case 0:
		
			executarTransacao(1500, 1000, 1001);
			break;
		}
	}

	private void executarTransacao(int tempo_bd, int tempo_minimo, int tempo_maximo) {
		for (int i = 0; i < 3; i++) {
		
			int tempo_calculo = (int) ((Math.random() * tempo_maximo) + tempo_minimo);
			try {
				
				System.out.println("T# " + id + ": calculando...");
				sleep(tempo_calculo);
				
				semaforo.acquire();
				System.out.println("T# " + id + ": Transação BD");
				sleep(tempo_bd);

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}
}