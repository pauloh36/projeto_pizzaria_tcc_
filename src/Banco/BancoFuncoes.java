package Banco;


import ConfiguracaoBanco.FILE.ManageFiles;
import ConfiguracaoBanco.FILE.ManageFilesReader;
import Funcoes.pintaDemonstrativoVenda;
import Movimentacao.DemonstrativoVenda;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.TableColumn;
import static org.alfredlibrary.validadores.CNPJ.isValido;
import org.alfredlibrary.validadores.CPF;


public class BancoFuncoes {

    String somaRecebidos, somaAReceber;
    
    BancoFuncoes banco;
    
    conectaBanco cb = new conectaBanco();
    
    Banco ba = new Banco();

    public void setSomaRecebidos(String d){
        somaRecebidos = d;
    }
    public String getSomaRecebidos(){
        return somaRecebidos;
    }

    public void setSomaAReceber(String n){
        somaAReceber = n;
    }
    public String getSomaAReceber(){
        return somaAReceber;
    }

//-------------------------------------------------Função Universal---------------------------------------------

    public BancoFuncoes
           carregaDadoUnico(String vsql, String msg1, String msg2, final JComboBox caixaTexto, String campoSql){

            Connection connection = null;

       try {
           //GAMBIARRA 
           
           ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

            Statement s = (Statement) connection.createStatement();

              ResultSet rs = s.executeQuery(vsql);

                   caixaTexto.removeAllItems();

                   caixaTexto.addItem("");

                while (rs.next()){
                    caixaTexto.addItem(rs.getString(campoSql));
                   }

            System.out.println("Conectado ao banco com sucesso");

             s.close();
             connection.close();

             System.out.println(msg1);
             System.out.println(vsql);
             return banco;

       }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, msg2);
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("Error: " + ex.getErrorCode());
          System.out.println(vsql);
          return null;
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, msg2);
          System.out.println(vsql);
          System.out.println("Dados não filtrados" + e);
          return null;
        }

   }
           
            public BancoFuncoes
           tabelaClientes(String sql, String msg1, String msg2, final JTable gridCliente){

               
               
          Connection connection = null;

   try {
       //GAMBIARRA 
          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridCliente.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String telefone = rs.getString("telefone");
                        String nome = rs.getString("nome");
                        String uf = rs.getString("uf");
                        String cidade = rs.getString("cidade");
                        String bairro = rs.getString("bairro");
                        String logradouro = rs.getString("endereco");
                        String numero = rs.getString("numero");
                        String cep = rs.getString("cep");
                        String complemento = rs.getString("complemento");
                        dtm.addRow(new Object[]{telefone, nome, uf, cidade, bairro, logradouro, numero, cep, complemento});
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
            public BancoFuncoes
           tabelaHistorico(String sql, String msg1, String msg2, final JTable gridCliente){

               
               
          Connection connection = null;

   try {
       //GAMBIARRA 
          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridCliente.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String telefone = rs.getString("telefone");
                        String nome = rs.getString("nome");
                        String npedido = rs.getString("npedido");
                        String total = rs.getString("total");
                        String data = rs.getString("data");
   
                        dtm.addRow(new Object[]{telefone, nome, npedido, total, data});
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
             public BancoFuncoes
           tabelaCaixa(String sql, String msg1, String msg2, final JTable gridCaixa){

               
               
          Connection connection = null;

   try {
       //GAMBIARRA 
          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridCaixa.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String Descricao = rs.getString("Produto");
                        String Qtde = rs.getString("qtde");
                        String Preco = rs.getString("preco");
                        String Total = rs.getString("total");
               
                        dtm.addRow(new Object[]{Descricao, Qtde, Preco, Total});
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
             public BancoFuncoes
           tabelaPedidosEntrega(String sql, String msg1, String msg2, final JTable gridCaixa){

               
               
          Connection connection = null;

   try {
       
       //GAMBIARRA 
  ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridCaixa.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String npedido = rs.getString("npedido");
                        String nome = rs.getString("nome");
                        String telefone = rs.getString("telefone");
                        String formapagamento = rs.getString("formapagamento");
                        String total = rs.getString("total");
                        String motoboy = rs.getString("motoboy");
                        String situacaoentrega = rs.getString("situacaoentrega");
                        String hora = rs.getString("hora");
                        String horasaida = rs.getString("hrsaida");
                         String horaentrega = rs.getString("horaentrega");
                  
               
                        dtm.addRow(new Object[]{npedido, nome, telefone, formapagamento,total ,motoboy ,situacaoentrega ,hora ,horasaida ,horaentrega});
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
                 public BancoFuncoes
           tabelaPedidosAberto(String sql, String msg1, String msg2, final JTable gridCaixa){

               
               
          Connection connection = null;

   try {
       //GAMBIARRA 
          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridCaixa.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String npedido = rs.getString("npedido");
                        String itens = rs.getString("produto");
                        String qtde = rs.getString("qtde");
                        String hora = rs.getString("hora");
             
                  
               
                        dtm.addRow(new Object[]{npedido, itens, qtde, hora});
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
            public BancoFuncoes
           tabelaPedidosBalcao(String sql, String msg1, String msg2, final JTable gridCaixa){

               
               
          Connection connection = null;

   try {
       //GAMBIARRA 
          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridCaixa.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String npedido = rs.getString("npedido");
                        String nome = "";
                        String telefone ="";
                        String formapagamento = rs.getString("formapagamento");
                        String total = rs.getString("total");
                        String motoboy = "";
                        String situacaoentrega = rs.getString("situacaoentrega");
                        String hora = rs.getString("hora");
                        String horasaida = "";
                         String horaentrega = rs.getString("horaentrega");
                  
               
                        dtm.addRow(new Object[]{npedido, nome, telefone, formapagamento,total ,motoboy ,situacaoentrega ,hora ,horasaida ,horaentrega});
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
           
              public BancoFuncoes
           tabelaCompras(String sql, String msg1, String msg2, final JTable gridCompras){

               
               
          Connection connection = null;

   try {

          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridCompras.getModel();
                 
          int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String N_Pedido = rs.getString("npedido");
                        String CPF = rs.getString("cpfFor");
                        String CNPJ = rs.getString("cnpjFor");
                        String Fornecedor = rs.getString("nomeFantasia");
                        String Tipo_Produto = rs.getString("tipoproduto");
                        String Produto = rs.getString("produto");
                        String Qtde = rs.getString("qtde");
         
                        dtm.addRow(new Object[]{N_Pedido, CPF, CNPJ, Fornecedor, Tipo_Produto, Produto, Qtde});
                        
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
                 public BancoFuncoes
           tabelaFuncionario(String sql, String msg1, String msg2, final JTable gridFuncionario){

               
               
          Connection connection = null;

   try {

         ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridFuncionario.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String Nome = rs.getString("nomeFun");
                        String Sexo = rs.getString("sexoFun");
                        String CPF = rs.getString("cpfFun");
                        String RG = rs.getString("rgFun");
                        String Situacao = rs.getString("situacao");
                        String Telefone = rs.getString("telFun");
                        String Ceular = rs.getString("celFun");
                        String Setor = rs.getString("setorFun");
                        String Motoboy = rs.getString("motoboy");
                        dtm.addRow(new Object[]{Nome ,Sexo ,CPF,RG ,Telefone ,Ceular , Setor, Motoboy, Situacao});
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
              public BancoFuncoes
           tabelaUsuario(String sql, String msg1, String msg2, final JTable gridUsuarios){

               
               
          Connection connection = null;

   try {

          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridUsuarios.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String Nome = rs.getString("f.nomeFun");
                        String CPF = rs.getString("u.cpfFun");
                        String Login = rs.getString("u.login");
                        String Permissao = rs.getString("u.permissao");
                        String Permissao2="";
                        
                        if(Permissao.equals("0")){
                            
                            Permissao2 += "Caixa";
                            
                        }
                        else if (Permissao.equals("1")){
             
                            Permissao2 += "Adm";
                        }
                        
                        dtm.addRow(new Object[]{Nome ,CPF ,Login,Permissao2});
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
       public BancoFuncoes
           tabelaCategoria(String sql, String msg1, String msg2, final JTable gridCategoriaProduto){

               
               
          Connection connection = null;

   try {

        ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

          
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);
       
       

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridCategoriaProduto.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String categoria = rs.getString("categoria");
                     
             
                        dtm.addRow(new Object[]{categoria});
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
  
           
            public BancoFuncoes
           tabelaFornecedor(String sql, String msg1, String msg2, final JTable gridFornecedor){

               
               
          Connection connection = null;

   try {

          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridFornecedor.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                        String Nome = rs.getString("nomeFantasia");
                        String pegaCPF = rs.getString("cpfFor");
                        String pegaCNPJ = rs.getString("cnpjFor");
                        
                        
                        String CPF_CNPJ = "";
                        
                        
                        if(CPF.isValido(pegaCPF) == true){
                            
                            CPF_CNPJ += pegaCPF;
                            
                        }
                        
                        else if (isValido(pegaCNPJ) == true){
                            
                            CPF_CNPJ += pegaCNPJ;
                            
                        }
                            
                            
                        
                        
                        String Inc_Est = rs.getString("estadualFor");
                        String Tipo = rs.getString("tipopessoa");
                        String Nome_Cont = rs.getString("nomeContato");                     
                        String Telefone = rs.getString("telFor");                      
                        String Telefone2 = rs.getString("tel2For");
                        String Celular = rs.getString("celFor");
                        String UF = rs.getString("ufFor");
                        String Cidade = rs.getString("cidadeFor");
                        String Bairro = rs.getString("bairroFor");
                        String Logradouro = rs.getString("endeFor");
                        String Numero = rs.getString("numFor");
                        String Cep = rs.getString("cepFor");
                        String Site = rs.getString("siteFor");
                        String Email = rs.getString("emailFor");
                        String Tipo_Produto = rs.getString("tipoproduto");
                
                        
                        
                        dtm.addRow(new Object[]{Nome, CPF_CNPJ,Inc_Est,Tipo, Nome_Cont, Telefone,Celular
              , UF, Email ,Tipo_Produto});
                   }


         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
           public BancoFuncoes
           tabelaProdutos(String sql, String msg1, String msg2, final JTable gridProdutos){

               
               
          Connection connection = null;

   try {

          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridProdutos.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String Codigo_Produto = rs.getString("codigoproduto");
                       String TipoProduto = rs.getString("tipoproduto");
                       String Descricao = rs.getString("descricao");
                       String ingredientes = rs.getString("ingredientes");
                       String Unidade_Medida = rs.getString("unidmedida");
                       String Estocavel = rs.getString("Estocavel");
                       String Qtde_Minima = rs.getString("qtdeminima");
                       String QtdeEstoque = rs.getString("qtdeestoque");
                       String ProdutoAcabadoPrima = rs.getString("acabadoprima");
                       String Valor = rs.getString("valor");
                       String ProdutoVenda = rs.getString("produtovenda");
                       
                               
                     
             
                        dtm.addRow(new Object[]{Codigo_Produto, TipoProduto, Descricao, ingredientes,Unidade_Medida,
                        Estocavel,Qtde_Minima, QtdeEstoque, ProdutoAcabadoPrima, Valor, ProdutoVenda });
                   }


//        System.out.println("Fornecedores Recuperados com sucesso");

         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
        
           
           
           
            public BancoFuncoes
           tabelaContasPagar(String sql, String msg1, String msg2, final JTable girdContaPagar){

               
               
          Connection connection = null;

   try {

          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)girdContaPagar.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String Nota_Fiscal = rs.getString("notaFiscal");
                        String Descricao = rs.getString("descricao");
                        String Dt_Recebimento = rs.getString("dataRecebimento");
                        String Dt_Emissao = rs.getString("dataEmissao");
                        String Dt_Vencimento = rs.getString("dataVencimento");
                        String Valor = rs.getString("valor");
                        String Juros = rs.getString("juros");
                        String Multa = rs.getString("multa");
                        String Fornecedor = rs.getString("fornecedor");
                        dtm.addRow(new Object[]{Nota_Fiscal, Descricao, Dt_Recebimento, Dt_Emissao, Dt_Vencimento, Valor, Juros, Multa, Fornecedor});
                   }


         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
           
            public BancoFuncoes
           tabelaContasReceber(String sql, String msg1, String msg2, final JTable gridContaReceber){

               
               
          Connection connection = null;

   try {

         ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridContaReceber.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String Telefone = rs.getString("telefone");
                        String Cliente = rs.getString("Cliente");
                        String Descricao = rs.getString("descricao");
                        String Dt_Recebimento = rs.getString("dtrecebimento");
                        String Dt_Vencimento = rs.getString("dtvencimento");
                        String Valor = rs.getString("valor");
                        String Tipo_Pagamento = rs.getString("tipopagamento");
                     
                        dtm.addRow(new Object[]{Telefone, Cliente, Descricao, Dt_Recebimento, Dt_Vencimento, Valor, Tipo_Pagamento});
                   }


         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
            public BancoFuncoes
           tabelaVendas(String sql, String msg1, String msg2, final JTable gridContaReceber){

               
               
          Connection connection = null;

   try {

          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridContaReceber.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                       String npedido = rs.getString("npedido");
                       String tipopedido = rs.getString("tipopedido"); 
                       String data = rs.getString("data");
                        String total = rs.getString("total");
             
                     
                        dtm.addRow(new Object[]{npedido,tipopedido, data, total});
                   }


         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
             public BancoFuncoes
           tabelaDemonstrativo(String sql, String msg1, String msg2, final JTable gridDemo){

               
               
          Connection connection = null;

   try {

         ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridDemo.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                      String npedido = rs.getString("npedido");
                      String nome = rs.getString("nome");
                       String produto = rs.getString("produto");
                        String qtde = rs.getString("qtde");
                        String preco = rs.getString("preco");
                        String total = rs.getString("total");
                        String data = rs.getString("data");
                     
                        dtm.addRow(new Object[]{npedido,nome,produto, qtde, preco, total,data});
                   }


         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
              public BancoFuncoes
           tabelaDemonstrativoBalcao(String sql, String msg1, String msg2, final JTable gridDemo){

               
               
          Connection connection = null;

   try {

          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridDemo.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                      String npedido = rs.getString("npedido");
                       String produto = rs.getString("produto");
                        String qtde = rs.getString("qtde");
                        String preco = rs.getString("preco");
                        String total = rs.getString("total");
                        String data = rs.getString("data");
                     
                        dtm.addRow(new Object[]{npedido,produto, qtde, preco, total,data});
                   }


         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
           public BancoFuncoes
           tabelaEndereco(String sql, String msg1, String msg2, final JTable gridDemo){

               
               
          Connection connection = null;

   try {

          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridDemo.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                      String Telefone = rs.getString("telefone");
                       String Nome = rs.getString("nome");
                        String Bairro = rs.getString("bairro");
                        String Endereco = rs.getString("endereco");
                        String Numero = rs.getString("numero");
                        
                     
                        dtm.addRow(new Object[]{Telefone,Nome, Bairro, Endereco, Numero});
                   }


         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
            public BancoFuncoes
           tabelaDemonstrativoPagamento(String sql, String msg1, String msg2, final JTable gridPagamento){

               
               
          Connection connection = null;

   try {

         ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        Statement s = (Statement) connection.createStatement();

          ResultSet rs = s.executeQuery(sql);

          javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)gridPagamento.getModel();
                   int i = dtm.getRowCount();
                   for(int a = 0; a < i; a++)
                   {
                   dtm.removeRow(0);
                   }

                   while (rs.next()){
                      String npedido = rs.getString("npedido");
                       String tipopagamento = rs.getString("formapagamento");
                        String total = rs.getString("total");
       
                        
                     
                        dtm.addRow(new Object[]{npedido,tipopagamento,total});
                   }


         s.close();
         connection.close();

         System.out.println(msg1);
         System.out.println(sql);
         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }

 }
           
           
           
            public BancoFuncoes
           salvar(String sql, String msg1, String msg2){

          com.mysql.jdbc.Connection connection = null;

   try {
          ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

        com.mysql.jdbc.Statement s = (com.mysql.jdbc.Statement) connection.createStatement();

        s.execute(sql);

        System.out.println("Conectado ao banco com sucesso");

         s.close();
         connection.close();

//         JOptionPane.showMessageDialog(null, msg1);
         System.out.println(sql);

         return banco;

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("Error: " + ex.getErrorCode());
      System.out.println(sql);
      return null;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null, msg2);
      System.out.println(sql);
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
      return null;
    }
  }
             
  
}          