package com.github.lucanicoladebiasi.exponent;

public class ValidIPAddress {

    protected static boolean validateChunk(final String chunk) {
        for(int i = 0; i < chunk.length(); i ++) {
            final char c = chunk.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        if (chunk.length() >= 2 && chunk.charAt(0) == '0') {
            return false;
        }
        int value = Integer.parseInt(chunk);
        return 0 <= value && value <= 255;
    }

    public static boolean validateIP(final String ip) {
        return validateIP(ip.split("\\."));
    }

    protected static boolean validateIP(final String[] chunks) {
        if (chunks.length > 0 && chunks.length < 5) {
            return validateChunk(chunks[0])
                    && validateChunk(chunks[1])
                    && validateChunk(chunks[2])
                    && validateChunk(chunks[3]);
        }
        return false;
    }

}
