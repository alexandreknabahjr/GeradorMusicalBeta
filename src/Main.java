import musica.SequenciaMusical;
import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args) {
        SequenciaMusical seq = new SequenciaMusical("A???????A");
        String seqDecod = seq.decodificaSequencia();
        System.out.println(seqDecod);
        Player player = new Player();
        player.play(seqDecod);
    }
}