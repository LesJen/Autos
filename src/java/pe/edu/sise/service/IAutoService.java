/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.sise.service;

import java.util.List;
import pe.edu.sise.bean.AutoBean;

/**
 *
 * @author vbendezup
 */
public interface IAutoService {
    
    public abstract List<AutoBean> listar() throws Exception;
    
    public abstract List<AutoBean> buscar(short siCodMarca, short siCodModelo, String vpropietario) throws Exception;
    
    public abstract void registrar(AutoBean auto) throws Exception;
    
    public abstract void actualizar(String cplaca, String vpropietario) throws Exception;
    
    public abstract void eliminar(String cplaca) throws Exception;
    
}
