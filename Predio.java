import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Predio extends JPanel {
	
	int num_Passageiros = 10;
	static int num_Floors = 4;
	static Passageiro passageiro;
	static Elevador elevador;
	private List<Floor> floors = new ArrayList<>();
	
	int posYFLoor = -150;

	public Predio() {
		passageiro = new Passageiro(num_Passageiros);
		passageiro.criarPassageiros(num_Passageiros);
		for(int i = 0; i < num_Floors; i++) {
			floors.add(new Floor(this));
			floors.get(i).setPosY((i + 1) * -150);
			floors.get(i).setListaDePassageiros(passageiro.getListaDePassageirosCriados());
			System.out.println(floors.get(i).getListaDePassageiros());
		}
		
		Begin();
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		for(int i = 0; i < floors.size(); i++) {
			floors.get(i).draw(g);
		}
	}
	
	private void Begin() {

		for(Passageiro p : passageiro.passageiro) {
			p.start();
			elevador = new Elevador(p.getAndarDesejado());
		}
		
		elevador.begin();
	
		
		}
}
