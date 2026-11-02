/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.olf.dao;

import com.olf.model.TipoHabitacion;

/**
 *
 * @author sheyl
 */
public interface TipoHabitacionDAO extends Crud<TipoHabitacion, Integer> {
    TipoHabitacion buscarPorNombre(String nombreTipo);
}
