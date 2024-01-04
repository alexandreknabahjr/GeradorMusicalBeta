package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import org.jfugue.player.ManagedPlayer;

public class BotaoPausa extends JButton implements ActionListener{

    ManagedPlayer player;
    barraDeProgresso timer;

    public BotaoPausa(ManagedPlayer parser, barraDeProgresso timer){
        this.player = parser;
        this.timer = timer;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        timer.pausaBarra();
        player.pause();
    }

}
