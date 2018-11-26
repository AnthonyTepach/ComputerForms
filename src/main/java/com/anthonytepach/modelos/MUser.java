/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.modelos;

import com.anthonytepach.beans.Usuarios;
import com.anthonytepach.configuracion.LoggerRegistros;
import com.anthonytepach.database.ConexionMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Anthony Tepach
 */
public class MUser {

    LoggerRegistros loggger = new LoggerRegistros(this.getClass());
    private String sql;
    private PreparedStatement ps;
    private ResultSet values = null;

    public void insertUser(Usuarios usuario, JRootPane rootPane) throws Exception {
        sql = "INSERT INTO tb_usuario VALUES(?,?,?,?)";
        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            ps.setString(1, usuario.getUuid());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getRol());
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

    public void updatetUser(Usuarios usuario, JRootPane rootPane) throws Exception {
        sql = "UPDATE tb_usuario SET us_passw =? ";
        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            ps.setString(1, usuario.getPassword());
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

    public void deleteUser(Usuarios usuario, JRootPane rootPane) throws Exception {
        sql = "DELETE FROM tb_usuario WHERE  us_uidd = ?";
        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            ps.setString(1, usuario.getUuid());
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

    public ResultSet querryUser(Usuarios usuario) throws Exception {
        sql = "SELECT * FROM tb_usuario WHERE us_nombre = ? AND us_passw = ?";

        try {
            ps = ConexionMySql.getConnection().prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            values = ps.executeQuery();

        } catch (SQLException ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        }
        return values;
    }
}
