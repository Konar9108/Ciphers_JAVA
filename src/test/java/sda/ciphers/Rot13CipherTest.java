package sda.ciphers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Rot13CipherTest {

    @DisplayName("When no arg constructor then empty decoded, encoded and base")
    @Test
    public void emptyArgConstructorReturnEmptyString() {
        final Rot13Cipher cipher = new Rot13Cipher();
        assertEquals("", cipher.getBase());
        assertEquals("", cipher.getEncode());
        assertEquals("", cipher.getDecoded());
    }

    @DisplayName("Check encode function")
    @ParameterizedTest(name = "Test case {index} : input {0} gives result {1}")
    @CsvSource(value = {"abc,nop","xyz,klm", "xYz,kLm", "x Y z,kLm", "x Y!@$!$! z, kLm"})
    public void getEncodeStringWhenGivenParamInput(
            String entry, String result
    ){
        final Rot13Cipher cipher = new Rot13Cipher(entry);
        cipher.encode();
        String encode = cipher.getEncode();
        assertEquals(result, encode);
    }

    @DisplayName("Check decode function")
    @ParameterizedTest(name = "Test case {index} : input {0} gives result {1}")
    @CsvSource(value = {"nop,abc","klm,xyz", "nOp,aBc"})
    public void getDecodeStringWhenGivenParamInput(
            String entry,
            String result
    ){
        final Rot13Cipher cipher = new Rot13Cipher(entry);
        cipher.decode();
        String decoded = cipher.getDecoded();
        assertEquals(result, decoded);
    }




}