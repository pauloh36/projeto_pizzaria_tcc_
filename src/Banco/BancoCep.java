package Banco;


import ConfiguracaoBanco.FILE.ManageFiles;
import ConfiguracaoBanco.FILE.ManageFilesReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoCep {

    Connection con;
    Statement stmt;
    ResultSet rs;
    private int codi;
    private String nom;

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public void conecta() {
        try {
            
             ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

            
            
            
            String serverName = "localhost";
            String mydatabase = "cep";
           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4];
           
            String driverName = "com.mysql.jdbc.Driver"; 
            Class.forName(driverName);
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            con = DriverManager.getConnection(url, user, password);
            stmt = (Statement) con.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar o Banco de Dados");
        } catch (IOException ex) {
            Logger.getLogger(BancoCep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public ResultSet buscaCep(String cep) {
        String sql;
        conecta();

        try {
            sql = "SELECT b.desc_bairro, c.flg_estado, l.desc_logradouro,c.desc_cidade, l.num_cep FROM bairros b\n" +               
"JOIN cidades c ON c.cidade_id = b.cidade_id\n" +
"JOIN logradouros l ON l.bairro_id = b.bairro_id WHERE l.num_cep ='" + cep + "';"; 
           
            
            
          
            
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            rs.first();
            if (rs.getString("num_cep") != null) {
                return rs;
            } else {
                return null;
            }

        } catch (SQLException e) {

            return null;
        }

    }
}
