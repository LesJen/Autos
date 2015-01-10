/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author vbendezup
 */
public class AutoBean implements Serializable{
    private String cplaca;
    private short siCodMarca;
    private String vdescMarca;
    private short siCodModelo;
    private String vdescModelo;
    private String vpropietario;
    private BigDecimal nkilometraje;
    private int ivelocidadMaxima;
    private boolean bactivo;
    
    public AutoBean(){
        
    }

    public String getCplaca() {
        return cplaca;
    }

    public void setCplaca(String cplaca) {
        this.cplaca = cplaca;
    }

    public short getSiCodMarca() {
        return siCodMarca;
    }

    public void setSiCodMarca(short siCodMarca) {
        this.siCodMarca = siCodMarca;
    }

    public String getVdescMarca() {
        return vdescMarca;
    }

    public void setVdescMarca(String vdescMarca) {
        this.vdescMarca = vdescMarca;
    }

    public short getSiCodModelo() {
        return siCodModelo;
    }

    public void setSiCodModelo(short siCodModelo) {
        this.siCodModelo = siCodModelo;
    }

    public String getVdescModelo() {
        return vdescModelo;
    }

    public void setVdescModelo(String vdescModelo) {
        this.vdescModelo = vdescModelo;
    }

    public String getVpropietario() {
        return vpropietario;
    }

    public void setVpropietario(String vpropietario) {
        this.vpropietario = vpropietario;
    }

    public BigDecimal getNkilometraje() {
        return nkilometraje;
    }

    public void setNkilometraje(BigDecimal nkilometraje) {
        this.nkilometraje = nkilometraje;
    }

    public int getIvelocidadMaxima() {
        return ivelocidadMaxima;
    }

    public void setIvelocidadMaxima(int ivelocidadMaxima) {
        this.ivelocidadMaxima = ivelocidadMaxima;
    }

    public boolean isBactivo() {
        return bactivo;
    }

    public void setBactivo(boolean bactivo) {
        this.bactivo = bactivo;
    }

    
}
