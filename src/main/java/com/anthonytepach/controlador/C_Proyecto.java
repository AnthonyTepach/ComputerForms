/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.controlador;

import com.anthonytepach.beans.Proyecto;
import com.anthonytepach.configuracion.LoggerRegistros;
import com.anthonytepach.configuracion.RenderTables;
import com.anthonytepach.modelos.MProyecto;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Stack;
import javax.swing.JRootPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * Letras="CG-"+type+"AA-"+String.valueOf(new
 * Date().getYear()+1900).substring(2, 4);
 *
 * @author Anthony Tepach
 */
public class C_Proyecto {

    LoggerRegistros loggger = new LoggerRegistros(this.getClass());

    public String generarClave(String tipo) {
        MProyecto mp = new MProyecto();
        Stack<String> ultimaClave = new Stack();
        String Letras = null;
        int type = 0;
        switch (tipo) {
            case "Propios":
                type = 1;
                break;
            case "Acuerdo":
                type = 2;
                break;
            case "Contrato":
                type = 3;
                break;
            default:
                throw new AssertionError();
        }
        try {
            ResultSet rows = mp.querryClavesByYear(String.valueOf(type));
            Stack<String> pila = new Stack();
            while (rows.next()) {
                pila.push(rows.getString(1));
            }
            if (pila.empty()) {
                Letras = "CG-" + type + "AA-" + String.valueOf(new Date().getYear() + 1900).substring(2, 4);
            } else {
                Letras = nuevoFolio(pila.pop(), type);
            }
        } catch (Exception ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        }
        return Letras;
    }

    private String nuevoFolio(String pop, int tipo) {
        int inicio = 65;
        int fin = 90;
        char letra1 = pop.substring(4, 5).charAt(0);
        char letra2 = pop.substring(5, 6).charAt(0);
        int p = letra1;
        int s = letra2;
        if ((p >= inicio && p <= fin) && (s >= inicio && s <= fin)) {
            s++;
            if (s > fin) {
                s = inicio;
                p++;
            }
        }
        return "CG-" + Integer.toString(tipo) + (char) p + (char) s + "-" + String.valueOf(new Date().getYear() + 1900).substring(2, 4);
    }

    public void insertDB(Proyecto data, JRootPane rootPane) {
        MProyecto mp = new MProyecto();
        try {
            mp.insertProject(data, rootPane);
        } catch (Exception ex) {
            loggger.setError(ex.getMessage(), ex.fillInStackTrace());
        }
    }

    public void verTabla(javax.swing.JTable tabla) throws Exception {
        MProyecto mpro = new MProyecto();
        ResultSet consulta = mpro.querryInfoProject();
        //render de la tabla
        tabla.setDefaultRenderer(Object.class, new RenderTables());
        
        //boton ver O.P
        javax.swing.JButton btn_ver = new javax.swing.JButton("Ver O.P.");
        btn_ver.setName("V");
        btn_ver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_ver.setFont(new Font("Arial", Font.BOLD, 14));
        //boton nueva O.P
        javax.swing.JButton btn_agregar = new javax.swing.JButton("Nueva O.P.");
        btn_agregar.setName("N");
        btn_agregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_agregar.setFont(new Font("Arial", Font.BOLD, 14));
        //boton reporte
        javax.swing.JButton btn_reporte = new javax.swing.JButton("PDF");
        btn_reporte.setName("R");
        btn_reporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_reporte.setFont(new Font("Arial", Font.BOLD, 14));

        //Modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        //Columnas
        modeloTabla.addColumn("Clave proyecto");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Cliente");
        modeloTabla.addColumn("Fecha inicio");
        modeloTabla.addColumn("Fecha fin");
        modeloTabla.addColumn("");
        modeloTabla.addColumn("");
        modeloTabla.addColumn("");

        //Fila
        while (consulta.next()) {
            modeloTabla.addRow(new Object[]{consulta.getString(2), consulta.getString(3), consulta.getString(6), consulta.getString(1), consulta.getString(4), consulta.getString(5), btn_agregar, btn_ver, btn_reporte});
        }

        //Asignacion del modelo
        tabla.setModel(modeloTabla);
        tabla.setRowHeight(25);
        
        //Header de la tabla;
        JTableHeader th;
        th = tabla.getTableHeader();
        Font fuente = new Font("Arial", Font.BOLD, 13);
        th.setFont(fuente);
        
        
    }

}
