package gui;

import musica.SequenciaMusical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.jfugue.midi.MidiParserListener;
import org.jfugue.player.ManagedPlayer;
import org.staccato.StaccatoParser;

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
            String inputUser = inputMusica.getText();
            SequenciaMusical seq = new SequenciaMusical(inputUser);
            String decodSeq = seq.decodificaSequencia();
            StaccatoParser staccatoParser = new StaccatoParser();
            MidiParserListener midiParserListener= new MidiParserListener();
            staccatoParser.addParserListener(midiParserListener);
            staccatoParser.parse(decodSeq);

            ManagedPlayer player = new ManagedPlayer();

            System.out.println(decodSeq);
             try {
                new TelaReproducao(midiParserListener.getSequence(), player);
            } catch (IOException n){}
        }
    }
}
