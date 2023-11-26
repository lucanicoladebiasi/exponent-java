package com.github.lucanicoladebiasi.exponent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecryptMessageTest {

    @Test
    void decrypt_crime() {
        String word = "dnotq";
        String  expected = "crime";
        String actual = DecryptMessage.decrypt(word);
        assertEquals(expected, actual);
    }

    @Test
    void deencrypt_encyclopedia() {
        String word = "flgxswdliefy";
        String expected = "encyclopedia";
        String actual = DecryptMessage.decrypt(word);
        assertEquals(expected, actual);
    }

    @Test
    void encrypt_crime() {
        String  word = "crime";
        String expected = "dnotq";
        String actual = DecryptMessage.encrypt(word);
        assertEquals(expected, actual);
    }

    @Test
    void encrypt_encyclopedia() {
        String  word = "encyclopedia";
        String expected = "flgxswdliefy";
        String actual = DecryptMessage.encrypt(word);
        assertEquals(expected, actual);
    }
}