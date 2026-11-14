package com.olf.test;

import com.olf.util.PasswordHasher;

public class PasswordHasherTest {

    public static void run() {
        System.out.println("  [TEST] Running PasswordHasherTest...");

        // Test 1: Hash generation is not null and has proper format: PREFIX$ITERATIONS$SALT$HASH
        String password = "AdminPassword2026!";
        String hash = PasswordHasher.hash(password.toCharArray());
        SimpleAssert.assertNotNull("Hash should not be null", hash);
        SimpleAssert.assertTrue("Hash starts with PBKDF2-SHA256", hash.startsWith("PBKDF2-SHA256$"));
        String[] parts = hash.split("\\$");
        SimpleAssert.assertEquals("Hash has 4 parts separated by dollar sign", 4, parts.length);

        // Test 2: Correct password verification succeeds
        boolean verified = PasswordHasher.verify(password.toCharArray(), hash);
        SimpleAssert.assertTrue("Correct password must verify successfully", verified);

        // Test 3: Incorrect password verification fails
        boolean wrongVerified = PasswordHasher.verify("WrongPassword123".toCharArray(), hash);
        SimpleAssert.assertFalse("Wrong password must fail verification", wrongVerified);

        // Test 4: Two hashes for the same password produce different salts
        String hash2 = PasswordHasher.hash(password.toCharArray());
        SimpleAssert.assertFalse("Salted hashes for same password should differ", hash.equals(hash2));
        SimpleAssert.assertTrue("Second hash must also verify", PasswordHasher.verify(password.toCharArray(), hash2));

        // Test 5: Null / invalid hash handling
        SimpleAssert.assertFalse("Null password verification returns false", PasswordHasher.verify(null, hash));
        SimpleAssert.assertFalse("Null hash verification returns false", PasswordHasher.verify(password.toCharArray(), null));
        SimpleAssert.assertFalse("Malformed hash returns false", PasswordHasher.verify(password.toCharArray(), "invalid_hash"));

        System.out.println("    -> PasswordHasherTest PASSED");
    }
}
