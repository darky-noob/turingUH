/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import uhv1.ControlPrincipal;
import uhv1.Persistencia.DAOEvento;
import uhv1.Vistas.VentanaBajaEventConfirma;
import uhv1.Vistas.VentanaBajaEvento;

/**
 *
 * @author Jose Luis
 */

public class ControlBajaEvento {
    DAOEvento dahoeven;
    Evento even;
    
    public ControlBajaEvento(DAOEvento dahoeven, Evento even){
        this.dahoeven = dahoeven;
        this.even = even;    
    }
    
    public void inicia(){
        VentanaBajaEvento bajaEvent = new VentanaBajaEvento(this);
        bajaEvent.setVisible(true);
    }
    
    public void aceptaBaja(){
        boolean resultado;
        resultado = dahoeven.eliminaEvent(even);
        if(resultado){
            VentanaBajaEventConfirma ventAcept = new VentanaBajaEventConfirma(this);
            ventAcept.setVisible(resultado);
        
        }else{
            System.out.println("Hubo un error al eliminar");
        
        }
    }
    
    public void regresaPrincipal(){
        ControlPrincipal con = new ControlPrincipal();
        con.inicia();
    }
    
    public void botonCancelar(){
        ControlPrincipal ctrlPrincipal = new ControlPrincipal();
        ctrlPrincipal.inicia();
    }
    
}
