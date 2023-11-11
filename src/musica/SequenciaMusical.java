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

    private String inicializaSequencia(){
        return Sons.TROCASOM.toString();
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
        StringBuilder sequenciaMusical = new StringBuilder(instrumentoAtual);
        sequenciaMusical.append(inicializaSequencia());
        String ultimaNota = inicializaNota();
        String ultimaOitava = inicializaOitava();

        for(int i = 0; i < textoInput.length(); i++){
            char c = textoInput.charAt(i);

            switch (c){
                // Nota Lá
                case 'A':
                    sequenciaMusical.append(NotasMusicais.LA);
                    sequenciaMusical.append(ultimaOitava);
                    sequenciaMusical.append(Sons.TROCASOM);
                    ultimaNota = (NotasMusicais.LA + ultimaOitava);
                    break;
                // Nota Si
                case 'B':
                    sequenciaMusical.append(NotasMusicais.SI);
                    sequenciaMusical.append(ultimaOitava);
                    sequenciaMusical.append(Sons.TROCASOM);
                    ultimaNota = (NotasMusicais.SI + ultimaOitava);
                    break;
                // Nota Dó
                case 'C':
                    sequenciaMusical.append(NotasMusicais.DO);
                    sequenciaMusical.append(ultimaOitava);
                    sequenciaMusical.append(Sons.TROCASOM);
                    ultimaNota = (NotasMusicais.DO + ultimaOitava);
                    break;
                // Nota Ré
                case 'D':
                    sequenciaMusical.append(NotasMusicais.RE);
                    sequenciaMusical.append(ultimaOitava);
                    sequenciaMusical.append(Sons.TROCASOM);
                    ultimaNota = (NotasMusicais.RE + ultimaOitava);
                    break;
                // Nota Mi
                case 'E':
                    sequenciaMusical.append(NotasMusicais.MI);
                    sequenciaMusical.append(ultimaOitava);
                    sequenciaMusical.append(Sons.TROCASOM);
                    ultimaNota = (NotasMusicais.MI + ultimaOitava);
                    break;
                // Nota Fá
                case 'F':
                    sequenciaMusical.append(NotasMusicais.FA);
                    sequenciaMusical.append(ultimaOitava);
                    sequenciaMusical.append(Sons.TROCASOM);
                    ultimaNota = (NotasMusicais.FA + ultimaOitava);
                    break;
                // Nota Sol
                case 'G':
                    sequenciaMusical.append(NotasMusicais.SOL);
                    sequenciaMusical.append(ultimaOitava);
                    sequenciaMusical.append(Sons.TROCASOM);
                    ultimaNota = NotasMusicais.SOL.toString();
                    break;
                // Troca instrumento para Agogo
                case '!':
                    instrumentoAtual = InstrumentosMusicais.AGOGO.toString();
                    sequenciaMusical.append(instrumentoAtual);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Troca instrumento para Harpschiord
                case 'O', 'o', 'I', 'i', 'U', 'u':
                    instrumentoAtual = InstrumentosMusicais.HARPSCHIORD.toString();
                    sequenciaMusical.append(instrumentoAtual);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Troca instrumento
                case '0', '1', '2', '3','4','5','6','7','8','9':
                    instrumentoAtual = atualizaInstrumento(instrumentoAtual, c);
                    sequenciaMusical.append(instrumentoAtual);
                    sequenciaMusical.append(Sons.TROCASOM);
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
                    sequenciaMusical.append(instrumentoAtual);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Troca instrumento para Pan Flute
                case ';':
                    instrumentoAtual = InstrumentosMusicais.PANFLUTE.toString();
                    sequenciaMusical.append(instrumentoAtual);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Troca instrumento para Church Organ
                case ',':
                    instrumentoAtual = InstrumentosMusicais.CHURCHORGAN.toString();
                    sequenciaMusical.append(instrumentoAtual);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Letras minúsculas
                // Consoantes que não são notas
                // Nenhum char mapeado
                default:
                    if(i > 0){
                        if(textoInput.charAt(i - 1) == 'A' || textoInput.charAt(i - 1) == 'B'
                                || textoInput.charAt(i - 1) == 'C' || textoInput.charAt(i - 1) == 'D'
                                || textoInput.charAt(i - 1) == 'E' || textoInput.charAt(i - 1) == 'F'
                                || textoInput.charAt(i - 1) == 'G'){

                            sequenciaMusical.append(ultimaNota);
                            sequenciaMusical.append(Sons.TROCASOM);

                        } else{
                            sequenciaMusical.append(Sons.MEIAPAUSA);
                            sequenciaMusical.append(Sons.TROCASOM);
                        }
                    } else {
                        sequenciaMusical.append(Sons.MEIAPAUSA);
                        sequenciaMusical.append(Sons.TROCASOM);
                    }
                    break;

            }


        }
        return sequenciaMusical.toString();
    }
}
