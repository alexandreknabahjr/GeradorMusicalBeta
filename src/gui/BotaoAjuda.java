package gui;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class BotaoAjuda extends JButton implements ActionListener{
    
    int estado;
    public BotaoAjuda(){
        this.estado = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this){
            switch (estado) {
                case 0:
                    try {
                        new TelaAjuda();
                    } catch (Exception e1) {
                    }
                    estado++;
                    break;
                case 1:
                    
                    break;
                default:
                    break;
            }
            
            
        }
    }
}
