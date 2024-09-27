package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {

    HomeWork testClass = new HomeWork();

    @Test
    void findMaxSubstring() {

        assertEquals("abcd", testClass.findMaxSubstring("abcddcba"));
        assertEquals("dcbaX", testClass.findMaxSubstring("abcddcbaX"));
    }


    @Test
    void check() {
        assertTrue(testClass.check("The quick brown fox jumps over the lazy dog"));
        assertFalse(testClass.check("The quick brown"));
    }
}