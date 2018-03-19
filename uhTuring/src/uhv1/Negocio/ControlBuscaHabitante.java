
package uhv1.Negocio;

import uhv1.Persistencia.DAOHabitantes;
import uhv1.Vistas.VentanaBuscaHabitante;
import uhv1.Vistas.VentanaNoEncontrado;

/**
 *
 * @author darky
 */

public class ControlBuscaHabitante {
    DAOHabitantes daores;
    
    /* Este es el constructor que recibe el dao habitantes */
    public ControlBuscaHabitante(DAOHabitantes daores){
         this.daores = daores;
    }
    
    /* Este metodo recibe mensaje de control ventana habitante y despliega la ventana busca habitante*/
    public void inicia(){
        VentanaBuscaHabitante ventHab= new VentanaBuscaHabitante(this);
        ventHab.setVisible(true);
    }
    
    /* Este metodo recibe mensaje de la ventana busca habitante con el nombre y el apellido paterno del
    habitante a buscar, este le envia un mensaje al dao con estos datos para buscar al habitante*/
    public void buscaH(String nombre, String aPat){
        Responsable res;
        /* Se envia mensaje al dao habitante con los datos del habitante a buscar */
        res = daores.buscaHabitante(nombre, aPat);
        if(res == null){
            /*Si no se encontro el habitante buscado, se envia mensaje a la ventana no encontrado, para
            desplegar una alerta */
            VentanaNoEncontrado vent = new VentanaNoEncontrado(this);
            vent.setVisible(true);
        }else{
            System.out.println(res.getNombre() + res.getaPat() + res.getaMat() );
            /* Se encontro el habitante, y se crea una instancia de control gestion
            habitante con el habitante encontrado y el dao responsable, y lo inicia*/
            ControlGestionHabitante controlgestiona = new ControlGestionHabitante(res, daores);
            controlgestiona.inicia();
        }
        
    }
    
    /*Este metodo recibe un mensaje de Ventana no encontrado para regresar a la ventana habitante, 
    ya que no se encontro un habitante con los datos dados */
    public void regresaVentHabitante(){
        ControlVentanaHabitante CVH = new ControlVentanaHabitante();
        CVH.inicia();
    }
}
