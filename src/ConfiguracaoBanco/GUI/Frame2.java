/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracaoBanco.GUI;

import Banco.VerificaConexaoDAO;
import ConfiguracaoBanco.FILE.ManageFiles;
import ConfiguracaoBanco.FILE.ManageFilesWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Frame2 extends javax.swing.JFrame {

    String server;
    String porta;
    String senha;

    public Frame2(String server, String porta, String senha) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        this.server = server;
        this.porta = porta;
        this.senha = senha;
        FBancoDeDados.requestFocus();
//        jProgressBar1.setVisible(false);
    }
    VerificaConexaoDAO verificaConexaoDAO = new VerificaConexaoDAO();
    ManageFiles manageFiles = new ManageFiles();
    ManageFilesWriter manageFilesWriter = new ManageFilesWriter();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PBorda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        BContinuar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FBancoDeDados = new javax.swing.JTextField();
        lblMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizzaria - Banco de Dados");

        PBorda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jTextArea1.setRows(3);
        jTextArea1.setText("Assistente de Configuração para Banco de Dados\ndo Sistema \"Pizzaria 15\".\n\nPara dar continuidade ao processo clique em \ncontinuar para criar o banco de dados do sistema.");
        jScrollPane1.setViewportView(jTextArea1);

        BContinuar.setText("Continuar");
        BContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BContinuarActionPerformed(evt);
            }
        });
        BContinuar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BContinuarKeyPressed(evt);
            }
        });

        jLabel1.setText("Banco de Dados");

        FBancoDeDados.setEditable(false);
        FBancoDeDados.setText("pizzaria15");
        FBancoDeDados.setToolTipText("Nome do banco de dados a ser criado para o sistema ");
        FBancoDeDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FBancoDeDadosActionPerformed(evt);
            }
        });
        FBancoDeDados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FBancoDeDadosFocusLost(evt);
            }
        });

        lblMensagem.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblMensagem.setMaximumSize(new java.awt.Dimension(110, 22));
        lblMensagem.setMinimumSize(new java.awt.Dimension(110, 22));
        lblMensagem.setPreferredSize(new java.awt.Dimension(110, 22));

        javax.swing.GroupLayout PBordaLayout = new javax.swing.GroupLayout(PBorda);
        PBorda.setLayout(PBordaLayout);
        PBordaLayout.setHorizontalGroup(
            PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBordaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PBordaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FBancoDeDados, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 179, Short.MAX_VALUE))
                    .addGroup(PBordaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BContinuar)))
                .addContainerGap())
        );
        PBordaLayout.setVerticalGroup(
            PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBordaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PBordaLayout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(BContinuar))
                    .addGroup(PBordaLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(FBancoDeDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PBorda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PBorda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FBancoDeDadosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FBancoDeDadosFocusLost
        // TODO add your handling code here:
//        String bancoDeDados = FBancoDeDados.getText();
//        if (bancoDeDados.isEmpty()) {
//            JOptionPane.showMessageDialog(rootPane, "Preencha o campo Banco de Dados.");
//            FBancoDeDados.requestFocus();
//        } else if (bancoDeDados.contains(" ")) {
//            JOptionPane.showMessageDialog(rootPane, "O nome do Banco de Dados não pode conter espaços.");
//            FBancoDeDados.requestFocus();
//        } else {
//            BContinuar.setEnabled(true);
//        }
    }//GEN-LAST:event_FBancoDeDadosFocusLost

    private void BContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BContinuarActionPerformed
        // TODO add your handling code here:
//        jProgressBar1.setVisible(true);
//        
//        new Thread() {
//            @Override
//            public void run() {
//                for (int j = 0; j < 101; j++) {
//                    try {
//                        sleep(100);
//                        jProgressBar1.setValue(j);
//                    } catch (InterruptedException ex) {
//
//                    }
//                }
//            }
//        }.start();
       
        try {
            manageFilesWriter.setArquivoDeConf(manageFiles.getArquivoDeConf(), server, porta, FBancoDeDados.getText(), "root", senha);
        } catch (IOException ex) {
            Logger.getLogger(Frame2.class.getName()).log(Level.SEVERE, null, ex);
        }

         
        
        
        if (verificaConexaoDAO.criaBancoDeDados(FBancoDeDados.getText())
                && verificaConexaoDAO.criaTabelas(FBancoDeDados.getText())) {
            JOptionPane.showMessageDialog(null, "Banco de Dados criado com sucesso.\n"
                    + "Tabelas e Registros criados com sucesso.\n"
                    + "Arquivo conf.ini configurado com sucesso.\n\n\n"
                    + "Processo concluido!");

            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Banco de Dados: " + FBancoDeDados.getText() + " já existente!");
            dispose();
        }

    }//GEN-LAST:event_BContinuarActionPerformed

    private void BContinuarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BContinuarKeyPressed
        // TODO add your handling code here:
//        jProgressBar1.setVisible(true);
//        new Thread() {
//            public void run() {
//                for (int j = 0; j < 101; j++) {
//                    try {
//                        sleep(100);
//                        jProgressBar1.setValue(j);
//                    } catch (InterruptedException ex) {
//
//                    }
//                }
//            }
//        }.start();
        try {
            manageFilesWriter.setArquivoDeConf(manageFiles.getArquivoDeConf(), server, porta, FBancoDeDados.getText(), "root", senha);
        } catch (IOException ex) {
            Logger.getLogger(Frame2.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (verificaConexaoDAO.criaBancoDeDados(FBancoDeDados.getText())
                && verificaConexaoDAO.criaTabelas(FBancoDeDados.getText())) {
            JOptionPane.showMessageDialog(null, "Banco de Dados criado com sucesso.\n"
                    + "Tabelas e Registros criado com sucesso.\n"
                    + "Arquivo conf.ini configurado com sucesso.\n\n\n"
                    + "Processo concluido!");

            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel criar o Banco de Dados: " + FBancoDeDados.getText());
            dispose();
        }

    }//GEN-LAST:event_BContinuarKeyPressed

    private void FBancoDeDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FBancoDeDadosActionPerformed
        // TODO add your handling code here:
        BContinuar.requestFocus();
    }//GEN-LAST:event_FBancoDeDadosActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BContinuar;
    private javax.swing.JTextField FBancoDeDados;
    private javax.swing.JPanel PBorda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblMensagem;
    // End of variables declaration//GEN-END:variables
}
