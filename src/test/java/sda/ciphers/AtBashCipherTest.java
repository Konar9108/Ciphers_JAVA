package sda.ciphers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("szyfr AtBash - testy")
class AtBashCipherTest {


    @DisplayName("check if non arg constructor has empty bot not null fields")
    @Test
    public void emptyConstructorChecker(){
        AtBashCipher atBashCipher = new AtBashCipher();
        assertEquals("",atBashCipher.getDecoded());
        assertEquals("",atBashCipher.getEncoded());
        assertEquals("",atBashCipher.getBase());

    }

    //

    @DisplayName("Check encode function")
    @ParameterizedTest(name = "Test case {index} : input {0} gives result {1}")
    @CsvSource(value = {"abc,zyx","xyz,cba", "xYz,cBa", "def,wvu", "Janusz kurcze ocb, Qzmfha pfixav lxy"})
    public void getEncodedStringWhenGivenParamInput(String entry, String result) {
        AtBashCipher atBashCipher = new AtBashCipher(entry);
        atBashCipher.encode();
        String encoded = atBashCipher.getEncoded();
        assertEquals(result,encoded);

    }
}