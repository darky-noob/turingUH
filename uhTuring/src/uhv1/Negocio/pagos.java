/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

/**
 *
 * @author darky
 */
public class pagos {
    private int id;
    private String fecha;
    private float monto;
    private int id_habitante;
    private int concepto;
    
    public pagos(int id, String fecha, float monto, int id_habitante, int concepto){
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.id_habitante = id_habitante;
        this.concepto = concepto;
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * @return the id_habitante
     */
    public int getId_habitante() {
        return id_habitante;
    }

    /**
     * @param id_habitante the id_habitante to set
     */
    public void setId_habitante(int id_habitante) {
        this.id_habitante = id_habitante;
    }

    /**
     * @return the concepto
     */
    public int getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(int concepto) {
        this.concepto = concepto;
    }

    @Override
    public String toString() {
        return fecha + " " + monto + " " + concepto; //To change body of generated methods, choose Tools | Templates.
    }
    
}
