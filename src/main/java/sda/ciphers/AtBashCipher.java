package sda.ciphers;

public class AtBashCipher implements ICipher {

    private String base;
    private String encoded;
    private String decoded;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public AtBashCipher(String base) {
        this.base = base;
    }

    @Override
    public void decode() {

    }

    @Override
    public void encode() {

    }

    public String getEncoded() {
        return encoded;
    }

    public String getDecoded() {
        return decoded;
    }

    @Override
    public String getBase() {
        return null;
    }
}
