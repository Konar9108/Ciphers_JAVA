package sda.utils.mail;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


class MailServiceTest {

    @Test
    void send() {
        //given
       final MailService service = new MailService
               .MailBuilder("konar9108@gmail.com","test mail")
               .setFrom("annarybak95@wp.pl")
               .addBody("test")
               .build();
        //when
        service.send();

        //then
        assertThat(service.getInformation(),is(notNullValue()));

    }
}