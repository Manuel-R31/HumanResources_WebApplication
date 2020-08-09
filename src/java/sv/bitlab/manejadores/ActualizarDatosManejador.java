/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.manejadores;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


import sv.bitlab.controladores.DepartamentoControlador;
import sv.bitlab.controladores.EmpleadoControlador;
import sv.bitlab.controladores.EstadoEmpleadoControlador;
import sv.bitlab.entidades.Departamento;
import sv.bitlab.entidades.Empleado;
import sv.bitlab.entidades.EstadoEmpleado;
import sv.bitlab.utilidades.UtilidadesManejador;

/**
 *
 * @author carlosGodoy
 */
@ManagedBean
@ViewScoped
public class ActualizarDatosManejador {

    private Empleado empleado = new Empleado();
    private EmpleadoControlador empControlador = new EmpleadoControlador();
    private List<Empleado> empleadoLista, empleadoListaActivo, empleadoListaSuspendido,
            empleadoListaDespedido;
    private EstadoEmpleado estadoEmp, estadoA, estadoS, estadoD;
    private List<EstadoEmpleado> estadoEmpList;
    private EstadoEmpleadoControlador estadoEmpleadoControlador = new EstadoEmpleadoControlador();
    
  

    @PostConstruct
    public void cargarInfo() {
        empleadoLista = empControlador.encontrarEntidades();
        try {
            estadoA = estadoEmpleadoControlador.encontrar(1);
            estadoS = estadoEmpleadoControlador.encontrar(2);
            estadoD = estadoEmpleadoControlador.encontrar(3);
            estadoEmpList = estadoEmpleadoControlador.encontrarEntidades();
            empleadoListaActivo = empControlador.EmpleadoPorEstado("Activo");
            empleadoListaSuspendido = empControlador.EmpleadoPorEstado("Suspendido");
            empleadoListaDespedido = empControlador.EmpleadoPorEstado("Despedido");
            
        } catch (Exception ex) {
            Logger.getLogger(ActualizarDatosManejador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   

    public void nuevoEmpleado() {
        empleado = new Empleado();
    }

    public void actualizarEmp() {
        try {
            empControlador.editar(empleado);
            cargarInfo();
            UtilidadesManejador.lanzarInfo("Exito", "Empleado Actualizado");
        } catch (Exception ex) {
            ex.printStackTrace();
            UtilidadesManejador.lanzarError("Error", ex.getMessage());
        }
    }

    public List<Empleado> getEmpleadoListaActivo() {
        return empleadoListaActivo;
    }

    public void setEmpleadoListaActivo(List<Empleado> empleadoListaActivo) {
        this.empleadoListaActivo = empleadoListaActivo;
    }

    public List<Empleado> getEmpleadoListaSuspendido() {
        return empleadoListaSuspendido;
    }

    public void setEmpleadoListaSuspendido(List<Empleado> empleadoListaSuspendido) {
        this.empleadoListaSuspendido = empleadoListaSuspendido;
    }

    public List<Empleado> getEmpleadoListaDespedido() {
        return empleadoListaDespedido;
    }

    public void setEmpleadoListaDespedido(List<Empleado> empleadoListaDespedido) {
        this.empleadoListaDespedido = empleadoListaDespedido;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public EmpleadoControlador getEmpControlador() {
        return empControlador;
    }

    public void setEmpControlador(EmpleadoControlador empControlador) {
        this.empControlador = empControlador;
    }

    public List<Empleado> getEmpleadoLista() {
        return empleadoLista;
    }

    public void setEmpleadoLista(List<Empleado> empleadoLista) {
        this.empleadoLista = empleadoLista;
    }

    public EstadoEmpleado getEstadoEmp() {
        return estadoEmp;
    }

    public void setEstadoEmp(EstadoEmpleado estadoEmp) {
        this.estadoEmp = estadoEmp;
    }

    public EstadoEmpleado getEstadoA() {
        return estadoA;
    }

    public void setEstadoA(EstadoEmpleado estadoA) {
        this.estadoA = estadoA;
    }

    public EstadoEmpleado getEstadoS() {
        return estadoS;
    }

    public void setEstadoS(EstadoEmpleado estadoS) {
        this.estadoS = estadoS;
    }

    public EstadoEmpleado getEstadoD() {
        return estadoD;
    }

    public void setEstadoD(EstadoEmpleado estadoD) {
        this.estadoD = estadoD;
    }

    public List<EstadoEmpleado> getEstadoEmpList() {
        return estadoEmpList;
    }

    public void setEstadoEmpList(List<EstadoEmpleado> estadoEmpList) {
        this.estadoEmpList = estadoEmpList;
    }

    public EstadoEmpleadoControlador getEstadoEmpleadoControlador() {
        return estadoEmpleadoControlador;
    }

    public void setEstadoEmpleadoControlador(EstadoEmpleadoControlador estadoEmpleadoControlador) {
        this.estadoEmpleadoControlador = estadoEmpleadoControlador;
    }

  
    

}
