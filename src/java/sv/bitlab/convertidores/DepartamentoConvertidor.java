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
import sv.bitlab.controladores.DepartamentoControlador;
import sv.bitlab.entidades.Departamento;


/**
 *
 * @author carlosGodoy
 */
@FacesConverter(forClass = Departamento.class)
public class DepartamentoConvertidor implements Converter<Object>  {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            DepartamentoControlador departamentoControlador = new DepartamentoControlador();
            return departamentoControlador.encontrar(Integer.parseInt(value));
        } catch (Exception ex) {
            Logger.getLogger(DepartamentoConvertidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
         return ((Departamento) arg2).getDepId().toString();
    }
    
}
