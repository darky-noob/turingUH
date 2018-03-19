
package uhv1.Negocio;

import uhv1.Persistencia.DAOEvento;
import uhv1.Vistas.VentanaBuscaEvento;

/**
 *
 * @author Jose Luis
 */
public class ControlBuscaEvento {
    
    DAOEvento daoeven;

    /* Este es el constructor que recibe el dao eventos*/
    public ControlBuscaEvento(DAOEvento daoeven) {
        this.daoeven = daoeven;
    }

    /* Este metodo recibe mensaje de control ventana evento y despliega la ventana busca evento*/
    public void inicia() {
        VentanaBuscaEvento ventEven = new VentanaBuscaEvento(this);
        ventEven.setVisible(true);
    }

    /* Este metodo recibe mensaje de la ventana busca evento con el nombre del evento 
    a buscar, este le envia un mensaje al dao con estos datos para buscar al evento*/
    
    public void buscaEvento(String nombre) {
        Evento even;
        /* Se envia mensaje al dao evento con los datos del evento a buscar */
        even = daoeven.buscaEvento(nombre);
        if (even == null) {
            /*Si no se encontro el evento buscado, se envia mensaje a la ventana no encontrado, para
             desplegar una alerta */
            // VentanaNoEncontrado vent = new VentanaNoEncontrado(this);
            //vent.setVisible(true);
        } else {
            System.out.println(even.getNombre() + even.getDescripcion() + even.getFechaReservacion());
            /* Se encontro el evento, y se crea una instancia de control gestion
             evento con el evento encontrado*/
            ControlGestionEvento controlgestiona = new ControlGestionEvento(even, daoeven);
            controlgestiona.inicia();
        }

    }

    /*Este metodo recibe un mensaje de Ventana no encontrado para regresar a la ventana evento, 
     ya que no se encontro un evento con los datos dados */
    public void regresaVentEvento() {
        ControlVentanaEvento CVH = new ControlVentanaEvento();
        CVH.inicia();
    }
}
