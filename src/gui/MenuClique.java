package gui;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuClique extends JButton {

    public MenuClique(JMenu help){
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
}
