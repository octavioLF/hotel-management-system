/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.olf.controller;

import com.olf.dao.UsuarioDAO;
import com.olf.dao.impl.UsuarioDAOImpl;
import com.olf.model.Usuario;
import com.olf.security.RolePermissions;
import com.olf.security.SesionContext;
import com.olf.system.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 *
 * @author OctavioLF
 */
public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;
    @FXML
    private Button bootstrapButton;
    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messageLabel.setText("");
        try {
            boolean noUsers = usuarioDAO.listarTodos().isEmpty();
            bootstrapButton.setVisible(noUsers);
            bootstrapButton.setManaged(noUsers);
        } catch (RuntimeException e) {
            messageLabel.setText("No se pudo conectar con la base de datos revisa lo siguiente: " + e);
        }
    }

    @FXML
    private void Login() {
        String username = usernameField.getText() == null ? "" : usernameField.getText().trim();
        char[] password = passwordField.getText() == null ? new char[0] : passwordField.getText().toCharArray();
        if (username.isEmpty() || password.length == 0) {
            messageLabel.setText("Escriba su usuario y contraseña. ");
            return;
        }
        try {
            Usuario user = usuarioDAO.iniciarSesion(username, new String(password));
            if (user == null) {
                messageLabel.setText("Usuario o contraseña incorrectos.");
                passwordField.clear();
                return;
            }
            if (RolePermissions.forRole(user.getRol()).isEmpty()) {
                messageLabel.setText("Su rol no tiene permisos configurados para acceder al sistema.");
                passwordField.clear();
                return;
            }

        } catch (RuntimeException e) {
            messageLabel.setText("No se pudo iniciar sesión. Revisa la conexion con la base de datos. ");
        } finally {
            java.util.Arrays.fill(password, '\0');
        }
    }

    @FXML
    private void bootstrapAdmin() {
        try {
            Main.show("BootstrapAdminView.fxml", 760, 820);
        } catch (IOException e) {
            messageLabel.setText("No se pudo abrir la configuración inicial.");
        }
    }
}
