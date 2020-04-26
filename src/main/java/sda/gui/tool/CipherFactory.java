package sda.gui.tool;

import sda.ciphers.*;

import javax.crypto.Cipher;

public class CipherFactory {

    static ICipher getAlgorithm(String cipher) {
        CiphersList algorithm = CiphersList.getCipher(cipher);

        switch (algorithm) {

            case CESAR: return new CesarCipher();
            case ROT13:  return new Rot13Cipher();
            case ATBASH:  return new AtBashCipher();
            case MATRIX:  return new MatrixCipher();
            case SHA256:
            case VIGENERE:
            default: return new NoneCipher();
        }

    }
}
