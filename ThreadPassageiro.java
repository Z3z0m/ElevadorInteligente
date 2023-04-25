import java.util.concurrent.Semaphore;

public class ThreadPassageiro extends Thread {
    private Elevador elevador;
    private Passageiro passageiro;
    private Semaphore semaphore;
    
    public ThreadPassageiro(Elevador elevador, Passageiro passageiro, Semaphore semaphore) {
        this.elevador = elevador;
        this.passageiro = passageiro;
        this.semaphore = semaphore;
    }

    
    @Override
    public void run() {
        try {
            semaphore.acquire(); // aguarda a liberação do semáforo
            while (elevador.getAndarAtual() != passageiro.getAndarAtual()) {
                Thread.sleep(1000);
            }
            elevador.addPassageiro(passageiro);
            while (elevador.getAndarAtual() != passageiro.getAndarDesejado()) {
                Thread.sleep(1000);
            }
            elevador.removerPassageiros();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
    }
}
