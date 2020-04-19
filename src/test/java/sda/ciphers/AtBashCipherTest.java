package sda.ciphers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtBashCipherTest {
    public static final String INPUT = "abcxyz";
    public static final String OUTPUT = "zyxcba";
    private AtBashCipher cipherNoArg;
    private AtBashCipher cipherArgs;

    @BeforeEach
    private void setUp() {
        cipherNoArg = new AtBashCipher();
        cipherArgs = new AtBashCipher(INPUT);
    }

    @DisplayName("When no arg constructor then empty encode string and empty decode string")
    @Test
    public void emptyArgConstructorReturnEmptyString() {
        assertEquals("", cipherNoArg.getBase());
        assertEquals("", cipherNoArg.getEncode());
        assertEquals("", cipherNoArg.getDecoded());
    }

    @DisplayName("Should be encoded sentence")
    @Test
    public void shouldReturnEncodeSentence() {
        cipherArgs.encode();
        final String encode = cipherArgs.getEncode();
        assertEquals(OUTPUT, encode);
    }

}