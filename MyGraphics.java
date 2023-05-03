import java.awt.Color;
import javax.swing.JFrame;

public class MyGraphics extends JFrame {
    
    public MyGraphics(){
        super(); // chama o construtor da superclasse JFrame
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLUE); // Define a cor de fundo do painel de conteúdo do JFrame
        setVisible(true);
    }    
    
    public static void main(String[] args) {
        MyGraphics graphics = new MyGraphics(); // Instancia a sua classe MyGraphics
    }
}