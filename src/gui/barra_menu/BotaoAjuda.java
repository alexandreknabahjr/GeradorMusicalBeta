package gui.barra_menu;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class BotaoAjuda extends JButton implements ActionListener{
    
    TelaAjuda tela;
    int estado = 0;
    JLabel txt1, txt2, txt3;
    int WIDTH = 550;
    int HEIGHT = 50;
    JLabel tituloTela2 = new JLabel("Lista de Comandos Aceitos");
    JLabel comandos1 = new JLabel("A (Nota Lá)        G (Nota Sol)                            -  (Volta o Volume para Default))");
    JLabel comandos2 = new JLabel("B (Nota Si)        Espaço (Silêncio)                   R- (Diminui uma Oitava)");
    JLabel comandos3 = new JLabel("C (Nota Dó)       ? (Nota Aleatória A-G)           NL new line (Trocar o Instrumento)");
    JLabel comandos4 = new JLabel("D (Nota Ré)        ; (BPM Aleatório)                  BPM+ (Aumenta 80 BPM's)");
    JLabel comandos5 = new JLabel("E (Nota Mi)        + (Dobra o Volume)               Nenhum dos anteriores (Ignora)\"");
    JLabel comandos6 = new JLabel("F (Nota Fá)        R+ (Aumenta uma oitava)     Volgal (Se anterior = nota, repete, ");
    JLabel complementoVogal = new JLabel("senão, troca p/ instrumento telefone)");

    public BotaoAjuda(TelaAjuda tela, JLabel txt1, JLabel txt2, JLabel txt3){
        this.tela = tela;
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.txt3 = txt3;
        addActionListener(this);
    }

    public void configAjuda(){
        tituloTela2.setBounds(190, -10, WIDTH, HEIGHT);
        comandos1.setBounds(20, 20, WIDTH, HEIGHT);
        comandos2.setBounds(20, 36, WIDTH, HEIGHT);
        comandos3.setBounds(20, 52, WIDTH, HEIGHT);
        comandos4.setBounds(20, 68, WIDTH, HEIGHT);
        comandos5.setBounds(20, 84, WIDTH, HEIGHT);
        comandos6.setBounds(20, 100, WIDTH, HEIGHT);
        complementoVogal.setBounds(262, 116, WIDTH, HEIGHT);
    }

    public void adicionaComponentesAjuda(){
        tela.remove(txt1);
        tela.remove(txt2);
        tela.remove(txt3);

        tela.add(tituloTela2);
        tela.add(comandos1);
        tela.add(comandos2);
        tela.add(comandos3);
        tela.add(comandos4);
        tela.add(comandos5);
        tela.add(comandos6);
        tela.add(complementoVogal);
        
        tela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == this){
            if(estado == 0){
                configAjuda();
                adicionaComponentesAjuda();
                estado++;
            }
            else{
                if(estado == 1){
                    tela.dispose();
                }
            }
        }
     }
}
