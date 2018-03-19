/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;


import uhv1.Persistencia.DAOPagos;
import uhv1.Vistas.VistaHistorial;

 
/**
 *
 * @author Jose Luis
 */
public class ControlHistorial {
   DAOPagos daoPagos;
   VistaHistorial vistaHist;
    
   public ControlHistorial(){
   }
   
   public ControlHistorial(VistaHistorial vistaHist){
       this.vistaHist = vistaHist;
   }
   
   public ControlHistorial(DAOPagos daoPagos){
       this.daoPagos = daoPagos;
   }  
   
   public void consultaHistorial(Responsable hab){             
       boolean bandera;
       daoPagos = new DAOPagos();
       pagos pagosArreglo[] = daoPagos.Recupera(hab);
       vistaHist = new VistaHistorial(this, pagosArreglo);
       
              
       if(pagosArreglo != null){
          vistaHist.setVisible(true);
          vistaHist.MuestaHistorial(hab);
       }
       
   }
   public void imprime(pagos pagos[], Responsable res){
       ControlImprimir ci = new ControlImprimir(pagos,res);
       ci.imprimirHistorial();
   }
}
