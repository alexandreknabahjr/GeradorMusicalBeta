package musica;

public enum InstrumentosMusicais {

    AGOGO("I[Agogo]"),
    HARPSCHIORD("I[Harpsichord]"),
    TUBULARBELLS("I[Tubular_Bells]"),
    PANFLUTE("I[Pan_Flute]"),
    CHURCHORGAN("I[Church_Organ]"),
    PIANO("I[Piano]");

    private String codInstrumento;

    InstrumentosMusicais(String codInstrumento){
        this.codInstrumento = codInstrumento;
    }

    @Override
    public String toString(){
        return codInstrumento;
    }
}
