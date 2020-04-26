package sda.ciphers;

import javax.crypto.Cipher;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum CiphersList {
    CESAR("Cesar"),
    ROT13("ROT-13"),
    ATBASH("AtBash"),
    MATRIX("Matrix"),
    VIGENERE("Vigenere"),
    SHA256("SHA256");

    CiphersList(String cipherName) {
        this.cipherName = cipherName;
    }

    private String cipherName;

    // strumien z enumów, wyciagniecie samych nazw tych obiektów i zapisanie ich do tablicy string[]
    public static String[] getCiphersList() {
        String[] list = Arrays.stream(CiphersList.values())
                .map(c -> c.cipherName)
                .sorted()
                .toArray(String[]::new);

        return list;
    }

    public static CiphersList getCipher(String cipher){
       cipher = cipher.replaceAll("[^a-zA-Z0-9_]*", "").toUpperCase();
        return CiphersList.valueOf(cipher);
    }

}
