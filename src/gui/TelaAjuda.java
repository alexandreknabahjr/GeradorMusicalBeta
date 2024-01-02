package gui;

import javax.swing.*;
import java.awt.BasicStroke;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.*;

public class TelaAjuda extends JFrame{
    private BotaoAjuda botaoOk;

    public TelaAjuda() throws IOException{
        configTelaAjuda();
        botaoOk = new BotaoAjuda(this);
        adicionaComponentesAjuda(botaoOk);
        setVisible(true);
    }

    private void configTelaAjuda() throws IOException{
        setTitle("Ajuda");
        setSize(475, 200);
        setUndecorated(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setIconImage(ImageIO.read(new File("img/nota.png")));
        setAlwaysOnTop(true);
        getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
    }

    private void adicionaComponentesAjuda(BotaoAjuda botaoOk){
        JLabel texto1 = new JLabel("1: Digite as notas na caixa de texto ou importe um arquivo em 'Arquivos'");
        JLabel texto2 = new JLabel("2: Clique em 'gerar música' para abrir a aba de reprodução");
        JLabel texto3 = new JLabel("3: Reproduza ou pause o áudio em seus botões correspondentes");
        JLabel texto4 = new JLabel("4: Salve seu áudio no formato MIDI clicando em 'Arquivos' -> Salvar Arquivo");

        JLabel comand1 = new JLabel("A (Nota Lá)        G (Nota Sol)                            -  (Volta o Volume para Default))");
        JLabel comand2 = new JLabel("B (Nota Si)        Espaço (Silêncio)                   R- (Diminui uma Oitava)");
        JLabel comand3 = new JLabel("C (Nota Dó)       ? (Nota Aleatória A-G)           NL new line (Trocar o Instrumento)");
        JLabel comand4 = new JLabel("D (Nota Ré)        ; (BPM Aleatório)                  BPM+ (Aumenta 80 unidades de BPM)");
        JLabel comand5 = new JLabel("E (Nota Mi)        + (Dobra o Volume)               Vogal (Se anterior era nota, repete)");
        JLabel comand6 = new JLabel("F (Nota Fá)        R+ (Aumenta uma oitava)     Nenhum dos anteriores (Ignora)");

        botaoOk.setText("OK");
        botaoOk.setBounds(190, 150, 60, 30);
        botaoOk.setBackground(Color.white);
        botaoOk.setLayout(null);
        botaoOk.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));

        texto1.setBounds(10, -10, 420, 70);
        texto2.setBounds(10, 2,420,70);
        texto3.setBounds(10, 14, 420, 70);
        texto4.setBounds(10,26,430,70);
        
        comand1.setBounds(10, 45, 460, 60);
        comand2.setBounds(10, 58, 460, 60);
        comand3.setBounds(10, 69, 460, 60);
        comand4.setBounds(10, 80, 460, 60);
        comand5.setBounds(10, 91, 460, 60);
        comand6.setBounds(10, 103, 460, 60);

        add(botaoOk);
        add(texto1);
        add(texto2);
        add(texto3);
        add(texto4);
        add(comand1);
        add(comand2);
        add(comand3);
        add(comand4);
        add(comand5);
        add(comand6);

    }
}
