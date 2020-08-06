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
import sv.bitlab.controladores.TipoUsuarioControlador;
import sv.bitlab.entidades.TipoUsuario;

/**
 *
 * @author Manuel
 */
@FacesConverter(forClass = TipoUsuario.class)
public class TipoUsuarioConvertidor implements Converter<TipoUsuario> {

    @Override
    public TipoUsuario getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            TipoUsuarioControlador tipoUsuarioControlador = new TipoUsuarioControlador();
            return tipoUsuarioControlador.encontrar(Integer.parseInt(value));
        } catch (Exception ex) {
            Logger.getLogger(TipoUsuarioConvertidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, TipoUsuario arg2) {
        return ((TipoUsuario)arg2).getTipId().toString();
    }
}
