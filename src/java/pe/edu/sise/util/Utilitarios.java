/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.util;

import java.util.ResourceBundle;

/**
 *
 * @author vbendezup
 */
public class Utilitarios {

    private static ResourceBundle bundle;
    
    static{
        try {
            bundle = ResourceBundle.getBundle((new StringBuilder("pe.edu.sise.properties.parametros")).toString());            
        } catch (Exception e) {
            System.out.println("Ocurrió un error al cargar el archivo de recursos: " + e.toString());
        }
    }
    
    public static String obtenerPropertie(String propertie) {
        return bundle.getString(propertie);
    }
}
