package gui;

import javax.sound.midi.Sequence;
import javax.swing.*;

import org.jfugue.player.ManagedPlayer;
import java.util.Timer;
import java.util.TimerTask;

public class barraDeProgresso{

    static final int MINIMO = 70;
    static final int MAXIMO = 500;
    static final int N_PIXELS = 430;
    static final int PIXELS_POR_MUDANCA = 2;

    ManagedPlayer player;
    JPanel progresso;
    int atual;
    double tempo;
    long milissegundosPorPixel;
    boolean pausado;
    boolean iniciado = false;

    public barraDeProgresso(ManagedPlayer player, JPanel progresso, Sequence sequencia){
        this.player = player;
        this.progresso = progresso;
        this.atual = MINIMO;
        this.tempo = sequencia.getMicrosecondLength();
        this.tempo = Math.floor(((tempo/1000)/N_PIXELS) * PIXELS_POR_MUDANCA);
        this.milissegundosPorPixel = (long) tempo;
        this.pausado = false;
    }

    public void iniciaBarra(){
        if(milissegundosPorPixel != 0 && iniciado == false){
            Timer timer = new Timer();
            TimerTask timertask = new TimerTask() {
                @Override
                public void run() {
                    if(pausado == true){

                    }
                    else{
                        if(atual < MAXIMO){
                            atual += PIXELS_POR_MUDANCA;
                            atualizaBarra(atual);
                        }
                        else{
                            retornaInicio();
                            timer.cancel();
                        }
                    }
                }
            };
            iniciado = true;

            timer.scheduleAtFixedRate(timertask, 0, milissegundosPorPixel);
        }
    }

    public void pausaBarra(){
        pausado = true;
    }

    public void retornaInicio(){
        iniciado = false;
        atual = MINIMO;
        atualizaBarra(atual);
    }

    public void atualizaBarra(int novoValor){
        progresso.setBounds(novoValor, 145, 25, 25);
    }
}
