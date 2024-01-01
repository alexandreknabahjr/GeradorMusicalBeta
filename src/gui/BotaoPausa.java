package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import org.jfugue.player.ManagedPlayer;

public class BotaoPausa extends JButton implements ActionListener{
    ManagedPlayer player;

    public BotaoPausa(ManagedPlayer parser){
        this.player = parser;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        player.pause();
    }

}
