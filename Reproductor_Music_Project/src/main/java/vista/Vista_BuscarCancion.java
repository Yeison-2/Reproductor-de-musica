/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import controlador.Controlador_ReproductorMusic;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import modelo.Cancion;
import modelo.modelo_playList;

public class Vista_BuscarCancion extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private Controlador_ReproductorMusic controlador;

    public Vista_BuscarCancion(Controlador_ReproductorMusic controlador) {
        this.controlador = controlador;
        setUndecorated(true);
        initComponents();
        setupTableSelection();
        this.setLocationRelativeTo(null);

    }

    public void mostrarResultadosBusqueda(Cancion[] canciones) {
        DefaultTableModel tableModel = (DefaultTableModel) JT_tablaCancioBuscada.getModel();
        tableModel.setRowCount(0); // Clear the table before adding new results
        for (Cancion cancion : canciones) {
            tableModel.addRow(new Object[]{cancion.getTitulo(), cancion.getArtista()});
        }
    }

    private void setupTableSelection() {
        JT_tablaCancioBuscada.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JT_tablaCancioBuscada.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = JT_tablaCancioBuscada.getSelectedRow();
                    if (selectedRow != -1) {
                        String titulo = (String) JT_tablaCancioBuscada.getModel().getValueAt(selectedRow, 0);
                        String artista = (String) JT_tablaCancioBuscada.getModel().getValueAt(selectedRow, 1);
                        int id = getIdCancionTxt(titulo, artista);
                        if (id != -1) {
                            controlador.reproducirCancion(id);
                            vaciarTabla();
                            Vista_BuscarCancion.this.dispose();
                        } else {
                            mostrartraMensaje("No se encontró la canción con el ID especificado.");
                        }
                    } else {
                        mostrartraMensaje("Seleccione una fila para ejecutar la acción.");
                    }
                }
            }
        });
    }

    private void vaciarTabla() {
        ((DefaultTableModel) JT_tablaCancioBuscada.getModel()).setRowCount(0);
    }

    private int getIdCancionTxt(String titulo, String artista) {
        try (BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/canciones.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String existeTitulo = datos[1].strip();
                    String existeArtista = datos[2].strip();
                    if (existeTitulo.equals(titulo) && existeArtista.equals(artista)) {
                        return Integer.parseInt(datos[0]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void mostrartraMensaje(String error) {
        JOptionPane.showMessageDialog(this, error, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_tablaCancioBuscada = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        JL_tituloCanciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JT_tablaCancioBuscada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        JT_tablaCancioBuscada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(JT_tablaCancioBuscada);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 264, 251));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        JL_tituloCanciones.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JL_tituloCanciones.setText("Resultados");
        jPanel1.add(JL_tituloCanciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                modelo_playList playlist = new modelo_playList();
                Vista_ReproductorMusica view = new Vista_ReproductorMusica();
                Controlador_ReproductorMusic controlador = new Controlador_ReproductorMusic(playlist, view);
                new Vista_BuscarCancion(controlador).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_tituloCanciones;
    private javax.swing.JTable JT_tablaCancioBuscada;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
