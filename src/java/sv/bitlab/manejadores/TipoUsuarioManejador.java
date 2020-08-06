/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.manejadores;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.bitlab.controladores.ControladorAbstracto;
import sv.bitlab.controladores.TipoUsuarioControlador;
import sv.bitlab.entidades.TipoUsuario;

/**
 *
 * @author Oscar
 */
@ManagedBean
@ViewScoped
public class TipoUsuarioManejador extends ManejadorAbstracto<TipoUsuario>{
    
    private TipoUsuarioControlador tipoUsuarioControlador;
            
    public TipoUsuarioManejador() {
        super(TipoUsuario.class);
        tipoUsuarioControlador = new TipoUsuarioControlador();
    }

    @Override
    public TipoUsuarioControlador getControlador() {
        return tipoUsuarioControlador;
    }
    
}
