/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.olf.dao;
import java.util.List;
import com.olf.model.Usuario;
/**
 *
 * @author OctavioLF
 */

public interface UsuarioDAO extends Crud<Usuario, Integer> {
    /** Verifica las credenciales con PBKDF2. El segundo parámetro es la contraseña en texto plano. */
    Usuario iniciarSesion(String username, String passwordClear);

    Usuario buscarPorUsername(String username);
    Usuario buscarPorEmail(String email);
    boolean cambiarPassword(int idUsuario, String passwordHash);
    boolean desactivarUsuario(int idUsuario);
    List<Usuario> listarActivos();
}