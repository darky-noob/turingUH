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
public class Casa {
    private int id;
    private String seccion;
    private int numero;
    
    public Casa(int id,String seccion, int numero){
        this.id = id;
        this.seccion = seccion;
        this.numero = numero;
    }

    public Casa(String string, int aInt) {        
        this.seccion = string;
        this.numero = aInt;
    
    }

    
     public int getId() {
        return id;
    }

    /**
     * @param numero the numero to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
