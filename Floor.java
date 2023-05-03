import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Floor {
	private ImageIcon imgFloor;
	private List<Passageiro> passageiros;
	private JPanel panel;
	
	private int posY;
	
	public Floor(JPanel panel) {
		this.panel = panel;
		this.passageiros = new ArrayList<>();
		imgFloor = new ImageIcon(getClass().getResource("Image/Floor2.gif"));
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void draw(Graphics g) {
		imgFloor.paintIcon(panel, g, 50, posY);
	}
	
	public void setListaDePassageiros(List<Passageiro> passageirosCriados) {
		passageiros.addAll(passageirosCriados);
	}
	
	public List<Passageiro> getListaDePassageiros() {
		return passageiros;
	}
}
