package sda.ciphers;

public class AtBashCipher {

    private String base;
    private String encoded;
    private String decoded;

    public AtBashCipher(String base) {
        this.base = base;
        encoded = "";
        decoded = "";
    }


    public AtBashCipher() {
        base = "";
        encoded = "";
        decoded = "";
    }

    public String getEncoded() {
        return encoded;
    }

    public String getDecoded() {
        return decoded;
    }

    public String getBase() {
        return base;
    }

    public void encode() {

        StringBuilder tempEncode = new StringBuilder();
        int ascii;
        int temp;
        for (int i = 0; i < base.length(); i++) {
            char letter = base.charAt(i);

            if(Character.isWhitespace(letter)) tempEncode.append(letter);
            if (!Character.isLetter(letter)) continue;
            final boolean isLower = Character.isLowerCase(letter);
            if (!isLower) {
                letter = Character.toLowerCase(letter);
            }
            ascii = letter;
            temp = ascii - 97;
            ascii = 122 - temp;
            letter = (char) ascii;
            if (!isLower) {
                letter = Character.toUpperCase(letter);
            }
            tempEncode.append(letter);
        }
        encoded = tempEncode.toString();

    }

    public void decode(){
        encode();
        decoded = encoded;

    }


}
