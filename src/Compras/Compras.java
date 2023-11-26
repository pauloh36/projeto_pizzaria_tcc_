/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import Banco.Banco;
import Banco.BancoFuncoes;
import Funcoes.LimitarCampos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static org.alfredlibrary.validadores.CNPJ.isValido;
import org.alfredlibrary.validadores.CPF;

/**
 *
 * @author Usuario
 */
public class Compras extends javax.swing.JFrame {
  
    Banco ba = new Banco();
    BancoFuncoes bf = new BancoFuncoes();
    public Compras() {
        initComponents();
        
        
         gridCompras.setModel(  
      new DefaultTableModel(  
      new Object[] []{ },  
      new String[] {"N_Pedido", "CPF", "CNPJ", "Fornecedor", "Tipo_Produto", "Produto", "Qtde"}) {  
  
   public boolean isCellEditable(int row, int col) {  
           return false;  
   
   }});   
        
        carregaTipoPruduto();
        carregaFornecedorCombo();
        escondecampos();
       carregaTabela(); 
       carregaFornecedorPesquisa();
       
       
       
        // DETECTA QUANDO O COMBOBOX TIPO PRODUTO É ALTERADO E PREENCHE O COMBO PRODUTOS
        
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
    
        // AO SELECIONAR O FORNECEDOR PREENCHE A TABELA COM OS PEDIDOS DE COMPRA DO MESMO
        
        comboFornePesquisa.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
       String Fornecedor = comboFornePesquisa.getSelectedItem().toString();
       
       
        
        String msg1 = "Compras recuperadas com sucesso";
        String msg2 = "Erro ao Recuperar Compras";
        String vsql = "SELECT " +
                        "npedido, cpfFor, cnpjFor, nomeFantasia, tipoProduto, produto, qtde " +
                      "FROM " +
                        "Compras where nomeFantasia = '"+Fornecedor+"'";


        bf.tabelaCompras(vsql, msg1, msg2, gridCompras);
            
        
        }
      }
    );
       
     //limita os campos
        
        txtParcela.setDocument(new LimitarCampos(2));
        txtValorTotal.setDocument(new LimitarCampos(8));
        txtValorDesc.setDocument(new LimitarCampos(8));
        txtValotNf.setDocument(new LimitarCampos(8)); 
        txtObservacao.setDocument(new LimitarCampos(200));
        txtRefProduto.setDocument(new LimitarCampos(15));
        txtQtde.setDocument(new LimitarCampos(5));
        txtValorUnit.setDocument(new LimitarCampos(8));
        txtValorDescItens.setDocument(new LimitarCampos(8));
        txtValorNfItens.setDocument(new LimitarCampos(8));
        
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalCompras = new javax.swing.JInternalFrame();
        tabCompras = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        comboNomeFor = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelCnpj = new javax.swing.JLabel();
        comboFormaPagto = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboCondicaoPagto = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtParcela = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboTipoPedido = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtValorDesc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtValotNf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        labelCpf = new javax.swing.JLabel();
        txtCpfFor = new javax.swing.JTextField();
        txtCnpjFor = new javax.swing.JFormattedTextField();
        labelPedido = new javax.swing.JLabel();
        txtNPedido = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        Gravar = new javax.swing.JButton();
        Alterar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        Novo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        comboTipoProduto = new javax.swing.JComboBox();
        comboProduto = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtUnidMedida = new javax.swing.JTextField();
        txtRefProduto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtQtde = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtValorUnit = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtValorDescItens = new javax.swing.JTextField();
        txtValorNfItens = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridCompras = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboFornePesquisa = new javax.swing.JComboBox();
        jToolBar2 = new javax.swing.JToolBar();
        Excluir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        internalCompras.setClosable(true);
        internalCompras.setTitle("Compras");
        internalCompras.setVisible(true);
        internalCompras.getContentPane().setLayout(null);

        tabCompras.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabComprasStateChanged(evt);
            }
        });
        tabCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabComprasMousePressed(evt);
            }
        });

        jPanel1.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));
        jPanel3.setLayout(null);

        comboNomeFor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboNomeForFocusLost(evt);
            }
        });
        jPanel3.add(comboNomeFor);
        comboNomeFor.setBounds(80, 60, 400, 30);

        jLabel1.setText("Fornecedor:");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 60, 100, 30);

        jLabel2.setText("Valor NF:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(420, 170, 90, 30);

        labelCnpj.setText("CNPJ Fornecedor:");
        jPanel3.add(labelCnpj);
        labelCnpj.setBounds(10, 100, 130, 30);

        comboFormaPagto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha forma de Pagamento", "Dinheiro", "Cartão de Crédito", "Cartão de Débito" }));
        jPanel3.add(comboFormaPagto);
        comboFormaPagto.setBounds(180, 130, 210, 30);

        jLabel4.setText("Forma de Pagto:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(180, 100, 100, 30);

        comboCondicaoPagto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha cond/Pagamento", "À Vista", "Parcelado" }));
        jPanel3.add(comboCondicaoPagto);
        comboCondicaoPagto.setBounds(430, 130, 190, 30);

        jLabel5.setText("Condição Pagto:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(430, 100, 100, 30);
        jPanel3.add(txtParcela);
        txtParcela.setBounds(650, 130, 70, 30);

        jLabel6.setText("Parcelas:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(650, 100, 100, 30);

        comboTipoPedido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de Pedido", "Pedido", "Cotação" }));
        jPanel3.add(comboTipoPedido);
        comboTipoPedido.setBounds(20, 200, 170, 30);

        jLabel7.setText("Observação:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(10, 240, 90, 30);
        jPanel3.add(txtValorTotal);
        txtValorTotal.setBounds(210, 200, 70, 30);

        jLabel8.setText("Valor Total:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(210, 170, 90, 30);
        jPanel3.add(txtValorDesc);
        txtValorDesc.setBounds(310, 200, 70, 30);

        jLabel9.setText("Valor Desc:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(310, 170, 90, 30);
        jPanel3.add(txtValotNf);
        txtValotNf.setBounds(420, 200, 100, 30);

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(90, 240, 600, 80);

        jLabel10.setText("Tipo Pedido:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(20, 170, 90, 30);

        labelCpf.setText("CPF Fornecedor:");
        jPanel3.add(labelCpf);
        labelCpf.setBounds(10, 100, 110, 30);

        txtCpfFor.setEditable(false);
        jPanel3.add(txtCpfFor);
        txtCpfFor.setBounds(10, 130, 140, 30);

        try {
            txtCnpjFor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txtCnpjFor);
        txtCnpjFor.setBounds(10, 130, 140, 30);

        labelPedido.setText("Pedido: ");
        jPanel3.add(labelPedido);
        labelPedido.setBounds(10, 20, 60, 30);

        txtNPedido.setEditable(false);
        jPanel3.add(txtNPedido);
        txtNPedido.setBounds(80, 20, 70, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 70, 760, 330);

        jToolBar1.setRollover(true);

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

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(0, 0, 770, 70);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));
        jPanel4.setLayout(null);

        jLabel11.setText("Valor NF:");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(450, 80, 90, 30);

        comboTipoProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTipoProdutoItemStateChanged(evt);
            }
        });
        comboTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoProdutoActionPerformed(evt);
            }
        });
        jPanel4.add(comboTipoProduto);
        comboTipoProduto.setBounds(20, 40, 150, 30);

        comboProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProdutoItemStateChanged(evt);
            }
        });
        comboProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboProdutoFocusLost(evt);
            }
        });
        comboProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProdutoActionPerformed(evt);
            }
        });
        jPanel4.add(comboProduto);
        comboProduto.setBounds(210, 40, 200, 30);

        jLabel12.setText("Tipo Produto:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(20, 10, 90, 30);

        jLabel13.setText("Produto: ");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(210, 10, 90, 30);

        txtUnidMedida.setEditable(false);
        txtUnidMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidMedidaActionPerformed(evt);
            }
        });
        jPanel4.add(txtUnidMedida);
        txtUnidMedida.setBounds(470, 40, 70, 30);
        jPanel4.add(txtRefProduto);
        txtRefProduto.setBounds(20, 110, 110, 30);

        jLabel14.setText("Unid Medida:");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(470, 10, 90, 30);

        jLabel15.setText("Ref. Produto: ");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(20, 80, 90, 30);
        jPanel4.add(txtQtde);
        txtQtde.setBounds(160, 110, 70, 30);

        jLabel16.setText("Qtde: ");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(160, 80, 90, 30);

        txtValorUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorUnitActionPerformed(evt);
            }
        });
        jPanel4.add(txtValorUnit);
        txtValorUnit.setBounds(250, 110, 70, 30);

        jLabel17.setText("Valor Unit:");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(250, 80, 90, 30);

        jLabel18.setText("Valor Desc:");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(350, 80, 90, 30);
        jPanel4.add(txtValorDescItens);
        txtValorDescItens.setBounds(350, 110, 70, 30);
        jPanel4.add(txtValorNfItens);
        txtValorNfItens.setBounds(450, 110, 70, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 400, 760, 150);

        tabCompras.addTab("Registro de Compras", jPanel1);

        jPanel2.setLayout(null);

        gridCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        gridCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridComprasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(gridCompras);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 190, 740, 340);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar"));
        jPanel5.setLayout(null);

        jLabel3.setText("Fornecedor:");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(60, 30, 110, 30);

        comboFornePesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFornePesquisaItemStateChanged(evt);
            }
        });
        jPanel5.add(comboFornePesquisa);
        comboFornePesquisa.setBounds(140, 30, 320, 30);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(100, 80, 540, 80);

        jToolBar2.setRollover(true);

        Excluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        Excluir1.setText("Excluir");
        Excluir1.setFocusable(false);
        Excluir1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Excluir1.setMargin(new java.awt.Insets(2, 25, 2, 25));
        Excluir1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Excluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excluir1ActionPerformed(evt);
            }
        });
        jToolBar2.add(Excluir1);

        jPanel2.add(jToolBar2);
        jToolBar2.setBounds(0, 0, 770, 70);

        tabCompras.addTab("Pedidos de Compra", jPanel2);

        internalCompras.getContentPane().add(tabCompras);
        tabCompras.setBounds(0, 0, 780, 580);

        getContentPane().add(internalCompras);
        internalCompras.setBounds(0, 0, 810, 610);

        setBounds(0, 0, 840, 765);
    }// </editor-fold>//GEN-END:initComponents

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed

        limpacampos();
        txtNPedido.setVisible(false);
                        labelPedido.setVisible(false);
                        txtNPedido.setText("");
    }//GEN-LAST:event_NovoActionPerformed

    private void GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GravarActionPerformed

                        txtNPedido.setVisible(false);
                        labelPedido.setVisible(false);
                        txtNPedido.setText("");
  
        String nomeFor, cpfFor, cnpjFor, formaPagto, condicaoPagto, tipoPedido,
               observacao,tipoProduto,nomeProduto,unidMedida,
                refProduto;
        
        int parcelas,qtde;
        float valorTotal,valorDesc,valorNf,valorUnit,valorDescItens,valorNfItens;
        
        
        
        cpfFor = txtCpfFor.getText();
        cnpjFor = txtCnpjFor.getText();
        observacao = txtObservacao.getText();
        unidMedida = txtUnidMedida.getText();
        refProduto = txtRefProduto.getText();

         nomeFor = comboNomeFor.getSelectedItem().toString();
         formaPagto = comboFormaPagto.getSelectedItem().toString();
         condicaoPagto = comboCondicaoPagto.getSelectedItem().toString();
         tipoPedido = comboTipoPedido.getSelectedItem().toString();
         tipoProduto = comboTipoProduto.getSelectedItem().toString();
         nomeProduto = comboProduto.getSelectedItem().toString();
         
         parcelas = Integer.parseInt(txtParcela.getText());
         qtde =  Integer.parseInt(txtQtde.getText());
         
         valorTotal = Float.parseFloat(txtValorTotal.getText());
         valorDesc  = Float.parseFloat(txtValorDesc.getText());
         valorNf  = Float.parseFloat(txtValotNf.getText());
         valorUnit = Float.parseFloat(txtValorUnit.getText());
        valorDescItens = Float.parseFloat(txtValorDescItens.getText());
         valorNfItens = Float.parseFloat(txtValorNfItens.getText());
         
         
         if("".equals(nomeFor)){
            
            JOptionPane.showMessageDialog(null," Preenche os campos obrigatorios (*)");
            
        
        
        }
        
        else{ 
            ba.gravarCompras(nomeFor, cpfFor, cnpjFor, formaPagto, condicaoPagto , tipoPedido, observacao,tipoProduto,
                    valorTotal,valorDesc,valorNf,valorUnit,valorDescItens,valorNfItens,
                    nomeProduto,unidMedida,refProduto,parcelas,qtde);

             limpacampos();
            
        
       
        }
         
         
    }//GEN-LAST:event_GravarActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed

       String nomeFor, cpfFor, cnpjFor, formaPagto, condicaoPagto, tipoPedido,
               observacao,tipoProduto,nomeProduto,unidMedida,
                refProduto;
        
        int parcelas,qtde,npedido;
        float valorTotal,valorDesc,valorNf,valorUnit,valorDescItens,valorNfItens;
        
        
        
        cpfFor = txtCpfFor.getText();
        cnpjFor = txtCnpjFor.getText();
        observacao = txtObservacao.getText();
        unidMedida = txtUnidMedida.getText();
        refProduto = txtRefProduto.getText();

         nomeFor = comboNomeFor.getSelectedItem().toString();
         formaPagto = comboFormaPagto.getSelectedItem().toString();
         condicaoPagto = comboCondicaoPagto.getSelectedItem().toString();
         tipoPedido = comboTipoPedido.getSelectedItem().toString();
         tipoProduto = comboTipoProduto.getSelectedItem().toString();
         nomeProduto = comboProduto.getSelectedItem().toString();
         
         parcelas = Integer.parseInt(txtParcela.getText());
         qtde =  Integer.parseInt(txtQtde.getText());
         npedido = Integer.parseInt(txtNPedido.getText());
         
         
         valorTotal = Float.parseFloat(txtValorTotal.getText());
         valorDesc  = Float.parseFloat(txtValorDesc.getText());
         valorNf  = Float.parseFloat(txtValotNf.getText());
         valorUnit = Float.parseFloat(txtValorUnit.getText());
        valorDescItens = Float.parseFloat(txtValorDescItens.getText());
         valorNfItens = Float.parseFloat(txtValorNfItens.getText());

        if("".equals(npedido)){

            JOptionPane.showMessageDialog(null,"Realize uma pesquisa para realizar uma alteração");
            
        }
        else{

            ba.atualizaCompra(npedido,nomeFor, cpfFor, cnpjFor, formaPagto, condicaoPagto , tipoPedido, observacao,tipoProduto,
                    valorTotal,valorDesc,valorNf,valorUnit,valorDescItens,valorNfItens,
                    nomeProduto,unidMedida,refProduto,parcelas,qtde);
            
            
                        txtNPedido.setVisible(false);
                        labelPedido.setVisible(false);
                        txtNPedido.setText("");
        }

    }//GEN-LAST:event_AlterarActionPerformed

    private void comboTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoProdutoActionPerformed
       
    }//GEN-LAST:event_comboTipoProdutoActionPerformed

    private void comboTipoProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoProdutoItemStateChanged
    
    }//GEN-LAST:event_comboTipoProdutoItemStateChanged

    private void comboProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProdutoActionPerformed

  
        
    }//GEN-LAST:event_comboProdutoActionPerformed

    private void comboProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProdutoItemStateChanged
 
    }//GEN-LAST:event_comboProdutoItemStateChanged

    public void limpacampos(){
        
         comboNomeFor.setSelectedItem("");
         txtCnpjFor.setText("");
        txtCpfFor.setText("");
        comboFormaPagto.setSelectedItem("Escolha forma de Pagamento");
        comboCondicaoPagto.setSelectedItem("Escolha cond/Pagamento");
        txtParcela.setText("");
        comboTipoPedido.setSelectedItem("Tipo de Pedido");
        txtValorTotal.setText("");
        txtValorDesc.setText("");
        txtValotNf.setText("");
        txtObservacao.setText("");
        comboTipoProduto.setSelectedItem("");
        comboProduto.setSelectedItem("");
        txtUnidMedida.setText("");
        txtQtde.setText("");
        txtValorUnit.setText("");
        txtValorDescItens.setText("");
        txtValorNfItens.setText("");
        txtRefProduto.setText("");
        txtNPedido.setVisible(false);
         labelPedido.setVisible(false);
         txtNPedido.setText("");
    }
    private void comboProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboProdutoFocusLost

        ResultSet rs;
           String produto = comboProduto.getSelectedItem().toString();
           



        if("".equals(produto)){

        }

        
        else{
            
            
            rs = ba.buscaUnidadeMedida(produto);
            try {

                if (ba.buscaUnidadeMedida(produto) != null) {

                    txtUnidMedida.setText(rs.getString("unidmedida"));
                   
                }
                else{

                }
            } catch (SQLException ex) {
            }
        } 
        
        
    }//GEN-LAST:event_comboProdutoFocusLost

    private void comboNomeForFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboNomeForFocusLost
        
        
        ResultSet rs;
           String nome = comboNomeFor.getSelectedItem().toString();
           



        if("".equals(nome)){

        }   
        
        else{
            
            
            rs = ba.buscaFornecedorCompras(nome);
            try {

                if (ba.buscaFornecedorCompras(nome) != null) {

                    String cpf = rs.getString("cpfFor");
                    String cnpj = rs.getString("cnpjFor");
                    
                  
                    if(CPF.isValido(cpf) == true){
                        
                        txtCpfFor.setText(rs.getString("cpfFor"));
                        
                        txtCnpjFor.setVisible(false);
                        labelCnpj.setVisible(false);
                        
                        txtCpfFor.setVisible(true);
                        labelCpf.setVisible(true);
                    }
                    
                    else if(isValido(cnpj) == true){

                         
                        txtCnpjFor.setText(rs.getString("cnpjFor"));
                             
                        txtCnpjFor.setVisible(true);
                        labelCnpj.setVisible(true);
                        
                        txtCpfFor.setVisible(false);
                        labelCpf.setVisible(false);
                        
                        
                    }
                }
                    
                    
                    
                    
                
                else{

                }
            } catch (SQLException ex) {
            }
        } 
        
        
    }//GEN-LAST:event_comboNomeForFocusLost

    private void txtValorUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorUnitActionPerformed

    private void tabComprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabComprasMousePressed
       
       
    }//GEN-LAST:event_tabComprasMousePressed

    private void gridComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridComprasMouseClicked
        
          if (evt.getClickCount() == 2) { 
          
          
             ResultSet rs;

        Object obj = (gridCompras.getValueAt(gridCompras.getSelectedRow(), 0));  //coluna 0  
            String npedido = obj.toString();
            

        rs = ba.buscaCompras(npedido);
                try {

                    if (ba.buscaCompras(npedido) != null) {
                        
                       String cpf,cnpj;
                        
                       cpf = rs.getString("cpfFor");
                       cnpj = rs.getString("cnpjFor");
                       
                        txtNPedido.setText(rs.getString("NPedido"));
                        comboNomeFor.setSelectedItem(rs.getString("nomeFantasia"));
                        comboFormaPagto.setSelectedItem(rs.getString("formapagto"));    
                        comboCondicaoPagto.setSelectedItem(rs.getString("condicaopagto"));        
                        txtParcela.setText(rs.getString("parcelas"));
                        comboTipoPedido.setSelectedItem(rs.getString("tipopedido"));     
                        txtValorTotal.setText(rs.getString("valortotal"));
                        txtValorDesc.setText(rs.getString("valordesc"));
                        txtValotNf.setText(rs.getString("valornf"));
                        txtObservacao.setText(rs.getString("observacao"));
                        comboTipoProduto.setSelectedItem(rs.getString("tipoproduto")); 
                        comboProduto.setSelectedItem(rs.getString("produto")); 
                        txtUnidMedida.setText(rs.getString("unidmedida"));
                        txtRefProduto.setText(rs.getString("refproduto"));
                        txtQtde.setText(rs.getString("Qtde"));
                        txtValorUnit.setText(rs.getString("valorunit"));
                        txtValorDescItens.setText(rs.getString("valordescitens"));
                        txtValorNfItens.setText(rs.getString("valornfitens"));
                       
                        txtNPedido.setVisible(true);
                        labelPedido.setVisible(true);
                        
                        
                         if(CPF.isValido(cpf) == true){
                        
                        txtCpfFor.setText(cpf);
                        
                        txtCnpjFor.setVisible(false);
                        labelCnpj.setVisible(false);
                        
                        txtCpfFor.setVisible(true);
                        labelCpf.setVisible(true);
                    }
                    
                    else if(isValido(cnpj) == true){

                         
                        txtCnpjFor.setText(cnpj);
                             
                        txtCnpjFor.setVisible(true);
                        labelCnpj.setVisible(true);
                        
                        txtCpfFor.setVisible(false);
                        labelCpf.setVisible(false);
                        
                        
                    }
                        
                        tabCompras.setSelectedIndex(0);   
                    }
                    else{

                        
                    }
                } catch (SQLException ex) {
                }
            }

          
               
             

    }//GEN-LAST:event_gridComprasMouseClicked

    private void comboFornePesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFornePesquisaItemStateChanged
      
    }//GEN-LAST:event_comboFornePesquisaItemStateChanged

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed

       String npedido = txtNPedido.getText();
        
        if(npedido.equals("")){

                JOptionPane.showMessageDialog(null,"Realize uma busca para fazer a exclusão");
                

            }

            else{
                if (ba.excluiCompra(npedido)) {
                    JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                    
                       carregaTabela(); 
                       limpacampos();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Não encontrado");
                }
            }
        
        
    }//GEN-LAST:event_ExcluirActionPerformed

    private void Excluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excluir1ActionPerformed

        
        
         Object obj = (gridCompras.getValueAt(gridCompras.getSelectedRow(), 0));  //coluna 0  
            String npedido = obj.toString();
                          

            if(npedido.equals("")){

                JOptionPane.showMessageDialog(null,"Selecione um pedido de compra para realizar uma exclusão");
                

            }

            else{
                if (ba.excluiCompra(npedido)) {
                    JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                    
                       carregaTabela(); 
                      
                }
                else {
                    JOptionPane.showMessageDialog(null, "Não encontrado");
                }
            }
        
        
    }//GEN-LAST:event_Excluir1ActionPerformed

    private void tabComprasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabComprasStateChanged
