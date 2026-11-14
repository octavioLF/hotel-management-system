package com.olf.test;

import com.olf.security.RolePermissions;
import com.olf.security.RolePermissions.Module;
import java.util.Set;

public class RolePermissionsTest {

    public static void run() {
        System.out.println("  [TEST] Running RolePermissionsTest...");

        // Test 1: Administrator / Gerente has access to all modules
        Set<Module> adminModules = RolePermissions.forRole("ADMINISTRADOR");
        SimpleAssert.assertEquals("Admin must have access to all modules", Module.values().length, adminModules.size());
        SimpleAssert.assertTrue("Admin can access USUARIOS", RolePermissions.allows("admin", Module.USUARIOS));
        SimpleAssert.assertTrue("Gerente can access CHECKOUT", RolePermissions.allows("GERENTE", Module.CHECKOUT));

        // Test 2: Recepcionista has access to operational modules but NOT to USUARIOS
        Set<Module> recepModules = RolePermissions.forRole("recepcionista");
        SimpleAssert.assertTrue("Recepcionista can access RESERVAS", recepModules.contains(Module.RESERVAS));
        SimpleAssert.assertTrue("Recepcionista can access CHECKIN", recepModules.contains(Module.CHECKIN));
        SimpleAssert.assertFalse("Recepcionista must NOT access USUARIOS", recepModules.contains(Module.USUARIOS));

        // Test 3: Housekeeping can ONLY access DASHBOARD and HABITACIONES
        Set<Module> hkModules = RolePermissions.forRole("HOUSEKEEPING");
        SimpleAssert.assertEquals("Housekeeping has exactly 2 modules", 2, hkModules.size());
        SimpleAssert.assertTrue("Housekeeping accesses DASHBOARD", hkModules.contains(Module.DASHBOARD));
        SimpleAssert.assertTrue("Housekeeping accesses HABITACIONES", hkModules.contains(Module.HABITACIONES));
        SimpleAssert.assertFalse("Housekeeping cannot access FACTURAS", hkModules.contains(Module.FACTURAS));

        // Test 4: Unknown role has empty permissions
        Set<Module> unknownModules = RolePermissions.forRole("ROL_INEXISTENTE");
        SimpleAssert.assertTrue("Unknown role should have no permissions", unknownModules.isEmpty());

        // Test 5: Role normalization (handles accents and lowercase)
        SimpleAssert.assertTrue("Accent normalization works for Recepción", RolePermissions.allows("Recepción", Module.HABITACIONES));

        System.out.println("    -> RolePermissionsTest PASSED");
    }
}
