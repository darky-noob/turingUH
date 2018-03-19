
package uhv1.Negocio;
import java.sql.SQLException;
import javax.swing.JFrame;
import uhv1.Persistencia.DAOCasa;
import uhv1.Persistencia.DAOHabitantes;
import uhv1.Vistas.DialogoSeleccionCasa;
import uhv1.Vistas.VentanaAltaHabitante;

public class ControlAgregarHabitante {
    
    private final DAOHabitantes daohabitante;
    private final DAOCasa casa;

    /*Constructor de la clase ControlAgregarHabitante*/
    public ControlAgregarHabitante(DAOHabitantes daohabitante, DAOCasa casa) {
        this.daohabitante = daohabitante;
        this.casa = casa;
    }

    public void inicia() {

        VentanaAltaHabitante ventanaAlta = new VentanaAltaHabitante(this);
        ventanaAlta.setVisible(true); // En este momento aparece la ventana principal
    }//fin del incia

    public Casa buscarCasa() {
        Casa arregloCasas[] = casa.dameCasas(); // Obtiene lista de casas
        DialogoSeleccionCasa dialogo = new DialogoSeleccionCasa(new JFrame(), arregloCasas); // Crea el dialogo con la lista de casas
        dialogo.setVisible(true); // Muestra el dialogo
        return dialogo.getCasaSeleccionada(); // Regresa la casa seleccionada en el dialogo }

    }

    public Casa[] dameCasas() {

        Casa casaTemp[] = casa.dameCasas();

        return casaTemp;

    }

    public void agregarHabitante(String nombre, String aPaterno, String aMaterno, float saldo,  Casa casa,float telefono) throws SQLException {

        Responsable habitante = new Responsable(0, nombre, aPaterno, aMaterno, telefono,casa,saldo);
        daohabitante.registraHabitante(habitante);

    }
    
     public void regresaVentanaHabitante(){
        ControlVentanaHabitante registro = new ControlVentanaHabitante();
        registro.inicia();
    }
    public void botonCancelar(){
         ControlVentanaHabitante cancelo = new ControlVentanaHabitante();
        cancelo.inicia();
    }
    
}
