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
import sv.bitlab.controladores.CargoControlador;
import sv.bitlab.controladores.DepartamentoControlador;
import sv.bitlab.controladores.EstadoCivilControlador;
import sv.bitlab.controladores.EstadoEmpleadoControlador;
import sv.bitlab.controladores.SexoControlador;
import sv.bitlab.entidades.Cargo;
import sv.bitlab.entidades.Departamento;

import sv.bitlab.entidades.EstadoEmpleado;
import sv.bitlab.entidades.Estadocivil;
import sv.bitlab.entidades.Sexo;

/**
 *
 * @author carlosGodoy
 */
@ManagedBean
@ViewScoped
public class FKmanejador {
    private List<Cargo> cargoList;
    private List<Sexo> sexoList;
    private List<Estadocivil> estadoCivil;
    private List<EstadoEmpleado> estadoEmpleadoList;
    private List<Departamento> departamentoList;
    
    private CargoControlador cargoController = new CargoControlador();
    private SexoControlador sexoContorller = new SexoControlador();
    private EstadoCivilControlador EstadoCivilController = new EstadoCivilControlador();
    private EstadoEmpleadoControlador estadoEmpladoController = new EstadoEmpleadoControlador();
    private DepartamentoControlador departamentoController = new DepartamentoControlador();
    
    @PostConstruct
    public void cargarInfo(){
        cargoList = cargoController.encontrarEntidades();
        sexoList = sexoContorller.encontrarEntidades();
        estadoCivil = EstadoCivilController.encontrarEntidades();
        estadoEmpleadoList = estadoEmpladoController.encontrarEntidades();
        departamentoList = departamentoController.encontrarEntidades();
    
    }
    
    
    

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    public List<Sexo> getSexoList() {
        return sexoList;
    }

    public void setSexoList(List<Sexo> sexoList) {
        this.sexoList = sexoList;
    }

    public List<Estadocivil> getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(List<Estadocivil> estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    

    public List<EstadoEmpleado> getEstadoEmpleadoList() {
        return estadoEmpleadoList;
    }

    public void setEstadoEmpleadoList(List<EstadoEmpleado> estadoEmpleadoList) {
        this.estadoEmpleadoList = estadoEmpleadoList;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public CargoControlador getCargoController() {
        return cargoController;
    }

    public void setCargoController(CargoControlador cargoController) {
        this.cargoController = cargoController;
    }

    public SexoControlador getSexoContorller() {
        return sexoContorller;
    }

    public void setSexoContorller(SexoControlador sexoContorller) {
        this.sexoContorller = sexoContorller;
    }

    public EstadoCivilControlador getEstadoCivilController() {
        return EstadoCivilController;
    }

    public void setEstadoCivilController(EstadoCivilControlador EstadoCivilController) {
        this.EstadoCivilController = EstadoCivilController;
    }

    public EstadoEmpleadoControlador getEstadoEmpladoController() {
        return estadoEmpladoController;
    }

    public void setEstadoEmpladoController(EstadoEmpleadoControlador estadoEmpladoController) {
        this.estadoEmpladoController = estadoEmpladoController;
    }

    public DepartamentoControlador getDepartamentoController() {
        return departamentoController;
    }

    public void setDepartamentoController(DepartamentoControlador departamentoController) {
        this.departamentoController = departamentoController;
    }
    
    
    
    
    
}
