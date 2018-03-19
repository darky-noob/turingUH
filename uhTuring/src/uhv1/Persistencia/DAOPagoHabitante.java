package uhv1.Persistencia;

import uhv1.Negocio.ControlPagoHabitante;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import uhv1.Negocio.Responsable;

public class DAOPagoHabitante{
    ControlPagoHabitante cph = new ControlPagoHabitante();//Instancia para regresar avisos
    
    java.sql.Date fecha;
    float monto;
    int idHabitantes;
    int concepto;
    
    private Connection conexion = null; 

    public DAOPagoHabitante(Date fecha, float monto, int idHabitantes, int concepto) {//constructor por default
        this.fecha = fecha;
        this.monto = monto;
        this.idHabitantes = idHabitantes;
        this.concepto = concepto;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getMonto() {
        return monto;
    }

    public int getIdHabitantes() {
        return idHabitantes;
    }

    public int getConcepto() {
        return concepto;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setIdHabitantes(int idHabitantes) {
        this.idHabitantes = idHabitantes;
    }

    public void setConcepto(int concepto) {
        this.concepto = concepto;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public DAOPagoHabitante(Responsable hab, float monto) throws SQLException{//Constructor que usará el DAO
        System.out.println("Ingresando a pago habitante");
        System.out.println("Ingresando a la conexion");
        Conecta();
        InsertaPago(hab, monto);
    }
    
    public void Conecta() throws SQLException{//La propia conexión a la base de datos
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/uh", "root", "");
        System.out.println("Conexion iniciada");
        conexion.setAutoCommit(false);
    }
    
    public void Desconecta() throws SQLException{//Desconecta la conexion propia de este DAO
        if (conexion!=null){
            conexion.close();
            System.out.println("Conexión cerrada");   
        }
    }
    
    public void InsertaPago(Responsable hab, float cantidad) throws SQLException{//Recibe los datos sobre el pago desde el control de pago 
        PreparedStatement InsertaPago = null; //prepara la inserción de instruciones de SQL en java
        try{
            
            String InsertaSQL = "INSERT INTO pagos(fecha, monto, Habitantes_idHabitante, concepto) VALUES (?,?,?,?)";//String con el Código del insert
            InsertaPago = conexion.prepareStatement(InsertaSQL);//prepara la conexion para ejecutar códogo SQL 
            InsertaPago.setDate(1, java.sql.Date.valueOf(LocalDate.now()));//inserta la fecha
            InsertaPago.setFloat(2, cantidad);//monto
            InsertaPago.setInt(3, hab.getId());//id FK Habitantes
            InsertaPago.setFloat(4, 0);// en caso del pago manto la clave es 0
            InsertaPago.executeUpdate();//Ejecuta la actualización de la base de datos
            conexion.commit();// Termina el bloque de instrucciones SQL correctamente
            cph.ResultadoCorrectoDAO(1);// en caso de ser correcto
            System.out.println("Ejecutada la inserción");
        }catch(SQLException ex){
            conexion.rollback();//en caso que el código no se ejecute deshace las acciones en la base de datos
            ex.printStackTrace();
            cph.ResultadoCorrectoDAO(0);//en caso de tener errores sql
        }finally{
            if(InsertaPago!=null){
                InsertaPago.close();//Si todo termina correctamente se cierra el statement
            }
        }
    }
}
