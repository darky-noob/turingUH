
package uhv1.Negocio;

import uhv1.Vistas.VentanaPagoHabitante;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControlVentanaPagoHabitante {
    
    
    public ControlVentanaPagoHabitante(){//constructor por default
    }
    //Contructor que recibe los datos del habitante que incluyen los datos de la casa
    public ControlVentanaPagoHabitante(Responsable hab){
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new VentanaPagoHabitante(hab).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ControlPagoHabitante.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    //Recibe de la ventana los datos sobre el pago y los envía al control de Pago para que este utilice el DAO
    public void RecibeFormulario(Responsable hab, float monto) throws SQLException{
        ControlPagoHabitante cph = new ControlPagoHabitante();
        cph.ControlInsertaPagoDAO(hab,monto);
        
    }
    
    public void AvisoExito(){//Ejecuta del control en caso de exito en el pago
        JOptionPane.showMessageDialog(null, "Se realizó el registro correcto del Pago al habitante.", "Aviso:",JOptionPane.INFORMATION_MESSAGE);  
    }
    
    public void AvisoFracaso(){//Ejecuta del control en caso de fracaso en el pago
        JOptionPane.showMessageDialog(null, "No realizó el registro correcto del Pago al habitante.", "Aviso:",JOptionPane.WARNING_MESSAGE);
    }
    
}
