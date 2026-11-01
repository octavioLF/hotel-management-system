package com.olf.model;

import java.sql.Timestamp;

/**
 *
 * @author OctavioLF
 */
public class ConsumoServicio {

    private int idConsumo;
    private int idReserva;
    private String tipoServicio;
    private String descripcion;
    private int cantidad;
    private Double precioUnitario;
    private Timestamp fechaConsumo;

    public ConsumoServicio() {
    }

    public ConsumoServicio(int idConsumo, int idReserva, String tipoServicio, String descripcion, int cantidad, Double precioUnitario, Timestamp fechaConsumo) {
        this.idConsumo = idConsumo;
        this.idReserva = idReserva;
        this.tipoServicio = tipoServicio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaConsumo = fechaConsumo;
    }

    public int getIdConsumo() {
        return idConsumo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public Timestamp getFechaConsumo() {
        return fechaConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setFechaConsumo(Timestamp fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }
}