comboFornePesquisa.setSelectedItem("");
       carregaTabela();


    }//GEN-LAST:event_tabComprasStateChanged

    private void txtUnidMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidMedidaActionPerformed

     public void carregaTipoPruduto(){;
        String msg1 = "Tipo Produto recuperados";
        String msg2 = "Erro ao Recuperar Tipo Produto ";
        String vsql = "SELECT categoria FROM categoriaProduto order by categoria";
        String campoSql = "categoria";

        bf.carregaDadoUnico(vsql, msg1, msg2, comboTipoProduto, campoSql);
    }
     
      
    public void carregaFornecedorCombo(){
        String msg1 = "Fornecedores recuperados";
        String msg2 = "Erro ao Recuperar Fornecedores";
        String vsql = "SELECT nomeFantasia FROM fornecedor order by nomeFantasia";
        String campoSql = "nomeFantasia";

        bf.carregaDadoUnico(vsql, msg1, msg2, comboNomeFor, campoSql);
    }
    
     public void carregaFornecedorPesquisa(){
        String msg1 = "Fornecedores recuperados";
        String msg2 = "Erro ao Recuperar Fornecedores";
        String vsql = "SELECT nomeFantasia FROM fornecedor order by nomeFantasia";
        String campoSql = "nomeFantasia";

        bf.carregaDadoUnico(vsql, msg1, msg2, comboFornePesquisa, campoSql);
    }
    
    public void carregaProduto(){
        
        
        String tipoproduto;
        
      tipoproduto = comboTipoProduto.getSelectedItem().toString();
        
        String msg1 = "Produtos recuperados";
        String msg2 = "Erro ao Recuperar Produtos";
        String vsql = "SELECT descricao FROM produtos WHERE tipoproduto ='"+tipoproduto+"';";
        String campoSql = "descricao";

        bf.carregaDadoUnico(vsql, msg1, msg2, comboProduto, campoSql);
    }
    
    
    
    public void carregaTabela(){
        String msg1 = "Compras recuperadas com sucesso";
        String msg2 = "Erro ao Recuperar Compras";
        String vsql = "SELECT " +
                        "npedido, cpfFor, cnpjFor, nomeFantasia, tipoProduto, produto, qtde " +
                      "FROM " +
                        "Compras";


        bf.tabelaCompras(vsql, msg1, msg2, gridCompras);
    }
    
    public void escondecampos(){
        
                  
                        
                        txtCpfFor.setVisible(false);
                        labelCpf.setVisible(false);
                        txtNPedido.setVisible(false);
                        labelPedido.setVisible(false);
    }
 
   
    
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
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton Excluir1;
    private javax.swing.JButton Gravar;
    private javax.swing.JButton Novo;
    private javax.swing.JComboBox comboCondicaoPagto;
    private javax.swing.JComboBox comboFormaPagto;
    private javax.swing.JComboBox comboFornePesquisa;
    private javax.swing.JComboBox comboNomeFor;
    private javax.swing.JComboBox comboProduto;
    private javax.swing.JComboBox comboTipoPedido;
    private javax.swing.JComboBox comboTipoProduto;
    private javax.swing.JTable gridCompras;
    public javax.swing.JInternalFrame internalCompras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel labelCnpj;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelPedido;
    private javax.swing.JTabbedPane tabCompras;
    private javax.swing.JFormattedTextField txtCnpjFor;
    private javax.swing.JTextField txtCpfFor;
    private javax.swing.JTextField txtNPedido;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtParcela;
    private javax.swing.JTextField txtQtde;
    private javax.swing.JTextField txtRefProduto;
    private javax.swing.JTextField txtUnidMedida;
    private javax.swing.JTextField txtValorDesc;
    private javax.swing.JTextField txtValorDescItens;
    private javax.swing.JTextField txtValorNfItens;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnit;
    private javax.swing.JTextField txtValotNf;
    // End of variables declaration//GEN-END:variables
}
