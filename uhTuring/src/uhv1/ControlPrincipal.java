/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1;

import uhv1.Negocio.ControlVentanaEvento;
import uhv1.Negocio.ControlVentanaHabitante;
import uhv1.Negocio.ControlVentanaTarjeton;
import uhv1.Vistas.VentanaPrincipal;
import uhv1.Persistencia.ManejadorBD;

/**
 *
 * @author darky
 */
public class ControlPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
	ControlPrincipal app = new ControlPrincipal(); // Crea la instancia de la aplicacion
	app.inicia(); // Inicia la aplicacion
    }
    
    public void inicia(){
        System.out.println("La aplicacion ha iniciado...");
        VentanaPrincipal ventanaP = new VentanaPrincipal(this);
        ventanaP.setVisible(true);
        
    }
    
    public void controlHabitante(){
        ControlVentanaHabitante controlVH = new ControlVentanaHabitante();
        controlVH.inicia();
    }
    
    public void controlEventos(){
        ControlVentanaEvento CVE = new ControlVentanaEvento();
        CVE.inicia();
    }
    
    public void controlTarjeton(){
        ControlVentanaTarjeton CVT = new ControlVentanaTarjeton();
        CVT.inicia();
    }
    
}
