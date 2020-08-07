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
import javax.faces.bean.ViewScoped;
import sv.bitlab.controladores.PlanillaControlador;
import sv.bitlab.entidades.Planilla;
import sv.bitlab.utilidades.UtilidadesManejador;

/**
 *
 * @author carlosGodoy
 */
@ManagedBean
@ViewScoped
public class GenerarPlanilla {
    private Planilla planilla = new Planilla();
    private PlanillaControlador plaControlador = new PlanillaControlador();
    private List<Planilla> planillaLista;
    
    @PostConstruct
    public void cargarInfo(){
        planillaLista = plaControlador.encontrarEntidades();
    }

    public List<Planilla> getPlanillaLista() {
        return planillaLista;
    }

    public void setPlanillaLista(List<Planilla> planillaLista) {
        this.planillaLista = planillaLista;
    }

    
    
    
    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    public PlanillaControlador getPlaControlador() {
        return plaControlador;
    }

    public void setPlaControlador(PlanillaControlador plaControlador) {
        this.plaControlador = plaControlador;
    }
    
}
