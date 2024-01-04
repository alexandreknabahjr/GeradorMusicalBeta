package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfugue.player.ManagedPlayer;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.swing.JButton;

public class BotaoReproducao extends JButton implements ActionListener{
    
    Sequence musica;
    ManagedPlayer player;
    barraDeProgresso timer;

    public BotaoReproducao(Sequence decodSequence, ManagedPlayer parser, barraDeProgresso timer){
        this.musica = decodSequence;
        this.player = parser;
        this.timer = timer;
        addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this){
            try {
                timer.iniciaBarra();
                timer.pausado = false;
                player.start(musica);
            } catch (InvalidMidiDataException e1) {
                e1.printStackTrace();
            } catch (MidiUnavailableException e1) {
                e1.printStackTrace();
            }
        }
    }

}
