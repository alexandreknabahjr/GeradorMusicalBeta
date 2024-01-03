package musica;

public class SequenciaMusical{

    private final String textoInput;
    private final int DEFAULT_OITAVA = 5;
    private final int MAX_OITAVA = 9;
    private Instrumento instrumento;
    private Bpm bpm;
    private Volume volume;

    public SequenciaMusical(String textoInput) {
        this.textoInput = textoInput;
        this.bpm = new Bpm();
        this.instrumento = new Instrumento(InstrumentosMusicais.PIANO.toString());
        this.volume = new Volume();
    }

    private String inicializaSequencia(){
        return Sons.TROCASOM.toString();
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

        StringBuilder sequenciaMusical = new StringBuilder(instrumento.obterNome());
        sequenciaMusical.append(inicializaSequencia());
        sequenciaMusical.append(volume.obterValor());
        sequenciaMusical.append(Sons.TROCASOM);
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
                    volume.dobraValor();
                    sequenciaMusical.append(volume.obterValor());
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Volta volume default
                case '-':
                    volume.resetaValor();
                    sequenciaMusical.append(volume.obterValor());
                    sequenciaMusical.append(Sons.TROCASOM);
                    break;
                // Troca instrumento
                case 'O', 'o', 'I', 'i', 'U', 'u':
                    if(i > 0 && NotasMusicais.contem(textoInput.charAt(i - 1))) {
                        sequenciaMusical.append(ultimaNota);
                    } else {
                        sequenciaMusical.append(InstrumentosMusicais.TELEPHONE_RING);
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
                    instrumento.trocaAleatoria();
                    sequenciaMusical.append(instrumento.obterNome());
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
