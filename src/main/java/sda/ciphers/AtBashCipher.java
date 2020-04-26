package sda.ciphers;

public class AtBashCipher implements ICipher {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String base;
    private String encoded;
    private String decoded;

    public AtBashCipher(String toEncode) {
        this();
        base = toEncode;
    }

    @Override
    public void setBase(String base) {
        this.base = base;
    }

    public AtBashCipher() {
        base = "";
        encoded = "";
        decoded = "";
    }

    public String getBase() {
        return base;
    }

    public void encode() {
        StringBuilder stringBuilder = new StringBuilder();
        final int size = base.length();
        int index = -1;
        while (++index < size) {
            final char letter = base.charAt(index);
            final boolean isLower = Character.isLowerCase(letter);
            final int position = alphabet.indexOf(letter);
            final char newLetter = alphabet.charAt(25 - position);
            stringBuilder.append(newLetter);
        }
        encoded = stringBuilder.toString();
        decoded = encoded;
    }

    public String getEncode() {
        return encoded;
    }

    public void decode() {
        encode();
    }

    public String getDecode() {
        return decoded;
    }
}
