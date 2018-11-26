/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.controlador;

import com.anthonytepach.beans.Usuarios;
import com.anthonytepach.configuracion.LoggerRegistros;
import com.anthonytepach.modelos.MUser;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Anthony Tepach
 */
public class C_Usuario {

    LoggerRegistros loggger = new LoggerRegistros(this.getClass());
    protected Usuarios userL = new Usuarios();

    public Usuarios getUserL() {
        return userL;
    }

    public boolean loguear(Usuarios user) {
        boolean existe = false;
        MUser mu = new MUser();
        String a, b;
        ResultSet consulta = null;
        try {
            consulta = mu.querryUser(user);
             while (consulta.next()) {
                    userL.setUuid(consulta.getString(1));
                    userL.setUsername(consulta.getString(2));
                    userL.setPassword(consulta.getString(3));
                    userL.setRol(consulta.getString(4));
                }
            if (consulta.absolute(1)) {
                
                existe = true;
               
            }
        } catch (Exception ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        } finally {
            if (consulta != null) {
                try {
                    consulta.close();
                } catch (SQLException ex) {
                    loggger.setError(ex.getMessage(), ex.fillInStackTrace());
                }
            }
        }
        return existe;
    }

  

}
