/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracaoBanco.GUI;

import Banco.VerificaConexaoDAO;
import javax.swing.JOptionPane;

public class Frame extends javax.swing.JFrame {

    public Frame() {
        initComponents();
        FServidor.requestFocus();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    VerificaConexaoDAO verificaConexaoDAO = new VerificaConexaoDAO();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PBorda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        BVerificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FServidor = new javax.swing.JTextField();
        FPorta = new javax.swing.JTextField();
        FSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizzaria - Banco de Dados");

        PBorda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jTextArea1.setRows(3);
        jTextArea1.setText("Assistente de Configuração para Banco de Dados\ndo Sistema \"PizzariaJava\".\n\nPara dar continuidade ao processo certifique-se\nde ter instalado o Banco de Dados MySQL");
        jScrollPane1.setViewportView(jTextArea1);

        BVerificar.setText("Verificar");
        BVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVerificarActionPerformed(evt);
            }
        });
        BVerificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BVerificarKeyPressed(evt);
            }
        });

        jLabel1.setText("Servidor");

        jLabel2.setText("Porta");

        jLabel3.setText("Senha");

        FServidor.setText("localhost");
        FServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FServidorActionPerformed(evt);
            }
        });

        FPorta.setText("3306");
        FPorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FPortaActionPerformed(evt);
            }
        });

        FSenha.setText("root");
        FSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FSenhaActionPerformed(evt);
            }
        });

        jLabel4.setText("OBS: Infrome a senha do \"MySQL\"");

        javax.swing.GroupLayout PBordaLayout = new javax.swing.GroupLayout(PBorda);
        PBorda.setLayout(PBordaLayout);
        PBordaLayout.setHorizontalGroup(
            PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBordaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PBordaLayout.createSequentialGroup()
                        .addGroup(PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FPorta)
                            .addComponent(FServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(FSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PBordaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BVerificar)))
                .addContainerGap())
        );
        PBordaLayout.setVerticalGroup(
            PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBordaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(FSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(BVerificar)
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

    private void BVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVerificarActionPerformed
        // TODO add your handling code here: 
        if (verificaConexaoDAO.VerificaConexao(FServidor.getText(), FPorta.getText(), String.valueOf(this.FSenha.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Conexão configurada com sucesso!");
           
            Frame2 frame2 = new Frame2(FServidor.getText(), FPorta.getText(), String.valueOf(this.FSenha.getPassword()));
            this. dispose();
            FServidor.setEditable(false);
            FPorta.setEditable(false);
            FSenha.setEditable(false);
            
        }
    }//GEN-LAST:event_BVerificarActionPerformed

    private void FServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FServidorActionPerformed
        // TODO add your handling code here:
        FPorta.requestFocus();
    }//GEN-LAST:event_FServidorActionPerformed

    private void FPortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FPortaActionPerformed
        // TODO add your handling code here:
        FSenha.requestFocus();
    }//GEN-LAST:event_FPortaActionPerformed

    private void FSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FSenhaActionPerformed
        // TODO add your handling code here:
        BVerificar.requestFocus();
    }//GEN-LAST:event_FSenhaActionPerformed

    private void BVerificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BVerificarKeyPressed
        // TODO add your handling code here:
        if (verificaConexaoDAO.VerificaConexao(FServidor.getText(), FPorta.getText(), String.valueOf(this.FSenha.getPassword()))) {
            FServidor.setEditable(false);
            FPorta.setEditable(false);
            FSenha.setEditable(false);
            JOptionPane.showMessageDialog(null, "Conexão configurada com sucesso!");
            dispose();
            Frame2 frame2 = new Frame2(FServidor.getText(), FPorta.getText(), String.valueOf(this.FSenha.getPassword()));
            
        }
    }//GEN-LAST:event_BVerificarKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BVerificar;
    private javax.swing.JTextField FPorta;
    private javax.swing.JPasswordField FSenha;
    private javax.swing.JTextField FServidor;
    private javax.swing.JPanel PBorda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
