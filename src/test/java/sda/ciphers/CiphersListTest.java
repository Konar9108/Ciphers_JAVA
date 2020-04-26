package sda.ciphers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;



class CiphersListTest {


    @Test
    void getCipherTest() {
        //given
        String cipherRequest = "rot-13";
        CiphersList expectedCipher = CiphersList.ROT13;

        //when
        final CiphersList result = CiphersList.getCipher(cipherRequest);
        //then
        assertThat(result,is(equalTo(expectedCipher))); //hamcrest syntax


    }
}