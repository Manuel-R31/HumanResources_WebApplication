/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.manejadores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.bitlab.controladores.EstadoDepartamentoControlador;
import sv.bitlab.entidades.EstadoDepartamento;

/**
 *
 * @author Manuel
 */
@ManagedBean
@ViewScoped
public class EstadoDepartamentoManejador extends ManejadorAbstracto<EstadoDepartamento>{

    private EstadoDepartamentoControlador estadoDepartamentoControlador;
    
    public EstadoDepartamentoManejador() {
        super(EstadoDepartamento.class);
        estadoDepartamentoControlador = new EstadoDepartamentoControlador();
    }

    @Override
    public EstadoDepartamentoControlador getControlador() {
        return estadoDepartamentoControlador;
    }
    
    
    
    
}
