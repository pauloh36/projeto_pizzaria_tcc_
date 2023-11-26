/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caixa;

import Banco.Banco;
import Banco.BancoFuncoes;
import Banco.conectaBanco;
import ConfiguracaoBanco.FILE.ManageFiles;
import ConfiguracaoBanco.FILE.ManageFilesReader;
import Funcoes.GerarPdf;
import TelaClientes.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import Funcoes.LimitarCampos;
import TelaClientes.AlterarClienteCaixa;
import TelaClientes.RegistroClientesCaixa;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.text.Document;
/**
 *
 * @author Usuario
 */
public class Caixa extends javax.swing.JFrame {

   Banco ba = new Banco();
    BancoFuncoes bf = new BancoFuncoes();
    GerarPdf pdf = new GerarPdf();
    
    JInternalFrame intCliente;

    
    private String datahoje;
    
    public Caixa() {
        initComponents();
        
        //carregaProduto();
        carregaSaborPizza2();
        carregaSaborPizza1();
        carregaNumeroPedido();
        somaVendas();
        dataHoje();
        horas();
        desabilitaCampos();
        carregaTipoPruduto();
       
        
         txtTelefone.setDocument(new LimitarCampos(8));
         txtCodProduto.setDocument(new LimitarCampos(10));
         txtQtde.setDocument(new LimitarCampos(3));
        txtQtde2Sabores.setDocument(new LimitarCampos(3));
        txtObservacao.setDocument(new LimitarCampos(50));
        txtValorRecebido.setDocument(new LimitarCampos(10));
        
        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {  
              public void focusLost(java.awt.event.FocusEvent evt) {  
                  txtTelefoneFocusLost(evt);  
              }  
              
          });
        
        // ao mudar o valor do combo coloca o valor do produto no campo ao lado
        
        
       comboTipoProduto.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
              
        String tipoproduto;
        
      tipoproduto = comboTipoProduto.getSelectedItem().toString();
        
        String msg1 = "Produtos recuperados";
        String msg2 = "Erro ao Recuperar Produtos";
        String vsql = "SELECT descricao FROM produtos WHERE tipoproduto ='"+tipoproduto+"';";
        String campoSql = "descricao";

