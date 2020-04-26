package sda.gui.tool;

import sda.ciphers.CesarCipher;
import sda.ciphers.ICipher;
import sda.ciphers.NoneCipher;
import sda.ciphers.Rot13Cipher;

public class CipherFactory {

    static ICipher getAlgorithm(String cipher) {
        switch (cipher.toUpperCase()) {

            case "CESAR" : return new CesarCipher();
            case "ROT-13" : return new Rot13Cipher();
            default: return new NoneCipher();
        }

    }
}
