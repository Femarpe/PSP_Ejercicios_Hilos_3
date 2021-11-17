package Ej1;

import java.util.concurrent.Semaphore;

public class Orden {
    private static Semaphore semaphore = new Semaphore(1);
    private static Hilo hilos[];
    public void lanzarHilos() {
        int nsum = 2;
        hilos = new Hilo[nsum];
        for (int i = nsum; i > 0; i--) {
            hilos[i-1] = new Hilo(i-1, 10,semaphore);
            hilos[i-1].start();

        }
        for (int i = 0; i < nsum; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }


    }
}
