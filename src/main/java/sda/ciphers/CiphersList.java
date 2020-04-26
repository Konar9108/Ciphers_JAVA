package sda.ciphers;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CiphersList {
    CESAR("Cesar"),
    ROT13("ROT-13"),
    ATBASH("AtBash"),
    MATRIX("Matrix"),
    VIGENERE("Vigenere");

    CiphersList(String cipherName) {
        this.cipherName = cipherName;
    }

    private String cipherName;

    // strumien z enumów
    public static String[] getCiphersList() {
        String[] list = new String[5];
        Arrays.stream(CiphersList.values())
                .map(c -> c.cipherName)
                .collect(Collectors.toList())
                .toArray(list);

        return list;
    }

}
