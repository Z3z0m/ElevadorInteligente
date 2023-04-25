import java.util.ArrayList;
import java.util.List;

public class Elevador {
    private int andarAtual;
    private int capacidadeMaxima;
    private List<Passageiro> passageiros;
    
    public Elevador(int capacidadeMaxima) {
        this.andarAtual = 0;
        this.capacidadeMaxima = capacidadeMaxima;
        this.passageiros = new ArrayList<>();
    }
    
    public synchronized void addPassageiro(Passageiro passageiro) throws InterruptedException {
        while (passageiros.size() >= capacidadeMaxima) {
            wait();
        }
        passageiros.add(passageiro);
        notifyAll();
    }
    
    public synchronized void removerPassageiros() throws InterruptedException {
        while (!passageiros.isEmpty()) {
            wait();
        }
        notifyAll();
    }
    
    public synchronized int getAndarAtual() {
        return andarAtual;
    }
    
    public synchronized void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }
}
