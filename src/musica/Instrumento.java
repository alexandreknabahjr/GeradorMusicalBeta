package musica;

import java.util.Random;
import org.jfugue.midi.MidiDictionary;

public class Instrumento {
    private String nome;
    private final int MAX_COD_INSTRUMENTO = 128;

    public Instrumento(String nome) {
        this.nome = nome;
    }

    public void trocaAleatoria() {
        Random random = new Random();

        int cod = random.nextInt(MAX_COD_INSTRUMENTO);

        Byte bInstrumento = (byte) (cod);

        this.nome = "I["+ MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(bInstrumento) +"]";
    }

    public String obterNome() {
        return nome;
    }
}
