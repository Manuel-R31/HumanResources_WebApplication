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
import sv.bitlab.controladores.EstadoDepartamentoControlador;
import sv.bitlab.entidades.EstadoDepartamento;

/**
 *
 * @author Manuel
 */
@FacesConverter(forClass = EstadoDepartamento.class)
public class EstadoDepartamentoConvertidor implements Converter<EstadoDepartamento>{

    @Override
    public EstadoDepartamento getAsObject(FacesContext context, UIComponent component, String value) {

        try {
            EstadoDepartamentoControlador estadoDepartamentoControlador = new EstadoDepartamentoControlador();
            return estadoDepartamentoControlador.encontrar(Integer.parseInt(value));
        } catch (Exception ex) {
            Logger.getLogger(EstadoDepartamentoConvertidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, EstadoDepartamento arg2) {
        return((EstadoDepartamento)arg2).getEdeId().toString();
    }
    
    
}
