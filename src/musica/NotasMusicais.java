package musica;

public enum NotasMusicais {

    LA("A"),
    SI("B"),
    DO("C"),
    RE("D"),
    MI("E"),
    FA("F"),
    SOL("G");

    private String codNota;

    NotasMusicais(String codNota){
        this.codNota = codNota;
    }

    @Override
    public String toString(){
        return codNota;
    }

    public char toChar(){
        return codNota.charAt(0);
    }

    public static boolean contem(char codNotaInput) {
        for (NotasMusicais notasMusicais : values()) {
            if (notasMusicais.codNota.equals(String.valueOf(codNotaInput))) {
                return true;
            }
        }

        return false;
    }
}
