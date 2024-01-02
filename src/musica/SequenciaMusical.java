package musica;

import org.jfugue.midi.MidiDictionary;

public class SequenciaMusical{

    private final String textoInput;
    private final int DEFAULT_VOLUME = 100;
    private final int MAX_VOLUME = 127;
    private final int DEFAULT_OITAVA = 5;
    private final int MAX_OITAVA = 9;
    private Bpm bpm;

    public SequenciaMusical(String textoInput) {
        this.textoInput = textoInput;
        this.bpm = new Bpm();
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

    public boolean sequenciaBpmMais(int i) {
        return textoInput.charAt(i) == 'B' && textoInput.charAt(i+1) == 'P' && textoInput.charAt(i+2) == 'M' && textoInput.charAt(i+3) == '+';
    }

    public String decodificaSequencia(){

        String instrumentoAtual = inicializaInstrumento();
        StringBuilder sequenciaMusical = new StringBuilder(instrumentoAtual);
        sequenciaMusical.append(inicializaSequencia());
        String ultimaNota = inicializaNota();
        String ultimaOitava = inicializaOitava();

        for(int i = 0; i < textoInput.length(); i++){
            char c = textoInput.charAt(i);

            switch (c) {
                // Nota Lá
                case 'A', 'a':
                    ultimaNota = (NotasMusicais.LA + ultimaOitava);
                    sequenciaMusical.append(ultimaNota);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                case 'B', 'b':
                    if (i + 3 < textoInput.length() && sequenciaBpmMais(i)) {
                        // Aumenta BPM em 80
                        bpm.aumentaBatidasPorMinuto(80);
                        sequenciaMusical.append(bpm.obterBatidasPorMinuto());
                        sequenciaMusical.append(Sons.TROCASOM);
                    } else {
                        // Nota Si
                        ultimaNota = (NotasMusicais.SI + ultimaOitava);
                        sequenciaMusical.append(ultimaNota);
                        sequenciaMusical.append(Sons.TROCASOM);
                    }
                    break;
                // Nota Dó
                case 'C', 'c':
                    ultimaNota = (NotasMusicais.DO + ultimaOitava);
                    sequenciaMusical.append(ultimaNota);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Nota Ré
                case 'D', 'd':
                    ultimaNota = (NotasMusicais.RE + ultimaOitava);
                    sequenciaMusical.append(ultimaNota);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Nota Mi
                case 'E', 'e':
                    ultimaNota = (NotasMusicais.MI + ultimaOitava);
                    sequenciaMusical.append(ultimaNota);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Nota Fá
                case 'F', 'f':
                    ultimaNota = (NotasMusicais.FA + ultimaOitava);
                    sequenciaMusical.append(ultimaNota);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Nota Sol
                case 'G', 'g':
                    ultimaNota = (NotasMusicais.SOL + ultimaOitava);
                    sequenciaMusical.append(ultimaNota);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Silencio ou pausa
                case ' ':
                    sequenciaMusical.append(Sons.MEIAPAUSA);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Aumenta volume
                case '+':
                    break;
                // Volta volume default
                case '-':
                    break;
                // Troca instrumento
                case 'O', 'o', 'I', 'i', 'U', 'u':
                    if(i > 0 && NotasMusicais.contem(textoInput.charAt(i - 1))) {
                        sequenciaMusical.append(ultimaNota);
                    } else {
                        // Telefone tocando
                    }

                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Atualiza oitava
                case 'R':
                    if (textoInput.charAt(i + 1) == '+') {
                        i++;

                        if (Integer.parseInt(ultimaOitava) >= MAX_OITAVA) {
                            ultimaOitava = Integer.toString(DEFAULT_OITAVA);
                        } else {
                            ultimaOitava = Integer.toString(Integer.parseInt(ultimaOitava) + 1);
                        }

                    } else if (textoInput.charAt(i + 1) == '-') {
                        i++;

                        if (Integer.parseInt(ultimaOitava) <= 0) {
                            ultimaOitava = Integer.toString(DEFAULT_OITAVA);
                        } else {
                            ultimaOitava = Integer.toString(Integer.parseInt(ultimaOitava) - 1);
                        }
                    }
                    break;
                // Toca nota aleatória
                case '?':
                    NotasMusicais nota = NotasMusicais.obterNotaAleatoria();
                    sequenciaMusical.append(nota);
                    sequenciaMusical.append(ultimaOitava);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Troca instrumento
                case '\n':
                    instrumentoAtual = atualizaInstrumento(instrumentoAtual, c);
                    sequenciaMusical.append(instrumentoAtual);
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // BPM com valor aleatório
                case ';':
                    bpm.trocaAleatoria();
                    sequenciaMusical.append(bpm.obterBatidasPorMinuto());
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                default:
                    break;

            }
        }
        return sequenciaMusical.toString();
    }
}
