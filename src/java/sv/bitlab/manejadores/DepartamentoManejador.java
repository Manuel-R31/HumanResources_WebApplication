/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.manejadores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.bitlab.controladores.DepartamentoControlador;
import sv.bitlab.entidades.Departamento;

/**
 *
 * @author Manuel
 */
@ManagedBean
@ViewScoped
public class DepartamentoManejador extends ManejadorAbstracto<Departamento>{

    private DepartamentoControlador departamentoControlador;
    
    public DepartamentoManejador() {
        super(Departamento.class);
        departamentoControlador = new DepartamentoControlador();
    }

    @Override
    public DepartamentoControlador getControlador() {
        return departamentoControlador;
    }

}
