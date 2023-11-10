package gui;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tela extends JFrame {

    private Botao botaoGeraMusica = new Botao();

    public Tela() throws IOException{
        setTitle("Gerador Musical");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        botaoGeraMusica.setText("Gerar Música");
        botaoGeraMusica.setBounds(220,250,150,50);
        add(botaoGeraMusica);
        setIconImage(ImageIO.read(new File("img/nota.png")));
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            new Tela();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
