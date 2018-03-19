package uhv1.Negocio;

import uhv1.ControlPrincipal;
import uhv1.Persistencia.DAOEvento;
import uhv1.Vistas.VentanaGestionEvento;


public class ControlGestionEvento {
    
    Evento even;
    DAOEvento dahoeven;

    public ControlGestionEvento(Evento even, DAOEvento dahoeven) {
        this.even = even;
        this.dahoeven = dahoeven;
    }
    
     public void inicia(){
        System.out.println("DESDE Inicia: " + even.getNombre());
        VentanaGestionEvento ventGes = new VentanaGestionEvento(this, even);
        ventGes.setVisible(true);
    }
    
     public void bajaEvento(){
        ControlBajaEvento bajaEvent = new ControlBajaEvento(dahoeven, even);
        bajaEvent.inicia();
     }
     
     public void botonCancelar(){
         ControlPrincipal ctrlPrincipal = new ControlPrincipal();
         ctrlPrincipal.inicia();
     }
}
