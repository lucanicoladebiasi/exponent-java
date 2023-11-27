package com.github.lucanicoladebiasi.exponent;

/**
 * The class implements a solution for the code challenge
 * <a href="https://www.tryexponent.com/courses/software-engineering/swe-practice/decrypt-message">Decrypt Message</a>.
 */
public class DecryptMessage {

    /**
     * The number of letters of the alphabet used in the code challenge.
     */
    static final int ALPHABET_RANGE = 26;

    /**
     * Return the `encrypted world decrypted using the algorithm described at
     * <a href="https://www.tryexponent.com/courses/software-engineering/swe-practice/decrypt-message">Decrypt Message</a>.
     *
     * @param encrypted word to decrypt. Nullable.
     * @return the `encrypted` word once decrypted, never `null`.
     *
     * @see #encrypt(String)
     */
    static String decrypt(final String encrypted) {
        final StringBuilder decrypted = new StringBuilder();
        int sum = 1;
        for (int i = 0; i < encrypted.length(); i++) {
            int c = encrypted.charAt(i) - sum;
            sum += c;
            while (c < (int) 'a') {
                c += ALPHABET_RANGE;
            }
            decrypted.append((char) c);
        }
        return decrypted.toString();
    }

    /**
     * Return the `decrypted` world encrypted using the algorithm described at
     * <a href="https://www.tryexponent.com/courses/software-engineering/swe-practice/decrypt-message">Decrypt Message</a>.
     *
     * @param decrypted word to encrypt. Nullable.
     * @return the `decrypted` word once encrypted, never `null`.
     */
    static String encrypt(final String decrypted) {
        final StringBuilder encrypted = new StringBuilder();
        if (decrypted != null) {
            int sum = 1;
            for (int i = 0; i < decrypted.length(); i++) {
                int c = decrypted.charAt(i) + sum;
                sum = c;
                while (c > (int) 'z') {
                    c -= ALPHABET_RANGE;
                }
                encrypted.append((char) c);
            }
        }
        return encrypted.toString();
    }

} //~ DecryptMessage
