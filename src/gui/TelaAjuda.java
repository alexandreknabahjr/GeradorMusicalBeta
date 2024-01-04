package gui;

import javax.swing.*;
import java.awt.BasicStroke;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class TelaAjuda extends JFrame{
    private BotaoAjuda botaoOk;

    public TelaAjuda() throws IOException{
        JLabel texto1 = new JLabel("1: Digite as notas na caixa de texto ou importe um arquivo em 'Arquivos'");
        JLabel texto2 = new JLabel("2: Clique em 'gerar música' para abrir a aba de reprodução");
        JLabel texto3 = new JLabel("3: Reproduza ou pause o áudio em seus botões correspondentes");
        JLabel texto4 = new JLabel("4: Salve seu áudio no formato MIDI clicando em 'Arquivos' -> Salvar Arquivo");
        configTelaAjuda();
        botaoOk = new BotaoAjuda(this, texto1, texto2, texto3, texto4);
        adicionaComponentesAjuda(botaoOk, texto1, texto2, texto3, texto4);
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

    private void adicionaComponentesAjuda(BotaoAjuda botaoOk, JLabel texto1, JLabel texto2, JLabel texto3, JLabel texto4){
        //JLabel texto1 = new JLabel("1: Digite as notas na caixa de texto ou importe um arquivo em 'Arquivos'");
        //JLabel texto2 = new JLabel("2: Clique em 'gerar música' para abrir a aba de reprodução");
        //JLabel texto3 = new JLabel("3: Reproduza ou pause o áudio em seus botões correspondentes");
        //JLabel texto4 = new JLabel("4: Salve seu áudio no formato MIDI clicando em 'Arquivos' -> Salvar Arquivo");

        //JLabel comand1 = new JLabel("A (Nota Lá)        G (Nota Sol)                            -  (Volta o Volume para Default))");
        //JLabel comand2 = new JLabel("B (Nota Si)        Espaço (Silêncio)                   R- (Diminui uma Oitava)");
        //JLabel comand3 = new JLabel("C (Nota Dó)       ? (Nota Aleatória A-G)           NL new line (Trocar o Instrumento)");
        //JLabel comand4 = new JLabel("D (Nota Ré)        ; (BPM Aleatório)                  BPM+ (Aumenta 80 unidades de BPM)");
        //JLabel comand5 = new JLabel("E (Nota Mi)        + (Dobra o Volume)               Vogal (Se anterior era nota, repete)");
        //JLabel comand6 = new JLabel("F (Nota Fá)        R+ (Aumenta uma oitava)     Nenhum dos anteriores (Ignora)");

        botaoOk.setText("OK");
        botaoOk.setBounds(190, 150, 60, 30);
        botaoOk.setBackground(Color.white);
        botaoOk.setLayout(null);
        botaoOk.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));

        texto1.setBounds(10, 15, 420, 70);
        texto2.setBounds(10, 30,420,70);
        texto3.setBounds(10, 45, 420, 70);
        texto4.setBounds(10,60,430,70);

        add(botaoOk);
        add(texto1);
        add(texto2);
        add(texto3);
        add(texto4);
    }
}
