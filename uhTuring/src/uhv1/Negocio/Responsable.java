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
public class Responsable {
    
    private String nombre;
    private String aPat;
    private String aMat;
    private float telefono;
    private Casa casa;
    private float saldo;
    private int id;
    

    

    public Responsable(int id, String nombre, String aPat, String aMat, float telefono, Casa casa, float saldo){
        this.id = id;
        this.nombre = nombre;
        this.aPat = aPat;
        this.aMat = aMat;
        this.telefono = telefono;
        this.casa = casa;
        this.telefono = saldo;                
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the aPat
     */
    public String getaPat() {
        return aPat;
    }

    /**
     * @param aPat the aPat to set
     */
    public void setaPat(String aPat) {
        this.aPat = aPat;
    }

    /**
     * @return the aMat
     */
    public String getaMat() {
        return aMat;
    }

    /**
     * @param aMat the aMat to set
     */
    public void setaMat(String aMat) {
        this.aMat = aMat;
    }

    /**
     * @return the telefono
     */
    public float getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(float telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the casa
     */
    public Casa getCasa() {
        return casa;
    }

    /**
     * @param casa the casa to set
     */
    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    /**
     * @return the saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    
}

  