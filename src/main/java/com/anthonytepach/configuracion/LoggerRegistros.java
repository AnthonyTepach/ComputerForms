/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.configuracion;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Anthony Tepach
 */
public class LoggerRegistros {

    private Logger log;

    public LoggerRegistros(Class clase) {
        this.log = Logger.getLogger(clase);
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    public void setError(String mensaje, Throwable t) {
        log.error(mensaje, t);
    }

    public void setFatal(String mensaje, Throwable t) {
        log.fatal(mensaje, t);
    }

    public void setDepuracion(String mensaje, Throwable t) {
        log.debug(mensaje, t);
    }

    public void setInformacion(String mensaje, Throwable t) {
        log.info(mensaje, t);
    }

    public void setAdvertencia(String mensaje, Throwable t) {
        log.warn(mensaje, t);
    }

    public void setRastro(String mensaje, Throwable t) {
        log.trace(mensaje, t);
    }

    public void setError(String mensaje) {
        log.error(mensaje);
    }

    public void setFatal(String mensaje) {
        log.fatal(mensaje);
    }

    public void setDepuracion(String mensaje) {
        log.debug(mensaje);
    }

    public void setInformacion(String mensaje) {
        log.info(mensaje);
    }

    public void setAdvertencia(String mensaje) {
        log.warn(mensaje);
    }

    public void setRastro(String mensaje) {
        log.trace(mensaje);
    }
}
