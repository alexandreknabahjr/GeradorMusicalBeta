package gui.barra_menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ItemAjuda extends JMenuItem implements ActionListener {

    public ItemAjuda(){
        super("Ajuda");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            new TelaAjuda();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro na abertura do menu ajuda.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
