package sda.ciphers;

public class Rot13Cipher extends CesarCipher{

    public Rot13Cipher(String toEncode) {
        super(toEncode);
    }

    public Rot13Cipher() {
        super();
    }

    @Override
    int getEncodedPosition(int position) {
        return (position + 13) % 26;
    }

    @Override
    int getDecodedPosition(int position) {
        return (position + 13) % 26;
    }
}
