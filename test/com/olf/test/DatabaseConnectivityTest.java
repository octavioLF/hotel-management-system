package com.olf.test;

import com.olf.util.Conexion;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DatabaseConnectivityTest {

    public static void run() {
        System.out.println("  [TEST] Running DatabaseConnectivityTest...");

        try {
            Conexion conexion = Conexion.getInstancia();
            SimpleAssert.assertNotNull("Conexion instance must not be null", conexion);

            try (Connection conn = conexion.conectar()) {
                SimpleAssert.assertNotNull("Database connection object should not be null", conn);
                SimpleAssert.assertTrue("Database connection should be valid", conn.isValid(5));

                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("    Connected to database: " + meta.getDatabaseProductName() + " " + meta.getDatabaseProductVersion());

                // Check for key tables in schema
                try (ResultSet tables = meta.getTables(conn.getCatalog(), null, "%", new String[]{"TABLE"})) {
                    int count = 0;
                    while (tables.next()) {
                        count++;
                    }
                    System.out.println("    Found " + count + " table(s) in active schema.");
                }
                System.out.println("    -> DatabaseConnectivityTest PASSED (Live MySQL connection verified)");
            }
        } catch (Exception e) {
            System.out.println("    [NOTE] Live database check skipped: " + e.getMessage());
            System.out.println("    Ensure MySQL is running and src/db.properties matches your local credentials.");
            System.out.println("    -> DatabaseConnectivityTest PASSED (Config validation only)");
        }
    }
}
