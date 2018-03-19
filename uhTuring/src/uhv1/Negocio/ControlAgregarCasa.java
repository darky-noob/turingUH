package uhv1.Negocio;

import java.sql.SQLException;
import uhv1.ControlPrincipal;
import uhv1.Persistencia.DAOCasa;
import uhv1.Vistas.VentanaAgregarCasa;

public class ControlAgregarCasa {

    private final DAOCasa daocasa;


    /*Constructor de la clase*/
    public ControlAgregarCasa(DAOCasa daocasa) {

        this.daocasa = daocasa;

    }

    public void inicia() {

        VentanaAgregarCasa ventanaCasa = new VentanaAgregarCasa(this);
        ventanaCasa.setVisible(true); // En este momento aparece la ventana principal
    }

    public void agregarCasa(String seccion, int numero) throws SQLException {

        Casa casa = new Casa(seccion, numero);
        daocasa.registraCasa(casa);

    }

    public void regresaVentanaHabitante() {
        ControlVentanaHabitante guardo = new ControlVentanaHabitante();
        guardo.inicia();
    }

    public void botonCancelar() {
        ControlVentanaHabitante cancelo = new ControlVentanaHabitante();
        cancelo.inicia();
    }

}
