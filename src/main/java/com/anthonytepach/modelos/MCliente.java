/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.modelos;

import com.anthonytepach.beans.Cliente;
import com.anthonytepach.configuracion.LoggerRegistros;
import com.anthonytepach.database.ConexionMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Anthony Tepach
 */
public class MCliente {

     
    LoggerRegistros loggger = new LoggerRegistros(this.getClass());
    private String sql;
    private PreparedStatement ps;
    private ResultSet values = null;

    public void insertClient(Cliente cliente,JRootPane rootPane) throws Exception {
        sql = "INSERT INTO tb_cliente VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            ps.setString(1, cliente.getRfc());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDireccion().getCalle());
            ps.setString(4, cliente.getDireccion().getNum_calle());
            ps.setString(5, cliente.getDireccion().getColonia());
            ps.setInt(6, cliente.getDireccion().getCp());
            ps.setString(7, cliente.getDireccion().getMucipio());
            ps.setString(8, cliente.getDireccion().getEstado());
            ps.setString(9, cliente.getDireccion().getPais());
            ps.setString(10, cliente.getContacto().getNum_movil());
            ps.setString(11, cliente.getContacto().getEmail());
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

    public void updateClient(Cliente cliente,JRootPane rootPane) throws Exception {
        sql = "UPDATE tb_cliente SET cl_nom=?, cl_calle=?, cl_numc=?,cl_col=?,cl_cp=?,cl_mun=?,cl_estado=?,cl_pais=?,cl_numtel=?,cl_email=? WHERE cl_rfc=?";
        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion().getCalle());
            ps.setString(3, cliente.getDireccion().getNum_calle());
            ps.setString(4, cliente.getDireccion().getColonia());
            ps.setInt(5, cliente.getDireccion().getCp());
            ps.setString(6, cliente.getDireccion().getMucipio());
            ps.setString(7, cliente.getDireccion().getEstado());
            ps.setString(8, cliente.getDireccion().getPais());
            ps.setString(9, cliente.getContacto().getNum_movil());
            ps.setString(10, cliente.getContacto().getEmail());
            ps.setString(11, cliente.getRfc());
            int a = ps.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(rootPane, "Guardado");
               
            }
        } catch (SQLException ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        } finally {
            
             if (ps != null) {
                ps.close();
            }
        }
    }

    public void deleteClient(Cliente cliente,JRootPane rootPane) throws Exception {
        sql = "DELETE FROM tb_cliente WHERE cl_rfc=?";
        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            ps.setString(1, cliente.getRfc());
            int a = ps.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(rootPane, "Guardado");
               
            }
        } catch (SQLException ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        } finally {
                      if (ps != null) {
                ps.close();
            }
        }
    }

    public ResultSet querryClients() throws Exception {
        sql = "SELECT cl_rfc,cl_nom FROM tb_cliente";

        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            values = ps.executeQuery();
        } catch (SQLException ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        }
        return values;
    }

}
