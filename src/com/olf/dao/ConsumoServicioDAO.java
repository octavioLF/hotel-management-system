
package com.olf.dao;

import com.olf.model.ConsumoServicio;
import java.util.List;

/**
 *
 * @author OctavioLF
 */
public interface ConsumoServicioDAO extends Crud<ConsumoServicio, Integer> {
    List<ConsumoServicio> listarPorReserva(int idReserva);
}
