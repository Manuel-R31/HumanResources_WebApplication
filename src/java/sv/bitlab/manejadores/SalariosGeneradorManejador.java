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
import sv.bitlab.controladores.EmpleadoControlador;
import sv.bitlab.controladores.SalarioControlador;
import sv.bitlab.entidades.Empleado;
import sv.bitlab.entidades.SalSalario;

/**
 *
 * @author carlosGodoy
 */
@ManagedBean
@ViewScoped
public class SalariosGeneradorManejador {
    private List<SalSalario> salarioLista;
    private EmpleadoControlador empControlador = new EmpleadoControlador();
    private SalSalario salario;
    private SalarioControlador salarioControlador = new SalarioControlador();
    private Empleado empleado = new Empleado();
    
   
    @PostConstruct
    public void cargarInfo(){
        
        salarioLista = salarioControlador.encontrarEntidades();
    
    }

    public List<SalSalario> getSalarioLista() {
        return salarioLista;
    }

    public void setSalarioLista(List<SalSalario> salarioLista) {
        this.salarioLista = salarioLista;
    }

    public EmpleadoControlador getEmpControlador() {
        return empControlador;
    }

    public void setEmpControlador(EmpleadoControlador empControlador) {
        this.empControlador = empControlador;
    }
    
    
    
}
