/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Banco.Banco;
import Banco.BancoFuncoes;
import Funcoes.LimitarCampos;
import Funcoes.ValidaCnpj;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.alfredlibrary.validadores.CPF;

/**
 *
 * @author Usuario
 */
public class Usuario extends javax.swing.JFrame {
    
    BancoFuncoes bf = new BancoFuncoes();
    Banco ba = new Banco();
    public Usuario() {
        initComponents();
            
                txt_loginFun1.setDocument(new LimitarCampos(15));
                txt_senhaFun1.setDocument(new LimitarCampos(15));
                
              
                
                desabilitaCampos();
        
        gridUsuarios.setModel(  
      new DefaultTableModel(  
      new Object[] []{ },  
      new String[] {"Nome", "CPF", "Login", "Permissao" }) {  
  
   public boolean isCellEditable(int row, int col) {  
           return false;  
   
   }});   
      
          carregaTabela();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txt_loginFun = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txt_senhaFun = new javax.swing.JPasswordField();
        CriarAcesso = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        Caixa = new javax.swing.JCheckBox();
        Adm = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        internalUsuario = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txt_loginFun1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txt_senhaFun1 = new javax.swing.JPasswordField();
        jPanel9 = new javax.swing.JPanel();
        Caixa1 = new javax.swing.JCheckBox();
        Adm1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_Cpf = new javax.swing.JFormattedTextField();
        jToolBar1 = new javax.swing.JToolBar();
        CriarAcesso1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário e Senha"));
        jPanel4.setLayout(null);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Login:");
        jPanel4.add(jLabel34);
        jLabel34.setBounds(10, 30, 50, 30);
        jPanel4.add(txt_loginFun);
        txt_loginFun.setBounds(70, 30, 140, 30);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Senha:");
        jPanel4.add(jLabel35);
        jLabel35.setBounds(10, 80, 50, 30);
        jPanel4.add(txt_senhaFun);
        txt_senhaFun.setBounds(70, 80, 140, 30);

        CriarAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/registro.png"))); // NOI18N
        CriarAcesso.setText("Criar Acesso");
        CriarAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarAcessoActionPerformed(evt);
            }
        });
        jPanel4.add(CriarAcesso);
        CriarAcesso.setBounds(40, 220, 180, 40);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Permissões"));
        jPanel8.setLayout(null);

        Caixa.setText("Caixa");
        jPanel8.add(Caixa);
        Caixa.setBounds(30, 20, 130, 23);

        Adm.setText("Administração");
        jPanel8.add(Adm);
        Adm.setBounds(30, 50, 130, 23);

        jPanel4.add(jPanel8);
        jPanel8.setBounds(40, 120, 180, 90);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        internalUsuario.setClosable(true);
        internalUsuario.setTitle("Usuários");
        internalUsuario.setVisible(true);
        internalUsuario.getContentPane().setLayout(null);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuário e Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel5.setLayout(null);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Login:");
        jPanel5.add(jLabel36);
        jLabel36.setBounds(10, 40, 50, 30);
        jPanel5.add(txt_loginFun1);
        txt_loginFun1.setBounds(70, 40, 140, 30);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Senha:");
        jPanel5.add(jLabel37);
        jLabel37.setBounds(10, 90, 50, 30);
        jPanel5.add(txt_senhaFun1);
        txt_senhaFun1.setBounds(70, 90, 140, 30);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permissões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel9.setLayout(null);

        Caixa1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Caixa1.setText("Caixa");
        jPanel9.add(Caixa1);
        Caixa1.setBounds(30, 30, 130, 23);

        Adm1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Adm1.setText("Administração");
        jPanel9.add(Adm1);
        Adm1.setBounds(30, 70, 130, 25);

        jPanel5.add(jPanel9);
        jPanel9.setBounds(290, 20, 210, 120);

        internalUsuario.getContentPane().add(jPanel5);
        jPanel5.setBounds(10, 150, 640, 150);

        gridUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Login", "Permissao"
            }
        ));
        gridUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gridUsuarios);

        internalUsuario.getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 320, 640, 120);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("CPF:");
        internalUsuario.getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 87, 29, 30);

        try {
            txt_Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_Cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_CpfFocusLost(evt);
            }
        });
        txt_Cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CpfKeyPressed(evt);
            }
        });
        internalUsuario.getContentPane().add(txt_Cpf);
        txt_Cpf.setBounds(70, 90, 140, 30);

        jToolBar1.setFloatable(false);

        CriarAcesso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/registro.png"))); // NOI18N
        CriarAcesso1.setText("Criar Acesso");
        CriarAcesso1.setMargin(new java.awt.Insets(2, 25, 2, 25));
        CriarAcesso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarAcesso1ActionPerformed(evt);
            }
        });
        jToolBar1.add(CriarAcesso1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        jButton2.setText("Excluir");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMargin(new java.awt.Insets(2, 25, 2, 25));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        internalUsuario.getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 680, 60);

        jPanel1.add(internalUsuario);
        internalUsuario.setBounds(10, 0, 690, 480);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 710, 490);

        setBounds(0, 0, 734, 531);
    }// </editor-fold>//GEN-END:initComponents

    private void CriarAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarAcessoActionPerformed
   
    }//GEN-LAST:event_CriarAcessoActionPerformed

    private void CriarAcesso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarAcesso1ActionPerformed
        String loginFun,senhaFun,cpf, permissao = "";

        cpf = txt_Cpf.getText();
        loginFun = txt_loginFun1.getText();
        senhaFun = txt_senhaFun1.getText();

        if(loginFun.equals("") || senhaFun.equals("")){
        
            JOptionPane.showMessageDialog(null, "Preenche todos os campos corretamente");
         
        }
        
        else if(CPF.isValido(cpf) == false || "111.111.111-11".equals(cpf) || "000.000.000-00".equals(cpf) || "   .   .   -  ".equals(cpf)  ){
        
        JOptionPane.showMessageDialog(null, "Cpf Invalido");
        
        }
        else{
        
        if (Caixa1.isSelected()) {
            permissao += "0";
        } 

        else if (Adm1.isSelected()) {
            permissao += "1";
        } 
        
       
       
       
             
        
        if (ba.gravaLogin( loginFun, senhaFun,cpf , permissao)) {

            txt_loginFun1.setText("");
            txt_senhaFun1.setText("");
            txt_Cpf.setText("");
            desabilitaCampos();
            carregaTabela();
             }
           }
        
    }//GEN-LAST:event_CriarAcesso1ActionPerformed

    private void txt_CpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CpfKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
        
        ResultSet rs;

        
        String cpf = txt_Cpf.getText();
        
     if(cpf.equals("   .   .   -  ") || CPF.isValido(cpf) == false){
         
          JOptionPane.showMessageDialog(null,"Atenção Cpf inválido");
         
     }

           
        rs = ba.buscaFuncionario(cpf);
        

                if (ba.buscaFuncionario(cpf) != null) {
          
                    habilitaCampos();
                    
                }
                else {
                    
                    JOptionPane.showMessageDialog(null,"Cpf não registrado");
                    
                }
            
            
        
   
        }
        
        
        
    }//GEN-LAST:event_txt_CpfKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String cpf =txt_Cpf.getText();

       

        
                if (ba.excluiUsuario(cpf)) {
                    JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                    
                       txt_Cpf.setText("");
                       carregaTabela();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Não encontrado");
                
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void gridUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridUsuariosMouseClicked
        
        if (evt.getClickCount() == 2) {  
            Object obj = (gridUsuarios.getValueAt(gridUsuarios.getSelectedRow(), 1));  //coluna 1
            String cpf = obj.toString();
            
            txt_Cpf.setText(cpf);
            habilitaCampos();
        }
        
    }//GEN-LAST:event_gridUsuariosMouseClicked

    private void txt_CpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CpfFocusLost
        String loginFun,senhaFun,cpf, permissao = "";        
        
        cpf = txt_Cpf.getText();
        loginFun = txt_loginFun1.getText();
        senhaFun = txt_senhaFun1.getText();
        
        if(cpf.equals("   .   .   -  ") || CPF.isValido(cpf) == false){
        
           
         
            desabilitaCampos();
        }
        
         ResultSet rs;

        
      
        
     

           
        rs = ba.buscaFuncionario(cpf);
        

                if (ba.buscaFuncionario(cpf) != null) {
          
                    habilitaCampos();
                    
                }
                else {
                    
                    JOptionPane.showMessageDialog(null,"Cpf não registrado");
                    
                    desabilitaCampos();
                    
                }
            
            
        
   
        
        
    }//GEN-LAST:event_txt_CpfFocusLost

       private void jTextField1FocusLostCpf(java.awt.event.FocusEvent evt) {
        String cpfFor = txt_Cpf.getText();
        String cpf = cpfFor;

            if (CPF.isValido(cpfFor) == false || "111.111.111-11".equals(cpfFor) || "000.000.000-00".equals(cpfFor) || "   .   .   -  ".equals(cpfFor)  ){


          

          JOptionPane.showMessageDialog(null,"Atenção Cpf inválido");
          
          txt_Cpf.requestFocus();
          
          
         }
        else{
         
         ValidaCnpj.formatar(cpf);
         txt_Cpf.setText(cpf);
         System.out.println(cpf);
         
        }

    }
     public void carregaTabela(){
        String msg1 = "Usuario recuperados com sucesso";
        String msg2 = "Erro ao Recuperar Usuario";
        String vsql = "SELECT f.nomeFun,u.cpfFun, u.login, u.permissao FROM usuario u INNER JOIN funcionario f ON f.cpffun = u.cpffun";


        bf.tabelaUsuario(vsql, msg1, msg2, gridUsuarios);
    }
    
    public void desabilitaCampos(){
        
        txt_loginFun1.setEnabled(false);
        txt_senhaFun1.setEnabled(false);
        Caixa1.setEnabled(false);
        Adm1.setEnabled(false);
        
    }
    
    public void habilitaCampos(){
        
        txt_loginFun1.setEnabled(true);
        txt_senhaFun1.setEnabled(true);
        Caixa1.setEnabled(true);
        Adm1.setEnabled(true);
        
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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Adm;
    private javax.swing.JCheckBox Adm1;
    private javax.swing.JCheckBox Caixa;
    private javax.swing.JCheckBox Caixa1;
    private javax.swing.JButton CriarAcesso;
    private javax.swing.JButton CriarAcesso1;
    private javax.swing.JTable gridUsuarios;
    public javax.swing.JInternalFrame internalUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JFormattedTextField txt_Cpf;
    private javax.swing.JTextField txt_loginFun;
    private javax.swing.JTextField txt_loginFun1;
    private javax.swing.JPasswordField txt_senhaFun;
    private javax.swing.JPasswordField txt_senhaFun1;
    // End of variables declaration//GEN-END:variables
}
