package gui;

import musica.SequenciaMusical;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Tela extends JFrame{

    private Botao botaoGeraMusica;
    private CaixaTexto inputMusica;

    public Tela() throws IOException{
        configTela();
        adicionaComponentes(inputMusica, botaoGeraMusica);
        setVisible(true);
    }

    private void configTela() throws IOException{
        setTitle("Gerador Musical");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setIconImage(ImageIO.read(new File("img/nota.png")));
    }

    private void adicionaComponentes(CaixaTexto caixa, Botao botao){
        caixa = new CaixaTexto();
        botao = new Botao(caixa);
        botao.setText("Gerar Música");
        botao.setBounds(220,250,150,50);
        caixa.setBounds(100, 100, 400, 100);
        add(botao);
        add(caixa);
    }

    public static void main(String[] args) {
        try {
            new Tela();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
