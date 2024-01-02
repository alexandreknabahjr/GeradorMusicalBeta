package gui;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class BotaoAjuda extends JButton implements ActionListener{
    
    TelaAjuda tela;
    public BotaoAjuda(TelaAjuda atual){
        this.tela = atual;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == this){
            tela.dispose();
        }    
     }
}
