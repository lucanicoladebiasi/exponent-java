package com.github.lucanicoladebiasi.exponent;

/**
 * https://www.tryexponent.com/courses/software-engineering/swe-practice/decrypt-message
 */
public class DecryptMessage {

    static final int ALPHABET_RANGE = 26;

    static String decrypt(String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        int sum = 1;
        for(int i = 0; i < encrypted.length(); i ++) {
            int c = encrypted.charAt(i) - sum;
            sum += c;
            while (c < (int) 'a') {
                c += ALPHABET_RANGE;
            }
            decrypted.append((char) c);
        }
        return decrypted.toString();
    }

    static String encrypt(String decrypted) {
        StringBuilder encrypted = new StringBuilder();
       int sum = 1;
        for(int i = 0; i < decrypted.length(); i ++) {
            int c = decrypted.charAt(i) + sum;
            sum = c;
            while (c > (int) 'z') {
                c -= ALPHABET_RANGE;
            }
            encrypted.append((char) c);
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        String encrypted = DecryptMessage.encrypt("crime");
        System.out.println(encrypted);
        System.out.println(DecryptMessage.decrypt(encrypted));
    }
}
