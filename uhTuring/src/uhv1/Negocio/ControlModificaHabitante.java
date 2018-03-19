/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import uhv1.ControlPrincipal;
import uhv1.Persistencia.DAOHabitantes;
import uhv1.Vistas.VentanaModificaHabitante;

/**
 *
 * @author adrianags
 */
public class ControlModificaHabitante {
    
    Responsable res; 
    DAOHabitantes daohab;
    Casa casa;
    public ControlModificaHabitante (Responsable res, DAOHabitantes daohab){
       
        this.res=res;
        this.daohab=daohab;
      
        
    }
 
    public void inicia() {
        
        VentanaModificaHabitante ventmodi = new VentanaModificaHabitante(this,res,casa);
        ventmodi.setVisible(true);
        
        
    }//fin del incia

   
           
    public void controlPrincipal(){
        ControlPrincipal control = new ControlPrincipal();
        control.inicia();
    }
    public boolean controlModifica(String nombre, String apat, String amat, int telefono, int casa1 ){
        
       
        Casa casa2;
        casa2 = new Casa(casa1,"C", 123);
        
        Responsable habitante = new Responsable(res.getId(),nombre, apat, amat, res.getSaldo() ,casa2 ,telefono);
       
        daohab.modificarHabitante(habitante, casa2);
        
        return true;
    }
}