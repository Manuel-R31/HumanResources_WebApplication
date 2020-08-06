/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.manejadores;

import sv.bitlab.utilidades.UtilidadesManejador;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import sv.bitlab.controladores.ControladorAbstracto;

/**
 *
 * @author Oscar
 */
public abstract class ManejadorAbstracto<T> {

    private T entidadSeleccion;
    private List<T> entidadesLista;
    private Class<T> claseEntidad;

    public ManejadorAbstracto(Class<T> entidad) {
        claseEntidad = entidad;
    }

    @PostConstruct
    public void cargarInformacion() {
        entidadesLista = getControlador().encontrarEntidades();
    }

    @PreDestroy
    public void destruir() {
        entidadesLista = null;
        entidadSeleccion = null;
    }

    public void nuevaEntidad() throws NoSuchMethodException {
        try {
            entidadSeleccion = claseEntidad.getDeclaredConstructor().newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(ManejadorAbstracto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ManejadorAbstracto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ManejadorAbstracto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ManejadorAbstracto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarEntidad() {
        try {
            getControlador().editar(entidadSeleccion);
            cargarInformacion();
            UtilidadesManejador.lanzarInfo("Exitoso ", claseEntidad.getSimpleName() + " ha sido guardado");
        } catch (Exception e) {
            e.printStackTrace();
            UtilidadesManejador.lanzarError("Error al guardar ", e.getMessage());
        }
    }

    public void eliminarEntidad() {
        try {
            getControlador().destruir(entidadSeleccion);
            cargarInformacion();
            UtilidadesManejador.lanzarInfo("Exitoso ", claseEntidad.getSimpleName() + " ha sido eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            UtilidadesManejador.lanzarError("Error al eliminar producto ", e.getMessage());
        }
    }

    public T getEntidadSeleccion() {
        return entidadSeleccion;
    }

    public void setEntidadSeleccion(T entidadSeleccion) {
        this.entidadSeleccion = entidadSeleccion;
    }

    public List<T> getEntidadesLista() {
        return entidadesLista;
    }

    public void setEntidadesLista(List<T> entidadesLista) {
        this.entidadesLista = entidadesLista;
    }

    public abstract ControladorAbstracto<T> getControlador();

}
