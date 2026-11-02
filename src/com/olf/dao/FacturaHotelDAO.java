package com.olf.dao;

import com.olf.model.FacturaHotel;

/**
 *
 * @author OctavioLF
 */
public interface FacturaHotelDAO extends Crud<FacturaHotel, Integer> {
    FacturaHotel obtenerPorIdReserva(int idReserva);
}
