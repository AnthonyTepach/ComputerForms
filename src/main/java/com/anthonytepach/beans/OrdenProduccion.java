/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.beans;

import java.util.Date;

/**
 *
 * @author Anthony Tepach
 */
public class OrdenProduccion {

    private String no_op;
    private String tipo;
    private Date fecha_ini;
    private Date fecha_fin;
    private String status;
    private String producto;
    private String clave_proyecto;
    private String clave_producto;
    private String no_cotizacion;
    private String desc;
    private String nom_forma;

    public String getClave_producto() {
        return clave_producto;
    }

    public void setClave_producto(String clave_producto) {
        this.clave_producto = clave_producto;
    }

    public String getNo_cotizacion() {
        return no_cotizacion;
    }

    public void setNo_cotizacion(String no_cotizacion) {
        this.no_cotizacion = no_cotizacion;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNom_forma() {
        return nom_forma;
    }

    public void setNom_forma(String nom_forma) {
        this.nom_forma = nom_forma;
    }

    public String getNo_op() {
        return no_op;
    }

    public void setNo_op(String no_op) {
        this.no_op = no_op;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getClave_proyecto() {
        return clave_proyecto;
    }

    public void setClave_proyecto(String clave_proyecto) {
        this.clave_proyecto = clave_proyecto;
    }

    public Date getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
