/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelaClientes;


import Banco.Banco;
import Banco.BancoCep;
import Banco.BancoFuncoes;
import BancoObjeto.ObjetoCliente;
import Funcoes.LimitarCampos;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paulo
 */
public class Cliente extends javax.swing.JPanel {

    BancoCep bacep = new BancoCep();
    Banco ba = new Banco();
    BancoFuncoes bf = new BancoFuncoes();
    
    
    public Cliente() {
        initComponents();
        carregaTabela();
 
        // BLOQUEA A EDIÇÃO DA JTABLE
        
      gridCliente.setModel(  
      new DefaultTableModel(  
      new Object[] []{ },  
      new String[] {"Telefone", "Nome", "UF", "Cidade", "Bairro", "Endereco", "Numero", "Cep", "Complemento" }) {  
  
   public boolean isCellEditable(int row, int col) {  
           return false;  
   
   }});   
      
      gridHistorico.setModel(  
      new DefaultTableModel(  
      new Object[] []{ },  
      new String[] {"Telefone", "Nome", "N°Pedido", "Total", "Data" }) {  
  
   public boolean isCellEditable(int row, int col) {  
           return false;  
   
   }});   
        
      
      

       
        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {  
              public void focusLost(java.awt.event.FocusEvent evt) {  
                  txtCepFocusLostCep(evt);  
              }  
              
          });
        
        // LIMITA O TAMANHO DOS CAMPOS
        
        txtNome.setDocument(new LimitarCampos(50));
        txtCidade.setDocument(new LimitarCampos(50));
        txtBairro.setDocument(new LimitarCampos(50));
        txtEndereco.setDocument(new LimitarCampos(50)); 
        txtUf.setDocument(new LimitarCampos(2));
        txtNumero.setDocument(new LimitarCampos(5));
        
