package sda.gui;

import sda.ciphers.CiphersList;
import sda.gui.tool.InputManager;
import sda.gui.tool.ProceedAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame implements ActionListener {
    private JTextArea logArea;
    private JTextField inputField;
    private JTextField outputField;
    private JComboBox ciphersCombo;
    private JRadioButton encodeRadioBtn;
    private JButton runAlgorithmBtn;

    public void startGui() {
        JFrame mainFrame = new JFrame("Crypto app");
        mainFrame.setMinimumSize(new Dimension(400, 200));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setJMenuBar(addMenuBar());
        mainFrame.add(addMainPanel());
        setListeners();
        mainFrame.setVisible(true);
        mainFrame.pack();
    }

    private void setListeners() {
        runAlgorithmBtn.addActionListener(new ProceedAlgorithm(inputField, outputField,
                ciphersCombo, encodeRadioBtn, logArea));
    }

    private JMenuBar addMenuBar() {
        JMenu fileMenu = new JMenu("File");
        JMenu optMenu = new JMenu("Options");

        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        exit.addActionListener(this);
        fileMenu.add(exit);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(optMenu);

        return menuBar;
    }

    private Component addMainPanel() {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints constr = new GridBagConstraints();
        logArea = new JTextArea(8, 10);

        //TODO get this value from properties
        JLabel titleLabel = new JLabel("SDA Enigma Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.RED);

        constr.fill = GridBagConstraints.CENTER;
        constr.gridx = 0;
        constr.gridy = 0;
        panel.add(titleLabel, constr);

        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.gridy = 1;
        panel.add(addSubPanelWithControllers(), constr);

        runAlgorithmBtn = new JButton("Run algorithm");

        constr.gridy = 2;
        constr.insets = new Insets(5, 3, 1, 3);
        panel.add(runAlgorithmBtn, constr);


        logArea.setLineWrap(true);
        constr.gridy = 3;
        JScrollPane scroll = new JScrollPane(logArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel.add(scroll, constr);

        return panel;
    }

    private Component addSubPanelWithControllers() {
        JPanel subPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel sourceLabel = new JLabel("Source file:");
        JLabel destinationLabel = new JLabel("Destination:");
        JLabel chooseLabel = new JLabel("Choose cipher");

        inputField = new JTextField("input.txt", 10);
        outputField = new JTextField("output.txt", 10);

        JButton choseInput = new JButton("Select");
        choseInput.addActionListener(new InputManager(inputField, logArea));
        JButton choseOutput = new JButton("Select");
        choseOutput.addActionListener(new InputManager(outputField, logArea));

        ciphersCombo = new JComboBox(CiphersList.getCiphersList());

        encodeRadioBtn = new JRadioButton("Encode");
        encodeRadioBtn.setSelected(true);
        JRadioButton decodeRadioBtn = new JRadioButton("Decode");
        ButtonGroup group = new ButtonGroup();
        group.add(encodeRadioBtn);
        group.add(decodeRadioBtn);

        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridy = 0;
        constraints.gridx = 0;
        subPanel.add(sourceLabel, constraints);

        constraints.gridx = 1;
        subPanel.add(inputField, constraints);

        constraints.gridx = 2;
        subPanel.add(choseInput, constraints);

        constraints.gridx = 3;
        subPanel.add(chooseLabel, constraints);

        constraints.gridx = 4;
        subPanel.add(encodeRadioBtn, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        subPanel.add(destinationLabel, constraints);

        constraints.gridx = 1;
        subPanel.add(outputField, constraints);

        constraints.gridx = 2;
        subPanel.add(choseOutput, constraints);

        constraints.gridx = 3;
        subPanel.add(ciphersCombo, constraints);

        constraints.gridx = 4;
        subPanel.add(decodeRadioBtn, constraints);

        return subPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("exit".equalsIgnoreCase(e.getActionCommand())) {
            System.exit(0);
        }

    }
}
