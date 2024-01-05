package gui.barra_menu;

import gui.barra_menu.TelaAjuda;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class BotaoAjuda extends JButton implements ActionListener{
    
    TelaAjuda tela;
    int estado = 0;
    JLabel txt1, txt2, txt3;

    public BotaoAjuda(TelaAjuda tela, JLabel txt1, JLabel txt2, JLabel txt3){
        this.tela = tela;
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.txt3 = txt3;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == this){
            if(estado == 0){
                JLabel comandos1 = new JLabel("Lista de Comandos Aceitos");
                JLabel comand1 = new JLabel("A (Nota Lá)        G (Nota Sol)                            -  (Volta o Volume para Default))");
                JLabel comand2 = new JLabel("B (Nota Si)        Espaço (Silêncio)                   R- (Diminui uma Oitava)");
                JLabel comand3 = new JLabel("C (Nota Dó)       ? (Nota Aleatória A-G)           NL new line (Trocar o Instrumento)");
                JLabel comand4 = new JLabel("D (Nota Ré)        ; (BPM Aleatório)                  BPM+ (Aumenta 80 BPM's)");
                JLabel comand5 = new JLabel("E (Nota Mi)        + (Dobra o Volume)               Nenhum dos anteriores (Ignora)\"");
                JLabel comand6 = new JLabel("F (Nota Fá)        R+ (Aumenta uma oitava)     Volgal (Se anterior = nota, repete, ");
                JLabel complementoVogal = new JLabel("senão, troca p/ instrumento telefone)");
                comandos1.setBounds(145, -10, 400, 50);
                comand1.setBounds(10, 20, 450, 50);
                comand2.setBounds(10, 36, 450, 50);
                comand3.setBounds(10, 52, 450, 50);
                comand4.setBounds(10, 68, 450, 50);
                comand5.setBounds(10, 84, 450, 50);
                comand6.setBounds(10, 100, 450, 50);
                complementoVogal.setBounds(252, 116, 450, 50);
                tela.remove(txt1);
                tela.remove(txt2);
                tela.remove(txt3);
                tela.add(comandos1);
                tela.add(comand1);
                tela.add(comand2);
                tela.add(comand3);
                tela.add(comand4);
                tela.add(comand5);
                tela.add(comand6);
                tela.add(complementoVogal);
                tela.repaint();
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
