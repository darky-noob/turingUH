package uhv1.Negocio;

import uhv1.Persistencia.DAOEvento;
import uhv1.Persistencia.DAOHabitantes;
import uhv1.Vistas.VentanaEventos;

/**
 *
 * @author darky
 */
public class ControlVentanaEvento {
    
     DAOEvento daoeventos;
    DAOHabitantes daohabitante;

    public ControlVentanaEvento() {
        this.daoeventos = daoeventos;
        this.daohabitante = daohabitante;
    }
    public void inicia(){
        ControlBuscaEvento busca_evento = new ControlBuscaEvento(daoeventos);
        VentanaEventos VE = new VentanaEventos(busca_evento);
        VE.setVisible(true);
    }
    
}
