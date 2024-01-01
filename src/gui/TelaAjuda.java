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
        botaoOk = new BotaoAjuda();
        JLabel texto1 = new JLabel("Passo a passo de como utilizar a aplicação...");
        JLabel texto2 = new JLabel("Digite as notas na caixa de texto ou importe um arquivo no menu Arquivos -> Abrir Arquivo");
        JLabel texto3 = new JLabel("Logo depois, clique em 'gerar música' para ser redirecionado para a aba de reprodução");
        JLabel texto4 = new JLabel("Nesta aba, você pode reproduzir o áudio no botão da esquerda e pausá-lo com o da direita");
        JLabel texto5 = new JLabel("Por fim, você pode salvar seu áudio no formato MIDI clicando em Arquivos -> Salvar Arquivo");
        adicionaComponentesAjuda();
        setVisible(true);
    }

    private void configTelaAjuda() throws IOException{
        setTitle("Ajuda");
        setSize(400, 200);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setIconImage(ImageIO.read(new File("img/nota.png")));
    }

    private void adicionaComponentesAjuda(){

    }
}
