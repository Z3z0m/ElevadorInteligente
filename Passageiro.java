import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Passageiro extends Thread{
	
    private int andarAtual, num_Passageiros;
    private int andarDesejado;
    Passageiro passageiro[];
    Floor floor;
    Predio predio;
    
    private int posX, posY;
    
    private List<Passageiro> passageirosCriados;
    
    public Passageiro(int num_Passageiros, Predio predio) {
    	this.predio = predio;
        this.andarDesejado = ThreadLocalRandom.current().nextInt(-1, 1);
        this.num_Passageiros = num_Passageiros;

        this.passageirosCriados = new ArrayList<>();
        
    }
    
    public int getAndarAtual() {
        return andarAtual;
    }
    
    public int getAndarDesejado() {
        return andarDesejado;
    }
    
    public void criarPassageiros(int n_passageiros) {
    	this.num_Passageiros = n_passageiros;
    	this.passageiro = new Passageiro[n_passageiros];
    	
		for(int i = 0; i < n_passageiros; i++) {
			passageiro[i] = new Passageiro(this.num_Passageiros, predio);
			System.out.println("passageiro " + i + " ");
			passageirosCriados.add(passageiro[i]);
			}
    }
    
    public List<Passageiro> getListaDePassageirosCriados(){
    	return passageirosCriados;
    }
    
    public void movePosX(int posXDestino) {
    	while(this.posX != posXDestino) {
    		
    		if(this.posX > posXDestino) {
    			this.posX += 1;
    		}else {
    			this.posX -= 1;
    		}
    	}
    	
    }
    
    public void movePosY() {
    	this.posY += 1;
    }
    
    
    public void run() {
    	System.out.println("foi Criado");
    }
}