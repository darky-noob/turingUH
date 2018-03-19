package uhv1.Persistencia;
/* @author Vianey*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uhv1.Negocio.Casa;
import uhv1.Persistencia.ManejadorBD;

public class DAOCasa {

    public DAOCasa() {
    }

    public boolean registraCasa(Casa casa) throws SQLException {

        int llave;
        try {
            // Crea el statement
            Statement statement = ManejadorBD.dameConnection().createStatement();
            // Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
            statement.execute("insert into Casa values (DEFAULT,'" + casa.getSeccion() + "','" + casa.getNumero() + ")", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave

            if (rs != null && rs.next()) {
                llave = rs.getInt(1);
                System.out.println("Id: " + llave);
                casa.setId(llave); // Asigna la llave al habitante
            }
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public Casa buscaCasa(int id) {
        Casa casa = null;
        try {
            // Crea el statement
            Statement statement = ManejadorBD.dameConnection().createStatement();
            // Recibe los resutados
            ResultSet rs = statement.executeQuery("SELECT * FROM Casa WHERE casaId=" + id);
            if (rs.next()) {
                // Crea una nueva instancia del objeto
                casa = new Casa(rs.getString("seccion"), rs.getInt("numero"));
                casa.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return casa;
    }

    public Casa[] dameCasas() {

        ArrayList<Casa> casasTemp = new ArrayList<Casa>();
        try {
            // Crea el statement
            Statement statement = ManejadorBD.dameConnection().createStatement();
            // Recibe los resutados
            ResultSet rs = statement.executeQuery("SELECT * FROM Casas");
            while (rs.next()) {
                // Crea una nueva instancia del objeto
                Casa casa = new Casa(rs.getInt("idCasa"), rs.getString("seccion"), rs.getInt("numero"));
                casasTemp.add(casa);
            }
            Casa casasTempArreglo[] = new Casa[casasTemp.size()];
            casasTemp.toArray(casasTempArreglo);
            return casasTempArreglo;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public int cuantasCasas() {
        try {
            // Crea el statement 
            Statement statement = ManejadorBD.dameConnection().createStatement();
            // Recibe los resutados
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Casa");
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

}
