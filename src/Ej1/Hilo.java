package Ej1;

import java.util.concurrent.Semaphore;

public class Hilo extends Thread {
    private int id;
    private int n;
    private Semaphore semaphore;
    public Hilo (int id,int n,Semaphore semaphore){
        this.id = id;
        this.n = n;
        this.semaphore = semaphore;
    }
    @Override
    public void run() {

        for (int i = 1; i <= n; i++) {
            System.out.println((id+1) + "-" + i);
            try {
                semaphore.acquire();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            semaphore.release();
        }
    }

}
