/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.sise.bean;

import java.io.Serializable;

/**
 *
 * @author vbendezup
 */
public class ModeloBean implements Serializable{
    private short siCodMarca;
    private short siCodModelo;
    private String vdescripcion;
    private boolean bactivo;

    public ModeloBean() {
    }

    public short getSiCodMarca() {
        return siCodMarca;
    }

    public void setSiCodMarca(short siCodMarca) {
        this.siCodMarca = siCodMarca;
    }

    public short getSiCodModelo() {
        return siCodModelo;
    }

    public void setSiCodModelo(short siCodModelo) {
        this.siCodModelo = siCodModelo;
    }

    public String getVdescripcion() {
        return vdescripcion;
    }

    public void setVdescripcion(String vdescripcion) {
        this.vdescripcion = vdescripcion;
    }

    public boolean isBactivo() {
        return bactivo;
    }

    public void setBactivo(boolean bactivo) {
        this.bactivo = bactivo;
    }

    
    
}
