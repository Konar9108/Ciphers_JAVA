package sda.gui.tool;

import sda.utils.mail.MailService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailManager implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final String addr = JOptionPane.showInputDialog("Add address to: ", "example@gmail.com");
        final String msg = JOptionPane.showInputDialog("add body msg: ", "regards from crypto app");
        final MailService service = new MailService
                .MailBuilder(addr,"CryptoMail")
                .addBody(msg)
                .build();
        service.send();

    }
}
