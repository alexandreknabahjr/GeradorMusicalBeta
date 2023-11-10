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
}
