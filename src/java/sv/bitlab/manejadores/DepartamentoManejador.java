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
import sv.bitlab.controladores.DepartamentoControlador;
import sv.bitlab.controladores.EstadoDepartamentoControlador;
import sv.bitlab.entidades.Departamento;
import sv.bitlab.entidades.EstadoDepartamento;

/**
 *
 * @author Manuel
 */
@ManagedBean
@ViewScoped
public class DepartamentoManejador extends ManejadorAbstracto<Departamento>{

    private List<EstadoDepartamento>  estadoDepList;
    private EstadoDepartamentoControlador estadoDepartamentoControlador = new EstadoDepartamentoControlador();
    private DepartamentoControlador departamentoControlador;
    
    
    public DepartamentoManejador() {
        super(Departamento.class);
        departamentoControlador = new DepartamentoControlador();
    }

    @PostConstruct
    public void cargarInfo(){
        estadoDepList = estadoDepartamentoControlador.encontrarEntidades();
    }
    
    @Override
    public DepartamentoControlador getControlador() {
        return departamentoControlador;
    }

    public List<EstadoDepartamento> getEstadoDepList() {
        return estadoDepList;
    }

    public void setEstadoDepList(List<EstadoDepartamento> estadoDepList) {
        this.estadoDepList = estadoDepList;
    }

    public DepartamentoControlador getDepartamentoControlador() {
        return departamentoControlador;
    }

    public void setDepartamentoControlador(DepartamentoControlador departamentoControlador) {
        this.departamentoControlador = departamentoControlador;
    }

}
