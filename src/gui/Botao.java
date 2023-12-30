package gui;

import musica.SequenciaMusical;
import org.jfugue.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Botao extends JButton implements ActionListener {

    CaixaTexto inputMusica;
    public Botao(CaixaTexto inputMusica){
        super();
        this.inputMusica = inputMusica;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== this){
            try {
                new TelaReproducao();
            } catch (IOException n){}
            String inputUser = inputMusica.getText();
            SequenciaMusical seq = new SequenciaMusical(inputUser);
            String decodSeq = seq.decodificaSequencia();
            System.out.println(decodSeq);
            Player player = new Player();
            player.play(decodSeq);
        }
    }
}
