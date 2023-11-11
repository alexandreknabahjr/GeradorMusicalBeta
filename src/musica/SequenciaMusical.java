package musica;

import musica.InstrumentosMusicais;
import org.jfugue.midi.MidiDictionary;

public class SequenciaMusical{

    private String textoInput;
    private final int DEFAULT_VOLUME = 100;
    private final int MAX_VOLUME = 127;
    private final int DEFAULT_OITAVA = 5;
    private final int MAX_OITAVA = 9;

    public SequenciaMusical(String textoInput) {
        this.textoInput = textoInput;
    }

    private String limpaStringInstrumento(String instrumentoAtual){

        return instrumentoAtual.replace("I", "").
                replace("[", "").
                replace("]", "");
    }

    private String mapeiaInstrumento(String instrumento, char c){

        String novoInstrumento = instrumento.toUpperCase();
        int numeroInstrumento = (int) (MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get(novoInstrumento));
        Byte bInstrumento = (byte) (numeroInstrumento + Character.getNumericValue(c));

        return MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(bInstrumento);
    }

    private String atualizaInstrumento(String instrumentoAtual, char c){

        String novoInstrumento = limpaStringInstrumento(instrumentoAtual);
        String proxInstrumento = mapeiaInstrumento(novoInstrumento, c);

        return "I[" + proxInstrumento + "]";
    }

    private String inicializaSequencia(String instrumento){
        return instrumento + Sons.TROCASOM.toString();
    }

    private String inicializaInstrumento(){
        return InstrumentosMusicais.PIANO.toString();
    }

    private String inicializaNota(){
        return "";
    }

    private String inicializaOitava(){
        return Integer.toString(DEFAULT_OITAVA);
    }

    public String decodificaSequencia(){

        String instrumentoAtual = inicializaInstrumento();
        String sequenciaMusical = inicializaSequencia(instrumentoAtual);
        String ultimaNota = inicializaNota();
        String ultimaOitava = inicializaOitava();

        for(int i = 0; i < textoInput.length(); i++){
            char c = textoInput.charAt(i);

            switch (c){
                // Nota Lá
                case 'A':
                    sequenciaMusical += NotasMusicais.LA.toString();
                    sequenciaMusical += ultimaOitava;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    ultimaNota = (NotasMusicais.LA.toString() + ultimaOitava);
                    break;
                // Nota Si
                case 'B':
                    sequenciaMusical += NotasMusicais.SI.toString();
                    sequenciaMusical += ultimaOitava;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    ultimaNota = (NotasMusicais.SI.toString() + ultimaOitava);
                    break;
                // Nota Dó
                case 'C':
                    sequenciaMusical += NotasMusicais.DO.toString();
                    sequenciaMusical += ultimaOitava;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    ultimaNota = (NotasMusicais.DO.toString() + ultimaOitava);
                    break;
                // Nota Ré
                case 'D':
                    sequenciaMusical += NotasMusicais.RE.toString();
                    sequenciaMusical += ultimaOitava;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    ultimaNota = (NotasMusicais.RE.toString() + ultimaOitava);
                    break;
                // Nota Mi
                case 'E':
                    sequenciaMusical += NotasMusicais.MI.toString();
                    sequenciaMusical += ultimaOitava;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    ultimaNota = (NotasMusicais.MI.toString() + ultimaOitava);
                    break;
                // Nota Fá
                case 'F':
                    sequenciaMusical += NotasMusicais.FA.toString();
                    sequenciaMusical += ultimaOitava;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    ultimaNota = (NotasMusicais.FA.toString() + ultimaOitava);
                    break;
                // Nota Sol
                case 'G':
                    sequenciaMusical += NotasMusicais.SOL.toString();
                    sequenciaMusical += ultimaOitava;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    ultimaNota = NotasMusicais.SOL.toString();
                    break;
                // Troca instrumento para Agogo
                case '!':
                    instrumentoAtual = InstrumentosMusicais.AGOGO.name();
                    sequenciaMusical += instrumentoAtual;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    break;
                // Troca instrumento para Harpschiord
                case 'O', 'o', 'I', 'i', 'U', 'u':
                    instrumentoAtual = InstrumentosMusicais.HARPSCHIORD.name();
                    sequenciaMusical += instrumentoAtual;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    break;
                // Troca instrumento
                case '0', '1', '2', '3','4','5','6','7','8','9':
                    instrumentoAtual = atualizaInstrumento(instrumentoAtual, c);
                    sequenciaMusical += instrumentoAtual;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    break;
                case '?':
                    if(Integer.parseInt(ultimaOitava) >= MAX_OITAVA){
                        ultimaOitava = Integer.toString(DEFAULT_OITAVA);
                    } else {
                        ultimaOitava = Integer.toString(Integer.parseInt(ultimaOitava) + 1);
                    }
                    break;
                // Troca instrumento para Tubular Bells
                case '\n':
                    instrumentoAtual = InstrumentosMusicais.TUBULARBELLS.toString();
                    sequenciaMusical += instrumentoAtual;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    break;
                // Troca instrumento para Pan Flute
                case ';':
                    instrumentoAtual = InstrumentosMusicais.PANFLUTE.toString();
                    sequenciaMusical += instrumentoAtual;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    break;
                // Troca instrumento para Church Organ
                case ',':
                    instrumentoAtual = InstrumentosMusicais.CHURCHORGAN.toString();
                    sequenciaMusical += instrumentoAtual;
                    sequenciaMusical += Sons.TROCASOM.toString();
                    break;
                // Letras minúsculas
                // Consoantes que não são notas
                // Nenhum char mapeado
                default:
                    if(textoInput.charAt(i - 1) == 'A' || textoInput.charAt(i - 1) == 'B'
                            || textoInput.charAt(i - 1) == 'C' || textoInput.charAt(i - 1) == 'D'
                            || textoInput.charAt(i - 1) == 'E' || textoInput.charAt(i - 1) == 'F'
                            || textoInput.charAt(i - 1) == 'G') {

                        sequenciaMusical += ultimaNota;
                        sequenciaMusical += Sons.TROCASOM.toString();

                    } else{

                        sequenciaMusical += Sons.MEIAPAUSA.toString();
                        sequenciaMusical += Sons.TROCASOM.toString();
                    }
                    break;

            }


        }
        return sequenciaMusical;
    }
}
