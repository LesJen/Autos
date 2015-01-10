/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.sise.dao;

import java.util.List;
import pe.edu.sise.bean.ModeloBean;

/**
 *
 * @author vbendezup
 */
public interface IModeloDao {
    
    public abstract List<ModeloBean> listarPorMarca(short siCodMarca) throws Exception;    
}
