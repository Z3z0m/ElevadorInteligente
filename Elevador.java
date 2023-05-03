import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Elevador extends Thread{
    private int andarAtual;
    Semaphore sem;
    private List<Passageiro> passageiros;
	int posY = 0 , posX, andarDesejado;
	ImageIcon imgElevador, imgElevadorFechado, imgElevadorAberto;
	private JPanel panel;
	Predio predio;
	boolean isRunning = false;
    
    public Elevador(int andarDesejado, Predio predio) {
    	this.andarDesejado = andarDesejado;
    	this.panel = panel;
        sem = new Semaphore(1);
        this.passageiros = new ArrayList<>();
        
        this.predio = predio;
        
        imgElevador = new ImageIcon(getClass().getResource("Image/Elevator.png"));
        imgElevadorFechado = new ImageIcon(getClass().getResource("Image/ElevatorClosed.png"));
        imgElevadorAberto = new ImageIcon(getClass().getResource("Image/ElevatorOpen.png"));
    }
    
    public void draw(Graphics g) {
    	imgElevadorFechado.paintIcon(panel, g, 50, posY);
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
    	while(isRunning = true){
        	if(andarDesejado > posY) {
        		posY += 1;
        		predio.repintar();
        	}else if(andarDesejado < posY) {
        		posY -= 1;
        		predio.repintar();
        	}
    	
    	}

    }
    
    public void begin(){
    	this.start();
    	isRunning = true;
    }
    
    public void run() {
    	while(isRunning != false) {
    		//move();
    	}
    }

}
