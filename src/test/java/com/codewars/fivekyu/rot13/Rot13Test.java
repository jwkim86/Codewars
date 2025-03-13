package com.codewars.fivekyu.rot13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rot13Test {
    @Test
    void testRot13() {
        // assertEquals("expected", "actual");
        assertEquals("grfg", Rot13.rot13("test"), "Input: \"test\"");
        assertEquals("Grfg", Rot13.rot13("Test"), "Input: \"Test\"");
        assertEquals("nopqrstuvwxyzabcdefghijklm", Rot13.rot13("abcdefghijklmnopqrstuvwxyz"));
        assertEquals("NOPQRSTUVWXYZABCDEFGHIJKLM", Rot13.rot13("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("!@#$%^&*()", Rot13.rot13("!@#$%^&*()"));
        assertEquals("MD':Y^(dse~wD", Rot13.rot13("ZQ':L^(qfr~jQ"));
    }

    @Test
    void testRot13_2() {
        // assertEquals("expected", "actual");
        assertEquals("grfg", Rot13.rot13_2("test"), "Input: \"test\"");
        assertEquals("Grfg", Rot13.rot13_2("Test"), "Input: \"Test\"");
        assertEquals("nopqrstuvwxyzabcdefghijklm", Rot13.rot13_2("abcdefghijklmnopqrstuvwxyz"));
        assertEquals("NOPQRSTUVWXYZABCDEFGHIJKLM", Rot13.rot13_2("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("!@#$%^&*()", Rot13.rot13_2("!@#$%^&*()"));
        assertEquals("MD':Y^(dse~wD", Rot13.rot13_2("ZQ':L^(qfr~jQ"));
    }
}