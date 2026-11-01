/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.olf.model;

/**
 *
 * @author OctavioLF
 * 
 */
public class Habitacion {

    private int idHabitacion;
    private String numeroHabitacion;
    private int piso;
    private String estadoHabitacion;
    private int idTipoHabitacion;

    public Habitacion() {
    }

    public Habitacion(int idHabitacion, String numeroHabitacion, int piso, String estadoHabitacion, int idTipoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.piso = piso;
        this.estadoHabitacion = estadoHabitacion;
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }
    
    
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }
    
        @Override
    public String toString() {
        return "Habitacion{" +
                "idHabitacion=" + idHabitacion +
                ", numeroHabitacion='" + numeroHabitacion + '\'' +
                ", piso=" + piso +
                ", estadoHabitacion='" + estadoHabitacion + '\'' +
                ", idTipoHabitacion=" + idTipoHabitacion +
                '}';
    }
}
