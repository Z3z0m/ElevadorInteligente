public class Passageiro {
    private int andarAtual;
    private int andarDesejado;
    
    public Passageiro(int andarAtual, int andarDesejado) {
        this.andarAtual = andarAtual;
        this.andarDesejado = andarDesejado;
    }
    
    public int getAndarAtual() {
        return andarAtual;
    }
    
    public int getAndarDesejado() {
        return andarDesejado;
    }
}