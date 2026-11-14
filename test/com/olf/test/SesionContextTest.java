package com.olf.test;

import com.olf.model.Usuario;
import com.olf.security.SesionContext;

public class SesionContextTest {

    public static void run() {
        System.out.println("  [TEST] Running SesionContextTest...");

        SesionContext context = SesionContext.getInstancia();
        SimpleAssert.assertNotNull("Singleton instance should not be null", context);

        // Reset session state
        context.cerrarSesion();
        SimpleAssert.assertNull("User should be null after closing session", context.getUsuarioActual());
        SimpleAssert.assertNull("Role should be null after closing session", context.getRol());
        SimpleAssert.assertNull("Session timestamp should be null after closing session", context.getHoraInicioSesion());

        // Set user session
        Usuario user = new Usuario("jdoe", "jdoe@hotel.com", "John", "Doe", "hash123", "administrador");
        context.setUsuarioActual(user);

        SimpleAssert.assertEquals("Active user must match", user, context.getUsuarioActual());
        SimpleAssert.assertEquals("Active role must match", "administrador", context.getRol());
        SimpleAssert.assertNotNull("Login timestamp must be registered", context.getHoraInicioSesion());

        // Close session
        context.cerrarSesion();
        SimpleAssert.assertNull("User must be cleared on logout", context.getUsuarioActual());

        System.out.println("    -> SesionContextTest PASSED");
    }
}
