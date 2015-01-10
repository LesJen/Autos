/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author vbendezup
 */
public class DBConn {

    //public static final String URL_SQLBD = "jdbc:sqlserver://172.29.66.39:1433;databaseName=VENTAS; user=sa; password=123456";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        } catch (Exception e) {
            System.out.println("Se produjo una excepción en el bloque static: " + e.toString());
        }
    }

    public static Connection obtenerConexion() {
        Connection conn = null;
        try {
            // obteniendo datos del archivo de propiedades
            String host = Utilitarios.obtenerPropertie("bd.host");
            String port = Utilitarios.obtenerPropertie("bd.port");
            String name = Utilitarios.obtenerPropertie("bd.name");
            String user = Utilitarios.obtenerPropertie("bd.user");
            String password = Utilitarios.obtenerPropertie("bd.password");
            // armando la cadena de conexión
            String urlConnection = (new StringBuilder("jdbc:sqlserver://")).append(host).append(":").append(port).
                    append(";databaseName=").append(name).
                    append(";user=").append(user).
                    append("; password=").append(password).toString();
            
            conn = DriverManager.getConnection(urlConnection);
        } catch (Exception e) {
            System.out.println("Se produjo una excepción al obtener la conexión: " + e.toString());
        }
        return conn;
    }
}
