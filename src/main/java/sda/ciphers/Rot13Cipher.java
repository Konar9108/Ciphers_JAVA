package sda.ciphers;

public class Rot13Cipher implements ICipher {
    private String base;
    private String encoded;
    private String decoded;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public Rot13Cipher(String toEncode) {
        base = toEncode;
    }


    public Rot13Cipher() {
        base = "";
        encoded= "";
        decoded= "";
    }

    public String getBase() {
        return base;
    }

    public String getEncoded() {
        return encoded;
    }

    public void decode() {
        StringBuilder tempDecode = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            char letter = base.charAt(i);
            final boolean isLower = Character.isLowerCase(letter);
            if (!isLower){
                letter = Character.toLowerCase(letter);
            }
            final int position = alphabet.indexOf(letter);
            final char c = alphabet.charAt(getDecodedPosition(position));
            tempDecode.append(isLower ? c : Character.toUpperCase(c)); // pisanie if jako elvis, krocej
        }
        decoded = tempDecode.toString();

    }


    public void encode() {
        StringBuilder tempEncode = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            char letter = base.charAt(i);

            if(!Character.isLetter(letter)) continue;

            final boolean isLower = Character.isLowerCase(letter);
            if (!isLower){
                letter = Character.toLowerCase(letter);
            }
            final int position = alphabet.indexOf(letter);
            final char c = alphabet.charAt(getEncodedPosition(position));
            tempEncode.append(isLower ? c : Character.toUpperCase(c)); // pisanie if jako elvis, krocej
        }
        encoded = tempEncode.toString();
    }

    private int getEncodedPosition(int position) {
        return (position + 13) % 26;
    }

    private int getDecodedPosition(int position) {
                return (position +13) % 26;
    }

    public String getDecoded() {
        return decoded;
    }


}
