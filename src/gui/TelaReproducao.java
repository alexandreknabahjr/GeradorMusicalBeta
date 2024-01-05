package gui;

import javax.swing.*;

import org.jfugue.player.ManagedPlayer;

import javax.imageio.ImageIO;
import javax.sound.midi.Sequence;

import java.io.File;
import java.io.IOException;
import java.awt.*;

public class TelaReproducao extends JFrame{

    private final BotaoPausa pausar;
    private final BotaoReproducao reproduzir;
    private final BotaoSalvamento salvar;

    public TelaReproducao(Sequence decodSeq, ManagedPlayer player) throws IOException{
        configReproducao();
        JPanel progresso = new JPanel();
        progresso.setBounds(70, 145, 25, 25);
        progresso.setBackground(Color.black);
        add(progresso);
        barraDeProgresso timer = new barraDeProgresso(player, progresso, decodSeq);
        pausar = new BotaoPausa(player, timer);
        reproduzir = new BotaoReproducao(decodSeq, player, timer);
        salvar = new BotaoSalvamento(decodSeq);
        configBotoes();
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

    private void configBotoes() {
        JPanel painel = new JPanel();
        painel.setBounds(70,150,450,11);
        painel.setBackground(Color.black);

        add(painel);
        add(pausar);
        add(reproduzir);
        add(salvar);
    }
}
