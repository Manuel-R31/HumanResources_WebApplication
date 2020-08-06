package sv.bitlab.manejadores;

import java.io.IOException;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import sv.bitlab.controladores.TipoUsuarioControlador;
import sv.bitlab.controladores.UsuarioControlador;
import sv.bitlab.entidades.Usuario;
import sv.bitlab.manejadores.entidades.UsrUsuario;
import sv.bitlab.utilidades.EncriptacionTexto;
import sv.bitlab.utilidades.UtilidadesManejador;

/**
 *
 * @author Oscar
 */
@ManagedBean
@SessionScoped
public class SesionUsuario {

    private UsrUsuario usuario;
    private UsuarioControlador usuarioControlador;
    private TipoUsuarioControlador tipoUsuarioControlador;
    private final String CODIGO = "B11A22";

    @PostConstruct
    public void inicializar() {
        usuario = new UsrUsuario();
        usuarioControlador = new UsuarioControlador();
    }

    public void validarUsuario() {
        Usuario usr = usuarioControlador.ObtenerUsuario(usuario.getUsuario());

        if (usr == null) {
            UtilidadesManejador.lanzarAdvertencia("Usaurio invalido", "El usuario o la contraseña son invalidos");
        } else {
            EncriptacionTexto encriptacionTexto = new EncriptacionTexto();
            if (usuario.getContrasena().equals(encriptacionTexto.getTextoDesencriptado(usr.getUsrContrasena()))) {
                // String buscarRol =  tipoUsuarioControlador.encontrar(usuario.getRol());
                 usuario.setRol(usr.getTipId().getTipId());
                UtilidadesManejador.redireccion("validacion");
            }
        }
    }

    public void validarSesion() {
        //Si el usuario no tiene rol, redireccionamos al login 
        if (usuario.getRol() == null) {
            ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
            try {
                contex.redirect(contex.getRequestContextPath() + "/login.devel");
            } catch (IOException e) {
                Logger.getLogger(SesionUsuario.class.getName());
            }

        }
    }

    public void doblefactor() {
        if (CODIGO.equals(usuario.getCodigo())) {
            UtilidadesManejador.redireccion("index");
        } else {
            UtilidadesManejador.lanzarAdvertencia("Codigo invalido", "Porfavor increse el codigo valido");
        }
    }

    public UsrUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(UsrUsuario usuario) {
        this.usuario = usuario;
    }

}
