import javax.swing.JPanel;

public class Predio extends JPanel {
	
	int num_Passageiros = 10;
	static int num_Floors = 2;
	static Passageiro passageiro;
	static Elevador elevador;
	static Floor floor[] = new Floor[num_Floors];
	
	public Predio() {
		passageiro = new Passageiro(num_Passageiros);
		passageiro.criarPassageiros(num_Passageiros);
		for(int i = 0; i < num_Floors; i++) {
			floor[i] = new Floor();
			floor[i].setListaDePassageiros(passageiro.getListaDePassageirosCriados());
			System.out.println(floor[i].getListaDePassageiros());
		}
		Begin();
	}

	private void Draw() {
		
	}
	
	private void Begin() {

		for(Passageiro p : passageiro.passageiro) {
			p.start();
			elevador = new Elevador(p.getAndarDesejado());
		}
		

		
		elevador.begin();
	
		
		}
}
