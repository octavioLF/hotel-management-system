package com.olf.test;

public final class SimpleAssert {

    private SimpleAssert() {
    }

    public static void assertTrue(String message, boolean condition) {
        if (!condition) {
            throw new AssertionError("Assertion Failed: " + message + " (expected true, got false)");
        }
    }

    public static void assertFalse(String message, boolean condition) {
        if (condition) {
            throw new AssertionError("Assertion Failed: " + message + " (expected false, got true)");
        }
    }

    public static void assertEquals(String message, Object expected, Object actual) {
        if (expected == null && actual == null) {
            return;
        }
        if (expected != null && expected.equals(actual)) {
            return;
        }
        throw new AssertionError("Assertion Failed: " + message + " (expected [" + expected + "], but got [" + actual + "])");
    }

    public static void assertNotNull(String message, Object object) {
        if (object == null) {
            throw new AssertionError("Assertion Failed: " + message + " (expected not null, got null)");
        }
    }

    public static void assertNull(String message, Object object) {
        if (object != null) {
            throw new AssertionError("Assertion Failed: " + message + " (expected null, got [" + object + "])");
        }
    }
}
