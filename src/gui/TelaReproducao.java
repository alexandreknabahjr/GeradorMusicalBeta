package gui;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class TelaReproducao extends JFrame{

    private BotaoPausa pausar;
    private BotaoReproducao reproduzir;
    private barraDeProgresso timer;

    public TelaReproducao() throws IOException{
        configReproducao();
        pausar = new BotaoPausa();
        reproduzir = new BotaoReproducao();
        timer = new barraDeProgresso();
        adicionaComponentesReproducao(pausar, reproduzir, timer);
        setVisible(true);
    }

    private void configReproducao() throws IOException{
        setTitle("Janela de Reprodução");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setIconImage(ImageIO.read(new File("img/nota.png")));
    }

    private void adicionaComponentesReproducao(BotaoPausa pausar, BotaoReproducao reproduzir, barraDeProgresso timer){

        pausar.setBounds(110,250,150,50);
        pausar.setLayout(null);

        reproduzir.setBounds(330, 250, 150, 50);
        reproduzir.setLayout(null);



        //label.setFont(new Font("Serif", Font.PLAIN, 36));

        add(pausar);
        add(reproduzir);
        add(timer);
    }
}
