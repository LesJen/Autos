/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.sise.serviceImpl;

import java.util.List;
import pe.edu.sise.bean.MarcaBean;
import pe.edu.sise.dao.IMarcaDao;
import pe.edu.sise.daoImpl.MarcaDaoImpl;
import pe.edu.sise.service.IMarcaService;

/**
 *
 * @author vbendezup
 */
public class MarcaServiceImpl implements IMarcaService{

    private final IMarcaDao iMarcaDao = new MarcaDaoImpl();

    @Override
    public List<MarcaBean> listar() throws Exception {
        return iMarcaDao.listar();
    }
}
