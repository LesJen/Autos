/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.sise.service;

import java.util.List;
import pe.edu.sise.bean.MarcaBean;

/**
 *
 * @author vbendezup
 */
public interface IMarcaService {
    
    public abstract List<MarcaBean> listar() throws Exception;
}
