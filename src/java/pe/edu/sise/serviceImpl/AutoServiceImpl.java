/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.sise.serviceImpl;

import java.util.List;
import pe.edu.sise.bean.AutoBean;
import pe.edu.sise.dao.IAutoDao;
import pe.edu.sise.daoImpl.AutoDaoImpl;
import pe.edu.sise.service.IAutoService;

/**
 *
 * @author vbendezup
 */
public class AutoServiceImpl implements IAutoService{

    private final IAutoDao iAutoDao = new AutoDaoImpl();

    @Override
    public List<AutoBean> listar() throws Exception {
        return iAutoDao.listar();
    }

    @Override
    public List<AutoBean> buscar(short siCodMarca, short siCodModelo, String vpropietario) throws Exception {
        return iAutoDao.buscar(siCodMarca, siCodModelo, vpropietario);
    }

    @Override
    public void registrar(AutoBean auto) throws Exception {
        iAutoDao.registrar(auto);
    }

    @Override
    public void actualizar(String cplaca, String vpropietario) throws Exception {
        iAutoDao.actualizar(cplaca, vpropietario);
    }

    @Override
    public void eliminar(String cplaca) throws Exception {
        iAutoDao.eliminar(cplaca);
    }
    
}
