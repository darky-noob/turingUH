/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import uhv1.ControlPrincipal;
import uhv1.Persistencia.DAOHabitantes;
import uhv1.Vistas.VentanaBajaAcep;
import uhv1.Vistas.VentanaBajaHabitante;

/**
 *
 * @author darky
 */
public class ControlBajaHabitante {
    
    DAOHabitantes daoh;
    Responsable res;
    
    /* Este es el constructor que recibe el dao habitante y el obj responsable */
    public ControlBajaHabitante(DAOHabitantes daoh, Responsable res){
        this.daoh = daoh;
        this.res =res;    
    }
    /* Este metodo crea una instancia y envia mensaje a ventana baja habitante para que muestre */
    public void inicia(){
        VentanaBajaHabitante venbaja = new VentanaBajaHabitante(this);
        venbaja.setVisible(true);
    }
    
    /*Este metodo recibe un mensaje de boton pulsado que viene de ventana baja habitante y elimina all habitante*/
    public void aceptapulsado(){
        boolean resultado;
        /*Se envia el mensaje al dao habitantes para que elimine al habitante de la base de datos*/
        resultado = daoh.eliminahab(res);
        if(resultado){
            VentanaBajaAcep ventacp = new VentanaBajaAcep(this);
            ventacp.setVisible(true);
        }else{
            System.out.println("Hubo un error al borrar");
        }
    }
    /* Este metodo recibe un mensaje de ventana baja acept y envia a ventana principal */
    public void regresaPrincipal(){
        ControlPrincipal con = new ControlPrincipal();
        con.inicia();
    }
    /* Este metodo recibe mensaje de ventana baja habitante despues de pulso el boton cancelar 
    y envia a ventana principal*/
    public void botonCancelar(){
        ControlPrincipal bt = new ControlPrincipal();
        bt.inicia();
    }
    
}