        bf.carregaDadoUnico(vsql, msg1, msg2, comboProduto, campoSql);
            
            
        
        }
      }
    );
        
         comboProduto.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){

      
      if(comboProduto.getItemCount() == 0){
          
          txtPreco.setText("");
          txtQtde.setText("");
          txtTotal.setText("");
      }
      
      else{
        
           String produto;
        
        
      produto = comboProduto.getSelectedItem().toString();
          
       ResultSet rs;
       txtQtde.setText("1");
        
        rs = ba.buscaProdutoNome(produto);
            try {

                if (ba.buscaProdutoNome(produto) != null) {
                   

                     txtPreco.setText(rs.getString("valor"));
                     txtTotal.setText(rs.getString("valor"));   
                }

                else{

              
                }
            } catch (SQLException ex) {
            }
        
      }
        }
      }
      
    );
         
         //ao trocar o valor do combo coloca o valor do produto do campo ao lado
         
        
         
        
        
          comboSabor1.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
                
        String produto;
        
      produto = comboSabor1.getSelectedItem().toString();
        
       ResultSet rs;
            
       txtQtde2Sabores.setText("1");
        
        rs = ba.buscaProdutoNome(produto);
            try {

                if (ba.buscaProdutoNome(produto) != null) {
                   

                     txtValorPizza1.setText(rs.getString("valor"));
                     
                     float valor1 = Float.parseFloat(rs.getString("valor"));
                             
                     float valor2 = 0;
                             
                        valor2 =  Float.parseFloat(txtValorPizza2.getText());
                     
                        txtQtde2Sabores.setText("1");
                        
                     if(valor1 > valor2){
                         

                          String total = String.valueOf(valor1);
                          
                          txtValorTotalPizza.setText(total);
                         
                     }
                     
                     
                     else if(valor2 > valor1){
                         
                         String total = String.valueOf(valor2);
                         
                         txtValorTotalPizza.setText(total);
                     }
                     else{
                         
                         String total = String.valueOf(valor1);
                         
                         txtValorTotalPizza.setText(total);
                         
                     }
                     
                }

                else{
                    
                    
              
                }
            } catch (SQLException ex) {
            }
        
       
        }
      }
    );
         
          
          
          
            //ao trocar o valor do combo coloca o valor do produto do campo ao lado
         
          comboSabor2.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
              
        String produto;
        
      produto = comboSabor2.getSelectedItem().toString();
        
       ResultSet rs;
            
        txtQtde2Sabores.setText("1");
        
        rs = ba.buscaProdutoNome(produto);
            try {

                if (ba.buscaProdutoNome(produto) != null) {
                   

                     txtValorPizza2.setText(rs.getString("valor"));

                     
                      float valor2 = Float.parseFloat(rs.getString("valor"));
                             
                     float valor1 = Float.parseFloat(txtValorPizza1.getText());
                     
                     txtQtde2Sabores.setText("1");
                     
                     if(valor1 > valor2){
                         

                          String total = String.valueOf(valor1);
                          
                          txtValorTotalPizza.setText(total);
                         
                          
                     }
                     
                     
                     else if(valor2 > valor1){
                         
                         String total = String.valueOf(valor2);
                         
                         txtValorTotalPizza.setText(total);
                         
                     }
                     else{
                         
                         String total = String.valueOf(valor2);
                         
                         txtValorTotalPizza.setText(total);
                         
                     }
                }

                else{

              
                }
            } catch (SQLException ex) {
            }
        
       
        }
      }
    );
          
          comboFormaPagamento.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
              
        String formaPagamento;
        
      formaPagamento = comboFormaPagamento.getSelectedItem().toString();
        
      if(formaPagamento.equals("Escolha forma de Pagamento")){
          
           FormaPagamento2();
           txtValorRecebido.setEnabled(false);
          txtTroco.setEnabled(false);
      }
      
      else if(formaPagamento.equals("Dinheiro")){
            
            FormaPagamento2();
            txtValorRecebido.setEnabled(true);
          txtTroco.setEnabled(true);
            
        }
      
      else if(formaPagamento.equals("Cartão de Crédito")){
          
          FormaPagamento();
      }
      
      else if (formaPagamento.equals("Cartão de Débito")){
          
          FormaPagamento();
          
           levalValorRecebido.setVisible(false);
          txtValorRecebido.setVisible(false);
          txtValorRecebido.setText("0");
          labelTroco.setVisible(false);
          txtTroco.setVisible(false);
          txtTroco.setText("0");
          
      }
      
        }}
    );
         
           gridCaixa.setModel(  
      new DefaultTableModel(  
      new Object[] []{ },  
      new String[] {"Descricao", "Qtde", "Preco", "Total"}) {  
  
   public boolean isCellEditable(int row, int col) {  
           return false;  
   
   }});   
          
           carregaTabela();
     
           
          
      
    }

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadioPartes = new javax.swing.ButtonGroup();
        radioTipoPedido = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        internalCaixa = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPontoRef = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrarCliente = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        txtTelefone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridCaixa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCodProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboProduto = new javax.swing.JComboBox();
        txtPreco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtQtde = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnIncluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        comboSabor1 = new javax.swing.JComboBox();
        comboSabor2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtValorPizza1 = new javax.swing.JTextField();
        txtValorTotalPizza = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtValorPizza2 = new javax.swing.JTextField();
        btnIncluir2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtQtde2Sabores = new javax.swing.JTextField();
        comboTipoProduto = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        txtTotalVenda = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboFormaPagamento = new javax.swing.JComboBox();
        txtValorRecebido = new javax.swing.JTextField();
        levalValorRecebido = new javax.swing.JLabel();
        labelTroco = new javax.swing.JLabel();
        txtTroco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        radioPedidoBalcao = new javax.swing.JRadioButton();
        rapidoPedidoEntrega = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtNPedido = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txDataHoje = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        internalCaixa.setTitle("PDV");
        internalCaixa.setVisible(true);
        internalCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                internalCaixaMousePressed(evt);
            }
        });
        internalCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                internalCaixaKeyPressed(evt);
            }
        });
        internalCaixa.getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));
        jPanel1.setLayout(null);

        jLabel1.setText("Cliente:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 90, 70, 30);

        txtCliente.setEditable(false);
        txtCliente.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtCliente);
        txtCliente.setBounds(140, 90, 360, 30);

        jLabel2.setText("Telefone:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 40, 60, 30);

        txtEndereco.setEditable(false);
        txtEndereco.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtEndereco);
        txtEndereco.setBounds(140, 130, 360, 30);

        jLabel3.setText("Endereço:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 130, 90, 30);

        txtBairro.setEditable(false);
        txtBairro.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtBairro);
        txtBairro.setBounds(140, 170, 360, 30);

        jLabel4.setText("Bairro:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 170, 90, 30);

        txtPontoRef.setEditable(false);
        txtPontoRef.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtPontoRef);
        txtPontoRef.setBounds(140, 210, 360, 30);

        jLabel5.setText("Ponto de Refêrencia:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 210, 130, 30);

        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/registro.png"))); // NOI18N
        btnRegistrarCliente.setText("Registrar Novo Cliente");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarCliente);
        btnRegistrarCliente.setBounds(280, 30, 190, 50);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizar.png"))); // NOI18N
        btnAlterar.setText("Alterar Dados do Cliente");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar);
        btnAlterar.setBounds(180, 250, 250, 40);

        txtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyPressed(evt);
            }
        });
        jPanel1.add(txtTelefone);
        txtTelefone.setBounds(140, 40, 100, 30);

        internalCaixa.getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 70, 530, 300);

        gridCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Descricao", "Qtde", "Preco", "Total"
            }
        ));
        gridCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridCaixaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gridCaixa);

        internalCaixa.getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 370, 1190, 100);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));
        jPanel2.setLayout(null);

        jLabel6.setText("Tipo Produto:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 50, 100, 30);

        txtCodProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodProdutoFocusLost(evt);
            }
        });
        txtCodProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodProdutoKeyPressed(evt);
            }
        });
        jPanel2.add(txtCodProduto);
        txtCodProduto.setBounds(110, 20, 90, 30);

        jLabel7.setText("Preço:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(180, 110, 40, 30);

        jPanel2.add(comboProduto);
        comboProduto.setBounds(20, 140, 150, 30);

        txtPreco.setEditable(false);
        txtPreco.setBackground(new java.awt.Color(204, 204, 204));
        txtPreco.setText("0");
        jPanel2.add(txtPreco);
        txtPreco.setBounds(180, 140, 70, 30);

        jLabel8.setText("Produto:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 110, 90, 30);

        txtQtde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtdeFocusLost(evt);
            }
        });
        txtQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdeActionPerformed(evt);
            }
        });
        txtQtde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtdeKeyPressed(evt);
            }
        });
        jPanel2.add(txtQtde);
        txtQtde.setBounds(260, 140, 80, 30);

        jLabel9.setText("Qtde:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(260, 110, 50, 30);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtTotal);
        txtTotal.setBounds(350, 140, 80, 30);

        jLabel10.setText("Total:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(350, 110, 40, 30);

        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/addproduto.png"))); // NOI18N
        btnIncluir.setText("Incluir no Pedido");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnIncluir);
        btnIncluir.setBounds(450, 120, 160, 50);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pizza Com 2 Sabores:"));
        jPanel3.setLayout(null);

        jLabel11.setText("Sabor 1:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(10, 30, 60, 30);

        jPanel3.add(comboSabor1);
        comboSabor1.setBounds(60, 30, 150, 30);

        jPanel3.add(comboSabor2);
        comboSabor2.setBounds(380, 30, 150, 30);

        jLabel12.setText("Sabor 2:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(320, 30, 70, 30);

        txtValorPizza1.setEditable(false);
        txtValorPizza1.setBackground(new java.awt.Color(204, 204, 204));
        txtValorPizza1.setText("0");
        jPanel3.add(txtValorPizza1);
        txtValorPizza1.setBounds(220, 30, 70, 30);

        txtValorTotalPizza.setEditable(false);
        txtValorTotalPizza.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.add(txtValorTotalPizza);
        txtValorTotalPizza.setBounds(220, 80, 70, 30);

        jLabel13.setText("Valor da Pizza:");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(120, 80, 80, 30);

        txtValorPizza2.setEditable(false);
        txtValorPizza2.setBackground(new java.awt.Color(204, 204, 204));
        txtValorPizza2.setText("0");
        jPanel3.add(txtValorPizza2);
        txtValorPizza2.setBounds(540, 30, 70, 30);

        btnIncluir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/addproduto.png"))); // NOI18N
        btnIncluir2.setText("Incluir no Pedido");
        btnIncluir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluir2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnIncluir2);
        btnIncluir2.setBounds(450, 70, 160, 40);

        jLabel21.setText("Qtde: ");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(10, 80, 60, 30);

        txtQtde2Sabores.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                txtQtde2SaboresHierarchyChanged(evt);
            }
        });
        txtQtde2Sabores.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtde2SaboresFocusLost(evt);
            }
        });
        txtQtde2Sabores.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtQtde2SaboresPropertyChange(evt);
            }
        });
        jPanel3.add(txtQtde2Sabores);
        txtQtde2Sabores.setBounds(60, 80, 40, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 180, 640, 120);

        jPanel2.add(comboTipoProduto);
        comboTipoProduto.setBounds(20, 80, 130, 30);

        jLabel17.setText("Codigo Produto:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(20, 20, 100, 30);

        internalCaixa.getContentPane().add(jPanel2);
        jPanel2.setBounds(530, 60, 660, 310);

        jLabel14.setText("Observação: ");
        internalCaixa.getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 690, 90, 30);
        internalCaixa.getContentPane().add(jTextField12);
        jTextField12.setBounds(10, 730, 410, 30);

        txtTotalVenda.setEditable(false);
        txtTotalVenda.setBackground(new java.awt.Color(204, 204, 204));
        txtTotalVenda.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        internalCaixa.getContentPane().add(txtTotalVenda);
        txtTotalVenda.setBounds(1040, 480, 140, 50);

        jLabel15.setText("Total:");
        internalCaixa.getContentPane().add(jLabel15);
        jLabel15.setBounds(990, 480, 40, 50);

        jLabel16.setText("Forma de Pagamento: ");
        internalCaixa.getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 540, 130, 30);

        comboFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha forma de Pagamento", "Dinheiro", "Cartão de Crédito", "Cartão de Débito" }));
        internalCaixa.getContentPane().add(comboFormaPagamento);
        comboFormaPagamento.setBounds(160, 540, 220, 30);

        txtValorRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorRecebidoFocusLost(evt);
            }
        });
        txtValorRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorRecebidoKeyPressed(evt);
            }
        });
        internalCaixa.getContentPane().add(txtValorRecebido);
        txtValorRecebido.setBounds(510, 540, 70, 30);

        levalValorRecebido.setText("Valor Recebido: ");
        internalCaixa.getContentPane().add(levalValorRecebido);
        levalValorRecebido.setBounds(420, 540, 100, 30);

        labelTroco.setText("Troco: ");
        internalCaixa.getContentPane().add(labelTroco);
        labelTroco.setBounds(620, 540, 50, 30);

        txtTroco.setBackground(new java.awt.Color(204, 204, 204));
        txtTroco.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        internalCaixa.getContentPane().add(txtTroco);
        txtTroco.setBounds(680, 510, 140, 60);

        jButton1.setText("Finalizar Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        internalCaixa.getContentPane().add(jButton1);
        jButton1.setBounds(930, 540, 120, 30);

        jLabel19.setText("Observação: ");
        internalCaixa.getContentPane().add(jLabel19);
        jLabel19.setBounds(20, 500, 90, 30);
        internalCaixa.getContentPane().add(txtObservacao);
        txtObservacao.setBounds(140, 500, 470, 30);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Pedido"));
        jPanel4.setLayout(null);

        radioTipoPedido.add(radioPedidoBalcao);
        radioPedidoBalcao.setText("Pedido Balcão");
        radioPedidoBalcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPedidoBalcaoActionPerformed(evt);
            }
        });
        jPanel4.add(radioPedidoBalcao);
        radioPedidoBalcao.setBounds(50, 20, 140, 23);

        radioTipoPedido.add(rapidoPedidoEntrega);
        rapidoPedidoEntrega.setText("Pedido Entrega");
        rapidoPedidoEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapidoPedidoEntregaActionPerformed(evt);
            }
        });
        jPanel4.add(rapidoPedidoEntrega);
        rapidoPedidoEntrega.setBounds(200, 20, 150, 23);

        internalCaixa.getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 530, 60);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));
        jPanel5.setToolTipText("");
        jPanel5.setLayout(null);

        jLabel20.setText("Número Pedido: ");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(40, 20, 100, 30);

        txtNPedido.setEditable(false);
        txtNPedido.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.add(txtNPedido);
        txtNPedido.setBounds(130, 20, 60, 30);

        jLabel22.setText("Data:  ");
        jPanel5.add(jLabel22);
        jLabel22.setBounds(210, 20, 50, 30);

        txDataHoje.setEnabled(false);
        jPanel5.add(txDataHoje);
        txDataHoje.setBounds(250, 20, 130, 30);

        jLabel23.setText("Horário:");
        jPanel5.add(jLabel23);
        jLabel23.setBounds(400, 20, 70, 30);

        txtHora.setEditable(false);
        jPanel5.add(txtHora);
        txtHora.setBounds(460, 20, 100, 30);

        internalCaixa.getContentPane().add(jPanel5);
        jPanel5.setBounds(530, 0, 660, 60);

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        internalCaixa.getContentPane().add(jButton2);
        jButton2.setBounds(1060, 540, 120, 30);

        getContentPane().add(internalCaixa);
        internalCaixa.setBounds(10, 10, 1210, 610);

        setBounds(0, 0, 1272, 716);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        
      RegistroClientesCaixa registroClientes = new RegistroClientesCaixa();  
      
  
      registroClientes.setVisible(true);  

      
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void txtQtdeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtdeFocusLost
       preencheTotal();
       
   
    }//GEN-LAST:event_txtQtdeFocusLost

    private void txtQtde2SaboresHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_txtQtde2SaboresHierarchyChanged
        
        
        
        
    }//GEN-LAST:event_txtQtde2SaboresHierarchyChanged

    private void txtQtde2SaboresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtde2SaboresFocusLost
      
    }//GEN-LAST:event_txtQtde2SaboresFocusLost

    private void txtQtde2SaboresPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtQtde2SaboresPropertyChange

    }//GEN-LAST:event_txtQtde2SaboresPropertyChange

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed

        if(comboProduto.getSelectedItem().toString().equals("")){
            
            JOptionPane.showMessageDialog(null,"Selecione um produto");
            
            
        }
        
        else if(txtQtde.getText().equals("")){
            
            JOptionPane.showMessageDialog(null,"Insira a quantidade");
            
        }
        
        else {
        
        preencheTotal();
        
        
        int pedido,qtde;
        String produto;
        float valorproduto,total;
        
        
        pedido = Integer.parseInt(txtNPedido.getText());
        qtde = Integer.parseInt(txtQtde.getText());
        
        
        produto = comboProduto.getSelectedItem().toString();
        
        valorproduto = Float.parseFloat(txtPreco.getText());
        total = Float.parseFloat(txtTotal.getText());
        
        
        ba.gravarItensCompra(pedido, qtde, produto, valorproduto, total);

                limpacampos1();
              
                carregaTabela();
                somaVendas();
        }  
                
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnIncluir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluir2ActionPerformed

        if(comboSabor1.getSelectedItem().toString().equals("") || comboSabor2.getSelectedItem().toString().equals("") ){
            
            JOptionPane.showMessageDialog(null,"Selecione os sabores");
            
            
        }
        
        else if(txtQtde2Sabores.getText().equals("")){
            
            JOptionPane.showMessageDialog(null,"Insira a quantidade");
            
        }
        
        else{
        
        preencheTotal2();
        
        String sabor1, sabor2,saborfinal;
        
        sabor1 = comboSabor1.getSelectedItem().toString();
        sabor2 = comboSabor2.getSelectedItem().toString();
        
        saborfinal = "Meio a Meio de "+sabor1+" e "+sabor2;
        
        int pedido,qtde;
  
        float valorproduto = 0,total,valor1,valor2;
        
        
        pedido = Integer.parseInt(txtNPedido.getText());
        qtde = Integer.parseInt(txtQtde2Sabores.getText());
        
 

        total = Float.parseFloat(txtValorTotalPizza.getText());
        
        valor1 = Float.parseFloat(txtValorPizza1.getText());
        valor2 = Float.parseFloat(txtValorPizza2.getText());
        
        if(valor1 > valor2){
            
            valorproduto += valor1;
            
            
        }
        
        else if (valor2 > valor1){
        
        valorproduto += valor2;
        
    }
        
        
        ba.gravarItensCompra(pedido, qtde, saborfinal, valorproduto, total);

               
                limpacampos2();
              
                carregaTabela();
                somaVendas();
        }
    }//GEN-LAST:event_btnIncluir2ActionPerformed

    private void gridCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridCaixaMouseClicked
         gridCaixa.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                 try{
                     
                             conectaBanco cb = new conectaBanco();  
                     
                     if(e.getClickCount() == 2){
                       int    col = gridCaixa.getSelectedColumn();
                       int    lin = gridCaixa.getSelectedRow();
                    String result =(String) gridCaixa.getValueAt(lin, 0);
                    
                    System.out.println(result);
                    
                         com.mysql.jdbc.Connection connection = null;
                          //GAMBIARRA 
           
           ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(cb.DB_URL(), user, password);
                         com.mysql.jdbc.Statement s = (com.mysql.jdbc.Statement) connection.createStatement();
                         
                    Object[] options = { "Sim", "Não" };
                        int opcao = JOptionPane.showOptionDialog(null, "Deseja Excluir Esta Venda ?", "AVISO",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                        if(opcao == 0){
                                    String msg1 = "Venda Excluída";
                                    String msg2 = "Erro ao Excluir Venda";
                                    String sql = "delete from itensPedido WHERE produto='"+result+"'";

                                    System.out.println(sql);
                                    s.execute(sql);  
                                    
                                    
                        }
                                        
                         carregaTabela();
                         somaVendas();
                         
                          if(gridCaixa.getRowCount() == 0){
        
                                            txtTotalVenda.setText("");
      
                                        }
                     }                    
                     
                    }catch (Exception ex) {
                       ex.printStackTrace(System.out);
   //                    JOptionPane.showMessageDialog(null, "Não Foi Possível Abrir Serviços");
                    }
                }   
          });
    }//GEN-LAST:event_gridCaixaMouseClicked

    private void txtQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdeActionPerformed

    private void txtValorRecebidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorRecebidoFocusLost

        
        String valorrecebido = txtValorRecebido.getText();
        
        if(valorrecebido.equals("")){
                 
                 txtTroco.setText("");
                 
             }
             else{
        
        
        String valorrecebidoEditada = valorrecebido.replace(',', '.');
        
        txtValorRecebido.setText(valorrecebidoEditada);
        
        operacaoTroco();
        
        }
    }//GEN-LAST:event_txtValorRecebidoFocusLost

    private void txtValorRecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecebidoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){    

            
             String valorrecebido = txtValorRecebido.getText();
             
             if(valorrecebido.equals("")){
                 
                 txtTroco.setText("");
                 
             }
             else{
             
        String valorrecebidoEditada = valorrecebido.replace(',', '.');
        
        txtValorRecebido.setText(valorrecebidoEditada);
            
            
            operacaoTroco();     
             }
}  
    }//GEN-LAST:event_txtValorRecebidoKeyPressed

    private void txtQtdeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdeKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){    

            preencheTotal();
            
}  
   
    }//GEN-LAST:event_txtQtdeKeyPressed

    private void radioPedidoBalcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPedidoBalcaoActionPerformed
       
        if(radioPedidoBalcao.isSelected()){
            habilitaCamposBalcao();
            txtTelefone.setEnabled(false);
            limparTodosCampos();
            horas();
            horas();
            btnAlterar.setEnabled(false);
            btnRegistrarCliente.setEnabled(false);
            
        }
        
    }//GEN-LAST:event_radioPedidoBalcaoActionPerformed

    private void rapidoPedidoEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapidoPedidoEntregaActionPerformed
        
        if(rapidoPedidoEntrega.isSelected()){
            
            habilitaCamposEntrega();
            txtTelefone.setEnabled(true);
            limparTodosCampos();
            horas();
        }
        
    }//GEN-LAST:event_rapidoPedidoEntregaActionPerformed

    private void internalCaixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_internalCaixaKeyPressed
        
    }//GEN-LAST:event_internalCaixaKeyPressed

    private void internalCaixaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_internalCaixaMousePressed
     
    }//GEN-LAST:event_internalCaixaMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ResultSet rs;
        
        String tel = txtTelefone.getText();
        if(gridCaixa.getRowCount() == 0){

            JOptionPane.showMessageDialog(null, "Insira ao menos um produto ao pedido");

        }
        
        else if (rapidoPedidoEntrega.isSelected() && tel.equals("")){
       
                
                            JOptionPane.showMessageDialog(null, "Insira o telefone do cliente");

            
        }

        else if (comboFormaPagamento.getSelectedItem().toString().equals("Escolha forma de Pagamento")){

            JOptionPane.showMessageDialog(null, "Escolha a forma de pagamento");
            comboFormaPagamento.requestFocus();

        }

        else {
            Object[] options = { "Sim", "Não" };
            int opcao = JOptionPane.showOptionDialog(null, "Finalizar Venda?", "AVISO",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if(opcao == 0){

                horas();

                int pedido;
                String produtos = "",preco="",pedido2,pedido3,formapagamento,observacao,telefone,data,hora,tipopedido = "",situacao ="Aberto";
                float troco,total,valorrecebido;
                
                if(radioPedidoBalcao.isSelected()){
                    
                    tipopedido += "Pedido Balcao";
                    
                }
                
                else if(rapidoPedidoEntrega.isSelected()){
                    
                     tipopedido += "Pedido Entrega";
                    
                }

                pedido = Integer.parseInt(txtNPedido.getText());
                pedido2 = String.valueOf("Pedido: "+txtNPedido.getText());
                pedido3 = String.valueOf(txtNPedido.getText());
                telefone = txtTelefone.getText();
                data = getDatahoje();
                String dataformat = getDataFormat();
                hora = txtHora.getText();

                formapagamento = comboFormaPagamento.getSelectedItem().toString();
                observacao = txtObservacao.getText();

                valorrecebido = Float.parseFloat(txtValorRecebido.getText());
                troco = Float.parseFloat(txtTroco.getText());
                total = Float.parseFloat(txtTotalVenda.getText());

                ba.gravarVenda(pedido, telefone, formapagamento, observacao, total,valorrecebido,troco,data,hora,tipopedido,situacao,dataformat);

                carregaNumeroPedido();
                carregaTabela();
                limparTodosCampos();

                desabilitaCampos();
                
                radioTipoPedido.clearSelection();
                
                
                rs = ba.buscaProdutos(pedido3);

   
                try {

                    if (ba.buscaProdutos(pedido3) != null) {
                        produtos += rs.getString("produto");
                        preco += rs.getString("preco");
                      

                    }
                    else{

                        
                    }
                } catch (SQLException ex) {
                }
                
                
                
                //gerar pdf 
                
                try {  
                pdf.main(new String[]{pedido2,data,hora,produtos,preco}); 
            } catch (Exception ex) {
                Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex);
            }
                // ---------------
                
                // chama a tela gridpedidos
                
                  
                // ---------------
                 
         
            
            Object[] options2 = { "Sim", "Não" };
            int opcao2 = JOptionPane.showOptionDialog(null, "Imprimir Cupom?", "AVISO",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);

          if(opcao2 == 0){
          
           String path = System.getProperty("user.dir") + "\\cupom.pdf";
           pdf.abrirPdf(path);
          
          }
  
                 gridPedidos pedidos = new gridPedidos();  
    
                 
                if (pedidos.instance == null) {
                    pedidos.instance = new gridPedidos();
                    pedidos.instance.setVisible(true);
                } else {
                    pedidos.instance.requestFocusInWindow();
                    pedidos.carregaTabelaPedidos();
                }
            
        }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Object[] options = { "Sim", "Não" };
                        int opcao = JOptionPane.showOptionDialog(null,"Ao sair se houver vendas, elas serão excluídas\n\nDeseja continuar ?", "AVISO",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                        if(opcao == 0){
                            
                              int npedido = Integer.parseInt(txtNPedido.getText());
                            
                              String msg1a = "Vendas Excluídas";
                              String msg2a = "Erro ao Excluir Vendas";
                              String sqla = "delete from venda WHERE npedido='"+npedido+"'";
                              
                              bf.salvar(sqla, msg1a, msg2a);
                            
                              String msg1 = "Itens Excluída";
                              String msg2 = "Erro ao Excluir Itens";
                              String sql = "delete from itensPedido WHERE npedido='"+npedido+"'";
                              
                              bf.salvar(sql, msg1, msg2);
                              
                            this.internalCaixa.dispose();
                          
                        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        
     AlterarClienteCaixa alterarClientes = new AlterarClienteCaixa();  
      
  
      alterarClientes.setVisible(true);  

        
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtCodProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodProdutoFocusLost
       
       pesquisaCodigoProduto();
        
        
    }//GEN-LAST:event_txtCodProdutoFocusLost

    private void txtCodProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProdutoKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){    
         
          pesquisaCodigoProduto();
         
         }
    }//GEN-LAST:event_txtCodProdutoKeyPressed

    private void txtTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
         
          buscaCliente();
         
         }
    }//GEN-LAST:event_txtTelefoneKeyPressed

    
    private void txtTelefoneFocusLost(java.awt.event.FocusEvent evt) {  
      
        buscaCliente();
        
        
    }
    
   
    
    
     /*public void carregaProduto(){;
        String msg1 = "roduto recuperados";
        String msg2 = "Erro ao Recuperar Tipo Produto ";
        String vsql = "SELECT descricao FROM produtos order by descricao";
        String campoSql = "descricao";

        bf.carregaDadoUnico(vsql, msg1, msg2, comboProduto, campoSql);
    }*/
     
      public void carregaSaborPizza1(){;
         String msg1 = "Produto recuperados";
        String msg2 = "Erro ao Recuperar Tipo Produto ";
        String vsql = "SELECT descricao FROM produtos where tipoproduto ='Pizza' ";
        String campoSql = "descricao";
        bf.carregaDadoUnico(vsql, msg1, msg2, comboSabor1, campoSql);
    }
      
      public void carregaSaborPizza2(){;
        String msg1 = "Produto recuperados";
        String msg2 = "Erro ao Recuperar Tipo Produto ";
        String vsql = "SELECT descricao FROM produtos where tipoproduto ='Pizza' ";
        String campoSql = "descricao";

        bf.carregaDadoUnico(vsql, msg1, msg2, comboSabor2, campoSql);
    }
    
    public void carregaNumeroPedido(){
        
             conectaBanco cb = new conectaBanco();
         
        String msg1 = "Código compra recuperado";
        String msg2 = "Erro ao Recuperar código compra";
        String vsql = "select max(npedido)ultimo from venda";
                
        com.mysql.jdbc.Connection connection = null;

       try {
        ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
       Class.forName(cb.JDBC_DRIVER()).newInstance();
        connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(cb.DB_URL(), user, password);

            com.mysql.jdbc.Statement s = (com.mysql.jdbc.Statement) connection.createStatement();

              ResultSet rs = s.executeQuery(vsql);

                    while (rs.next()){
                       
                       int ultimo = Integer.parseInt(rs.getString("ultimo"));
    
                                  txtNPedido.setText(String.valueOf(ultimo+1));
                                  
                       
                   }
                  
            System.out.println("Conectado ao banco com sucesso");

             s.close();
             connection.close();

             System.out.println(msg1);
             System.out.println(vsql);
             return;

       }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, msg2);
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("Error: " + ex.getErrorCode());
          System.out.println(vsql);
          return;
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, msg2);
          System.out.println(vsql);
          System.out.println("Dados não filtrados" + e);
          return;
        }
        
        
    }
    
    
     public void somaVendas(){
               conectaBanco cb = new conectaBanco();
               int codigocompra = Integer.parseInt(txtNPedido.getText());
               
              
               Connection connection = null;
               
              try{

            
            ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

           
            String user = manageFilesReader.getArrayDoArquivo()[3];
            String password = manageFilesReader.getArrayDoArquivo()[4]; 
       
          Class.forName(cb.JDBC_DRIVER()).newInstance();
          connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(cb.DB_URL(), user, password);
          
            Statement s = (Statement) connection.createStatement();

            String pega = "SELECT SUM(total)soma " +
                          "FROM itensPedido " +
                          "WHERE npedido = "+codigocompra+"";

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
                        
                        txtTotalVenda.setText(somaEditada);
                      
                      }


         }catch (Exception ex) {
                    ex.printStackTrace(System.out);
                    
                }
   }
    
    
    
    
    
    
     public void carregaTabela(){
       
         int npedido = Integer.parseInt(txtNPedido.getText());
         
         String msg1 = "Itens recuperados com sucesso";
        String msg2 = "Erro ao Recuperar Clientes";
        String vsql = "SELECT " +
                        "produto, qtde, preco, total " +
                      "FROM " +
                        "itenspedido where npedido = "+npedido+"";


        bf.tabelaCaixa(vsql, msg1, msg2, gridCaixa);
    }
     
     public void limpacampos1(){
         
                txtCodProduto.setText("");    
                comboProduto.setSelectedItem("");
                txtPreco.setText("");
                txtCodProduto.setText("");
                txtQtde.setText("");
                txtTotal.setText("");
         
     }
     
     
     public void limpacampos2(){
         
      
                comboSabor1.setSelectedItem("");
                comboSabor2.setSelectedItem("");
                txtValorPizza1.setText("0");
                txtValorPizza2.setText("0");
                txtQtde2Sabores.setText("");
                txtValorTotalPizza.setText("");
         
     }
     
     public void limparTodosCampos(){
         
                txtTelefone.setText("");
                txtCliente.setText("");
                txtEndereco.setText("");
                txtBairro.setText("");
                txtPontoRef.setText("");
                
                
                comboProduto.setSelectedItem("");
                comboTipoProduto.setSelectedItem("");
                txtPreco.setText("");
                txtCodProduto.setText("");
                txtQtde.setText("");
                txtTotal.setText("");
         
                
                comboSabor1.setSelectedItem("");
                comboSabor2.setSelectedItem("");
                txtValorPizza1.setText("0");
                txtValorPizza2.setText("0");
                txtQtde2Sabores.setText("");
                txtValorTotalPizza.setText("");
                txtObservacao.setText("");
                comboFormaPagamento.setSelectedItem("Escolha forma de Pagamento");
                txtValorRecebido.setText("");
                txtTroco.setText("");
                txtTotalVenda.setText("");
     }
     
     public void desabilitaCampos(){
         
         txtTelefone.setEnabled(false);
         txtCodProduto.setEnabled(false);
         txtQtde.setEnabled(false);
         txtQtde2Sabores.setEnabled(false);
         txtObservacao.setEnabled(false);
         txtValorRecebido.setEnabled(false);
         comboProduto.setEnabled(false);
         comboSabor1.setEnabled(false);
         comboSabor2.setEnabled(false);
         comboFormaPagamento.setEnabled(false);
         txtTelefone.setEnabled(false);
         btnIncluir.setEnabled(false);
         btnRegistrarCliente.setEnabled(false);
         btnAlterar.setEnabled(false);
      
         btnIncluir2.setEnabled(false);
          btnIncluir2.setEnabled(false);
         jButton1.setEnabled(false);
         txtTroco.setEnabled(false);
         comboTipoProduto.setEnabled(false);
         
     }
     
     public void habilitaCamposEntrega(){
         
         txtTelefone.setEnabled(true);
         txtCodProduto.setEnabled(true);
         txtQtde.setEnabled(true);
         txtQtde2Sabores.setEnabled(true);
         txtObservacao.setEnabled(true);
         txtValorRecebido.setEnabled(true);
         comboProduto.setEnabled(true);
         comboSabor1.setEnabled(true);
         comboSabor2.setEnabled(true);
         comboFormaPagamento.setEnabled(true);
         txtTelefone.setEnabled(true);
         btnIncluir.setEnabled(true);
         btnRegistrarCliente.setEnabled(true);
         btnAlterar.setEnabled(true);
         btnIncluir2.setEnabled(true);
          btnIncluir2.setEnabled(true);
         jButton1.setEnabled(true);
          comboTipoProduto.setEnabled(true);
         
     }
     
     public void preencheTelefone(String telefone){
         
         String ax = telefone;
         
         txtTelefone.setText(ax);
         
     }
     
     public void habilitaCamposBalcao(){
         
         txtTelefone.setEnabled(true);
         txtCodProduto.setEnabled(true);
         txtQtde.setEnabled(true);
         txtQtde2Sabores.setEnabled(true);
         txtObservacao.setEnabled(true);
         txtValorRecebido.setEnabled(true);
         comboProduto.setEnabled(true);
         comboSabor1.setEnabled(true);
         comboSabor2.setEnabled(true);
         comboFormaPagamento.setEnabled(true);
         txtTelefone.setEnabled(true);
         btnIncluir.setEnabled(true);
          comboTipoProduto.setEnabled(true);
         btnIncluir2.setEnabled(true);
          btnIncluir2.setEnabled(true);
         jButton1.setEnabled(true);
         
         
     }
     
     
     
     public void FormaPagamento(){
         
         levalValorRecebido.setVisible(false);
          txtValorRecebido.setVisible(false);
          txtValorRecebido.setText("0");
          labelTroco.setVisible(false);
          txtTroco.setVisible(false);
          txtTroco.setText("0");
         
     }
     
     public void FormaPagamento2(){
         
          levalValorRecebido.setVisible(true);
          txtValorRecebido.setVisible(true);
          txtValorRecebido.setText("");
          labelTroco.setVisible(true);
          txtTroco.setVisible(true);
          txtTroco.setText("");
     }
     
     public void preencheTotal(){
         
       int  qtde;
        float preco,aux;
        
        preco = Float.parseFloat(txtPreco.getText());
        qtde = Integer.parseInt(txtQtde.getText());
        
        aux = (preco * qtde);
        
        String total = String.valueOf(aux);
        
        txtTotal.setText(total);
         
         
     }
     
     public void preencheTotal2(){
         
          float total,aux;
        int qtde;

        String total2;
        
       
        
        qtde = Integer.parseInt(txtQtde2Sabores.getText());
        
        total = Float.parseFloat(txtValorTotalPizza.getText());
        
        aux = total*qtde;
        
        
        
         total2 = String.valueOf(aux);
        
        txtValorTotalPizza.setText(total2);
         
         
     }
     
     public void pesquisaCodigoProduto(){
         
          ResultSet rs;

        String codigoproduto = txtCodProduto.getText();
      

        if("".equals(codigoproduto)){

       
            
        }

        else{

            rs = ba.buscaProduto(codigoproduto);
            try {

                if (ba.buscaProduto(codigoproduto) != null) {
                    String  produto,tipo ;

                    tipo = rs.getString("tipoproduto");
                    produto = rs.getString("descricao");
                 
                    comboTipoProduto.setSelectedItem(tipo);
                    comboProduto.setSelectedItem(produto);

                }

                else{

                    
                }
            } catch (SQLException ex) {
            }
        }
         
         
     }
     
     public void operacaoTroco(){
         
         float total, valorrecebido, troco;
        String aux;
        
        total = Float.parseFloat(txtTotalVenda.getText());
        valorrecebido = Float.parseFloat(txtValorRecebido.getText());
        
        if(valorrecebido < total){
            
            JOptionPane.showMessageDialog(null,"Atenção Valor recebido menor que o valor total");
            
        }
        else{
        
        troco =  valorrecebido - total ;
        
        aux = String.valueOf(troco);
        
        txtTroco.setText(aux);
     }
        
         
     }
     
     public void buscaCliente(){
         
         
           ResultSet rs;
   

        String telefone = txtTelefone.getText();

        if("".equals(telefone)){

        }

        
        else{
            
            
            rs = ba.buscaCliente(telefone);
            try {

                if (ba.buscaCliente(telefone) != null) {

                   txtCliente.setText(rs.getString("nome"));
                   txtEndereco.setText(rs.getString("endereco"));
                   txtBairro.setText(rs.getString("bairro"));
                   txtPontoRef.setText(rs.getString("complemento"));
                       
                   
                }
                else{

                }
            } catch (SQLException ex) {
            }
        } 
         
         
     }
     
     
     public void dataHoje(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
        String novaData = formatador.format(data);  
        txDataHoje.setDate(data);
        
        
   }
     
     public void horas(){
         
         SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");  
  
       txtHora.setText(sdf.format(Calendar.getInstance().getTime()));  
            
     }
     
      public void carregaTipoPruduto(){;
        String msg1 = "Tipo Produto recuperados";
        String msg2 = "Erro ao Recuperar Tipo Produto ";
        String vsql = "SELECT categoria FROM categoriaProduto order by categoria";
        String campoSql = "categoria";

        bf.carregaDadoUnico(vsql, msg1, msg2, comboTipoProduto, campoSql);
    }
    
     
    
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnIncluir2;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboFormaPagamento;
    private javax.swing.JComboBox comboProduto;
    private javax.swing.JComboBox comboSabor1;
    private javax.swing.JComboBox comboSabor2;
    private javax.swing.JComboBox comboTipoProduto;
    private javax.swing.JTable gridCaixa;
    private javax.swing.ButtonGroup grupoRadioPartes;
    public javax.swing.JInternalFrame internalCaixa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JLabel labelTroco;
    private javax.swing.JLabel levalValorRecebido;
    private javax.swing.JRadioButton radioPedidoBalcao;
    private javax.swing.ButtonGroup radioTipoPedido;
    private javax.swing.JRadioButton rapidoPedidoEntrega;
    private com.toedter.calendar.JDateChooser txDataHoje;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNPedido;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtPontoRef;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtde;
    private javax.swing.JTextField txtQtde2Sabores;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalVenda;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtValorPizza1;
    private javax.swing.JTextField txtValorPizza2;
    private javax.swing.JTextField txtValorRecebido;
    private javax.swing.JTextField txtValorTotalPizza;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the datahoje
     */
    public String getDatahoje() {
       if (txDataHoje.getDate()!=null){
          return datahoje = new SimpleDateFormat("dd/MM/yyyy").format(txDataHoje.getDate());
        }else{
          return null;
        }
    }
     public String getDataFormat() {
       if (txDataHoje.getDate()!=null){
          return datahoje = new SimpleDateFormat("yyyy/MM/dd").format(txDataHoje.getDate());
        }else{
          return null;
        }
    }

    /**
     * @param datahoje the datahoje to set
     */
    public void setDatahoje(String n) {
        datahoje = n;
    }
}
