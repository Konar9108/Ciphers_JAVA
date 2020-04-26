package sda.ciphers;

public interface ICipher {
    void setBase(String base);

    void encode();

    void decode();

    String getEncode();

    String getDecode();

}
