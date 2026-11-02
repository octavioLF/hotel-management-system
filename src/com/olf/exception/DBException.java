/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.olf.exception;

/**
 *
 * @author OctavioLF
 */
public class DBException extends RuntimeException {
    public DBException(String message){
        super(message);
    }
    public DBException(String message, Throwable cause){
        super(message, cause);
    }
}
