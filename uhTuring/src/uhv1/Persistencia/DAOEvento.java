
package uhv1.Persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uhv1.Negocio.Casa;
import uhv1.Negocio.Evento;
import uhv1.Negocio.Responsable;

/**
 *
 * @author darky
 */
public class DAOEvento {
    
    public Evento buscaEvento(String nombreEvento) {
        
        String nomE;
        Date fechaR;
        String descripcion;
        int hab;
        float saldo;
        int id;
        
        try {
            Statement statement = ManejadorBD.dameConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Eventos WHERE nombre = '" + nombreEvento + "';");
            /*se pone el apuntador una fila depues para guardar los datos recibidos*/
            rs.next();
            /* Se guardan los datos recibidos en las variables correspondientes*/

            id = rs.getInt("idEvento");
            nomE = rs.getString("nombreEvento");
            fechaR = rs.getDate("fechaReservacion");
            descripcion = rs.getString("descripcion");
            saldo = rs.getFloat("saldo");
            hab = rs.getInt("Habitantes_idHabitante");

            rs.close();
        } catch (SQLException e) {
            System.out.println("Hubo un error 1");
            e.printStackTrace();
            return null;
        }
        try {
            Statement statement = ManejadorBD.dameConnection().createStatement();
            /* Se busca la casa del habitante solicitado */
            ResultSet rs2 = statement.executeQuery("SELECT * FROM Habitantes WHERE idHabitante = '" + hab + "';");
            rs2.next();
            /* Se crean los objetos casa y responsable con los datos del evento solicitado*/

            Casa casa = new Casa(rs2.getInt("idCasa"), rs2.getString("seccion"), rs2.getInt("numero"));
            Responsable habitante = new Responsable(rs2.getInt("idHabitante"), rs2.getString("nombre"), rs2.getString("aPat"), rs2.getString("aMat"), rs2.getFloat("telefono"), casa, rs2.getFloat("saldo"));
            Evento evento = new Evento(id, nomE, fechaR, descripcion, saldo, habitante);

            rs2.close();

            return evento;
        } catch (SQLException e) {
            System.out.println("Hubo un error 2");
            e.printStackTrace();
            return null;
        }
    }
    
    //Metodo que recibe un evento y lo elimina en la base de datos (Caso de uso CancelarEvento)
    public boolean eliminaEvent(Evento even){
        System.out.println("DAO ELIMINA");
        int resultado = 0;
        try {
            // Statement = declaracion
            Statement statement;
            statement = ManejadorBD.dameConnection().createStatement();   
            resultado = statement.executeUpdate("DELETE FROM Evento WHERE idEvento=" + even.getId() + ";" ); //busca en bd al evento por su id y lo elimina 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(resultado==0){
            return false;
        }else{
            return true;
        }
    }
}
