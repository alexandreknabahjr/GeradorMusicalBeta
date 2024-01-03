package gui;

import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

public class BordaCircular implements Border {

    private int raio;


    BordaCircular(int raio) {
        this.raio = raio;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.raio+1, this.raio+1, this.raio+2, this.raio);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int largura, int altura) {
        g.drawRoundRect(x, y, largura-1, altura-1, raio, raio);
    }
}
