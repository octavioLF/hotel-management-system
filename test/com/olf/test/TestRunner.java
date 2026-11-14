package com.olf.test;

public class TestRunner {

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("       GRANDSTAY HOTEL MANAGEMENT SYSTEM - TEST SUITE RUNNER         ");
        System.out.println("======================================================================");

        int totalSuites = 6;
        int passed = 0;
        int failed = 0;

        long startTime = System.currentTimeMillis();

        try {
            PasswordHasherTest.run();
            passed++;
        } catch (Throwable t) {
            System.err.println("    FAILED: " + t.getMessage());
            failed++;
        }

        try {
            RolePermissionsTest.run();
            passed++;
        } catch (Throwable t) {
            System.err.println("    FAILED: " + t.getMessage());
            failed++;
        }

        try {
            SesionContextTest.run();
            passed++;
        } catch (Throwable t) {
            System.err.println("    FAILED: " + t.getMessage());
            failed++;
        }

        try {
            ModelEntitiesTest.run();
            passed++;
        } catch (Throwable t) {
            System.err.println("    FAILED: " + t.getMessage());
            failed++;
        }

        try {
            FxmlResourcesTest.run();
            passed++;
        } catch (Throwable t) {
            System.err.println("    FAILED: " + t.getMessage());
            failed++;
        }

        try {
            DatabaseConnectivityTest.run();
            passed++;
        } catch (Throwable t) {
            System.err.println("    FAILED: " + t.getMessage());
            failed++;
        }

        long elapsed = System.currentTimeMillis() - startTime;

        System.out.println("======================================================================");
        System.out.println("TEST SUMMARY:");
        System.out.println("  Total suites : " + totalSuites);
        System.out.println("  Passed       : " + passed);
        System.out.println("  Failed       : " + failed);
        System.out.println("  Duration     : " + elapsed + " ms");
        System.out.println("======================================================================");

        if (failed > 0) {
            System.exit(1);
        }
    }
}
