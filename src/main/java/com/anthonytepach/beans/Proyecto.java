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
public class Proyecto {
    private String Clave;
    private String nombre;
    private String lider;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String tipo;
    private String Cliente;
    private String fecha_alta;
    private String entrega_parcial;
    private int vol_total;
    private int costo;

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getEntrega_parcial() {
        return entrega_parcial;
    }

    public void setEntrega_parcial(String entrega_parcial) {
        this.entrega_parcial = entrega_parcial;
    }

    public int getVol_total() {
        return vol_total;
    }

    public void setVol_total(int vol_total) {
        this.vol_total = vol_total;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
}
