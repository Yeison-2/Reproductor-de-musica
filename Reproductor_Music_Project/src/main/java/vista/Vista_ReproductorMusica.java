/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.mpatric.mp3agic.Mp3File;
import controlador.Controlador_ReproductorMusic;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.plaf.FileChooserUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yeison Romero
 */
public class Vista_ReproductorMusica extends javax.swing.JFrame {

    private Controlador_ReproductorMusic ctrl;

    public Vista_ReproductorMusica() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Reproductor de musica");
        this.setSize(new Dimension(1021, 650));
        configurarPlaceholder(JTF_BuscaCanciones, "Buscar Cancion");
        verContenidoTxt();

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
        JB_pausa = new javax.swing.JButton();
        JB_aleatorio = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        JP_canciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JT_tablaCancioArtista = new javax.swing.JTable();
        JL_tituloCanciones = new javax.swing.JLabel();
        JTF_BuscaCanciones = new javax.swing.JTextField();
        JB_buscarCancion = new javax.swing.JButton();
        JB_añadirCancion = new javax.swing.JButton();
        JB_eliminarCancion = new javax.swing.JButton();
        JB_eliminarLista = new javax.swing.JButton();
        JP_biblioteca = new javax.swing.JPanel();
        JP_canciones1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JT_tablaCancioArtista1 = new javax.swing.JTable();
        JL_tituloCanciones1 = new javax.swing.JLabel();
        JB_añadirPlaylist = new javax.swing.JButton();
        JCB_playList = new javax.swing.JComboBox<>();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        JB_pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/TablerPlayerPauseFilled.png"))); // NOI18N
        JB_pausa.setBorderPainted(false);
        JB_pausa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_pausaActionPerformed(evt);
            }
        });

        JB_aleatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconamoonPlaylistShuffleBold.png"))); // NOI18N
        JB_aleatorio.setBorderPainted(false);
        JB_aleatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_aleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_aleatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(JB_anterior)
                .addGap(18, 18, 18)
                .addComponent(JB_play)
                .addGap(26, 26, 26)
                .addComponent(JB_pausa)
                .addGap(18, 18, 18)
                .addComponent(JB_siguiente)
                .addGap(18, 18, 18)
                .addComponent(JB_aleatorio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_progresoMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(JL_progresoMusica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_play)
                    .addComponent(JB_anterior)
                    .addComponent(JB_siguiente)
                    .addComponent(JB_pausa)
                    .addComponent(JB_aleatorio))
                .addGap(0, 42, Short.MAX_VALUE))
        );

        JP_canciones.setBackground(new java.awt.Color(255, 255, 255));

        JT_tablaCancioArtista.setModel(new javax.swing.table.DefaultTableModel(
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

        JB_eliminarLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        JB_eliminarLista.setText("Eliminar lista de canciones");
        JB_eliminarLista.setBorderPainted(false);
        JB_eliminarLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_eliminarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_eliminarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_cancionesLayout = new javax.swing.GroupLayout(JP_canciones);
        JP_canciones.setLayout(JP_cancionesLayout);
        JP_cancionesLayout.setHorizontalGroup(
            JP_cancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_cancionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JB_añadirCancion)
                .addGap(307, 307, 307))
            .addGroup(JP_cancionesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(JP_cancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_cancionesLayout.createSequentialGroup()
                        .addGroup(JP_cancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JB_eliminarCancion)
                            .addComponent(JB_eliminarLista))
                        .addGap(135, 135, 135)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_cancionesLayout.createSequentialGroup()
                        .addComponent(JL_tituloCanciones)
                        .addGap(45, 45, 45)
                        .addComponent(JB_buscarCancion)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_BuscaCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        JP_cancionesLayout.setVerticalGroup(
            JP_cancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_cancionesLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(JP_cancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_cancionesLayout.createSequentialGroup()
                        .addComponent(JL_tituloCanciones)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_cancionesLayout.createSequentialGroup()
                        .addGroup(JP_cancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTF_BuscaCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_buscarCancion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JB_añadirCancion)
                        .addGap(6, 6, 6)))
                .addGroup(JP_cancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JP_cancionesLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(JB_eliminarCancion)
                        .addGap(18, 18, 18)
                        .addComponent(JB_eliminarLista)))
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("Canciones", JP_canciones);

        JP_canciones1.setBackground(new java.awt.Color(255, 255, 255));

        JT_tablaCancioArtista1.setModel(new javax.swing.table.DefaultTableModel(
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
        JT_tablaCancioArtista1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(JT_tablaCancioArtista1);

        JL_tituloCanciones1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JL_tituloCanciones1.setText("Biblioteca");

        JB_añadirPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SymbolsAddSuma.png"))); // NOI18N
        JB_añadirPlaylist.setText("Añadir ");
        JB_añadirPlaylist.setBorderPainted(false);
        JB_añadirPlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_añadirPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_añadirPlaylistActionPerformed(evt);
            }
        });

        JCB_playList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "favoritas", "despecho" }));
        JCB_playList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_playListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_canciones1Layout = new javax.swing.GroupLayout(JP_canciones1);
        JP_canciones1.setLayout(JP_canciones1Layout);
        JP_canciones1Layout.setHorizontalGroup(
            JP_canciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_canciones1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(JP_canciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JP_canciones1Layout.createSequentialGroup()
                        .addGroup(JP_canciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JCB_playList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JL_tituloCanciones1))
                        .addGap(482, 482, 482)
                        .addComponent(JB_añadirPlaylist)
                        .addGap(27, 27, 27)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        JP_canciones1Layout.setVerticalGroup(
            JP_canciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_canciones1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(JP_canciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_canciones1Layout.createSequentialGroup()
                        .addComponent(JL_tituloCanciones1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_canciones1Layout.createSequentialGroup()
                        .addComponent(JB_añadirPlaylist)
                        .addGap(1, 1, 1)))
                .addComponent(JCB_playList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout JP_bibliotecaLayout = new javax.swing.GroupLayout(JP_biblioteca);
        JP_biblioteca.setLayout(JP_bibliotecaLayout);
        JP_bibliotecaLayout.setHorizontalGroup(
            JP_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1021, Short.MAX_VALUE)
            .addGroup(JP_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JP_bibliotecaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JP_canciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        JP_bibliotecaLayout.setVerticalGroup(
            JP_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
            .addGroup(JP_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JP_bibliotecaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JP_canciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Biblioteca", JP_biblioteca);

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

    private void JB_pausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_pausaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_pausaActionPerformed

    private void JB_eliminarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_eliminarListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_eliminarListaActionPerformed

    private void JB_añadirPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_añadirPlaylistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_añadirPlaylistActionPerformed

    private void JCB_playListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_playListActionPerformed
        verContenidoTxtPlaylist();
    }//GEN-LAST:event_JCB_playListActionPerformed

    private void JB_aleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_aleatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_aleatorioActionPerformed

    public void verContenidoTxtPlaylist() {
        DefaultTableModel model = (DefaultTableModel) JT_tablaCancioArtista1.getModel();
        model.setRowCount(0);

        String nombrePlaylist = getNombrePlaylistSeleccionada().toLowerCase().replace(" ", "_").replace("ñ", "n");
        String filePath = "src/main/resources/" + nombrePlaylist + ".txt";

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 3) {
                    String artista = datos[0];
                    String titulo = datos[1];
                    String ruta = datos[2];
                    model.addRow(new Object[]{titulo, artista, ruta});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public String getNombrePlaylistSeleccionada() {
        return JCB_playList.getSelectedItem().toString();
    }

    public String getArtistaCancion(Mp3File mp3file) {
        if (mp3file.hasId3v1Tag()) {
            return mp3file.getId3v1Tag().getArtist();
        } else if (mp3file.hasId3v2Tag()) {
            return mp3file.getId3v2Tag().getArtist();
        }
        return "Artista desconocido";
    }

    public String getTituloCancion(Mp3File mp3file) {
        if (mp3file.hasId3v1Tag()) {
            return mp3file.getId3v1Tag().getTitle();
        } else if (mp3file.hasId3v2Tag()) {
            return mp3file.getId3v2Tag().getTitle();
        }
        return "Titulo desconocido";
    }

    public String getRutaCancion(File archivoMp3Actual) {
        return archivoMp3Actual.getAbsolutePath();
    }
    //metodos para enviar todo al controlador
    /**
     * metodo que retorna la cancion a buscar con String para usurla en el
     * controlador
     *
     * @return el dato que esta en el JTF_buscarCancion
     */
    public String pedirCancionString() {
        return JTF_BuscaCanciones.getText();
    }

    /**
     * devuelve un arreglo de String que contiene el nombre y el artista de la
     * cancion seleccionada retorna null si no se selecciono nada
     *
     * @return
     */
    public String[] getCancionSeleccionadaTabla() {
        int filaSeleccionada = JT_tablaCancioArtista.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) JT_tablaCancioArtista.getModel();
            String titulo = (String) model.getValueAt(filaSeleccionada, 0);
            String artista = (String) model.getValueAt(filaSeleccionada, 1);
            return new String[]{titulo, artista};

        }
        this.mostrartraMensaje("Seleccione una fila para ejecutar la acción.");
        return null;
    }

    /**
     * retorna el id de la cancion guardad en el archivo txt canciones
     *
     * @param titulo
     * @param artista
     * @return
     */
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

    public int getIdCancion(String[] contenidoFila) {
        if (contenidoFila != null) {
            return getIdCancionTxt(contenidoFila[0], contenidoFila[1]);
        }
        return -1;
    }

    public String getNombreCancionABuscar() {
        return JTF_BuscaCanciones.getText().trim();
    }

    //metodo para agregar el nombre y el autor a la table
    /**
     * Metodo para mostra notificaciones de errores como por ejemplo dato no
     * valido
     *
     * @param error String
     */
    public void mostrartraMensaje(String error) {
        JOptionPane.showMessageDialog(this, error, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Metodo que retorna las interacciones con los botones y le asigna un
     * comando exclusivo a cada uno para que puedan se utillizados por ejemplo
     * en el controlador
     *
     * play siguiete anterior eliminar añadir buscar
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

        JB_eliminarCancion.setActionCommand("eliminar");
        JB_eliminarCancion.addActionListener(listener);

        JB_añadirCancion.setActionCommand("anadir");
        JB_añadirCancion.addActionListener(listener);
        
        JB_añadirPlaylist.setActionCommand("anadirPlayList");
        JB_añadirPlaylist.addActionListener(listener);

        JB_buscarCancion.setActionCommand("buscar");
        JB_buscarCancion.addActionListener(listener);
        
        JB_pausa.setActionCommand("pausa");
        JB_pausa.addActionListener(listener);
        
        JB_eliminarLista.setActionCommand("eliminar lista cancion");
        JB_eliminarLista.addActionListener(listener);
    }

    public void addAbrirArchivoListener(ActionListener listener) {
        JB_añadirCancion.addActionListener(listener);
    }

    /**
     * Metodo que permite abrir el archivo mp3 solamente
     *
     * @return archivo seleccionado
     */
    public File[] abrirArchivoMp3() {
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivo mp3", "mp3"));
        archivo.setMultiSelectionEnabled(true);
        int resultado = archivo.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            return archivo.getSelectedFiles();
        }
        return null;
    }

    /**
     * metodo que permite ver el contenido de el archivo txt en la tabla
     */
    public void verContenidoTxt() {
        DefaultTableModel model = (DefaultTableModel) JT_tablaCancioArtista.getModel();
        model.setRowCount(0);

        try (BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/canciones.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 3) {
                    String nombre = datos[1];
                    String artista = datos[2];
                    model.addRow(new Object[]{nombre, artista});

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public JSlider getSlider(){
        return JL_progresoMusica;
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
    private javax.swing.JButton JB_aleatorio;
    private javax.swing.JButton JB_anterior;
    private javax.swing.JButton JB_añadirCancion;
    private javax.swing.JButton JB_añadirPlaylist;
    private javax.swing.JButton JB_buscarCancion;
    private javax.swing.JButton JB_eliminarCancion;
    private javax.swing.JButton JB_eliminarLista;
    private javax.swing.JButton JB_pausa;
    private javax.swing.JButton JB_play;
    private javax.swing.JButton JB_siguiente;
    private javax.swing.JComboBox<String> JCB_playList;
    private javax.swing.JSlider JL_progresoMusica;
    private javax.swing.JLabel JL_tituloCanciones;
    private javax.swing.JLabel JL_tituloCanciones1;
    private javax.swing.JPanel JP_biblioteca;
    private javax.swing.JPanel JP_canciones;
    private javax.swing.JPanel JP_canciones1;
    private javax.swing.JTextField JTF_BuscaCanciones;
    private javax.swing.JTable JT_tablaCancioArtista;
    private javax.swing.JTable JT_tablaCancioArtista1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
