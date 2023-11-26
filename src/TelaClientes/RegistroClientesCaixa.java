/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelaClientes;

import Banco.Banco;
import Banco.BancoCep;
import Caixa.Caixa;
import Funcoes.LimitarCampos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class RegistroClientesCaixa extends javax.swing.JFrame {

    Banco ba = new Banco();
    BancoCep bacep = new BancoCep();
    Caixa caixa = new Caixa();
    
    public RegistroClientesCaixa() {
        initComponents();
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
       
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
        this.setLocationRelativeTo(null);  
    
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
                    txtNumero.requestFocus();
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

        jToolBar1 = new javax.swing.JToolBar();
        Gravar = new javax.swing.JButton();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 890, 70);

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

        getContentPane().add(jPanel6);
        jPanel6.setBounds(10, 210, 840, 180);

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

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 80, 840, 120);

        setBounds(0, 0, 883, 442);
    }// </editor-fold>//GEN-END:initComponents

    private void GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GravarActionPerformed

        /*SE A PESSOA FOR FISICA FAZ A INSERÇÃO NO BANCO É O MESMO CODIGO DE BAIXO*/

        String telefone,telefone2, nome, cep, cidade, bairro, uf, numero,endereco , complemento;

        telefone = txtTelefone.getText();
        telefone2 = txtTelefone.getText();
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
            
         
            
            caixa.preencheTelefone(telefone2);
             this.dispose();
        }
    }//GEN-LAST:event_GravarActionPerformed

    private void txtUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUfActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroClientesCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroClientesCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroClientesCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroClientesCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroClientesCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Gravar;
    private javax.swing.JLabel aa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextPane txtComplemento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
