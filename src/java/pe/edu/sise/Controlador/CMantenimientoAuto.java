/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import pe.edu.sise.bean.AutoBean;
import pe.edu.sise.bean.MarcaBean;
import pe.edu.sise.bean.ModeloBean;
import pe.edu.sise.service.IAutoService;
import pe.edu.sise.service.IMarcaService;
import pe.edu.sise.service.IModeloService;
import pe.edu.sise.serviceImpl.AutoServiceImpl;
import pe.edu.sise.serviceImpl.MarcaServiceImpl;
import pe.edu.sise.serviceImpl.ModeloServiceImpl;

/**
 *
 * @author alumno
 */
@ManagedBean
@ViewScoped
public class CMantenimientoAuto implements Serializable{

    private AutoBean auto;
    private AutoBean selectedAuto;
    private ArrayList<MarcaBean> listaMarcas;
    private ArrayList<ModeloBean> listaModelos;
    private ArrayList<AutoBean> listaAutos;
    // para los campos de búsqueda
    private short filtrodMarca;
    private short filtrodModelo;
    private String filtroPropietario;
            
    /**
     * Creates a new instance of CRegistrar
     */
    public CMantenimientoAuto() {
        try {
            IMarcaService iMarcaService = new MarcaServiceImpl();
            // llenando el combo de marcas
            listaMarcas = (ArrayList<MarcaBean>) iMarcaService.listar();
            listar();
        } catch (Exception ex) {
            System.out.println("Error al listar las marcas o los autos-->" + ex.toString());
        }
    }
    
    public void obtenerModelo(ValueChangeEvent event) {
        try {
            if(event.getNewValue()!= null){
                short siCodMarca = Short.parseShort(event.getNewValue().toString());
                IModeloService iModeloService = new ModeloServiceImpl();
                listaModelos = (ArrayList<ModeloBean>) iModeloService.listarPorMarca(siCodMarca);
            }
        }catch (Exception e) {
              
        }			
    }

    public String buscar(){
        try {
            IAutoService iAutoService = new AutoServiceImpl();
            listaAutos = (ArrayList<AutoBean>) iAutoService.buscar(filtrodMarca, filtrodModelo, filtroPropietario);
        } catch (Exception ex) {
            System.out.println("Error el ejecutar la búsqueda de autos-->" + ex.toString());
        }
        return null;
    }
    
    public String registrar(){
        try {
            // registramos un auto
            IAutoService iAutoService = new AutoServiceImpl();
            iAutoService.registrar(auto);
            listar();
            // mostramos un mensaje adecuado
            FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, 
                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                        "Registro de Autos", 
                                        "Los datos del auto fueron grabados correctamente"));
        } catch (Exception ex) {
            System.out.println("Error al registrar un auto !!! -->" + ex.toString());
        }
        return null;
    }
    
    public String eliminar(){
        try {
            // registramos un auto
            IAutoService iAutoService = new AutoServiceImpl();
            iAutoService.eliminar(selectedAuto.getCplaca());
            listar();
            // mostramos un mensaje adecuado
            FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, 
                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                        "Registro de Autos", 
                                        "Los datos del auto fueron eliminados correctamente"));
        } catch (Exception ex) {
            System.out.println("Error al eliminar un auto !!! -->" + ex.toString());
        }
        return null;
    }
        
    private void listar(){
        try {
            IAutoService iAutoService = new AutoServiceImpl();
            listaAutos = (ArrayList<AutoBean>) iAutoService.listar();
        } catch (Exception ex) {
            System.out.println("Error al listar los autos (listar)-->" + ex.toString());
        }
    }
    
    public AutoBean getAuto() {
        return auto;
    }

    public void setAuto(AutoBean auto) {
        this.auto = auto;
    }

    public AutoBean getSelectedAuto() {
        return selectedAuto;
    }

    public void setSelectedAuto(AutoBean selectedAuto) {
        this.selectedAuto = selectedAuto;
    }

    public ArrayList<MarcaBean> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(ArrayList<MarcaBean> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public ArrayList<ModeloBean> getListaModelos() {
        return listaModelos;
    }

    public void setListaModelos(ArrayList<ModeloBean> listaModelos) {
        this.listaModelos = listaModelos;
    }
    
    public ArrayList<AutoBean> getListaAutos() {
        return listaAutos;
    }

    public void setListaAutos(ArrayList<AutoBean> listaAutos) {
        this.listaAutos = listaAutos;
    }

    public short getFiltrodMarca() {
        return filtrodMarca;
    }

    public void setFiltrodMarca(short filtrodMarca) {
        this.filtrodMarca = filtrodMarca;
    }

    public short getFiltrodModelo() {
        return filtrodModelo;
    }

    public void setFiltrodModelo(short filtrodModelo) {
        this.filtrodModelo = filtrodModelo;
    }

    public String getFiltroPropietario() {
        return filtroPropietario;
    }

    public void setFiltroPropietario(String filtroPropietario) {
        this.filtroPropietario = filtroPropietario;
    }

    
   
    
}
