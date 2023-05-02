import java.util.ArrayList;
import java.util.List;

public class Floor {
	
	private List<Passageiro> passageiros;
	
	public Floor() {
		this.passageiros = new ArrayList<>();
	}
	
	public void setListaDePassageiros(List<Passageiro> passageirosCriados) {
		passageiros.addAll(passageirosCriados);
	}
	
	public List<Passageiro> getListaDePassageiros() {
		return passageiros;
	}
}
