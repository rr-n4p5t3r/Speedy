/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.rr.speedy.speedy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * Clase principal que representa la aplicación Speedy, un editor de código simple.
 * Permite crear, abrir, guardar y editar archivos de texto.
 * También proporciona una opción de ayuda que muestra información sobre la aplicación.
 * @author Ricardo Rosero - n4p5t3r
 * @github https://github.com/rr-n4p5t3r
 */
public class Speedy extends javax.swing.JFrame {
    
    private JTextArea textArea;

    /**
     * Constructor de la clase Speedy.
     * Inicializa y configura los componentes de la interfaz de usuario.
     */
    public Speedy() {
        initComponentsCustom();
    }

    /**
     * Método privado para inicializar y personalizar los componentes de la interfaz de usuario.
     */
    @SuppressWarnings({"CallToPrintStackTrace", "ConvertToTryWithResources"})
    private void initComponentsCustom() {
        setTitle("Speedy - Editor de Código");
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // Menú Archivo
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem newMenuItem = new JMenuItem("Nuevo");
        JMenuItem openMenuItem = new JMenuItem("Abrir");
        JMenuItem saveMenuItem = new JMenuItem("Guardar");
        JMenuItem exitMenuItem = new JMenuItem("Salir");
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        // Menú Ayuda
        JMenu helpMenu = new JMenu("Ayuda");
        JMenuItem aboutMenuItem = new JMenuItem("Acerca de");
        helpMenu.add(aboutMenuItem);
        menuBar.add(helpMenu);

        // Acción para la opción "Nuevo"
        newMenuItem.addActionListener((ActionEvent e) -> {
            textArea.setText("");
        });

        // Acción para la opción "Abrir"
        openMenuItem.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(Speedy.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                        sb.append("\n");
                    }
                    br.close();
                    textArea.setText(sb.toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Acción para la opción "Guardar"
        saveMenuItem.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(Speedy.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile));
                    bw.write(textArea.getText());
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Acción para la opción "Salir"
        exitMenuItem.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        // Acción para la opción "Acerca de"
        aboutMenuItem.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(Speedy.this, "Speedy - Editor de Código\nVersión 1.0\nDesarrollado por Ricardo Rosero\nemail: rrosero2000@gmail.com\nGithub: https://github.com/rr-n4p5t3r", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
        });

        // Text area para editar código
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    /**
     * Método principal que inicia la aplicación Speedy.
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String args[]) {
        try {
            // Setea el look and feel de Nimbus
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        // Crea y muestra la ventana
        java.awt.EventQueue.invokeLater(() -> {
            new Speedy().setVisible(true);
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
