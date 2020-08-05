/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sv.bitlab.manejadores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sv.bitlab.controladores.UsuarioControlador;
import sv.bitlab.entidades.Usuario;
import sv.bitlab.utilidades.EncriptacionTexto;

/**
 *
 * @author Manuel
 */

@ManagedBean
@SessionScoped
public class UsuarioManejador extends ManejadorAbstracto<Usuario> {
    
    private static final Logger log = LoggerFactory.getLogger(UsuarioManejador.class);
    
    private UsuarioControlador usuarioControlador;
    private String contrasena;
    
    public UsuarioManejador() {
        super(Usuario.class);
        usuarioControlador =  new UsuarioControlador();
    }
    
    //encriptando la contrasena de usuarios hacia la base de datos
    @Override
    public void guardarEntidad() {
        log.info("Guardando la identidad");
        if(getEntidadSeleccion().getUsrContrasena() == null || !getEntidadSeleccion().getUsrContrasena().equals(contrasena)){
            EncriptacionTexto encriptacionTexto = new  EncriptacionTexto();
            getEntidadSeleccion().setUsrContrasena(encriptacionTexto.getTextoEncriptado(contrasena));
        }
        super.guardarEntidad();
    }
    
    public void completarInformacion(Usuario usr){
        log.info("ingresando a crear la contrasena");
        setEntidadSeleccion(usr);
        this.contrasena = getEntidadSeleccion().getUsrContrasena();
    }
    
    
    @Override
    public UsuarioControlador getControlador() {
        return usuarioControlador;
    }
    

    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
 
}
