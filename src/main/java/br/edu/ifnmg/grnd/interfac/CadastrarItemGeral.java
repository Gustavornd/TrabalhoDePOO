/*
 * Copyright (C) 2022 Gustavo Rafael Nunes Durães 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.edu.ifnmg.grnd.interfac;

import br.edu.ifnmg.grnd.entidade.ItemGeral;
import br.edu.ifnmg.grnd.repositorio.ItemGeralDAO;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gustavo Rafael Nunes Durães
 */
public class CadastrarItemGeral extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarItemGeral
     */
    public CadastrarItemGeral() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IGnomeLBL = new javax.swing.JLabel();
        IGpesoLBL = new javax.swing.JLabel();
        IGprecoLBL = new javax.swing.JLabel();
        IGquantidadeLBL = new javax.swing.JLabel();
        IGdescricaoLBL = new javax.swing.JLabel();
        IGsalvarBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        IGdescricaoTXF = new javax.swing.JTextArea();
        IGnomeTXF = new javax.swing.JTextField();
        IGpesoTXF = new javax.swing.JTextField();
        IGprecoTXF = new javax.swing.JTextField();
        IGquantidadeTXF = new javax.swing.JTextField();
        IGequipadoCKB = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IGnomeLBL.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGnomeLBL.setText("Nome:");

        IGpesoLBL.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGpesoLBL.setText("Peso: ");

        IGprecoLBL.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGprecoLBL.setText("Preço:");

        IGquantidadeLBL.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGquantidadeLBL.setText("Quantidade:");

        IGdescricaoLBL.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGdescricaoLBL.setText("Descrição:");

        IGsalvarBTN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGsalvarBTN.setText("Salvar");
        IGsalvarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGsalvarBTNActionPerformed(evt);
            }
        });

        IGdescricaoTXF.setColumns(20);
        IGdescricaoTXF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGdescricaoTXF.setRows(5);
        jScrollPane1.setViewportView(IGdescricaoTXF);

        IGnomeTXF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGnomeTXF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGnomeTXFActionPerformed(evt);
            }
        });

        IGpesoTXF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGpesoTXF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGpesoTXFActionPerformed(evt);
            }
        });

        IGprecoTXF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGprecoTXF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGprecoTXFActionPerformed(evt);
            }
        });

        IGquantidadeTXF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGquantidadeTXF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGquantidadeTXFActionPerformed(evt);
            }
        });

        IGequipadoCKB.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IGequipadoCKB.setText("Equipado");
        IGequipadoCKB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IGequipadoCKBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IGquantidadeLBL)
                            .addComponent(IGprecoLBL)
                            .addComponent(IGpesoLBL)
                            .addComponent(IGnomeLBL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IGquantidadeTXF)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IGnomeTXF, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IGpesoTXF, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IGprecoTXF, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IGdescricaoLBL)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(IGequipadoCKB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1)))))
                .addGap(152, 152, 152))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IGsalvarBTN)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IGnomeLBL)
                    .addComponent(IGnomeTXF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IGpesoLBL)
                    .addComponent(IGpesoTXF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IGprecoLBL)
                    .addComponent(IGprecoTXF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IGquantidadeLBL)
                    .addComponent(IGquantidadeTXF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IGdescricaoLBL)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IGequipadoCKB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IGsalvarBTN)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IGnomeTXFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGnomeTXFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IGnomeTXFActionPerformed

    private void IGpesoTXFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGpesoTXFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IGpesoTXFActionPerformed

    private void IGquantidadeTXFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGquantidadeTXFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IGquantidadeTXFActionPerformed

    private void IGequipadoCKBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGequipadoCKBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IGequipadoCKBActionPerformed

    private void IGprecoTXFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGprecoTXFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IGprecoTXFActionPerformed

    private void IGsalvarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IGsalvarBTNActionPerformed
         ItemGeral item = new ItemGeral();
         item.setNome(IGnomeTXF.getText());
         item.setPeso(new Double(IGpesoTXF.getText()));
         item.setPreco(new Double(IGprecoTXF.getText()));
         item.setQuantidade(new Integer(IGquantidadeTXF.getText()));
         item.setDescricao(IGdescricaoTXF.getText());
         item.setEquipado(IGequipadoCKB.isSelected());
         
         System.out.println(item.toString());
         new ItemGeralDAO().salvar(item);
        
    }//GEN-LAST:event_IGsalvarBTNActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarItemGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarItemGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarItemGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarItemGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarItemGeral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IGdescricaoLBL;
    private javax.swing.JTextArea IGdescricaoTXF;
    private javax.swing.JCheckBox IGequipadoCKB;
    private javax.swing.JLabel IGnomeLBL;
    private javax.swing.JTextField IGnomeTXF;
    private javax.swing.JLabel IGpesoLBL;
    private javax.swing.JTextField IGpesoTXF;
    private javax.swing.JLabel IGprecoLBL;
    private javax.swing.JTextField IGprecoTXF;
    private javax.swing.JLabel IGquantidadeLBL;
    private javax.swing.JTextField IGquantidadeTXF;
    private javax.swing.JButton IGsalvarBTN;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}