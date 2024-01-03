package gui;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class Tela extends JFrame{

    private Botao botaoGeraMusica;
    private CaixaTexto inputMusica;
    private JScrollPane scroll;


    public Tela() throws IOException{
        configTela();
        adicionaMenu();
        JLabel label = new JLabel("Digite o texto: ");
        inputMusica = new CaixaTexto();
        botaoGeraMusica = new Botao(inputMusica);
        scroll = new JScrollPane(inputMusica);
        adicionaComponentes(scroll, botaoGeraMusica, inputMusica, label);
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

    private void adicionaComponentes(JScrollPane scroll, Botao botao, CaixaTexto inputMusica, JLabel label){

        botao.setText("Gerar Música");
        botao.setBounds(220,250,150,60);
        botao.setBackground(new Color(255,255,255));
        botao.setLayout(null);
        //botao.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
        botao.setBorder(new BordaCircular(12));
    

        scroll.setBounds(100, 100, 400, 100);

        inputMusica.setBackground(Color.lightGray);
        inputMusica.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));

        label.setBounds(100, 50, 200, 50);
        label.setFont(new Font(null,Font.BOLD,20));



        //label.setFont(new Font("Serif", Font.PLAIN, 36));

        add(botao);
        add(scroll);
        add(label);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private void adicionaMenu(){
        JMenuBar barraSuperior = new JMenuBar();

        JMenu arquivos = new JMenu("Arquivos");
        JMenu ajuda = new JMenu("Ajuda");

        JMenuItem abrir = new JMenuItem("Abrir Arquivo");
        JMenuItem salvar = new JMenuItem("Salvar arquivo");

        arquivos.add(abrir);
        arquivos.add(salvar);
        barraSuperior.add(arquivos);
        barraSuperior.add(ajuda);
        new MenuClique(ajuda, salvar, abrir);
        barraSuperior.setBackground(Color.lightGray);
        barraSuperior.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
        this.setJMenuBar(barraSuperior);

    }


    public static void main(String[] args) {
        try {
            new Tela();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
