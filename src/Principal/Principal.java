/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import TelaClientes.Cliente;
import javax.swing.JInternalFrame;
import Fornecedor.Fornecedor;
import Caixa.Caixa;
import ContaPagarReceber.ContasPagarReceber;
import Funcionario.Funcionario;
import Compras.Compras;
import Movimentacao.Vendas;
import Pedidos.Pedidos;
import Produtos.Produto;
import Usuario.Usuario;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Paulo
 */
public class Principal extends javax.swing.JFrame {

    JInternalFrame intCliente;
    JInternalFrame intProdutos;
    JInternalFrame intUsuario;
    JInternalFrame intFuncionario;
    JInternalFrame intFornecedor;
    JInternalFrame intContasPagarReceber;
    JInternalFrame intCompras;
    JInternalFrame intCaixa;
    JInternalFrame intMovimentacao;
    JInternalFrame intPedidos;

    
    
    public Principal() {
        initComponents();
        
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnUsuario = new javax.swing.JButton();
        btnFuncionario = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProdutos = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Fornecedor = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        Encerrar = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 204));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnUsuario.setBackground(new java.awt.Color(255, 255, 204));
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1440270532_user-group.png"))); // NOI18N
        btnUsuario.setText("Usuarios");
        btnUsuario.setFocusable(false);
        btnUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsuario.setMargin(new java.awt.Insets(2, 25, 2, 25));
        btnUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUsuario);

        btnFuncionario.setBackground(new java.awt.Color(255, 255, 204));
        btnFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/funcionario.png"))); // NOI18N
        btnFuncionario.setText("Funcionarios");
        btnFuncionario.setFocusable(false);
        btnFuncionario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFuncionario.setMargin(new java.awt.Insets(2, 25, 2, 25));
        btnFuncionario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFuncionario);

        btnCliente.setBackground(new java.awt.Color(255, 255, 204));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1440270593_clients.png"))); // NOI18N
        btnCliente.setText("Clientes");
        btnCliente.setFocusable(false);
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setMargin(new java.awt.Insets(2, 25, 2, 25));
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCliente);

        btnProdutos.setBackground(new java.awt.Color(255, 255, 204));
        btnProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/caixa.png"))); // NOI18N
        btnProdutos.setText("Vendas");
        btnProdutos.setFocusable(false);
        btnProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProdutos.setMargin(new java.awt.Insets(2, 25, 2, 25));
        btnProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProdutos);

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/produtos.png"))); // NOI18N
        jButton2.setText("Produtos");
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

        jButton4.setBackground(new java.awt.Color(255, 255, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1440270844_shopping.png"))); // NOI18N
        jButton4.setText("Pedidos");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMargin(new java.awt.Insets(2, 25, 2, 25));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        Fornecedor.setBackground(new java.awt.Color(255, 255, 204));
        Fornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1440270909_truck.png"))); // NOI18N
        Fornecedor.setText("Fornecedor");
        Fornecedor.setFocusable(false);
        Fornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Fornecedor.setMargin(new java.awt.Insets(2, 25, 2, 25));
        Fornecedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FornecedorActionPerformed(evt);
            }
        });
        jToolBar1.add(Fornecedor);

        jButton6.setBackground(new java.awt.Color(255, 255, 204));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1440270991_shopping_basket.png"))); // NOI18N
        jButton6.setText("Compras");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMargin(new java.awt.Insets(2, 25, 2, 25));
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton8.setBackground(new java.awt.Color(255, 255, 204));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1440271170_wallet.png"))); // NOI18N
        jButton8.setText("Contas a Pagar/Receber");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMargin(new java.awt.Insets(2, 25, 2, 25));
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jButton10.setBackground(new java.awt.Color(255, 255, 204));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1440271295_Untitled-2-34.png"))); // NOI18N
        jButton10.setText("Movimentação");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setMargin(new java.awt.Insets(2, 25, 2, 25));
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);

        Encerrar.setBackground(new java.awt.Color(255, 255, 204));
        Encerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/exit (2).png"))); // NOI18N
        Encerrar.setText("Sair do sitema");
        Encerrar.setFocusable(false);
        Encerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Encerrar.setMargin(new java.awt.Insets(2, 25, 2, 25));
        Encerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Encerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncerrarActionPerformed(evt);
            }
        });
        jToolBar1.add(Encerrar);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 1600, 60);

        desktop.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pizza_grande.jpg"))); // NOI18N
        desktop.add(jLabel1);
        jLabel1.setBounds(0, 0, 1600, 820);

        getContentPane().add(desktop);
        desktop.setBounds(0, 60, 1600, 820);

        setBounds(0, 0, 1616, 939);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        if(intCaixa == null || intCaixa.isClosed()){
             intCaixa = new Caixa().internalCaixa;
             getContentPane().add(intCaixa);
             desktop.add(intCaixa);
             intCaixa.setLocation(240, 30);
             intCaixa.moveToFront();
         }
    }//GEN-LAST:event_btnProdutosActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(intCompras == null || intCompras.isClosed()){
             intCompras = new Compras().internalCompras;
             getContentPane().add(intCompras);
             desktop.add(intCompras);
             intCompras.setLocation(240, 30);
             intCompras.moveToFront();
         }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioActionPerformed

         if(intFuncionario == null || intFuncionario.isClosed()){
             intFuncionario = new Funcionario().internalFuncionario;
             getContentPane().add(intFuncionario);
             desktop.add(intFuncionario);
             intFuncionario.setLocation(240, 30);
             intFuncionario.moveToFront();
         }
    }//GEN-LAST:event_btnFuncionarioActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        if(intCliente == null || intCliente.isClosed()){
             intCliente = new Cliente().internalCliente;
             getContentPane().add(intCliente);
             desktop.add(intCliente);
             intCliente.setLocation(240, 30);
             intCliente.moveToFront();
         }
    }//GEN-LAST:event_btnClienteActionPerformed

    private void FornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FornecedorActionPerformed
        if(intFornecedor == null || intFornecedor.isClosed()){
             intFornecedor = new Fornecedor().internalFornecedor;
             getContentPane().add(intFornecedor);
             desktop.add(intFornecedor);
             intFornecedor.setLocation(240, 30);
             intFornecedor.moveToFront();
         }
    }//GEN-LAST:event_FornecedorActionPerformed

    private void EncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncerrarActionPerformed
 if(intCaixa == null || intCaixa.isClosed()){

            Object[] options = { "Sim", "Não" };
            int opcao = JOptionPane.showOptionDialog(null,"Deseja fechar o sistema ?", "AVISO",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

               if(opcao == 0){

                   System.exit(0);
               }
        }else{
            JOptionPane pane = new JOptionPane("O programa não pode ser fechado enquanto o 'PDV' estiver aberto\n\n"+
                                                 "Feche o 'PDV' para poder fechar o programa");  
            JDialog dialog = pane.createDialog("Aviso");  
            dialog.setAlwaysOnTop(true);
            dialog.show();
        }
    }//GEN-LAST:event_EncerrarActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        if(intUsuario == null || intUsuario.isClosed()){
             intUsuario = new Usuario().internalUsuario;
             getContentPane().add(intUsuario);
             desktop.add(intUsuario);
             intUsuario.setLocation(130, 15);
             intUsuario.moveToFront();
         }
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
                
                if(intProdutos == null || intProdutos.isClosed()){
             intProdutos = new Produto().internalProduto;
             getContentPane().add(intProdutos);
             desktop.add(intProdutos);
             intProdutos.setLocation(240, 30);
             intProdutos.moveToFront();
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
                
                  if(intContasPagarReceber == null || intContasPagarReceber.isClosed()){
             intContasPagarReceber = new ContasPagarReceber().internalContasPagarReceber;
             getContentPane().add(intContasPagarReceber);
             desktop.add(intContasPagarReceber);
             intContasPagarReceber.setLocation(240, 30);
             intContasPagarReceber.moveToFront();
         }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        
        
        if(intMovimentacao == null || intMovimentacao.isClosed()){
             intMovimentacao = new Vendas().internalMovimentacao;
             getContentPane().add(intMovimentacao);
             desktop.add(intMovimentacao);
             intMovimentacao.setLocation(240, 30);
             intMovimentacao.moveToFront();
         }
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(intPedidos == null || intPedidos.isClosed()){
             intPedidos = new Pedidos().internalPedidos;
             getContentPane().add(intPedidos);
             desktop.add(intPedidos);
             intPedidos.setLocation(240, 30);
             intPedidos.moveToFront();
         }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Encerrar;
    private javax.swing.JButton Fornecedor;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnFuncionario;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}