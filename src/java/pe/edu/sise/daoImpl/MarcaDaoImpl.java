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
import pe.edu.sise.bean.MarcaBean;
import pe.edu.sise.dao.IMarcaDao;
import pe.edu.sise.util.Constantes;
import pe.edu.sise.util.DBConn;

/**
 *
 * @author vbendezup
 */
public class MarcaDaoImpl implements IMarcaDao{

    @Override
    public List<MarcaBean> listar() throws Exception {
        List<MarcaBean> lista = new ArrayList<MarcaBean>();
        // obtenemos la conexión
        Connection conn = DBConn.obtenerConexion();
        Statement st = conn.createStatement();
        // armamos la query
        StringBuilder sql = new StringBuilder();
        sql.append("select siCodMarca as codigo, ");
        sql.append("vdescripcion as descripcion ");
        sql.append("from TBL_MARCA ");
        sql.append("where bactivo = ").append(Constantes.ESTADO_ACTIVO);
        ResultSet rs = st.executeQuery(sql.toString());
        // recorremos los resultados
        while(rs.next()){
            MarcaBean marca = new MarcaBean();
            marca.setSiCodMarca(rs.getShort("codigo"));
            marca.setVdescripcion(rs.getString("descripcion"));
            lista.add(marca);
        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }
    
}
