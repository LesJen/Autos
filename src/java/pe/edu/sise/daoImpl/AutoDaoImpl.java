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
import pe.edu.sise.bean.AutoBean;
import pe.edu.sise.dao.IAutoDao;
import pe.edu.sise.util.Constantes;
import pe.edu.sise.util.DBConn;

/**
 *
 * @author vbendezup
 */
public class AutoDaoImpl implements IAutoDao{

    @Override
    public List<AutoBean> listar() throws Exception {
        List<AutoBean> lista = new ArrayList<AutoBean>();
        // obtenemos la conexión
        Connection conn = DBConn.obtenerConexion();
        Statement st = conn.createStatement();
        // armamos la query
        StringBuilder sql = new StringBuilder();
        sql.append("select a.cplaca as placa, ");
        sql.append("ma.vdescripcion as descMarca, ");
        sql.append("mo.vdescripcion as descModelo, ");
        sql.append("a.vpropietario as propietario, ");
        sql.append("a.nkilometraje as kilometraje, ");
        sql.append("a.ivelocidadmax as velocidad ");
        sql.append("from TBL_AUTO a ");
        sql.append("INNER JOIN TBL_MARCA ma ON a.siCodMarca = ma.siCodMarca ");
        sql.append("INNER JOIN TBL_MODELO mo ON a.siCodModelo = mo.siCodModelo ");
        sql.append("where a.bactivo = ").append(Constantes.ESTADO_ACTIVO);
        ResultSet rs = st.executeQuery(sql.toString());
        // recorremos los resultados
        while(rs.next()){
            AutoBean auto = new AutoBean();
            auto.setCplaca(rs.getString("placa"));
            auto.setVdescMarca(rs.getString("descMarca"));
            auto.setVdescModelo(rs.getString("descModelo"));
            auto.setVpropietario(rs.getString("propietario"));
            auto.setNkilometraje(rs.getBigDecimal("kilometraje"));
            auto.setIvelocidadMaxima(rs.getInt("velocidad"));
            lista.add(auto);
        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }

    @Override
    public List<AutoBean> buscar(short siCodMarca, short siCodModelo, String vpropietario) throws Exception {
        List<AutoBean> lista = new ArrayList<AutoBean>();
        // obtenemos la conexión
        Connection conn = DBConn.obtenerConexion();
        Statement st = conn.createStatement();
        // armamos la query
        StringBuilder sql = new StringBuilder();
        sql.append("select a.cplaca as placa, ");
        sql.append("ma.vdescripcion as descMarca, ");
        sql.append("mo.vdescripcion as descModelo, ");
        sql.append("a.vpropietario as propietario, ");
        sql.append("a.nkilometraje as kilometraje, ");
        sql.append("a.ivelocidadmax as velocidad ");
        sql.append("from TBL_AUTO a ");
        sql.append("INNER JOIN TBL_MARCA ma ON a.siCodMarca = ma.siCodMarca ");
        sql.append("INNER JOIN TBL_MODELO mo ON a.siCodModelo = mo.siCodModelo ");
        sql.append("where a.bactivo = ").append(Constantes.ESTADO_ACTIVO);
        // evaluamos las condiciones para armar la query dinámica
        if(siCodMarca > 0){
            sql.append(" and a.siCodMarca = ").append(siCodMarca);
        }
        if(siCodModelo > 0){
            sql.append(" and a.siCodModelo = ").append(siCodModelo);
        }
        if(vpropietario != null && !vpropietario.isEmpty()){
            sql.append(" and a.vpropietario LIKE '").append(vpropietario).append("%'");
        }
        ResultSet rs = st.executeQuery(sql.toString());
        // recorremos los resultados
        while(rs.next()){
            AutoBean auto = new AutoBean();
            auto.setCplaca(rs.getString("placa"));
            auto.setVdescMarca(rs.getString("descMarca"));
            auto.setVdescModelo(rs.getString("descModelo"));
            auto.setVpropietario(rs.getString("propietario"));
            auto.setNkilometraje(rs.getBigDecimal("kilometraje"));
            auto.setIvelocidadMaxima(rs.getInt("velocidad"));
            lista.add(auto);
        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }

    @Override
    public void registrar(AutoBean auto) throws Exception {
        // obtenemos la conexión
        Connection conn = DBConn.obtenerConexion();
        Statement st = conn.createStatement();
        // armamos la query
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO TBL_AUTO(CPLACA, SICODMARCA, SICODMODELO, VPROPIETARIO, ");
        sql.append(" NKILOMETRAJE, IVELOCIDADMAX, BACTIVO)");
        sql.append(" VALUES (").
                append("'").append(auto.getCplaca()).append("', ").
                append(auto.getSiCodMarca()).append(", ").
                append(auto.getSiCodModelo()).append(", ").
                append("'").append(auto.getVpropietario()).append("', ").
                append(auto.getNkilometraje()).append(", ").
                append(auto.getIvelocidadMaxima()).append(", ").
                append(auto.isBactivo()).append(")");
        st.executeUpdate(sql.toString());
        st.close();
        conn.close();
    }

    @Override
    public void actualizar(String cplaca, String vpropietario) throws Exception {
        // obtenemos la conexión
        Connection conn = DBConn.obtenerConexion();
        Statement st = conn.createStatement();
        // armamos la query
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE TBL_AUTO ");
        sql.append(" SET VPROPIETARIO = '").append(vpropietario).append("' ");
        sql.append(" WHERE CPLACA = '").append(cplaca).append("' ");
        st.executeUpdate(sql.toString());
        st.close();
        conn.close();
    }

    @Override
    public void eliminar(String cplaca) throws Exception {
        // obtenemos la conexión
        Connection conn = DBConn.obtenerConexion();
        Statement st = conn.createStatement();
        // armamos la query
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE TBL_AUTO ");
        sql.append(" SET BACTIVO = ").append(Constantes.ESTADO_INACTIVO);
        sql.append(" WHERE CPLACA = '").append(cplaca).append("' ");
        st.executeUpdate(sql.toString());
        st.close();
        conn.close();
    }
    
}
