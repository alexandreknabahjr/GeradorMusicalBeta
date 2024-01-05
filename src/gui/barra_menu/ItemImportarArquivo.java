package gui.barra_menu;

import gui.CaixaTexto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class ItemImportarArquivo extends JMenuItem implements ActionListener {

    private CaixaTexto inputMusica;

    public ItemImportarArquivo(CaixaTexto inputMusica){
        super("Importar arquivo");
        this.inputMusica = inputMusica;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileReader fileReader = new FileReader(fc.getSelectedFile());
                BufferedReader br = new BufferedReader(fileReader);

                StringBuilder conteudo = new StringBuilder();
                String linha;
                while ((linha = br.readLine()) != null) {
                    conteudo.append(linha).append("\n");
                }

                this.inputMusica.setText(conteudo.toString());

                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro na abertura do arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
