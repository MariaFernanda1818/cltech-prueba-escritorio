/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gov.app.prueba.clteach.vistas;

import com.gov.app.prueba.clteach.services.ILeerArchivoService;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SubidaArchivosWindow extends javax.swing.JFrame {

    private final ILeerArchivoService iLeerArchivoService;
    private File archivo;

    /**
     * Creates new form SubidaArchivosWindow
     */
    public SubidaArchivosWindow(ILeerArchivoService iLeerArchivoService) {
        this.iLeerArchivoService = iLeerArchivoService;
        setTitle("Subida de Archivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        java.awt.GridBagConstraints gridBagConstraints;

        seleccionarArchivoButton = new javax.swing.JButton();
        enviarButton = new javax.swing.JButton();
        nombreArchivoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Subida de archivos");
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 20, 0, 20, 0};
        layout.rowHeights = new int[] {0, 20, 0, 20, 0};
        getContentPane().setLayout(layout);

        seleccionarArchivoButton.setText("Seleccionar Archivo");
        seleccionarArchivoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarArchivoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        getContentPane().add(seleccionarArchivoButton, gridBagConstraints);

        enviarButton.setText("Enviar");
        enviarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        getContentPane().add(enviarButton, gridBagConstraints);

        nombreArchivoLabel.setText("Archivo seleccionado: Ninguno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        getContentPane().add(nombreArchivoLabel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarButtonActionPerformed
        if (archivo == null) {
            JOptionPane.showMessageDialog(this,
                "Por favor, selecciona un archivo antes de enviar.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "¿Deseas enviar el archivo seleccionado?",
            "Confirmar Envío",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                iLeerArchivoService.leerArchivoHl7(archivo);
                JOptionPane.showMessageDialog(this,
                    "Archivo enviado exitosamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    "Ocurrió un error al enviar el archivo: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_enviarButtonActionPerformed

    private void seleccionarArchivoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarArchivoButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Archivo");
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            archivo = fileChooser.getSelectedFile();
            if (!archivo.getName().endsWith(".txt")) {
                JOptionPane.showMessageDialog(this,
                    "El archivo seleccionado no es válido. Solo se aceptan archivos .txt.",
                    "Error de Archivo",
                    JOptionPane.ERROR_MESSAGE);
                archivo = null; // Reiniciar selección si no es válido
                return;
            }
            nombreArchivoLabel.setText("Archivo seleccionado: " + archivo.getName());
        } else {
            JOptionPane.showMessageDialog(this,
                "No se seleccionó ningún archivo.",
                "Sin Archivo",
                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_seleccionarArchivoButtonActionPerformed
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviarButton;
    private javax.swing.JLabel nombreArchivoLabel;
    private javax.swing.JButton seleccionarArchivoButton;
    // End of variables declaration//GEN-END:variables
}
