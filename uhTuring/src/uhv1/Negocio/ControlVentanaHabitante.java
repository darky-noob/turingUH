 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import uhv1.Persistencia.DAOCasa;
import uhv1.Persistencia.DAOHabitantes;
import uhv1.Vistas.VentanaHabitante;

/**
 *
 * @author darky
 */
public class ControlVentanaHabitante {
    DAOHabitantes daohab;
    DAOCasa daocasa;
    
    public ControlVentanaHabitante(){
        this.daohab = new DAOHabitantes();
        this.daocasa = new DAOCasa();
    }
    public void  inicia(){
        VentanaHabitante vent = new VentanaHabitante(this);
        vent.setVisible(true);
    }
    
     public void controlAlta() {
        //System.out.println("Estas en agregar habitante");
        ControlAgregarHabitante controlAlta = new ControlAgregarHabitante(daohab, daocasa);
        controlAlta.inicia();
    }

    public void controlCasa() {
        System.out.println("Estas en agregar casa");
        ControlAgregarCasa controlCasa = new ControlAgregarCasa(daocasa);
        controlCasa.inicia();
    }
    
    /* Este metodo recibe el mensaje de ventana habitante y evia mensaje a control busca habitante he inicia
    dicho control pasando como parametros a su contructor el dao habitante */
    public void controlBusca(){
        ControlBuscaHabitante controlBusca = new ControlBuscaHabitante(daohab);
        controlBusca.inicia();
    }
}
