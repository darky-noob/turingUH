/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import uhv1.Persistencia.DAOHabitantes;
import uhv1.Vistas.VentanaGestionHabitante;

/**
 *
 * @author darky
 */
public class ControlGestionHabitante {
    Responsable res;
    DAOHabitantes daohab;
    
    public ControlGestionHabitante(Responsable res, DAOHabitantes daohab){
        this.res = res;
        this.daohab = daohab;
    }
    
    public void inicia(){
        System.out.println("DESDE Inicia: " + res.getNombre());
        VentanaGestionHabitante ventGes = new VentanaGestionHabitante(this, res);
        ventGes.setVisible(true);
    }
    
    /* Este metodo envia un mensaje a control baja habitante para comenzar el caso de uso baja habitante*/
    public void baja_pulsado(){        
        ControlBajaHabitante var = new ControlBajaHabitante(daohab, res);
        var.inicia();
    }
    
    public void pagaMantenimiento(){
        ControlPagoHabitante cp = new ControlPagoHabitante(res);
    }

    public void modificaHabitante() {
        ControlModificaHabitante cmh = new ControlModificaHabitante(res, daohab);
        cmh.inicia();
    }
    
    public void consultaHistorial(){
        ControlHistorial controlHis = new ControlHistorial();
        controlHis.consultaHistorial(res);
    }
}
