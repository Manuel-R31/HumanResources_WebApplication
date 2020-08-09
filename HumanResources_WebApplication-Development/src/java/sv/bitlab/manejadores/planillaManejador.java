/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.manejadores;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.bitlab.controladores.ControladorAbstracto;
import sv.bitlab.controladores.EmpleadoControlador;
import sv.bitlab.controladores.PlanillaControlador;
import sv.bitlab.entidades.Empleado;
import sv.bitlab.entidades.Planilla;

/**
 *
 * @author carlosGodoy
 */
public class planillaManejador extends ManejadorAbstracto<Planilla>{

    PlanillaControlador planillaControlador = new PlanillaControlador();
    EmpleadoControlador empleadoControlador = new EmpleadoControlador();
    
    public planillaManejador() {
        super(Planilla.class);
    }

    public void generarPlanilla(){
        try {
            //Buscar todos los empleados que tengan estado activo y Obtener salario de los empleados
            List<Empleado> emp = empleadoControlador.EmpleadoPlanilla();
            List<Planilla> pla = new ArrayList();
            //Recorrer la lista de empleados y preparar para guarrdar registro en planilla
            for(Empleado e: emp){
               
            }
            //Realizar calculos
            
            //Guardar consulta 
        } catch (Exception ex) {
            Logger.getLogger(planillaManejador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Double calculoIsssPatronal(Double Salario){
        
        return 1.0;
    }
    
    public Double calculoIsssPersonal(Double salario){
        Double AfpPatronal = salario * 0.0725;
        return AfpPatronal;
    }
    
     public Double calculoAfpPatronal(Double salario){
         Double AfpPatronal = salario * 0.0775;
        return AfpPatronal;
    }
    
    public Double calculoAfpPersonal(Double salario){
        Double AfpPersonal = salario * 0.0725;
        return AfpPersonal;
    }
    
    public Double calculoRenta(){
        return 1.0;
    }
    
    @Override
    public ControladorAbstracto<Planilla> getControlador() {
        return planillaControlador;
    }
    
}
