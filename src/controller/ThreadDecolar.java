package controller;

import java.util.concurrent.Semaphore;

public class ThreadDecolar extends Thread {
	
	private int aeronaves;
	private Semaphore semaforo;
	

	public ThreadDecolar(int aeronaves, Semaphore semaforo) {
		this.aeronaves = aeronaves;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		Manobra();
		Taxiar();
		
		try {
			semaforo.acquire();
			Decolagem();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
		
		Afastar();
		
	}

	private void Manobra() {
		
		int TempoManobra = (int) ((Math.random() * 3001) + 7001);
		
		System.out.println("# " +aeronaves+ " AERONAVE passou pela fase de MANOBRA em "+TempoManobra+ " s.");
		System.out.println(" ");
		
		
	}

	private void Taxiar() {
		
		int TempoTaxiar = (int) ((Math.random() * 5001) + 10001);
		
		System.out.println("# " +aeronaves+ " AERONAVE passou pela fase de TAXIAR em "+TempoTaxiar+ " s.");
		System.out.println(" ");
		
	}

	private void Decolagem() {
		
		int TempoDecolar = (int) ((Math.random() * 1001) + 4001);
		
		System.out.println("# " +aeronaves+ " AERONAVE passou pela fase de DECOLAR em "+TempoDecolar+ " s.");
		System.out.println(" ");
	
		
	}

	private void Afastar() {
		
		int TempoAfastar = (int) ((Math.random() * 1001) + 4001);
		
		System.out.println("# " +aeronaves+ " AERONAVE passou pela fase de AFASTAR em "+TempoAfastar+ " s.");
		System.out.println(" ");
	
		
	}
}
