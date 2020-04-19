package sda.ciphers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Cipher Cesar under test")
class CesarCipherTest {

    @DisplayName("When no arg constructor then empty encode string and empty decode string")
    @Test
    public void emptyArgConstructorReturnEmptyString() {
        //given
        final CesarCipher cipher = new CesarCipher();
        //when
        //then
        assertEquals("", cipher.getBase());
        assertEquals("", cipher.getEncode());
        assertEquals("", cipher.getDecoded());
    }

    @DisplayName("Check encode function")
    @ParameterizedTest(name = "Test case {index} : input {0} gives result {1}")
    @CsvSource({"abc,def", "xyz,abc", "xYz,aBc", "x Y z,aBc","'',''"})
    public void getEncodeStringWhenGivenParamInput(
            String entry, String result
    ) {
        //given
        final CesarCipher cipher = new CesarCipher(entry);
        //when
        cipher.encode();
        String encode = cipher.getEncode();
        //then
        assertEquals(result, encode);

    }

    @DisplayName("Check decode function")
    @ParameterizedTest(name = "Test case {index} : input {0} gives result {1}")
    @CsvSource({"def,abc", "abc,xyz", "aBc,xYz"})
    public void getDecodeStringWhenGivenParamInput(
            String entry, String result
    ) {
        //given
        final CesarCipher cipher = new CesarCipher(entry);
        //when
        cipher.decode();
        String decoded = cipher.getDecoded();
        //then
        assertEquals(result, decoded);

    }
}