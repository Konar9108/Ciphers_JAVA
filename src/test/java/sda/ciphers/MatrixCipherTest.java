package sda.ciphers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Matrix Cipher test list")
class MatrixCipherTest {

    public static final String INPUT = "abcabcab";
    public static final String OUTPUT = "aaabbbcc ";
    private MatrixCipher cipherNoArg;
    private MatrixCipher cipherArgs;

    @BeforeEach
    private void setUp() {
        cipherNoArg = new MatrixCipher();
        cipherArgs = new MatrixCipher(INPUT);
    }

    @Test
    @DisplayName("New instance is created")
    public void testInstanceWithInputString() {
        assertNotNull(cipherArgs);
        assertNotNull(cipherNoArg);
    }

    @DisplayName("When no arg constructor then empty encode string and empty decode string")
    @Test
    public void emptyArgConstructorReturnEmptyString() {
        assertEquals("", cipherNoArg.getBase());
        assertEquals("", cipherNoArg.getEncode());
        assertEquals("", cipherNoArg.getDecode());
    }

    @Test
    @DisplayName("Encoded sentence should return length nearest to first N x N")
    public void shallReturnNxNLength() {
        final String encode = cipherArgs.getEncode();
        assertEquals(9, encode.length());
    }

    @DisplayName("Should be encoded sentence")
    @Test
    public void shouldReturnEncodeSentence() {
        final String encode = cipherArgs.getEncode();
        assertEquals(OUTPUT, encode);
    }
}