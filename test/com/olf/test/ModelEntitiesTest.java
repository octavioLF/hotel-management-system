package com.olf.test;

import com.olf.model.ConsumoServicio;
import com.olf.model.FacturaHotel;
import com.olf.model.Habitacion;
import com.olf.model.Huesped;
import com.olf.model.Reserva;
import com.olf.model.TipoHabitacion;
import com.olf.model.Usuario;
import java.sql.Date;
import java.sql.Timestamp;

public class ModelEntitiesTest {

    public static void run() {
        System.out.println("  [TEST] Running ModelEntitiesTest...");

        // Huesped test
        Huesped guest = new Huesped(1, "DOC-100", "Carlos", "Pérez", "555-1234", "carlos@test.com", "Guatemalteco");
        SimpleAssert.assertEquals("Guest ID", 1, guest.getIdHuesped());
        SimpleAssert.assertEquals("Guest name", "Carlos", guest.getNombreHuesped());
        SimpleAssert.assertTrue("Guest toString contains name", guest.toString().contains("Carlos"));

        // Habitacion test
        Habitacion room = new Habitacion(10, "101", 1, "disponible", 2);
        SimpleAssert.assertEquals("Room number", "101", room.getNumeroHabitacion());
        SimpleAssert.assertEquals("Room floor", 1, room.getPiso());
        room.setEstadoHabitacion("ocupada");
        SimpleAssert.assertEquals("Updated room status", "ocupada", room.getEstadoHabitacion());

        // TipoHabitacion test
        TipoHabitacion type = new TipoHabitacion(2, "Suite Ejecutiva", "Vista panorámica", 2, 450.0);
        SimpleAssert.assertEquals("Room type name", "Suite Ejecutiva", type.getNombreTipo());
        SimpleAssert.assertEquals("Room type rate", 450.0, type.getTarifaNoche());

        // Reserva test
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Date checkIn = Date.valueOf("2026-11-20");
        Date checkOut = Date.valueOf("2026-11-25");
        Reserva res = new Reserva(5, 1, 10, now, checkIn, checkOut, 2, 450.0, 200.0, true, null, null, "confirmada");
        SimpleAssert.assertEquals("Reservation ID", 5, res.getIdReserva());
        SimpleAssert.assertTrue("Deposit paid check", res.isDepositoPagado());
        SimpleAssert.assertEquals("Reservation state", "confirmada", res.getEstadoReserva());

        // ConsumoServicio test
        ConsumoServicio consumption = new ConsumoServicio(3, 5, "minibar", "Agua mineral", 2, 15.0, now);
        SimpleAssert.assertEquals("Consumption quantity", 2, consumption.getCantidad());
        SimpleAssert.assertEquals("Consumption price", 15.0, consumption.getPrecioUnitario());

        // FacturaHotel test
        FacturaHotel invoice = new FacturaHotel(1, 5, now, 5, 2250.0, 30.0, 200.0, 2080.0, "pendiente");
        SimpleAssert.assertEquals("Invoice total", 2080.0, invoice.getTotalFactura());
        SimpleAssert.assertEquals("Invoice status", "pendiente", invoice.getEstadoPago());
        invoice.setEstadoPago("pagada");
        SimpleAssert.assertEquals("Updated invoice status", "pagada", invoice.getEstadoPago());

        // Usuario test
        Usuario user = new Usuario("admin", "admin@hotel.com", "Admin", "User", "hash123", "administrador");
        user.setId(1);
        user.setActivo(true);
        user.setFechaCreacion(now);
        SimpleAssert.assertEquals("Username", "admin", user.getUsername());
        SimpleAssert.assertTrue("User is active", user.isActivo());
        SimpleAssert.assertEquals("User role", "administrador", user.getRol());

        System.out.println("    -> ModelEntitiesTest PASSED");
    }
}
