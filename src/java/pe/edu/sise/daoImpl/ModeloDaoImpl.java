/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.sise.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.sise.bean.ModeloBean;
import pe.edu.sise.dao.IModeloDao;
import pe.edu.sise.util.Constantes;
import pe.edu.sise.util.DBConn;

/**
 *
 * @author vbendezup
 */
public class ModeloDaoImpl implements IModeloDao{

    @Override
    public List<ModeloBean> listarPorMarca(short siCodMarca) throws Exception {
        List<ModeloBean> lista = new ArrayList<ModeloBean>();
        // obtenemos la conexión
        Connection conn = DBConn.obtenerConexion();
        Statement st = conn.createStatement();
        // armamos la query
        StringBuilder sql = new StringBuilder();
        sql.append("select siCodModelo as codigo, ");
        sql.append("vdescripcion as descripcion ");
        sql.append("from TBL_MODELO ");
        sql.append("where siCodMarca = ").append(siCodMarca);
        sql.append("and bactivo = ").append(Constantes.ESTADO_ACTIVO);        
        ResultSet rs = st.executeQuery(sql.toString());
        // recorremos los resultados
        while(rs.next()){
            ModeloBean modelo = new ModeloBean();
            modelo.setSiCodModelo(rs.getShort("codigo"));
            modelo.setVdescripcion(rs.getString("descripcion"));
            lista.add(modelo);
        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }
    
}
