/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.olf.model;

import java.sql.Timestamp;
import java.sql.Date;

/**
 *
 * @author OctavioLF
 */

public class Reserva {

    private int idReserva;
    private int idHuesped;
    private int idHabitacion;
    private Timestamp fechaReserva;
    private Date fechaEntrada;
    private Date fechaSalida;
    private int cantidadHuespedes;
    private Double tarifaAplicada;
    private Double depositoPrevio;
    private boolean depositoPagado;
    private Timestamp fechaCheckin;
    private Timestamp fechaCheckout;
    private String estadoReserva;

    public Reserva() {
    }

    public Reserva(int idReserva, int idHuesped, int idHabitacion, Timestamp fechaReserva, Date fechaEntrada, Date fechaSalida, int cantidadHuespedes, Double tarifaAplicada, Double depositoPrevio, boolean depositoPagado, Timestamp fechaCheckin, Timestamp fechaCheckout, String estadoReserva) {
        this.idReserva = idReserva;
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.fechaReserva = fechaReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cantidadHuespedes = cantidadHuespedes;
        this.tarifaAplicada = tarifaAplicada;
        this.depositoPrevio = depositoPrevio;
        this.depositoPagado = depositoPagado;
        this.fechaCheckin = fechaCheckin;
        this.fechaCheckout = fechaCheckout;
        this.estadoReserva = estadoReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public Timestamp getFechaReserva() {
        return fechaReserva;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public int getCantidadHuespedes() {
        return cantidadHuespedes;
    }

    public Double getTarifaAplicada() {
        return tarifaAplicada;
    }

    public Double getDepositoPrevio() {
        return depositoPrevio;
    }

    public boolean isDepositoPagado() {
        return depositoPagado;
    }

    public Timestamp getFechaCheckin() {
        return fechaCheckin;
    }

    public Timestamp getFechaCheckout() {
        return fechaCheckout;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setFechaReserva(Timestamp fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setCantidadHuespedes(int cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }

    public void setTarifaAplicada(Double tarifaAplicada) {
        this.tarifaAplicada = tarifaAplicada;
    }

    public void setDepositoPrevio(Double depositoPrevio) {
        this.depositoPrevio = depositoPrevio;
    }

    public void setDepositoPagado(boolean depositoPagado) {
        this.depositoPagado = depositoPagado;
    }

    public void setFechaCheckin(Timestamp fechaCheckin) {
        this.fechaCheckin = fechaCheckin;
    }

    public void setFechaCheckout(Timestamp fechaCheckout) {
        this.fechaCheckout = fechaCheckout;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

}
