/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.modelos;

import com.anthonytepach.beans.Proyecto;
import com.anthonytepach.configuracion.LoggerRegistros;
import com.anthonytepach.database.ConexionMySql;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Anthony Tepach
 */
public class MProyecto {

     
    LoggerRegistros loggger = new LoggerRegistros(this.getClass());
    private String sql;
    private PreparedStatement ps;
    private ResultSet values = null;
     SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public ResultSet querryClavesByYear(String tipo) throws Exception {
        sql = "SELECT pry_clave FROM tb_proyecto WHERE YEAR(pry_alta) = YEAR(CURDATE()) AND pry_clave LIKE '___" + tipo + "%'";

        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            values = ps.executeQuery();

        } catch (SQLException ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        }
        return values;
    }

    public void insertProject(Proyecto proyecto,JRootPane rootPane) {
        
        sql = "INSERT INTO tb_proyecto VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps=ConexionMySql.getConnection().prepareStatement(sql);
            ps.setString(1, proyecto.getClave());
            ps.setString(2, proyecto.getLider());
            ps.setString(3, proyecto.getNombre());
            ps.setString(4, proyecto.getDescripcion());
            ps.setString(5, DATE_FORMAT.format(proyecto.getFecha_inicio()));
            ps.setString(6,  DATE_FORMAT.format(proyecto.getFecha_fin()));
            ps.setString(7, proyecto.getFecha_alta());
            ps.setString(8, proyecto.getTipo());
            ps.setString(9, proyecto.getCliente());
            ps.setString(10, proyecto.getEntrega_parcial());
            ps.setInt(11, proyecto.getCosto());
            ps.setInt(12, proyecto.getVol_total());
            int a = ps.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(rootPane, "Guardado");
               
            }
        } catch (SQLException ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
            JOptionPane.showMessageDialog(null, ex.fillInStackTrace(), ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    public ResultSet querryInfoProject() throws Exception {
        sql = "SELECT  cl_nom,pry_clave,pry_nombre,pry_fecha_inicio,pry_fecha_fin,pry_tipo"
                + " FROM  tb_proyecto NATURAL JOIN tb_cliente WHERE YEAR(pry_alta)=YEAR(NOW()) ORDER BY pry_clave";

        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            values = ps.executeQuery();
        } catch (SQLException ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        }
        return values;
    }
}
