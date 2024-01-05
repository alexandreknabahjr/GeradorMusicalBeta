package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.jfugue.player.ManagedPlayer;

public class BotaoPausa extends JButton implements ActionListener{

    ManagedPlayer player;
    barraDeProgresso timer;

    public BotaoPausa(ManagedPlayer parser, barraDeProgresso timer){
        this.player = parser;
        this.timer = timer;
        configBotao();
        addActionListener(this);
    }

    private void configBotao() {
        ImageIcon icone = new ImageIcon("img/pause-button.png");
        Image imagem = icone.getImage();
        Image imagemEmEscala = imagem.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH);

        setIcon(new ImageIcon(imagemEmEscala));
        setBounds(250, 210, 100, 100);
        setLayout(null);
        setBorder(null);
        setBorderPainted(false);
        setBackground(Color.white);
        setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        timer.pausaBarra();
        player.pause();
    }

}
