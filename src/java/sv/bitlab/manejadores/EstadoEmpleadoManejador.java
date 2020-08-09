/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.manejadores;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.bitlab.controladores.EstadoEmpleadoControlador;
import sv.bitlab.entidades.Empleado;
import sv.bitlab.entidades.EstadoEmpleado;
import sv.bitlab.entidades.Usuario;

/**
 *
 * @author Manuel
 */
@ManagedBean
@ViewScoped
public class EstadoEmpleadoManejador extends ManejadorAbstracto<EstadoEmpleado> {
    
    private Empleado empleado = new Empleado();
    private EstadoEmpleado estadoEmpleado = new EstadoEmpleado();
    private List<EstadoEmpleado> estadoEmpList;
    private EstadoEmpleadoControlador estadoEmpleadoControlador = new EstadoEmpleadoControlador();

    public EstadoEmpleadoManejador() {
        super(EstadoEmpleado.class);
    }

    public void setEstadoEmpleadoControlador(EstadoEmpleadoControlador estadoEmpleadoControlador) {
        this.estadoEmpleadoControlador = estadoEmpleadoControlador;
    }

    @PostConstruct
    public void cargarEstEmpleList(){
        estadoEmpList = estadoEmpleadoControlador.encontrarEntidades();
    }
    
    @Override
    public EstadoEmpleadoControlador getControlador() {
        return estadoEmpleadoControlador;
    }

    public List<EstadoEmpleado> getEstadoEmpList() {
        return estadoEmpList;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public EstadoEmpleado getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(EstadoEmpleado estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    
    
    public void setEstadoEmpList(List<EstadoEmpleado> estadoEmpList) {
        this.estadoEmpList = estadoEmpList;
    }

    
    
}
