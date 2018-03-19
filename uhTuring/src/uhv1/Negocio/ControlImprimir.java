/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Negocio;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import sun.swing.SwingUtilities2;

/**
 *
 * @author darky
 */
class ControlImprimir {
    public static final String filename
        = "Historial.pdf";
    private pagos pagos[];
    private Responsable res;
    ControlImprimir(pagos[] pagos, Responsable res) {
        this.res=res;
        this.pagos = pagos;
    }
    
    public void imprimirHistorial() {
        Document document = null;
        try {
            document = new Document();               
            PdfWriter.getInstance(document, new FileOutputStream(filename));        
            document.open();
        } catch (Exception e) {
        }
        
        float[] f = new float[4];
        f[0] = 10.0f;
        f[1] = 30.0f;
        f[2] = 30.0f;
        f[3] = 30.0f;
        
        Object arr[][] = new Object[2][4];
        arr[0][0] = 1;
        arr[0][1] = "1/feb";
        arr[0][2] = 200;
        arr[0][3] = 1;
        
        arr[1][0] = 2;
        arr[1][1] = "2/feb";
        arr[1][2] = 300;
        arr[1][3] = 2;
     
        try{
            
            Chapter c1 = new  Chapter(0);
            Section sec1 = c1;
            
            Image imagen = Image.getInstance("img/info.png");            
            imagen.setAlignment(Image.TEXTWRAP);
            imagen.scaleAbsolute(100, 100);                 
                        
            Paragraph sub = new Paragraph("Unidad Habitacional \n  ",FontFactory.getFont("Arial", 24, Font.BOLD, BaseColor.BLACK));                                
            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);
            
            sub.setFont(FontFactory.getFont("Arial", 20, Font.BOLD, BaseColor.BLACK));
            sub.add("Historial de pagos\n ");
            sub.setAlignment(Paragraph.ALIGN_CENTER);
            sub.add(dottedline);
            
            sec1.add(imagen);           
            sec1.add(sub);   
                        
            Section secDatos = sec1;
            
            Chunk espacio = new Chunk("\n");
            secDatos.add(espacio);
            
            Chunk glue = new Chunk(new VerticalPositionMark());
                                    
            Chunk nom = new Chunk();           
            nom.append("Nombre:" + res.getaPat() + " "+ res.getaMat() + " " + res.getNombre());
            nom.setFont(FontFactory.getFont("Arial", 10, Font.NORMAL));
            Chunk cas = new Chunk(); 
            cas.append("Seccion: " + res.getCasa().getSeccion() + "   Numero: " + res.getCasa().getNumero());
            cas.setFont(FontFactory.getFont("Arial", 10, Font.NORMAL));
            
            Paragraph pDatos = new Paragraph("Datos habitante: \n",FontFactory.getFont("Arial", 15, Font.BOLD, BaseColor.BLACK));            
            pDatos.add(nom);
            pDatos.add(new Chunk(glue));
            pDatos.add(cas);
            
            secDatos.add(pDatos);
            
            Chunk telSal = new Chunk();           
            telSal.append("Telefono: " + res.getTelefono() + "       Saldo: $" + res.getSaldo());
            telSal.setFont(FontFactory.getFont("Arial", 10, Font.NORMAL));
            Paragraph pDatos2 = new Paragraph();
            pDatos2.setFont(FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK));
            pDatos2.add(telSal);
            pDatos2.add(espacio);
            
            secDatos.add(pDatos2);
            
            Section secTable = secDatos;
            
            secTable.add(espacio);
            
            PdfPTable table = new PdfPTable(4); 
            PdfPCell columnHeader;
            String header [] = new String [] {"Id",
                            "Fecha",
                            "Monto",
                            "Concepto"
                            
            };
            for (int column = 0; column < 4; column++) {
                columnHeader = new PdfPCell(new Phrase(header[column]));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);
            }
            table.setHeaderRows(1);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.setWidthPercentage(100);
            table.setWidths(f);
            for (int row = 0; row < pagos.length; row++) {   
                System.out.println("uhv1.Negocio.ControlImprimir.imprimirHistorial()");
                String id = " "+ row;
                System.out.println(id);
                table.addCell(id);                
                String fech = pagos[row].getFecha();
                System.out.println(fech);
                table.addCell(fech);
                String mont = " "+ pagos[row].getMonto();
                System.out.println(mont);
                table.addCell(""+ pagos[row].getMonto());                
                int concep = pagos[row].getConcepto();
                System.out.println(concep);
                switch(concep){
                    case 0:
                        table.addCell("Pago mantenimiento");
                        break;
                    case 1:
                        table.addCell("Pago evento");
                        break;
                }                                                       
            }
            secTable.add(table);
            document.add(sec1);
            
        }catch(IOException | DocumentException ex){
            ex.getMessage();
        }              
        document.close();
        try{ 
            //definiendo la ruta en la propiedad file
            Runtime.getRuntime().exec("cmd /c start "+filename);
            System.out.println("uhv1.Negocio.ControlImprimir.imprimirHistorial()");
        }catch(IOException e){
            e.printStackTrace();
        } 
    }
    
}
