package sda.ciphers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Cipher ROT-13 under test")
class Rot13CipherTest {


    @DisplayName("When no arg constructor then empty encode string and empty decode string")
    @Test
    public void emptyArgConstructorReturnEmptyString() {
        //given
        final Rot13Cipher cipher = new Rot13Cipher();
        //when
        //then
        assertEquals("", cipher.getBase());
        assertEquals("", cipher.getEncode());
        assertEquals("", cipher.getDecode());
    }

    @DisplayName("Check encode function")
    @ParameterizedTest(name = "Test case {index} : input {0} gives result {1}")
    @CsvSource({"abc,nop", "xyz,klm", "xYz,kLm", "x Y z,kLm","'',''"})
    public void getEncodeStringWhenGivenParamInput(
            String entry, String result
    ) {
        //given
        final Rot13Cipher cipher = new Rot13Cipher(entry);
        //when
        cipher.encode();
        String encode = cipher.getEncode();
        //then
        assertEquals(result, encode);

    }

}