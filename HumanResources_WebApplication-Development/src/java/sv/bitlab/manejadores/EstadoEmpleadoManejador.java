/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sv.bitlab.manejadores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.bitlab.controladores.EstadoEmpleadoControlador;
import sv.bitlab.entidades.EstadoEmpleado;

/**
 *
 * @author Manuel
 */
@ManagedBean
@ViewScoped
public class EstadoEmpleadoManejador extends ManejadorAbstracto<EstadoEmpleado> {
    
    private EstadoEmpleado estadoEmpleado = new EstadoEmpleado();
    private EstadoEmpleadoControlador estadoEmpleadoControlador = new EstadoEmpleadoControlador();;

    
    public EstadoEmpleadoManejador() {
        super(EstadoEmpleado.class);
        estadoEmpleado = new EstadoEmpleado();
    }

    
    @Override
    public EstadoEmpleadoControlador getControlador() {
        return estadoEmpleadoControlador;
    }
    
        
    public EstadoEmpleado getEstadoEmpleado() {
        return estadoEmpleado;
    }
    
    public void setEstadoEmpleado(EstadoEmpleado estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public EstadoEmpleadoControlador getEstadoEmpleadoControlador() {
        return estadoEmpleadoControlador;
    }

    public void setEstadoEmpleadoControlador(EstadoEmpleadoControlador estadoEmpleadoControlador) {
        this.estadoEmpleadoControlador = estadoEmpleadoControlador;
    }
    
    
    
}
