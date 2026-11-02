/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.olf.dao;

import com.olf.model.Reserva;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author octavioFL
 */
public interface ReservaDAO extends Crud<Reserva, Integer>{
    List<Reserva> buscarPorHuesped(int idHuesped);
    List<Reserva> buscarPorHabitacion(int idHabitacion);
    List<Reserva> buscarPorEstado(String estadoReserva);
    List<Reserva> buscarPorRangoFechas(Date fechaEntrada, Date fechaSalida);
}
