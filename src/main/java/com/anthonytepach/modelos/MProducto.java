/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.modelos;

import com.anthonytepach.configuracion.LoggerRegistros;
import com.anthonytepach.database.ConexionMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anthony Tepach
 */
public class MProducto {
    LoggerRegistros loggger = new LoggerRegistros(this.getClass());
    private String sql;
    private PreparedStatement ps;
    private ResultSet values = null;
    
    public ResultSet querryProducts() throws Exception {
        sql = "SELECT pt_codigo,pt_nombre FROM tb_producto_terminado";

        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            values = ps.executeQuery();
        } catch (SQLException ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        }
        return values;
    }
}
