
package uhv1.Negocio;

import java.sql.Date;

/**
 *
 * @author Jose Luis
 */
public class Evento {
    private String nombre;
    private Date fechaReservacion;
    private String descripcion;
    private float saldo;
    private Responsable habitante;
    private int id;

    public Evento(int id,String nombre, Date fechaReservacion, String descripcion, float saldo, Responsable habitante) {
        this.id=id;
        this.nombre = nombre;
        this.fechaReservacion = fechaReservacion;
        this.descripcion = descripcion;
        this.saldo = saldo;
        this.habitante = habitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(Date fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Responsable getHabitante() {
        return habitante;
    }

    public void setHabitante(Responsable habitante) {
        this.habitante = habitante;
    }

    public boolean cambiaId(int idEvento) {

        if (idEvento != id && idEvento != 0) {
            this.id = idEvento;
            return true;
        } else {
            return false;
        }
    }
    
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Eventos{" + "nombre=" + nombre + ", fechaReservacion=" + fechaReservacion + ", descripcion=" + descripcion + ", saldo=" + saldo + ", habitante=" + habitante + '}';
    }
}
