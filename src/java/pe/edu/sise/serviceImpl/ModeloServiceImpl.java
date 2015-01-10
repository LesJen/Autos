/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.sise.serviceImpl;

import java.util.List;
import pe.edu.sise.bean.ModeloBean;
import pe.edu.sise.dao.IModeloDao;
import pe.edu.sise.daoImpl.ModeloDaoImpl;
import pe.edu.sise.service.IModeloService;

/**
 *
 * @author vbendezup
 */
public class ModeloServiceImpl implements IModeloService{

    private final IModeloDao iModeloDao = new ModeloDaoImpl();

    @Override
    public List<ModeloBean> listarPorMarca(short siCodMarca) throws Exception {
        return iModeloDao.listarPorMarca(siCodMarca);
    }
    
}
