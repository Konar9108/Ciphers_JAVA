package sda.ciphers;

public interface ICipher {

    void decode();
    void encode();
    String getEncoded();
    String getDecoded();
    String getBase();


}
