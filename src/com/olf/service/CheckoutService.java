/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.olf.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.olf.dao.impl.FacturaHotelDAOImpl;
import com.olf.exception.AppException;
import com.olf.exception.DBException;
import com.olf.model.FacturaHotel;
import com.olf.util.Conexion;
/**
 *
 * @author OctavioLF
 */
public class CheckoutService {
    private static final String CHECKOUT = "{call sp_realizarcheckout(?)}";
    private final FacturaHotelDAOImpl facturaDAO = new FacturaHotelDAOImpl();

    public FacturaHotel realizarCheckout(int idReserva) {
        if (idReserva <= 0) throw new IllegalArgumentException("El ID de reserva debe ser positivo.");
        try (Connection connection = Conexion.getInstancia().conectar();
                CallableStatement statement = connection.prepareCall(CHECKOUT)) {
            statement.setInt(1, idReserva);
            statement.execute();
        } catch (SQLException e) {
            throw new DBException("No se pudo completar el checkout de la reserva " + idReserva, e);
        }
        FacturaHotel invoice = facturaDAO.obtenerPorIdReserva(idReserva);
        if (invoice == null) throw new AppException("El checkout terminó, pero no se pudo recuperar la factura.");
        return invoice;
    }
}

