/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.olf.dao;

import com.olf.model.Huesped;
import java.util.List;

/**
 *
 * @author OctavioFL
 */
public interface HuespedDAO extends Crud<Huesped, Integer> {
    Huesped buscarPorDocumento(String documentoIdentificacion);
    List<Huesped> buscarPorApellido(String apellidoHuesped);
}
