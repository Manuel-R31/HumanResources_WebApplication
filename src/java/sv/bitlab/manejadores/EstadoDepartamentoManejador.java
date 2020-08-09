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
import sv.bitlab.controladores.EstadoDepartamentoControlador;
import sv.bitlab.entidades.Departamento;
import sv.bitlab.entidades.EstadoDepartamento;

/**
 *
 * @author Manuel
 */
@ManagedBean
@ViewScoped
public class EstadoDepartamentoManejador extends ManejadorAbstracto<EstadoDepartamento>{

    private EstadoDepartamentoControlador estadoDepartamentoControlador = new EstadoDepartamentoControlador();
    private List<EstadoDepartamento> estadoDepList;
    private Departamento departamento = new Departamento();
    private EstadoDepartamento estadoDepartamento = new EstadoDepartamento();
    
    @PostConstruct
    public void CargarEstadosDep(){
        estadoDepList = estadoDepartamentoControlador.encontrarEntidades();
    }

    public EstadoDepartamentoControlador getEstadoDepartamentoControlador() {
        return estadoDepartamentoControlador;
    }

    public void setEstadoDepartamentoControlador(EstadoDepartamentoControlador estadoDepartamentoControlador) {
        this.estadoDepartamentoControlador = estadoDepartamentoControlador;
    }
    
    public EstadoDepartamentoManejador() {
        super(EstadoDepartamento.class);
        estadoDepartamentoControlador = new EstadoDepartamentoControlador();
    }

    @Override
    public EstadoDepartamentoControlador getControlador() {
        return estadoDepartamentoControlador;
    }

    public List<EstadoDepartamento> getEstadoDepList() {
        return estadoDepList;
    }

    public void setEstadoDepList(List<EstadoDepartamento> estadoDepList) {
        this.estadoDepList = estadoDepList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public EstadoDepartamento getEstadoDepartamento() {
        return estadoDepartamento;
    }

    public void setEstadoDepartamento(EstadoDepartamento estadoDepartamento) {
        this.estadoDepartamento = estadoDepartamento;
    }
    
    
    
    
}
