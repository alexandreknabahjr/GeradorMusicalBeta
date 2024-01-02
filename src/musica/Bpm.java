package musica;

import java.util.Random;

public class Bpm {
    private int batidasPorMinuto = 120;
    private final int MAX_BPM = 300;

    public void trocaAleatoria() {
        Random random = new Random();

        batidasPorMinuto = random.nextInt(MAX_BPM);
    }

    public void aumentaBatidasPorMinuto(int unidades) {
        if (batidasPorMinuto + unidades < MAX_BPM) {
            batidasPorMinuto += unidades;
        } else {
            batidasPorMinuto = MAX_BPM;
        }
    }

    public String obterBatidasPorMinuto() {
        return "T" + batidasPorMinuto;
    }
}
