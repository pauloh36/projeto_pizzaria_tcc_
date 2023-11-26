package Movimentacao;

import Banco.BancoFuncoes;
import Banco.conectaBanco;
import ConfiguracaoBanco.FILE.ManageFiles;
import ConfiguracaoBanco.FILE.ManageFilesReader;
import Movimentacao.DemonstrativoVenda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Vendas extends javax.swing.JFrame {

    private String npedido;
    
    public Vendas() {
        initComponents();

     
        
         gridVenda.setModel(  
      new DefaultTableModel(  
      new Object[] []{ },  
      new String[] {"Npedido","Tipo Pedido", "Data", "Total", }) {  
  
   public boolean isCellEditable(int row, int col) {  
           return false;  
   
   }}); 
         
           
        
       
       
        
         
    }

    String codigo, barras, produto, categoria, fornecedor, referencia, vendaInicial, vendaFinal;

        BancoFuncoes bf = new BancoFuncoes();

    public void setCodigo(String d){
        codigo = d;
    }
    public String getCodigo(){
        return codigo = txtNpedido.getText();
    }
    
    public void setVendaInicial(String n){
        vendaInicial = n;
    }
    public String getVendaData1(){
        if (txtData1.getDate()!=null){
          return vendaInicial = new SimpleDateFormat("yyyy/MM/dd").format(txtData1.getDate());
        }else{
          return null;
        }
    }
    
     public String getVendaData2(){
        if (txtData1.getDate()!=null){
          return vendaInicial = new SimpleDateFormat("yyyy/MM/dd").format(txtData2.getDate());
        }else{
          return null;
        }
    }
    
    public void setVendaFinal(String n){
        vendaFinal = n;
    }
    public String getVendaFinal(){
        if (txtData2.getDate()!=null){
          return vendaFinal = new SimpleDateFormat("yyyy-MM-dd").format(txtData2.getDate());
        }else{
          return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        internalMovimentacao = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        bnPesquisa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNpedido = new javax.swing.JTextField();
        txtData1 = new com.toedter.calendar.JDateChooser();
        txtData2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridVenda = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jButton1.setText("Pesquisar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        internalMovimentacao.setClosable(true);
        internalMovimentacao.setIconifiable(true);
        internalMovimentacao.setTitle("Vendas Efetuadas");
        internalMovimentacao.setToolTipText("");
        internalMovimentacao.setVisible(true);
        internalMovimentacao.getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar"));
        jPanel1.setLayout(null);

        bnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
        bnPesquisa.setText("Consultar");
        bnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(bnPesquisa);
        bnPesquisa.setBounds(640, 50, 140, 40);

        jLabel2.setText("À:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(470, 60, 30, 30);
        jPanel1.add(txtNpedido);
        txtNpedido.setBounds(20, 60, 110, 30);
        jPanel1.add(txtData1);
        txtData1.setBounds(320, 60, 140, 30);
        jPanel1.add(txtData2);
        txtData2.setBounds(500, 60, 130, 30);

        jLabel3.setText("N° Pedido:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 30, 110, 30);

        jLabel4.setText("Período da Venda:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(320, 30, 110, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
        jButton2.setText("Consultar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(140, 50, 140, 40);

        jLabel6.setText("De:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(290, 60, 30, 30);

        internalMovimentacao.getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 10, 790, 120);

        gridVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        gridVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridVendaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(gridVenda);

        internalMovimentacao.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 140, 780, 270);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(204, 204, 204));
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        internalMovimentacao.getContentPane().add(txtTotal);
        txtTotal.setBounds(660, 430, 110, 40);

        jLabel5.setText("Total:");
        internalMovimentacao.getContentPane().add(jLabel5);
        jLabel5.setBounds(600, 430, 50, 40);

        getContentPane().add(internalMovimentacao);
        internalMovimentacao.setBounds(10, 10, 810, 530);

        setBounds(0, 0, 849, 586);
    }// </editor-fold>//GEN-END:initComponents

    private void bnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnPesquisaActionPerformed
        String data1,data2;
        
        data1 = getVendaData1();
        data2 = getVendaData2();
        
        if(data1 == null || data2 == null){
            
            JOptionPane.showMessageDialog(null,"Entre com as datas");
            
        }
        else{
        
         String msg1 = "Vendas recuperadas com sucesso";
        String msg2 = "Erro ao Recuperar vendas";
        String vsql = "SELECT v.npedido,v.tipopedido, v.data, v.total FROM venda v WHERE\n" +
        "v.dataformat BETWEEN '"+data1+"' AND '"+data2+"';";

        bf.tabelaVendas(vsql, msg1, msg2, gridVenda);
        
        
         conectaBanco cb = new conectaBanco();
              
     Connection connection = null;       
              try{

           
             //GAMBIARRA 
           
           ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(cb.DB_URL(), user, password);
            Statement s = (Statement) connection.createStatement();

            String pega = "SELECT SUM(v.total)soma " +
                          "FROM venda v where v.dataformat BETWEEN '"+data1+"' AND '"+data2+"'";

            System.out.println(pega);

            ResultSet r = s.executeQuery(pega);
                 while(r.next()) {
                        
                        String soma = r.getString("soma");  
                        int ponto = soma.indexOf(".");
                        int tamanho = soma.length();
                        int total = tamanho-(ponto+1);
                        String somaEditada = soma.replace(',', '.');

//                        System.out.println(total);

                        if(ponto == -1){
                           somaEditada = somaEditada+",00";
                        }else{
                            if(total==2)
                                somaEditada = somaEditada;
                            if(total==1)
                                somaEditada = somaEditada+"0";
                            if(total>2)
                                somaEditada = somaEditada.substring(0, ponto+3);
                        }
                        
                        txtTotal.setText(somaEditada);
                      
                      }


         }catch (Exception ex) {
                    ex.printStackTrace(System.out);
                    
                }
        }
        
    }//GEN-LAST:event_bnPesquisaActionPerformed

    private void gridVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridVendaMouseClicked
         if (evt.getClickCount() == 2) {  

             DemonstrativoVenda demovenda = new DemonstrativoVenda();
              DemonstrativoVendaBalcao demovendabalcao = new DemonstrativoVendaBalcao();
             
             Object obj = (gridVenda.getValueAt(gridVenda.getSelectedRow(), 0));  //coluna 0  
             String npedido = obj.toString();
             
             Object obj1 = (gridVenda.getValueAt(gridVenda.getSelectedRow(), 1));  //coluna 0  
             String tipo = obj1.toString();
             
             if(tipo.equals("Pedido Entrega")){

              
              demovenda.setVisible(true);   
              
               demovenda.carregaTabela1(npedido);
               demovenda.carregaTabela2(npedido);
             }
             
             else if(tipo.equals("Pedido Balcao")){
                 
                  demovendabalcao.setVisible(true);   
              
               demovendabalcao.carregaTabela1(npedido);
               demovendabalcao.carregaTabela2(npedido);
                 
             }
             
             
         }
    }//GEN-LAST:event_gridVendaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        String cod = txtNpedido.getText();
        
        if(cod.equals("")){
        
            
            JOptionPane.showMessageDialog(null,"Entre com o número do pedido");
        
        }
        else{
        String msg1 = "Vendas recuperadas com sucesso";
        String msg2 = "Erro ao Recuperar vendas";
        String vsql = "SELECT npedido,tipopedido, data, total " +
                      "FROM venda where npedido = "+cod+"";

        bf.tabelaVendas(vsql, msg1, msg2, gridVenda);
        
         conectaBanco cb = new conectaBanco();
              
 
              try{

            Connection connection = null;
             //GAMBIARRA 
           
           ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(cb.DB_URL(), user, password);
            Statement s = (Statement) connection.createStatement();

            String pega = "SELECT SUM(v.total)soma " +
                          "FROM venda v where npedido = '"+cod+"'";

            System.out.println(pega);

            ResultSet r = s.executeQuery(pega);
                 while(r.next()) {
                        
                        String soma = r.getString("soma");  
                        int ponto = soma.indexOf(".");
                        int tamanho = soma.length();
                        int total = tamanho-(ponto+1);
                        String somaEditada = soma.replace(',', '.');

//                        System.out.println(total);

                        if(ponto == -1){
                           somaEditada = somaEditada+",00";
                        }else{
                            if(total==2)
                                somaEditada = somaEditada;
                            if(total==1)
                                somaEditada = somaEditada+"0";
                            if(total>2)
                                somaEditada = somaEditada.substring(0, ponto+3);
                        }
                        
                        txtTotal.setText(somaEditada);
                      
                      }


         }catch (Exception ex) {
                    ex.printStackTrace(System.out);
                    
                }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public void carregaTabela(){
        String msg1 = "Vendas recuperadas com sucesso";
        String msg2 = "Erro ao Recuperar vendas";
        String vsql = "SELECT npedido,tipopedido, data, total " +
                      "FROM venda";

        bf.tabelaVendas(vsql, msg1, msg2, gridVenda);
    }
    
   


        
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnPesquisa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable gridVenda;
    public javax.swing.JInternalFrame internalMovimentacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public com.toedter.calendar.JDateChooser txtData1;
    public com.toedter.calendar.JDateChooser txtData2;
    private javax.swing.JTextField txtNpedido;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the npedido
     */
    public String getNpedido() {
        return npedido;
    }

    /**
     * @param npedido the npedido to set
     */
    public void setNpedido(String npedido) {
        this.npedido = npedido;
    }
}
