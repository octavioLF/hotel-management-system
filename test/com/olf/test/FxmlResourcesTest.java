package com.olf.test;

import java.io.InputStream;

public class FxmlResourcesTest {

    public static void run() {
        System.out.println("  [TEST] Running FxmlResourcesTest...");

        String[] fxmlViews = {
            "/com/olf/view/LoginView.fxml",
            "/com/olf/view/BootstrapAdminView.fxml",
            "/com/olf/view/DashboardView.fxml",
            "/com/olf/view/CheckInView.fxml",
            "/com/olf/view/CheckoutView.fxml",
            "/com/olf/view/WorkspaceView.fxml"
        };

        for (String path : fxmlViews) {
            try (InputStream in = FxmlResourcesTest.class.getResourceAsStream(path)) {
                SimpleAssert.assertNotNull("FXML file must exist on classpath: " + path, in);
            } catch (Exception e) {
                throw new AssertionError("Failed to load FXML resource: " + path, e);
            }
        }

        String[] cssFiles = {
            "/com/olf/view/login.css",
            "/com/olf/view/dashboard.css",
            "/com/olf/view/checkin.css",
            "/com/olf/view/checkout.css",
            "/com/olf/view/workspace.css"
        };

        for (String path : cssFiles) {
            try (InputStream in = FxmlResourcesTest.class.getResourceAsStream(path)) {
                SimpleAssert.assertNotNull("CSS stylesheet must exist on classpath: " + path, in);
            } catch (Exception e) {
                throw new AssertionError("Failed to load CSS resource: " + path, e);
            }
        }

        // Verify that all controllers referenced by views exist as valid classes
        String[] controllers = {
            "com.olf.controller.LoginController",
            "com.olf.controller.BootstrapAdminController",
            "com.olf.controller.DashboardController",
            "com.olf.controller.CheckInController",
            "com.olf.controller.CheckoutController",
            "com.olf.controller.WorkspaceController"
        };

        for (String className : controllers) {
            try {
                Class<?> clazz = Class.forName(className);
                SimpleAssert.assertNotNull("Controller class must be found: " + className, clazz);
            } catch (ClassNotFoundException e) {
                throw new AssertionError("Controller class not found: " + className, e);
            }
        }

        System.out.println("    -> FxmlResourcesTest PASSED");
    }
}
