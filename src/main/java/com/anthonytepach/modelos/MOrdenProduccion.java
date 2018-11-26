/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.modelos;

import com.anthonytepach.beans.OrdenProduccion;
import com.anthonytepach.configuracion.LoggerRegistros;
import com.anthonytepach.database.ConexionMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Anthony Tepach
 */
public class MOrdenProduccion {

    LoggerRegistros loggger = new LoggerRegistros(this.getClass());
    private String sql;
    private PreparedStatement ps;
    private ResultSet values = null;
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public void insertDB(OrdenProduccion op, JRootPane rootPane) throws Exception {
        sql = "INSERT INTO tb_orden_produccion VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            ps.setString(1, op.getNo_op());
            ps.setString(2, op.getTipo());
            ps.setString(3, op.getNom_forma());
            ps.setString(4, DATE_FORMAT.format(op.getFecha_ini()));
            ps.setString(5, DATE_FORMAT.format(op.getFecha_fin()));
            ps.setString(6, op.getStatus());
            ps.setString(7, op.getNo_cotizacion());
            ps.setString(8, op.getDesc());
            ps.setString(9, op.getProducto());
            ps.setString(10, op.getClave_proyecto());
            int a = ps.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(rootPane, "Guardado");

            }
        } catch (SQLException ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
            JOptionPane.showMessageDialog(null, ex.fillInStackTrace(), ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
    
    public ResultSet querryInfoOP(String clave) throws Exception {
        sql = "SELECT op_num, op_nom_forma, op_descripcion,op_status,op_cotizacion,pt_codigo,op_fecha_inicio,op_fecha_fin"
                + " FROM  tb_orden_produccion WHERE pry_clave= ? ORDER BY op_num";

        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            ps.setString(1, clave);
            values = ps.executeQuery();
        } catch (SQLException ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        }
        return values;
    }
    
}
