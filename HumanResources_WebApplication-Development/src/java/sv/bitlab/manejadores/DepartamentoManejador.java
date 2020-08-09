/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sv.bitlab.manejadores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.bitlab.controladores.DepartamentoControlador;
import sv.bitlab.controladores.EstadoDepartamentoControlador;
import sv.bitlab.entidades.Departamento;

/**
 *
 * @author Manuel
 */
@ManagedBean
@ViewScoped
public class DepartamentoManejador extends ManejadorAbstracto<Departamento>{
    
    private Departamento departamento = new Departamento();
    private DepartamentoControlador departamentoControlador;
    private EstadoDepartamentoControlador estadoDepartamentoControlador = new EstadoDepartamentoControlador();
    
    
    public DepartamentoManejador() {
        super(Departamento.class);
        departamentoControlador = new DepartamentoControlador();
    }
    
    @Override
    public DepartamentoControlador getControlador() {
        return departamentoControlador;
    }
    
    public DepartamentoControlador getDepartamentoControlador() {
        return departamentoControlador;
    }
    
    public void setDepartamentoControlador(DepartamentoControlador departamentoControlador) {
        this.departamentoControlador = departamentoControlador;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public EstadoDepartamentoControlador getEstadoDepartamentoControlador() {
        return estadoDepartamentoControlador;
    }

    public void setEstadoDepartamentoControlador(EstadoDepartamentoControlador estadoDepartamentoControlador) {
        this.estadoDepartamentoControlador = estadoDepartamentoControlador;
    }
    
    
}
