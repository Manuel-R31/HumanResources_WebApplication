/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.manejadores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.bitlab.controladores.ControladorAbstracto;
import sv.bitlab.controladores.EmpleadoControlador;
import sv.bitlab.controladores.PlanillaControlador;
import sv.bitlab.entidades.Empleado;
import sv.bitlab.entidades.Planilla;
import sv.bitlab.utilidades.UtilidadesManejador;

/**
 *
 * @author Oscar
 */
@ManagedBean
@ViewScoped
public class planillaManejador extends ManejadorAbstracto<Planilla>{

    PlanillaControlador planillaControlador = new PlanillaControlador();
    EmpleadoControlador empleadoControlador = new EmpleadoControlador();
    private Date fecha_inicio;
    private Date fecha_fin;
    private String codigo;
    Empleado empleado = new Empleado();
    
    public planillaManejador() {
        super(Planilla.class);
    }

    public void generarPlanilla(){
        try {
            
            //Buscar todos los empleados que tengan estado activo y Obtener salario de los empleados
            List<Empleado> emp = empleadoControlador.empleadoPlanilla();
            
            
            List<Planilla> planilla = new ArrayList();
            
            //Recorrer la lista de empleados y preparar para guarrdar registro en planilla
            for(Empleado e: emp){
                Planilla pla = new Planilla();
                //Obtner salario de empleado
                double salario = (double) e.getEmpSalario();
                //Realizar calculos para planilla
                double isssPersonal = calculoIsssPersonal(salario);
                double isssPatronal = calculoIsssPatronal(salario);
                double afpPersonal = calculoAfpPersonal(salario);
                double afpPatronal = calculoAfpPatronal(salario);
                double isr = calculoRenta(salario, afpPersonal, isssPersonal);
                double totalPagar = salario - (isssPersonal+ afpPersonal +isr);
                
                System.out.println("isssPersonal "+ isssPersonal );
                System.out.println("isssPatronal "+ isssPatronal );
                System.out.println("afpPersonal "+ afpPersonal );
                System.out.println("afpPatronal "+ afpPatronal );
                System.out.println("isr "+ isr );
                System.out.println("totalPagar "+ totalPagar );
                //Agregando datos a la planilla;
                pla.setPlaCodigo(codigo);
                pla.setPlaSalarioNeto((float)salario);
                pla.setPlaAfpPatronal((float) afpPatronal );
                pla.setPlaAfpLaboral( (float)afpPersonal);
                pla.setPlaIsssPatronal((float) isssPatronal);
                pla.setPlaIsssLaboral((float) isssPersonal);
                pla.setPlaRenta((float) isr);
                pla.setPlaTotalPagar( (float) totalPagar);
                System.out.println ("fecha inicio "+ fecha_inicio);
                System.out.println("fecha inicio "+fecha_fin);
                System.out.println("codio "+codigo);
                pla.setPlaFechaInicio(fecha_inicio);
                pla.setPlaFechaFin(fecha_fin);
                pla.setPlaAfpLaboral( (float)afpPersonal);
                pla.setEmpId(empleadoControlador.encontrar(e.getEmpId()));
                //Agregando planilla a lista para guardar
                planilla.add(pla);  
            }
            //Guardar consulta 
            planillaControlador.crear(planilla);
            UtilidadesManejador.lanzarInfo("Generacion exitosa", "Se ha generado la planilla correctamente");
        } catch (Exception ex) {
            Logger.getLogger(planillaManejador.class.getName()).log(Level.SEVERE, null, ex);
            UtilidadesManejador.lanzarError("Error en la generacion", "La planilla no se ha generado correctamente");
        }
    }
    
    public Double calculoIsssPatronal(Double salario){
        Double IsssPatronal = salario * 0.075;
        if (IsssPatronal > 75) 
            IsssPatronal = 75.00;
        return IsssPatronal;
    }
    
    public Double calculoIsssPersonal(Double salario){
        Double IsssPersonal = salario * 0.03;
        if (IsssPersonal > 30) 
            IsssPersonal = 30.00;
        
        return IsssPersonal;
    }
    
     public Double calculoAfpPatronal(Double salario){
         Double AfpPatronal = salario * 0.0775;
        return AfpPatronal;
    }
    
    public Double calculoAfpPersonal(Double salario){
        Double AfpPersonal = salario * 0.0725;
        return AfpPersonal;
    }
    
    public Double calculoRenta(Double salario, Double afp, Double isss){
        Double salarioNominal = salario - (afp+isss);
        Double isr = 0.00;
        if (salarioNominal <= 472.00) {
            isr = 0.00;
        }else if (salarioNominal > 472.00 && salarioNominal <= 895.24) {
            isr = ((salarioNominal - 472.00) * 0.1) + 17.67;
        }else if (salarioNominal > 895.24 && salarioNominal <= 2038.10) {
            isr = ((salarioNominal - 895.24) * 0.2) + 60.00;
        }else if (salarioNominal > 2038.10) {
            isr = ((salarioNominal - 2038.10) * 0.3) + 288.57;
        }
        return isr;
    }
    
    @Override
    public ControladorAbstracto<Planilla> getControlador() {
        return planillaControlador;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
}
