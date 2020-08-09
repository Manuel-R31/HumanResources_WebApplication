/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.bitlab.manejadores;

import sv.bitlab.conexion.Conexion;
import sv.bitlab.controladores.ConfiguracionControlador;
import sv.bitlab.controladores.ControladorAbstracto;
import sv.bitlab.entidades.Configuracion;

/**
 *
 * @author Oscar
 */
public class ConfiguracionManejador extends ManejadorAbstracto<Configuracion>{

  private ConfiguracionControlador configuracionControlador = new ConfiguracionControlador();

    public ConfiguracionManejador() {
        super(Configuracion.class);
    }

    @Override
    public ControladorAbstracto<Configuracion> getControlador() {
       return configuracionControlador;
    }
  
    
}
