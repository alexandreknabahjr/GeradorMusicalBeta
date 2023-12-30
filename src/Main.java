import musica.SequenciaMusical;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args) {
        
        //JFrame frame;
        //try{
        //    frame = new Tela();
        //} catch(IOException e){
        //}

        SequenciaMusical seq = new SequenciaMusical("C9CCCCC");
        String seqDecod = seq.decodificaSequencia();
        System.out.println(seqDecod);
        Player player = new Player();
        player.play(seqDecod);
    }
}