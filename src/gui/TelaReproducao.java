package gui;

import javax.swing.*;

import org.jfugue.player.ManagedPlayer;

import javax.imageio.ImageIO;
import javax.sound.midi.Sequence;

import java.io.File;
import java.io.IOException;
import java.awt.*;

public class TelaReproducao extends JFrame{

    private BotaoPausa pausar;
    private BotaoReproducao reproduzir;

    public TelaReproducao(Sequence decodSeq, ManagedPlayer player) throws IOException{
        configReproducao();
        JPanel progresso = new JPanel();
        progresso.setBounds(70, 145, 25, 25);
        progresso.setBackground(Color.black);
        add(progresso);
        barraDeProgresso timer = new barraDeProgresso(player, progresso, decodSeq);
        pausar = new BotaoPausa(player, timer);
        reproduzir = new BotaoReproducao(decodSeq, player, timer);
        adicionaComponentesReproducao(pausar, reproduzir, player);
        setVisible(true);
    }

    private void configReproducao() throws IOException{
        setTitle("Janela de Reprodução");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setIconImage(ImageIO.read(new File("img/nota.png")));
    }

    private void adicionaComponentesReproducao(BotaoPausa pausar, BotaoReproducao reproduzir, ManagedPlayer player){

        ImageIcon pausaIcon = new ImageIcon("img/pause-button.png");
        Image pauseImage = pausaIcon.getImage(); 
        Image newimgPause = pauseImage.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        pausaIcon = new ImageIcon(newimgPause);
        pausar.setBounds(320,210,100,100);
        pausar.setLayout(null);
        pausar.setIcon(pausaIcon);
        pausar.setBorder(null);
        pausar.setBorderPainted(false);
        //pausar.setContentAreaFilled(false);
        pausar.setBackground(Color.white);
        pausar.setOpaque(false);

        ImageIcon reproduzIcon = new ImageIcon("img/play-button.png");
        Image reproduzImage = reproduzIcon.getImage(); 
        Image newimgReproduz = reproduzImage.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH);
        reproduzIcon = new ImageIcon(newimgReproduz);
        reproduzir.setBounds(160, 210, 90, 90);
        reproduzir.setLayout(null);
        reproduzir.setIcon(reproduzIcon);
        reproduzir.setBorder(null);
        reproduzir.setBorderPainted(false);
        //reproduzir.setContentAreaFilled(false);
        reproduzir.setBackground(Color.white);
        reproduzir.setOpaque(false);

        JPanel painel = new JPanel();
        painel.setBounds(70,150,450,11);
        painel.setBackground(Color.black);
        
        

        //label.setFont(new Font("Serif", Font.PLAIN, 36));

        add(painel);
        add(pausar);
        add(reproduzir);
    }
}
