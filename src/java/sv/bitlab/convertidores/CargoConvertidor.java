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
import sv.bitlab.controladores.CargoControlador;
import sv.bitlab.entidades.Cargo;

/**
 *
 * @author carlosGodoy
 */
@FacesConverter(forClass = Cargo.class)
public class CargoConvertidor implements Converter<Object> {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            CargoControlador cargoController = new CargoControlador();
            return cargoController.encontrar(Integer.parseInt(value));
        } catch (Exception ex) {
            Logger.getLogger(CargoConvertidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
     return ((Cargo) arg2).getCarId().toString();
    }
    
}