        txtTelefone.setDocument(new LimitarCampos(8));
        txtPesquisa.setDocument(new LimitarCampos(8));
        txtTelHistorico.setDocument(new LimitarCampos(8));
        
    
    }

    
    
    private void txtCepFocusLostCep(java.awt.event.FocusEvent evt) {  
        ResultSet rs;
   

        String cep = txtCep.getText();

        if("".equals(cep)){

        }

        
        else{
            
            
            rs = bacep.buscaCep(cep);
            try {

                if (bacep.buscaCep(cep) != null) {

                    txtEndereco.setText(rs.getString("desc_logradouro"));
                    txtCidade.setText(rs.getString("desc_cidade"));
                    txtUf.setText(rs.getString("flg_estado"));
                    txtBairro.setText(rs.getString("desc_bairro"));
                    
                }
                else{

                }
            } catch (SQLException ex) {
            }
        } 
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalCliente = new javax.swing.JInternalFrame();
        TabCliente = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComplemento = new javax.swing.JTextPane();
        txtEndereco = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtCep = new javax.swing.JFormattedTextField();
        aa = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        Pesquisar = new javax.swing.JButton();
        Gravar = new javax.swing.JButton();
        Alterar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        Novo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridCliente = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnPesquisaCliente = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTelHistorico = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        gridHistorico = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setLayout(null);

        internalCliente.setClosable(true);
        internalCliente.setTitle("Clientes");
        internalCliente.setVisible(true);
        internalCliente.getContentPane().setLayout(null);

        TabCliente.setBackground(new java.awt.Color(255, 255, 255));
        TabCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabClienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabClienteMousePressed(evt);
            }
        });

        jPanel1.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(null);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(20, 70, 70, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Telefone(*):");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(10, 20, 90, 30);
        jPanel4.add(txtNome);
        txtNome.setBounds(100, 70, 420, 30);
        jPanel4.add(txtTelefone);
        txtTelefone.setBounds(100, 20, 110, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(10, 80, 860, 120);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ponto de Referência:");
        jPanel6.add(jLabel4);
        jLabel4.setBounds(20, 130, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cep:");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(20, 10, 70, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cidade:");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(240, 10, 90, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Bairro:");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(20, 50, 90, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Endereco(*):");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(20, 90, 100, 30);

        jScrollPane1.setViewportView(txtComplemento);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(160, 130, 400, 30);
        jPanel6.add(txtEndereco);
        txtEndereco.setBounds(120, 90, 400, 30);
        jPanel6.add(txtBairro);
        txtBairro.setBounds(120, 50, 400, 30);
        jPanel6.add(txtCidade);
        txtCidade.setBounds(310, 10, 400, 30);

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel6.add(txtCep);
        txtCep.setBounds(120, 10, 110, 30);

        aa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        aa.setText("UF:");
        jPanel6.add(aa);
        aa.setBounds(530, 50, 50, 30);

        txtUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUfActionPerformed(evt);
            }
        });
        jPanel6.add(txtUf);
        txtUf.setBounds(580, 50, 60, 30);

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });
        jPanel6.add(txtNumero);
        txtNumero.setBounds(580, 90, 60, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("N°(*):");
        jPanel6.add(jLabel5);
        jLabel5.setBounds(530, 90, 60, 30);

        jPanel3.add(jPanel6);
        jPanel6.setBounds(10, 210, 840, 180);

        jToolBar1.setRollover(true);

        Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
        Pesquisar.setText("Consultar");
        Pesquisar.setFocusable(false);
        Pesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pesquisar.setMargin(new java.awt.Insets(2, 25, 2, 25));
        Pesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarActionPerformed(evt);
            }
        });
        jToolBar1.add(Pesquisar);

        Gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        Gravar.setText("Inserir");
        Gravar.setFocusable(false);
        Gravar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Gravar.setMargin(new java.awt.Insets(2, 25, 2, 25));
        Gravar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GravarActionPerformed(evt);
            }
        });
        jToolBar1.add(Gravar);

        Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizar.png"))); // NOI18N
        Alterar.setText("Alterar");
        Alterar.setFocusable(false);
        Alterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Alterar.setMargin(new java.awt.Insets(2, 25, 2, 25));
        Alterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });
        jToolBar1.add(Alterar);

        Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        Excluir.setText("Excluir");
        Excluir.setFocusable(false);
        Excluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Excluir.setMargin(new java.awt.Insets(2, 25, 2, 25));
        Excluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(Excluir);

        Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novo.png"))); // NOI18N
        Novo.setText("Limpar Campos");
        Novo.setFocusable(false);
        Novo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Novo.setMargin(new java.awt.Insets(2, 25, 2, 25));
        Novo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });
        jToolBar1.add(Novo);

        jPanel3.add(jToolBar1);
        jToolBar1.setBounds(0, 0, 890, 70);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 900, 410);

        TabCliente.addTab("Registrar Cliente", jPanel1);

        jPanel2.setLayout(null);

        gridCliente.setAutoCreateRowSorter(true);
        gridCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefone", "Nome", "UF", "Cidade", "Bairro", "Endereco", "Numero", "Cep", "Complemento"
            }
        ));
        gridCliente.setToolTipText("");
        gridCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridClienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gridClienteMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(gridCliente);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(0, 90, 890, 200);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Telefone:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(220, 30, 90, 40);

        btnPesquisaCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
        btnPesquisaCliente.setText("Consultar");
        btnPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnPesquisaCliente);
        btnPesquisaCliente.setBounds(440, 30, 160, 40);

        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });
        jPanel2.add(txtPesquisa);
        txtPesquisa.setBounds(300, 30, 120, 40);

        TabCliente.addTab("Pesquisar Cliente", jPanel2);

        jPanel5.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Telefone:");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(270, 50, 90, 30);
        jPanel5.add(txtTelHistorico);
        txtTelHistorico.setBounds(360, 50, 110, 30);

        gridHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(gridHistorico);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(10, 90, 870, 310);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(490, 40, 140, 40);

        TabCliente.addTab("Histórico Cliente", jPanel5);

        internalCliente.getContentPane().add(TabCliente);
        TabCliente.setBounds(0, 0, 900, 450);

        add(internalCliente);
        internalCliente.setBounds(40, 30, 920, 490);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void txtUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUfActionPerformed

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed

       

        txtTelefone.setText("");
        txtNome.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtEndereco.setText("");
        txtComplemento.setText("");
        txtUf.setText("");
        txtNumero.setText("");
     
    }//GEN-LAST:event_NovoActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
        
       String telefone, nome, cep, cidade, bairro, uf, numero,endereco , complemento;   
        
        telefone = txtTelefone.getText();
        nome = txtNome.getText();
        cep = txtCep.getText();
        cidade = txtCidade.getText();
        bairro = txtBairro.getText();
        uf = txtUf.getText();
        numero = txtNumero.getText();
        endereco = txtEndereco.getText();
        complemento = txtComplemento.getText();

        if("".equals(telefone)){

            JOptionPane.showMessageDialog(null,"Preecha  o campo CNPJ");
            txtTelefone.requestFocus();
        }
        else{

            ba.atualizaCliente(telefone, nome, cep, cidade, bairro, uf,numero, endereco, complemento);

        }
    
    }//GEN-LAST:event_AlterarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed

        //String nomeFantasia = nome_fantasiaFor.getText();

        

            String telefone =txtTelefone.getText();

            if("(11)    -    ".equals(telefone)){

                JOptionPane.showMessageDialog(null,"Preencha o campo telefone para realizar uma exclusão");
                txtTelefone.requestFocus();

            }

            else{
                if (ba.excluiCliente(telefone)) {
                    JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                    
                       txtTelefone.setText("");
                        txtNome.setText("");
                        txtCep.setText("");
                        txtCidade.setText("");
                        txtBairro.setText("");
                        txtEndereco.setText("");
                        txtComplemento.setText("");
                         txtUf.setText("");
                         txtNumero.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Não encontrado");
                }
            }
        

       
    }//GEN-LAST:event_ExcluirActionPerformed

    private void PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarActionPerformed
        ResultSet rs;

         String telefone =txtTelefone.getText();

        

            if("".equals(telefone)){

        
                JOptionPane.showMessageDialog(null,"Preencha o campo telefone para realizar uma busca");
                txtTelefone.requestFocus();
            }

            else{
               
                rs = ba.buscaCliente(telefone);
                try {

                    if (ba.buscaCliente(telefone) != null) {
                        txtTelefone.setText(rs.getString("telefone"));
                        txtNome.setText(rs.getString("nome"));
                        txtCep.setText(rs.getString("cep"));
                        txtCidade.setText(rs.getString("cidade"));
                        txtBairro.setText(rs.getString("bairro"));
                        txtEndereco.setText(rs.getString("endereco"));
                        txtComplemento.setText(rs.getString("complemento"));
                        txtUf.setText(rs.getString("uf"));
                        txtNumero.setText(rs.getString("numero"));
                        

                        txtTelefone.setText(txtTelefone.getText());

                    }
                    else{

                        
                    }
                } catch (SQLException ex) {
                }
            }

        
      
        

        

        

      
        


    }//GEN-LAST:event_PesquisarActionPerformed

    private void GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GravarActionPerformed

        /*SE A PESSOA FOR FISICA FAZ A INSERÇÃO NO BANCO É O MESMO CODIGO DE BAIXO*/
 
        
        
        
        String telefone, nome, cep, cidade, bairro, uf, numero,endereco , complemento;   
        
        telefone = txtTelefone.getText();
        nome = txtNome.getText();
        cep = txtCep.getText();
        cidade = txtCidade.getText();
        bairro = txtBairro.getText();
        uf = txtUf.getText();
        numero = txtNumero.getText();
        endereco = txtEndereco.getText();
        complemento = txtComplemento.getText();
        
        
        if("".equals(telefone) || "".equals(endereco) || "".equals(numero) ){
            
            JOptionPane.showMessageDialog(null," Preenche os campos obrigatorios (*)");
            
        
        
        }
        
        else{ 
            ba.gravarCliente(telefone, nome, cep, cidade, bairro , uf, numero, endereco, complemento);

                txtTelefone.setText("");
                txtNome.setText("");
                txtCep.setText("");
                txtCidade.setText("");
                txtUf.setText("");
                txtNumero.setText("");
                txtEndereco.setText("");
                txtComplemento.setText("");
                txtBairro.setText("");
             
            
        
       
        }
        
        

    }//GEN-LAST:event_GravarActionPerformed

    private void btnPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaClienteActionPerformed
     DefaultTableModel modelo = (DefaultTableModel)gridCliente.getModel();
       
    gridCliente.removeAll();
    
    while(modelo.getRowCount() > 0){
        modelo.removeRow(0);
    }
    
    ObjetoCliente clientepesquisado = new ObjetoCliente();
    
  
    
     if(txtPesquisa.getText().isEmpty() == false){
        int telefone = Integer.parseInt(txtPesquisa.getText());

        if(telefone > 0){
            clientepesquisado = ba.buscaClienteTabela(String.valueOf(telefone));
            if(clientepesquisado != null){
                modelo.addRow(new Object[]{clientepesquisado.getTelefone(),clientepesquisado.getNome(), clientepesquisado.getUf(), clientepesquisado.getCidade(), clientepesquisado.getBairro(), clientepesquisado.getEndereco(), clientepesquisado.getNumero(), clientepesquisado.getCep(), clientepesquisado.getComplemento()});
            }
            else{
                JOptionPane.showMessageDialog(null, "Nenhum Cliente encontrado !!!");
            }
        }
    }
    
    gridCliente.repaint();
    
    txtPesquisa.setText(null);
              

    }//GEN-LAST:event_btnPesquisaClienteActionPerformed
 
    
    
    
    // AO SELECIONAR UMA LINHA NA JTABLE PREENCHE OS CAMPOS NA OUTRA ABA CLIENTE
    
    private void gridClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridClienteMouseClicked
        
        // PEGA OS CAMPOS QUE ESTÃO NA JTABLE 
        
        if (evt.getClickCount() == 2) {  
            Object obj = (gridCliente.getValueAt(gridCliente.getSelectedRow(), 0));  //coluna 0  
            String telefone = obj.toString();
            
            Object obj1 = (gridCliente.getValueAt(gridCliente.getSelectedRow(), 1));  //coluna 0  
            String nome = obj1.toString();
            
            Object obj2 = (gridCliente.getValueAt(gridCliente.getSelectedRow(), 2));  //coluna 0  
            String uf = obj2.toString();  
            
            Object obj3 = (gridCliente.getValueAt(gridCliente.getSelectedRow(), 3));  //coluna 0  
            String cidade = obj3.toString();  
            
            Object obj4 = (gridCliente.getValueAt(gridCliente.getSelectedRow(), 4));  //coluna 0  
            String bairro = obj4.toString();  
            
            Object obj5 = (gridCliente.getValueAt(gridCliente.getSelectedRow(), 5));  //coluna 0  
            String logradouro = obj5.toString(); 
            
            Object obj6 = (gridCliente.getValueAt(gridCliente.getSelectedRow(), 6));  //coluna 0  
            String numero = obj6.toString();  
            
            Object obj7 = (gridCliente.getValueAt(gridCliente.getSelectedRow(), 7));  //coluna 0  
            String cep = obj7.toString();  
            
            Object obj8 = (gridCliente.getValueAt(gridCliente.getSelectedRow(), 8));  //coluna 0  
            String complemento = obj8.toString();  
         
            // SETA OS DADOS PEGO ACIMA PARA OS JTEXTFIELD

             txtTelefone.setText(telefone);   
             txtNome.setText(nome); 
             txtCep.setText(cep); 
             txtCidade.setText(cidade); 
             txtBairro.setText(bairro); 
             txtEndereco.setText(logradouro); 
             txtComplemento.setText(complemento); 
             txtUf.setText(uf); 
             txtNumero.setText(numero);      
             
             
             
               // QUANDO SELECIONA A LINHA NA JTABLE MUDA A ABA
              TabCliente.setSelectedIndex(0);   
             
              
        }  
        
        
    }//GEN-LAST:event_gridClienteMouseClicked

     public void carregaTabela(){
        String msg1 = "Clientes recuperados com sucesso";
        String msg2 = "Erro ao Recuperar Clientes";
        String vsql = "SELECT " +
                        "telefone, nome, cep, endereco, numero, complemento, cidade, uf, bairro " +
                      "FROM " +
                        "clientes";


        bf.tabelaClientes(vsql, msg1, msg2, gridCliente);
    }

    
    
    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
      

    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void TabClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabClienteMouseClicked
        
       
        
    }//GEN-LAST:event_TabClienteMouseClicked

    private void TabClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabClienteMousePressed
      
        // AO CLICAR NA TABMENU PREENCHE A TABELA CLIENTES
        
        carregaTabela();
    }//GEN-LAST:event_TabClienteMousePressed

    private void gridClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridClienteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_gridClienteMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String telefone;
        
        telefone = txtTelHistorico.getText();
        
        String msg1 = "Clientes recuperados com sucesso";
        String msg2 = "Erro ao Recuperar Clientes";
        String vsql = "SELECT C.TELEFONE,V.NPEDIDO,C.NOME,V.total ,V.DATA\n" +
"FROM CLIENTES C\n" +
"INNER JOIN VENDA V\n" +
"ON C.TELEFONE = V.TELEFONE\n" +
"WHERE C.TELEFONE = "+telefone+"";


        bf.tabelaHistorico(vsql, msg1, msg2, gridHistorico);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton Gravar;
    private javax.swing.JButton Novo;
    private javax.swing.JButton Pesquisar;
    private javax.swing.JTabbedPane TabCliente;
    private javax.swing.JLabel aa;
    private javax.swing.JButton btnPesquisaCliente;
    private javax.swing.JTable gridCliente;
    private javax.swing.JTable gridHistorico;
    public javax.swing.JInternalFrame internalCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextPane txtComplemento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtTelHistorico;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
