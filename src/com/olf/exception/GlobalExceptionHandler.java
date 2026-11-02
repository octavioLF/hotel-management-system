/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.olf.exception;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author octavioLF
 */
public class GlobalExceptionHandler {
    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());
    
    public static void handleException(Exception e){
        if (e instanceof DBException){
            LOGGER.log(Level.SEVERE, "Error de base de datos revisar las siguientes credenciales: " + e.getMessage(), e);
        }else if(e instanceof AppException){
            LOGGER.log(Level.WARNING, "Error de aplicacion: " + e.getMessage(), e);
        }else {
            LOGGER.log(Level.SEVERE, "Error inesperado, intentelo de nuevo" + e.getMessage(), e);
        }
    }
}
