package uhv1.Negocio;

import uhv1.Persistencia.DAOPagoHabitante;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uhv1.ControlPrincipal;

public class ControlPagoHabitante{
    
    
    public ControlPagoHabitante(){//constructor vacío por default
    }

    public ControlPagoHabitante(Responsable hab){   //Constructor que recibe al habitante e inicia el flujo de Pago de manto.  
        ControlVentanaPagoHabitante cvph = new ControlVentanaPagoHabitante(hab); // se llama al control para generar la ventana de pago
    }
    
    public void ControlInsertaPagoDAO(Responsable hab, float monto) throws SQLException {//Recibe los datos del habitante y monto del control de ventana
        DAOPagoHabitante daoph = new DAOPagoHabitante(hab, monto);//Envia los datos del pago al DAO de Pago
    }
    
    public void ResultadoCorrectoDAO(int res){//Recibe retroalimentación del pago correcto y lo envia a la ventana
        ControlVentanaPagoHabitante cvph = new ControlVentanaPagoHabitante();
        if (res==0) {
            cvph.AvisoFracaso();
        }
        else{
            cvph.AvisoExito();
        }
        ControlPrincipal CP = new ControlPrincipal();
        CP.inicia();
    }
}

