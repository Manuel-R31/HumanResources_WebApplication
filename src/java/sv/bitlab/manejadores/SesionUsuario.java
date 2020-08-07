package sv.bitlab.manejadores;


import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.LoggerFactory;
import sv.bitlab.controladores.ConfiguracionControlador;
import sv.bitlab.controladores.TipoUsuarioControlador;
import sv.bitlab.controladores.UsuarioControlador;
import sv.bitlab.entidades.Configuracion;
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
    private ConfiguracionControlador configuracionControlador;
    private TipoUsuarioControlador tipoUsuarioControlador;
    private String cadena;
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SesionUsuario.class);

    @PostConstruct
    public void inicializar() {
        usuario = new UsrUsuario();
        usuarioControlador = new UsuarioControlador();
        configuracionControlador = new ConfiguracionControlador();
    }

    public void validarUsuario() {
        UtilidadesManejador.lanzarAdvertencia("Datos erroneos", "El usuario o la contraseña son invalidos");
        Usuario usr = usuarioControlador.ObtenerUsuario(usuario.getUsuario());
        if (usr == null) {
            UtilidadesManejador.lanzarAdvertencia("Usaurio invalido", "El usuario o la contraseña son invalidos");
        } else {
            //Encriptando Texto de la base 
            EncriptacionTexto encriptacionTexto = new EncriptacionTexto();
            //Verificando la contraseña 
            if (usuario.getContrasena().equals(encriptacionTexto.getTextoDesencriptado(usr.getUsrContrasena()))) {
                //Asignando rol a usaurio (obtenido desde la base
                usuario.setRol(usr.getTipId().getTipId());
                log.debug("Asignandole rol al usuario: " + usr.getUsrAcceso());
                //Preparando codigo de doble factor de autenticacion
                 cadena = codigoAcceso();
                //Funcion para enviar el correo electronico 
                enviarCorreo(usr.getUsrNombre(), usr.getUsrAcceso(), cadena);
                //Validando el codigo de acceso del usuario
//                validarCodigoAcceso(cadena, usr.getUsrNombre());
                UtilidadesManejador.redireccion("validacion");
            }
        }
    }

    //Verficia el codigo del doble factor de autenticacion y cierra la sesion si es erroneo
    public void doblefactor() {
        log.debug("Validando el codigo de seguridad");

        if (cadena.equalsIgnoreCase(usuario.getCodigo())) {
            UtilidadesManejador.redireccion("index");
        } else {
            UtilidadesManejador.lanzarAdvertencia("Codigo invalido", "Porfavor increse el codigo valido");
        }        
    }


    public String codigoAcceso() {
        log.debug("Preparando cadena de seguridad");
        //Variables para Generar el ID de Forma Aleatoria
        Random aleatorio = new Random();
        final String CODIGO_TOKEN = "AB7CDE0FG9HIJK2LMN6OPQRST8UVW4XY5Z163@#%+*";
        final byte NIVEL_SEGURIDAD = 7; //cantidad de caracteres para el codigo
        String cadena = ""; //Cadena de seguridad

        //Preparando la cadena
        for (int i = 1; i < NIVEL_SEGURIDAD; i++) {
            //Método para el Cálculo de las letras
            byte caracter = (byte) (aleatorio.nextDouble() * CODIGO_TOKEN.length() - 1 + 0);
            cadena = cadena + CODIGO_TOKEN.charAt(caracter);
        }
        return cadena;
    }

    //funicon para enviar correo electronico del codigo de seguridad previamente establecido
    public void enviarCorreo(String nombre, String correo, String codigo) {
        EncriptacionTexto encriptacionTexto = new EncriptacionTexto();
        //Obteniendo la configuracion de la base de datos
        List<Configuracion> datos = configuracionControlador.encontrarEntidades();
        //Combirtiendo la lista a tipo configuracion
        Configuracion con = datos.get(0);
        log.debug("Preparando envio de correo electronico de seguridad");
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName(encriptacionTexto.getTextoDesencriptado(con.getConServer()));
            email.setSmtpPort(Integer.parseInt(encriptacionTexto.getTextoDesencriptado(con.getConPort())));
            email.setAuthenticator(new DefaultAuthenticator(
                    encriptacionTexto.getTextoDesencriptado(con.getConCorreo()),
                    encriptacionTexto.getTextoDesencriptado(con.getConPcorreo())));
            email.setSSLOnConnect(true);
            email.setFrom(encriptacionTexto.getTextoDesencriptado(con.getConCorreo()));
            email.setSubject("Autenticacion de dos pasos");
            email.setHtmlMsg("<h1>Gracias por utilizar nuestros sistemas " + nombre + "\n </h1> "
                    + "<p>Hay un intento de inicio de sesión a su sistema de Human Resources</p>"
                    + "<h3>Su codigo de acceso a la plataforma es: <strong>" + codigo + "</strong></h3> \n "
                    + "<p><b>Si usted no solicito este acceso porfavor ignore este correo.</b></p>"
                    + "<p>Has recibido este e-mail porque tienes una cuenta registrada en Human Resources System</p>"
                    + "<h4>Por su seguirdad nunca comparta este correo electronico con nadie.</h4>"
                    + "<p>&copy; 2020 Human Resources System<p>");
            email.addTo(correo);
            log.debug("Enviando correo electronico");
            email.send();
        } catch (EmailException ex) {

        }
    }

    //Valida si el usuario tiene sesion o no 
    public void validarSesion() {
        //Si el usuario no tiene rol, redireccionamos al login 
        if (usuario.getRol() == null || usuario.getRol() == 0) {
            UtilidadesManejador.redireccionLogin();
        }
    }

    public void cerrarSesion() {
        usuario.setRol(null);
        UtilidadesManejador.redireccionLogin();
    }

    public UsrUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(UsrUsuario usuario) {
        this.usuario = usuario;
    }

}
