/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Persistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uhv1.Negocio.Casa;
import uhv1.Negocio.Responsable;
import uhv1.Persistencia.ManejadorBD;

/**
 *
 * @author darky
 */
public class DAOHabitantes {
    
    /* Este metodo recibe un mensaje de control baja dicho metodo ejecuta un query para eliminar
    al habitante de la base de datos*/
    public boolean eliminahab(Responsable res){
        System.out.println("DAO ELIMINA");
        int resultado = 0;
        try {
            // Statement = declaracion
            Statement statement;
            statement = ManejadorBD.dameConnection().createStatement();
            resultado = statement.executeUpdate("DELETE FROM Habitantes WHERE nombre='" + res.getNombre() + "'AND aPat='" + res.getaPat() + "';" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(resultado==0){
            return false;
        }else{
            return true;
        }
    }
    /*  Este metodo recibe un mensaje de control busca con los datos del habitante para buscarlo
        en la base de datos */
    public Responsable buscaHabitante(String nombre, String aPat){
            String nom;
            String aPata;
            String aMat;
            float tel;
            int ca;
            float saldo;
            int id;
        try {
            Statement statement = ManejadorBD.dameConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Habitantes WHERE nombre = '" + nombre + "' AND aPat= '" + aPat + "';");
            /*se pone el apuntador una fila depues para guardar los datos recibidos*/
            rs.next();
            /* Se guardan los datos recibidos en las variables correspondientes*/
            id = rs.getInt("idHabitante");
            nom = rs.getString("nombre");
            aPata = rs.getString("aPat");
            aMat = rs.getString("aMat");
            tel = rs.getFloat("telefono");
            ca  = rs.getInt("Casas_idCasa");
            saldo = rs.getFloat("saldo");                                 
            rs.close();
        } catch (SQLException e) {
            System.out.println("Hubo un error 1");
            e.printStackTrace();
            return null;
        }
        try {
            Statement statement = ManejadorBD.dameConnection().createStatement();
            /* Se busca la casa del habitante solicitado */
            ResultSet rs2 = statement.executeQuery("SELECT * FROM Casas WHERE idCasa = '" + ca + "';");            
            rs2.next();
            /* Se crean los objetos casa y responsable con los datos del habitante solicitado*/
            Casa casa = new Casa(rs2.getInt("idCasa"), rs2.getString("seccion"), rs2.getInt("numero"));            
            Responsable res = new Responsable(id, nom, aPata, aMat, tel, casa, saldo);            
            rs2.close();
            
            return res;
        } catch (SQLException e) {
            System.out.println("Hubo un error 2");
            e.printStackTrace();
            return null;
        }
    }

    public boolean modificarHabitante(Responsable habitante, Casa casa) {

        try {
            System.out.println("en el dao: "+habitante.getNombre()+habitante.getaPat()+habitante.getaMat()+habitante.getTelefono());
            Statement statement = ManejadorBD.dameConnection().createStatement();

            statement.execute("UPDATE habitantes SET nombre='" + habitante.getNombre() + "', aPat='" 
                    + habitante.getaPat() + "', aMat='" + habitante.getaMat() + "', telefono='" 
                    + habitante.getTelefono() + "'  where idHabitante = '" + habitante.getId() + "';"
            );

            return true;
            
        } catch (SQLException e) {
            System.out.println("No se pudo modificar");
            e.printStackTrace();
            return false;
        }
    }

    public boolean registraHabitante(Responsable habitante) throws SQLException {

        int llave;
        try {
            // Crea el statement
            Statement statement = ManejadorBD.dameConnection().createStatement();
            // Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
            System.out.println("DESDE el dao inserta " + habitante.getNombre() + "','" + habitante.getaPat() + "','" + habitante.getaMat() + "'," + habitante.getSaldo() + "," + habitante.getTelefono() + "," + habitante.getCasa().getId());
            statement.execute("INSERT into habitantes (nombre, aPat, aMat, saldo, telefono, Casas_idCasa) values ('" + habitante.getNombre() + "', '" + habitante.getaPat() + "','" + habitante.getaMat() + "'," + habitante.getSaldo() + "," + habitante.getTelefono() + "," + habitante.getCasa().getId() + ");", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave

            if (rs != null && rs.next()) {
                llave = rs.getInt(1);
                System.out.println("Id: " + llave);
                habitante.setId(llave); // Asigna la llave al habitante
            }
            return true;
        } catch (SQLException e) {
            return false;
        }

    }
}
