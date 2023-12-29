package musica;

public enum NotasMusicais {

    LA('A'),
    SI('B'),
    DO('C'),
    RE('D'),
    MI('E'),
    FA('F'),
    SOL('G');

    private final char codNota;

    NotasMusicais(char codNota){
        this.codNota = codNota;
    }

    @Override
    public String toString(){
        return String.valueOf(codNota);
    }
    public static boolean contem(char codNotaInput) {
        for (NotasMusicais notasMusicais : values()) {
            if (notasMusicais.codNota == codNotaInput) {
                return true;
            }
        }

        return false;
    }
}
