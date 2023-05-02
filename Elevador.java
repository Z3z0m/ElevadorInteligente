import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Elevador extends Thread{
    private int andarAtual;
    Semaphore sem;
    private List<Passageiro> passageiros;
	int posY, posX, andarDesejado;
	
	
	boolean isRunning = false;
    
    public Elevador(int andarDesejado) {
    	this.andarDesejado = andarDesejado;
        this.andarAtual = 0;
        sem = new Semaphore(1);
        this.passageiros = new ArrayList<>();
    }
    
    public void addPassageiro(Passageiro passageiro){
    	try {
			sem.acquire();
	        passageiros.add(passageiro);
	        passageiro.movePosX(this.posX);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
    	{
			sem.release();
		}
    }
    
    private void removerPassageiros(){
        if(!passageiros.isEmpty()) {
        	passageiros.clear();
        }
    }
   
    public int getAndarAtual() {
        return andarAtual;
    }
    
    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }
    
    public void getPassageirosNoAndarAtual() {
    	
    }
    
    private void move() {
    	if(andarDesejado > posY) {
    		posY += 1;
    		System.out.println("andou para cima");
    	}else if(andarDesejado < posY) {
    		posY -= 1;
    		System.out.println("andou para baixo");
    	}
    }
    
    public void begin(){
    	this.start();
    	isRunning = true;
    }
    
    public void run() {
    	while(isRunning != false) {
    		move();
    	}
    }

}
