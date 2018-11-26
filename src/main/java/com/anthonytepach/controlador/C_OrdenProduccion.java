/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.controlador;

import com.anthonytepach.beans.OrdenProduccion;
import com.anthonytepach.configuracion.RenderTables;
import com.anthonytepach.modelos.MOrdenProduccion;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Anthony Tepach
 */
public class C_OrdenProduccion {

    public void insertOP(OrdenProduccion data, JRootPane rootPane) throws Exception {
        MOrdenProduccion m_op = new MOrdenProduccion();
        m_op.insertDB(data, rootPane);
    }

    public void verTabla(JTable tabla, String clave) throws Exception {
        MOrdenProduccion mop = new MOrdenProduccion();
        ResultSet consulta = mop.querryInfoOP(clave);
        //render de la tabla
        tabla.setDefaultRenderer(Object.class, new RenderTables());
        //botones
        javax.swing.JButton btn_ver = new javax.swing.JButton("Descripcion");
        btn_ver.setName("Desc");

        //Modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //columnas
        modeloTabla.addColumn("N° OP");
        modeloTabla.addColumn("Nombre de la Forma");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Status");
        modeloTabla.addColumn("N° Cotización");
        modeloTabla.addColumn("Código de producto");
        modeloTabla.addColumn("Fecha inicio");
        modeloTabla.addColumn("Fecha fin");
        modeloTabla.addColumn("");

        //Filas
        while (consulta.next()) {
            modeloTabla.addRow(new Object[]{
                consulta.getString(1),
                consulta.getString(2),
                consulta.getString(3),
                consulta.getString(4),
                consulta.getString(5),
                consulta.getString(6),
                consulta.getString(7),
                consulta.getString(8),
                btn_ver
            });
        }
        //Asignacion del modelo
        tabla.setModel(modeloTabla);

        tabla.setRowHeight(25);
        JTableHeader th;
        th = tabla.getTableHeader();
        Font fuente = new Font("Arial", Font.BOLD, 13);
        th.setFont(fuente);

    }

}
