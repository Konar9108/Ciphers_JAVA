package sda.utils.mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.io.IOException;

public class MailService {
    private String mailTo;
    private String mailTitle;
    private String mailBody;
    private String information;

    private MailService(MailBuilder mail){
        this.mailTo = mail.mailTo;
        this.mailTitle = mail.mailTitle;
        this.mailBody = mail.mailBody;
    }

    public void send() {
        final SimpleEmail mailer = MailPrototype.getInstance();
        try {
            mailer.setSubject(mailTitle);
            mailer.addTo(mailTo);
            mailer.setMsg(mailBody);
            information = mailer.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    public String getInformation() {
        return information;
    }


   public static class MailBuilder{
        private String mailTo;
        private String mailTitle;
        private String mailFrom;
        private String mailBody;

        public MailBuilder(String mailTo, String mailTitle) {
            this.mailTo = mailTo;
             this.mailTitle = mailTitle;
             this.mailFrom = "no_reply@example.com";
             this.mailBody = "";
        }

             public MailBuilder setFrom(String adress){
                 this.mailFrom = adress;
                 return this;
            }

            public MailBuilder addBody(String bodyMessage){
            this.mailBody = bodyMessage;
            return this;
        }

        public MailService build(){
            return new MailService(this);
        }

    }
}
