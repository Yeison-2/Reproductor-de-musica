/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Yeison Romero
 */
public class Vista_ReproductorMusica extends javax.swing.JFrame {

    public Vista_ReproductorMusica() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Reproductor de musica");
        this.setSize(new Dimension(1021, 650));
        configurarPlaceholder(JTF_BuscaCanciones, "Buscar Cancion");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        JL_progresoMusica = new javax.swing.JSlider();
        JB_play = new javax.swing.JButton();
        JB_anterior = new javax.swing.JButton();
        JB_siguiente = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_tablaCancioArtista = new javax.swing.JTable();
        JL_tituloCanciones = new javax.swing.JLabel();
        JTF_BuscaCanciones = new javax.swing.JTextField();
        JB_buscarCancion = new javax.swing.JButton();
        JB_añadirCancion = new javax.swing.JButton();
        JB_eliminarCancion = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        JL_progresoMusica.setBackground(new java.awt.Color(255, 255, 255));

        JB_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Play.png"))); // NOI18N
        JB_play.setBorderPainted(false);
        JB_play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_playActionPerformed(evt);
            }
        });

        JB_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anterior.png"))); // NOI18N
        JB_anterior.setBorderPainted(false);
        JB_anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_anteriorActionPerformed(evt);
            }
        });

        JB_siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/siguiente.png"))); // NOI18N
        JB_siguiente.setBorderPainted(false);
        JB_siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_siguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JL_progresoMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(JB_anterior)
                .addGap(53, 53, 53)
                .addComponent(JB_play)
                .addGap(48, 48, 48)
                .addComponent(JB_siguiente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(JL_progresoMusica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_play)
                    .addComponent(JB_anterior)
                    .addComponent(JB_siguiente))
                .addGap(0, 42, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        JT_tablaCancioArtista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cancion", "Artista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JT_tablaCancioArtista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(JT_tablaCancioArtista);

        JL_tituloCanciones.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JL_tituloCanciones.setText("Canciones");

        JTF_BuscaCanciones.setText("Buscar Cancion");
        JTF_BuscaCanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_BuscaCancionesActionPerformed(evt);
            }
        });

        JB_buscarCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SearchBuscar.png"))); // NOI18N
        JB_buscarCancion.setText("Buscar");
        JB_buscarCancion.setBorderPainted(false);
        JB_buscarCancion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_buscarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_buscarCancionActionPerformed(evt);
            }
        });

        JB_añadirCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SymbolsAddSuma.png"))); // NOI18N
        JB_añadirCancion.setText("Añadir ");
        JB_añadirCancion.setBorderPainted(false);
        JB_añadirCancion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_añadirCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_añadirCancionActionPerformed(evt);
            }
        });

        JB_eliminarCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        JB_eliminarCancion.setText("Eliminar");
        JB_eliminarCancion.setBorderPainted(false);
        JB_eliminarCancion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_eliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_eliminarCancionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JB_añadirCancion)
                .addGap(307, 307, 307))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JB_eliminarCancion)
                        .addGap(135, 135, 135)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JL_tituloCanciones)
                        .addGap(45, 45, 45)
                        .addComponent(JB_buscarCancion)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_BuscaCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(JL_tituloCanciones)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTF_BuscaCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_buscarCancion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JB_añadirCancion)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(JB_eliminarCancion)))
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("Canciones", jPanel3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1021, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Biblioteca", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_BuscaCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_BuscaCancionesActionPerformed

    }//GEN-LAST:event_JTF_BuscaCancionesActionPerformed

    private void JB_añadirCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_añadirCancionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_añadirCancionActionPerformed

    private void JB_eliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_eliminarCancionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_eliminarCancionActionPerformed

    private void JB_buscarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_buscarCancionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_buscarCancionActionPerformed

    private void JB_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_playActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_playActionPerformed

    private void JB_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_anteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_anteriorActionPerformed

    private void JB_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_siguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_siguienteActionPerformed

    //metodos para enviar todo al controlador
    /**
     * metodo que retorna la cancion a buscar con String para usurla en el
     * controlador
     *
     * @return el dato que esta en el JTF_buscarCancion
     */
    public String getpedirCancionString() {
        return JTF_BuscaCanciones.getText();
    }

    //metodo para agregar el nombre y el autor a la table
    /**
     * Metodo para mostra notificaciones de errores como por ejemplo dato no
     * valido
     *
     * @param error String
     */
    public void verError(String error) {
        JOptionPane.showMessageDialog(this, error, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Metodo que retorna las interacciones con los botones y le asigna un
     * comando exclusivo a cada uno para que puedan se utillizados por ejemplo
     * en el controlador
     *
     * @param listener 
     */
    public void addListener(ActionListener listener) {
        JB_play.setActionCommand("play");//le asigno un comando especifico para llamarlo
        JB_play.addActionListener(listener);

        JB_siguiente.setActionCommand("siguiente");
        JB_siguiente.addActionListener(listener);

        JB_anterior.setActionCommand("anterior");
        JB_anterior.addActionListener(listener);

        //eliminar , añadir, buscar
        JB_eliminarCancion.setActionCommand("eliminar");
        JB_eliminarCancion.addActionListener(listener);

        JB_añadirCancion.setActionCommand("añadir");
        JB_añadirCancion.addActionListener(listener);

        JB_buscarCancion.setActionCommand("buscar");
        JB_buscarCancion.addActionListener(listener);
    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_ReproductorMusica().setVisible(true);
            }
        });
    }

    // Método para configurar el placeholder en cualquier JTextField
    public static void configurarPlaceholder(JTextField textField, String placeholder) {
        // Establecer el texto inicial (placeholder)
        textField.setText(placeholder);

        // Añadir el FocusListener para manejar el comportamiento del placeholder
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Borrar el texto si el contenido es el placeholder
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Restaurar el placeholder si el campo está vacío al perder el foco
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_anterior;
    private javax.swing.JButton JB_añadirCancion;
    private javax.swing.JButton JB_buscarCancion;
    private javax.swing.JButton JB_eliminarCancion;
    private javax.swing.JButton JB_play;
    private javax.swing.JButton JB_siguiente;
    private javax.swing.JSlider JL_progresoMusica;
    private javax.swing.JLabel JL_tituloCanciones;
    private javax.swing.JTextField JTF_BuscaCanciones;
    private javax.swing.JTable JT_tablaCancioArtista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
