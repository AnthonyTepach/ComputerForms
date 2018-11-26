/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.controlador;

import com.anthonytepach.beans.Cliente;
import com.anthonytepach.configuracion.LoggerRegistros;
import com.anthonytepach.modelos.MCliente;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Anthony Tepach
 */
public class C_Cliente {

    LoggerRegistros loggger = new LoggerRegistros(this.getClass());

    public void insertDB(Cliente cliente, JRootPane rootPane) {
        MCliente mcli = new MCliente();
        try {
            mcli.insertClient(cliente,rootPane);
        } catch (Exception ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        }
    }

    public ResultSet getClients() throws Exception {
        MCliente mcli = new MCliente();
        return mcli.querryClients();
    }

}
