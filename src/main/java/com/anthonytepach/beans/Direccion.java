/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthonytepach.beans;


/**
 *
 * @author Anthony Tepach
 */
public class Direccion{

    private String pais,
            estado,
            mucipio,
            colonia,
            calle,
            num_calle;
    private int cp;
      

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMucipio() {
        return mucipio;
    }

    public void setMucipio(String mucipio) {
        this.mucipio = mucipio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNum_calle() {
        return num_calle;
    }

    public void setNum_calle(String num_calle) {
        this.num_calle = num_calle;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

}
