/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.controlador;

import com.anthonytepach.database.ConexionMySql;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Anthony Tepach
 */
public class C_Reporte extends Thread{

    public C_Reporte(String clave_proyecto) throws Exception {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("CLAVE_PROYECTO", clave_proyecto);
        String ruta = System.getProperty("user.dir") + "\\src\\main\\java\\com\\anthonytepach\\reportes\\AltaProyecto.jrxml";
        JasperReport report = JasperCompileManager.compileReport(ruta);
        JasperPrint print = JasperFillManager.fillReport(report, parametros, ConexionMySql.getConnection());
        JasperViewer.viewReport(print,false);
    }
  
}
