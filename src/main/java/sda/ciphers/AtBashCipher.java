package sda.ciphers;

public class AtBashCipher {

    private String base;
    private String encoded;
    private String decoded;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public AtBashCipher(String base) {
        this.base = base;
    }

    public String getEncoded() {
        return encoded;
    }

    public String getDecoded() {
        return decoded;
    }
}
