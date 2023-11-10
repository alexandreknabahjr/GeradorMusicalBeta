package musica;

public enum Sons {

    TROCASOM(" "),
    MEIAPAUSA("Rh");

    private String codSom;

    Sons(String codSom){
        this.codSom = codSom;
    }

    @Override
    public String toString(){
        return codSom;
    }
}
