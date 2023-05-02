// import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class Graphics extends JFrame {
    
    public Graphics(){
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // RenderizadorPNG renderizador = new RenderizadorPNG("imagem.png");
        // add(renderizador);
        setBackground(Color.blue);
        setVisible(true);
    }    
}
