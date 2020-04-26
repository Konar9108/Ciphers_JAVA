package sda.ciphers;

import java.util.Arrays;

public class MatrixCipher implements ICipher {
    public static final char BLANK = ' ';
    private char[][] matrix;
    private String sentenceEncoded;
    private String sentenceDecoded;



    @Override
    public void setBase(String base) {
        this.sentenceDecoded = base;
    }

    @Override
    public void encode() {
        createMatrix();
        eraseMatrix();
        writeDecodedSentenceToMatrix();
        readEncodedSentenceFromMatrix();
    }

    @Override
    public void decode() {
        encode();
    }


    public MatrixCipher(String secret) {
        sentenceDecoded = secret;
    }

    public MatrixCipher() {
        sentenceDecoded = "";
    }

    public String getBase() {
        return sentenceDecoded;
    }

    public String getEncode() {
        return sentenceEncoded;
    }

    private void readEncodedSentenceFromMatrix() {
        int size = matrix.length;
        StringBuilder encodedBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                encodedBuilder.append(matrix[k][i]);
            }
        }
        sentenceEncoded = encodedBuilder.toString();
    }

    private void createMatrix() {
        final int size = determinateMatrix();
        matrix = new char[size][size];
    }

    private void writeDecodedSentenceToMatrix() {
        int size = matrix.length;
        final int length = sentenceDecoded.length();
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                final int index = i * size + k;
                if (length > index) {
                    matrix[i][k] = sentenceDecoded.charAt(index);
                } else {
                    break;
                }
            }
        }
    }

    private void eraseMatrix() {
        for (char[] row : matrix) {
            Arrays.fill(row, BLANK);
        }
    }

    private int determinateMatrix() {
        int N_length = 0;
        int sentenceLength = sentenceDecoded.length();
        while (sentenceLength > N_length * N_length) {
            N_length++;
        }

        return N_length;
    }

    public String getDecode() {
        return sentenceDecoded;
    }
}
