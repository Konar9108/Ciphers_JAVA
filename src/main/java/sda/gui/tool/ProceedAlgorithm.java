package sda.gui.tool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProceedAlgorithm implements ActionListener {
    private JTextField input;
    private JTextField output;
    private JComboBox cipher;
    private JRadioButton encode;
    private JTextArea log;

    public ProceedAlgorithm(JTextField input, JTextField output, JComboBox ciphers,
                            JRadioButton encode, JTextArea log) {
        this.encode = encode;
        this.log = log;

        this.input = input;
        this.output = output;

        this.cipher = ciphers;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File inFile = Path.of(input.getText()).toFile();
        File outFile = Path.of(output.getText()).toFile();
        log.append("Algorithm: " + cipher.getSelectedItem() + ((encode.isSelected()) ? " encode\n" : " decode\n"));
        log.append("In: " + inFile.getName() + " out: " + outFile.getName() + "\n");

        //nalezy pobrac algorytm szyfrowania

        //otwiera i zamyka
        try (
                final BufferedReader fileReader = new BufferedReader(new FileReader(inFile)); //czytanie plikow
                final BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outFile)) // zapisywanie plikow
        ){
            fileWriter.write("");
            String line;
            while ((line = fileReader.readLine()) != null) {
                log.append("Input " + line + "\n");
                fileWriter.append(line).append("\n");
            }
        } catch (IOException ex) {
            log.append(ex + "ERROR\n");
        }
    }
}
