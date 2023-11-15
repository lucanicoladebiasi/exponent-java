package com.github.lucanicoladebiasi.exponent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidIPAddressTest {

    @Test
    void validateIP_12_34_5_6() {
        assertTrue(ValidIPAddress.validateIP("12.34.5.6"));
    }

    @Test
    void validateIP_0_23_25_0() {
        assertTrue(ValidIPAddress.validateIP("0.23.25.0"));
    }

    @Test
    void validateIP_155_255_255_255() {
        assertTrue(ValidIPAddress.validateIP("255.255.255.255"));
    }

    @Test
    void validateIP_12_34_5_oops() {
        assertFalse(ValidIPAddress.validateIP("12.34.56.oops"));
    }

    @Test
    void validateIP_1_2_3_4_5() {
        assertFalse(ValidIPAddress.validateIP("1.2.3.4.5"));
    }

    @Test
    void validateIP_123_235_153_425() {
        assertFalse(ValidIPAddress.validateIP("123.235.153.425"));
    }

    @Test
    void validateIP_192_168_0_1() {
        assertTrue(ValidIPAddress.validateIP("192.168.0.1"));
    }

    @Test
    void validateIP_0_0_0_0() {
        assertTrue(ValidIPAddress.validateIP("0.0.0.0"));
    }

    @Test
    void validateIP_123_24_59_99() {
        assertTrue(ValidIPAddress.validateIP("123.24.59.99"));
    }

    @Test
    void validateIP_192_168_123_456() {
        assertFalse(ValidIPAddress.validateIP("192.168.123.456"));
    }


}