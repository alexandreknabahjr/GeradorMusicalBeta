package gui;

import org.jfugue.midi.MidiFileManager;

import javax.sound.midi.Sequence;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BotaoSalvamento extends JButton implements ActionListener {

    private Sequence musica;

    public BotaoSalvamento(Sequence musica) {
        super();
        this.musica = musica;
        configBotao();
        addActionListener(this);
    }

    private void configBotao() {
        ImageIcon icone = new ImageIcon("img/save-button.png");
        Image imagem = icone.getImage();
        Image imagemEmEscala = imagem.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH);

        setIcon(new ImageIcon(imagemEmEscala));
        setBounds(400, 210, 100, 100);
        setLayout(null);
        setBorder(null);
        setBorderPainted(false);
        setBackground(Color.white);
        setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Escolha o diretoria para salvar o arquivo MIDI gerado.");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File diretorio = fc.getSelectedFile();

            try {
                File output = new File(diretorio, "output.mid");
                MidiFileManager.save(musica, output);
                JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso.", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro no salvamento do arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
