/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

import Banco.Banco;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class GerarPdf {

    Banco ba = new Banco();

  public static void main(String arg[])throws Exception
      {
          
        File arquivo = new File("cupom.pdf");  

      System.out.print(arquivo.getAbsolutePath()); 
      
      
   
File file = new File(arquivo.getAbsolutePath());  
file.delete();  
          

  Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("cupom.pdf"));
      document.open();  
      document.add(new Paragraph("CUPOM NÃO FISCAL"));
      document.add(new Paragraph("\nData: "+arg[1]));
      document.add(new Paragraph("Hora: "+arg[2]));
      document.add(new Paragraph(arg[0]));
      document.add(new Paragraph("\nProdutos:\n"+arg[3] +"   R$ "+ arg[4]));
      
      document.close(); 
    
     
      }
  
   public static void abrirPdf(String caminho) {
        try {
            java.awt.Desktop.getDesktop().open(new File(caminho));
        } catch (IOException ex) {
            Logger.getLogger(GerarPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
}
    

