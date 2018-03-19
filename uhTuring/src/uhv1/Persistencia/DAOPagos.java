/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Persistencia;

/**
 *
 * @author Jose Luis
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uhv1.Negocio.Responsable;
import uhv1.Negocio.pagos;
import uhv1.Persistencia.ManejadorBD;

public class DAOPagos {
    
    Responsable  hab;
    
    public DAOPagos(){
    }
    
    public pagos[] Recupera(Responsable hab){        
        Statement statement;
        ArrayList<pagos> pagosTemp = new ArrayList<pagos>();
        try {
            statement = ManejadorBD.dameConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM pagos where Habitantes_idHabitante =" + hab.getId() + ";");
            while(rs.next()){ // mientras tenga datos que imprimir
                pagos pago = new pagos(rs.getInt("idPago"), rs.getString("fecha"), rs.getFloat("monto"),rs.getInt("Habitantes_idhabitante"),rs.getInt("concepto"));
                System.out.println(pago.getFecha());
                pagosTemp.add(pago);
            }
            pagos pagosTempArreglo[] = new pagos[pagosTemp.size()];
            pagosTemp.toArray(pagosTempArreglo);
            return pagosTempArreglo;
        }catch (SQLException e) {
             e.printStackTrace();
             return null;
        }        
    }
}
     

