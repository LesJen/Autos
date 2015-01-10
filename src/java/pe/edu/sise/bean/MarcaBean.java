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
public class MarcaBean implements Serializable{
    private short siCodMarca;
    private String vdescripcion;
    private boolean bactivo;

    public MarcaBean() {
    }

    public short getSiCodMarca() {
        return siCodMarca;
    }

    public void setSiCodMarca(short siCodMarca) {
        this.siCodMarca = siCodMarca;
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
