package gui;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class ajudaMenuClique extends JFrame{

    JMenu ajuda;
    public ajudaMenuClique(JMenu help){
        this.ajuda = help;
        CliqueAjuda();
    }

    public void CliqueAjuda(){
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
    }
}
