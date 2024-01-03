package gui;
import musica.Abertura;
import musica.Salvamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuClique extends JButton implements ActionListener{

    JMenuItem salvar;
    JMenuItem abrir;
    public MenuClique(JMenu help, JMenuItem save, JMenuItem open){
        this.salvar = save;
        this.abrir = open;
        salvar.addActionListener(this);
        abrir.addActionListener(this);
        help.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                try {
                    new TelaAjuda();
                } catch (Exception e1) {}
            }

            @Override
            public void menuDeselected(MenuEvent e) {}

            @Override
            public void menuCanceled(MenuEvent e) {}
            
        });
    }

    /*public void CliqueAjuda(){
        ajuda.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                try {
                    new TelaAjuda();
                } catch (Exception e1) {}

            }

            @Override
            public void menuDeselected(MenuEvent e) {
                try {
                    
                } catch (Exception e1) {}

            }

            @Override
            public void menuCanceled(MenuEvent e) {
                try {
                    
                } catch (Exception e1) {}

            }
        });
    }*/

    @Override
        public void actionPerformed(ActionEvent evt){
            if(evt.getSource() == salvar){
                try {
                    new Salvamento();
                } catch (Exception e) {}
            }
            if(evt.getSource() == abrir){
                try {
                    new Abertura();
                } catch (Exception e) {}
            }
        }
}
