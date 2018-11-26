/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.controlador;


import com.anthonytepach.modelos.MProducto;
import java.sql.ResultSet;

/**
 *
 * @author Anthony Tepach
 */
public class C_Producto {

    public ResultSet getProducts() throws Exception {
        MProducto mcli = new MProducto();
        return mcli.querryProducts();
    }
}
