package sda.ciphers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Szyfr Cezara - testy")
class CesarCipherTest {

    @DisplayName("When no arg constructor then empty decoded, encoded and base")
    @Test
    public void emptyArgConstructorReturnEmptyString() {
        final CesarCipher cipher = new CesarCipher();
        assertEquals("", cipher.getBase());
        assertEquals("", cipher.getEncoded());
        assertEquals("", cipher.getDecoded());
    }

    @DisplayName("Check encode function")
    @ParameterizedTest(name = "Test case {index} : input {0} gives result {1}")
    @CsvSource(value = {"abc,def","xyz,abc", "xYz,aBc", "x Y z,aBc", "x Y!@$!$! z, aBc"})
    public void getEncodeStringWhenGivenParamInput(
            String entry, String result
    ){
        final CesarCipher cipher = new CesarCipher(entry);
        cipher.encode();
        String encode = cipher.getEncoded();
        assertEquals(result, encode);
    }

    @DisplayName("Check decode function")
    @ParameterizedTest(name = "Test case {index} : input {0} gives result {1}")
    @CsvSource(value = {"def,abc","abc,xyz", "aBc,xYz"})
    public void getDecodeStringWhenGivenParamInput(
            String entry, String result
    ){
        final CesarCipher cipher = new CesarCipher(entry);
        cipher.decode();
        String decoded = cipher.getDecoded();
        assertEquals(result, decoded);
    }




}