package gui;

import javax.swing.*;

public class barraDeProgresso extends JPanel{
    JProgressBar barraProgresso;

    static final int MINIMO = 0;
    static final int MAXIMO = 100;

    public void criaBarra(){
        barraProgresso = new JProgressBar();
        barraProgresso.setMinimum(MINIMO);
        barraProgresso.setMaximum(MAXIMO);
        add(barraProgresso);
    }

    public void atualizaBarra(int novoValor){
        barraProgresso.setValue(novoValor);
    }
}
