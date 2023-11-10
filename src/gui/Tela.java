package gui;

import musica.SequenciaMusical;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Tela extends JFrame implements ActionListener {

    private Botao botaoGeraMusica;
    private CaixaTexto inputMusica;

    public Tela() throws IOException{
        setTitle("Gerador Musical");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        botaoGeraMusica = new Botao();
        botaoGeraMusica.addActionListener(this);
        botaoGeraMusica.setText("Gerar Música");
        botaoGeraMusica.setBounds(220,250,150,50);
        inputMusica = new CaixaTexto();
        inputMusica.setBounds(100, 100, 400, 100);
        add(botaoGeraMusica);
        add(inputMusica);
        setIconImage(ImageIO.read(new File("img/nota.png")));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==botaoGeraMusica){
            String inputUser = inputMusica.getText();
            SequenciaMusical seq = new SequenciaMusical(inputUser);
            String decodSeq = seq.decodificaSequencia();
            System.out.println(decodSeq);
        }
    }

    public static void main(String[] args) {
        try {
            new Tela();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
