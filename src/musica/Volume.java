package musica;

public class Volume {
    private int valor;
    private final int DEFAULT_VOLUME = 8000;
    private final int MAX_VOLUME = 16383;

    public Volume() {
        this.valor = DEFAULT_VOLUME;
    }

    public void dobraValor() {
        if (this.valor > MAX_VOLUME) {
            this.valor = MAX_VOLUME;
        } else {
            this.valor *= 2;
        }
    }

    public void resetaValor() {
        this.valor = DEFAULT_VOLUME;
    }

     public String obterValor() {
         return ":CE(935, " + this.valor + ")";
     }
}
