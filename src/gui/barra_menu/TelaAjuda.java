package gui.barra_menu;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TelaAjuda extends JFrame {

    private final int WIDTH = 550;
    private final int HEIGHT = 250;
    private BotaoAjuda botaoOk;

    public TelaAjuda() throws IOException{
        JLabel texto1 = new JLabel("1: Digite as notas na caixa de texto ou importe um arquivo em 'Opções'.");
        JLabel texto2 = new JLabel("2: Clique em 'gerar música' para abrir a aba de reprodução.");
        JLabel texto3 = new JLabel("3: Reproduza, pause ou salve o áudio em seus botões correspondentes.");
        configTelaAjuda();
        botaoOk = new BotaoAjuda(this, texto1, texto2, texto3);
        adicionaComponentesAjuda(botaoOk, texto1, texto2, texto3);
        setVisible(true);
    }

    private void configTelaAjuda() throws IOException{
        setTitle("Ajuda");
        setSize(WIDTH, HEIGHT);
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

    private void adicionaComponentesAjuda(BotaoAjuda botaoOk, JLabel texto1, JLabel texto2, JLabel texto3){
        botaoOk.setText("OK");
        botaoOk.setBounds(WIDTH / 2 - 55, 160, 60, 30);
        botaoOk.setBackground(Color.white);
        botaoOk.setLayout(null);
        botaoOk.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));

        texto1.setBounds(10, -80, WIDTH, HEIGHT);
        texto2.setBounds(10, -60, WIDTH, HEIGHT);
        texto3.setBounds(10, -40, WIDTH, HEIGHT);

        add(botaoOk);
        add(texto1);
        add(texto2);
        add(texto3);
    }
}
