/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.convertidores;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sv.bitlab.controladores.EstadoEmpleadoControlador;
import sv.bitlab.controladores.SexoControlador;
import sv.bitlab.entidades.EstadoEmpleado;
import sv.bitlab.entidades.Sexo;

/**
 *
 * @author carlosGodoy
 */
@FacesConverter(forClass = Sexo.class)
public class SexoConvertidor implements Converter<Object> {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
           SexoControlador sexoController = new SexoControlador();
            return sexoController.encontrar(Integer.parseInt(value));
        } catch (Exception ex) {
            Logger.getLogger(EstadoEmpleadoConvertidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return ((Sexo) arg2).getSexId().toString();
    }
}