/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.utilidades;

import sv.bitlab.manejadores.SesionUsuario;
import java.io.IOException;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Oscar
 */
public class UtilidadesManejador {
    
    //Envia un mensaje personalizado
    public static void lanzarMensaje(FacesMessage.Severity severidad, String encabezado, String detalle){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidad, encabezado, detalle));
    }
    
    //Envia un mensaje de informacion
    public static void lanzarInfo(String encabezado, String detalle){
        lanzarMensaje(FacesMessage.SEVERITY_INFO, encabezado, detalle);
    }
    
    //Envia un mensaje de error
    public static void lanzarError(String encabezado, String detalle){
        lanzarMensaje(FacesMessage.SEVERITY_ERROR, encabezado, detalle);
    }
    
    //Envia un mensaje de error
    public static void lanzarAdvertencia(String encabezado, String detalle){
        lanzarMensaje(FacesMessage.SEVERITY_WARN, encabezado, detalle);
    }
    
    public static void redireccion(String pagina){
        ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        try {
            contex.redirect(contex.getRequestContextPath()+"/pages/"+pagina+".devel");
        } catch (IOException e) {
            Logger.getLogger(SesionUsuario.class.getName());
        }
    }
    
    public static void redireccionLogin(){
        ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
            try {
                contex.redirect(contex.getRequestContextPath() + "/login.devel");
            } catch (IOException e) {
                Logger.getLogger(SesionUsuario.class.getName());
            }
    }
}
