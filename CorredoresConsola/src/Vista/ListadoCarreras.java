package Vista;

import Controlador.GestionCarrera;
import Controlador.GestionCorredor;
import Modelo.Carrera;
import Modelo.CorredorCarrera;
import Modelo.MiTablaCarreras;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;
import org.openide.util.Exceptions;

/**
 *
 * @author Ainhoa
 */
public class ListadoCarreras extends javax.swing.JDialog implements Serializable {

    private GestionCarrera gc;
    private GestionCorredor gestionCorredor;

    public ListadoCarreras(java.awt.Frame parent, boolean modal, GestionCarrera gc, GestionCorredor gestionCorredor) {
        super(parent, modal);
        initComponents();
        this.gc = gc;
        this.gestionCorredor = gestionCorredor;
        ponerAyuda();
        setLocationRelativeTo(this);
        rellenarTablaCarreras();
    }

    public void rellenarTablaCarreras() {
        jTableCarreras.setModel(new MiTablaCarreras(gc.getListaCarreras()));
    }

    private void ponerAyuda() {
        try {
            File ficheroAyuda = new File("help" + File.separator + "help_set.hs");
            URL hsURL = ficheroAyuda.toURI().toURL();

            //Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            hb.enableHelpOnButton(jButtonAyuda, "ventanaCarreras", helpset);
            //Al pulsar F1 salta la ayuda
            hb.enableHelpKey(getRootPane(), "ventanaCarreras", helpset);

        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (HelpSetException ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCarreras = new javax.swing.JTable();
        jButtonAltaCarrera = new javax.swing.JButton();
        jButtonBorrarCarrera = new javax.swing.JButton();
        jButtonModificarCarrera = new javax.swing.JButton();
        jButtonAddCorredores = new javax.swing.JButton();
        jButtonIniciarCarrera = new javax.swing.JButton();
        jButtonAyuda = new javax.swing.JButton();
        jButtonClasificacion = new javax.swing.JButton();

        jButton1.setText(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jButton1.text")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jLabel1.text")); // NOI18N

        jTableCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCarreras);
        if (jTableCarreras.getColumnModel().getColumnCount() > 0) {
            jTableCarreras.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jTableCarreras.columnModel.title0")); // NOI18N
            jTableCarreras.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jTableCarreras.columnModel.title1")); // NOI18N
            jTableCarreras.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jTableCarreras.columnModel.title2")); // NOI18N
            jTableCarreras.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jTableCarreras.columnModel.title3")); // NOI18N
        }

        jButtonAltaCarrera.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButtonAltaCarrera.setText(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jButtonAltaCarrera.text")); // NOI18N
        jButtonAltaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaCarreraActionPerformed(evt);
            }
        });

        jButtonBorrarCarrera.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButtonBorrarCarrera.setText(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jButtonBorrarCarrera.text")); // NOI18N
        jButtonBorrarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarCarreraActionPerformed(evt);
            }
        });

        jButtonModificarCarrera.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButtonModificarCarrera.setText(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jButtonModificarCarrera.text")); // NOI18N
        jButtonModificarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarCarreraActionPerformed(evt);
            }
        });

        jButtonAddCorredores.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButtonAddCorredores.setText(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jButtonAddCorredores.text")); // NOI18N
        jButtonAddCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCorredoresActionPerformed(evt);
            }
        });

        jButtonIniciarCarrera.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButtonIniciarCarrera.setText(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jButtonIniciarCarrera.text")); // NOI18N
        jButtonIniciarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarCarreraActionPerformed(evt);
            }
        });

        jButtonAyuda.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jButtonAyuda.setText(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jButtonAyuda.text")); // NOI18N

        jButtonClasificacion.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButtonClasificacion.setText(org.openide.util.NbBundle.getMessage(ListadoCarreras.class, "ListadoCarreras.jButtonClasificacion.text")); // NOI18N
        jButtonClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClasificacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAyuda)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonModificarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBorrarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButtonIniciarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAyuda)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAltaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModificarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBorrarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonIniciarCarrera)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAltaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaCarreraActionPerformed
        CuestionarioAltaCarreras cuestionarioAltaCarrera = new CuestionarioAltaCarreras(this, true, gc);
        cuestionarioAltaCarrera.setVisible(true);
        rellenarTablaCarreras();

    }//GEN-LAST:event_jButtonAltaCarreraActionPerformed

    private void jButtonModificarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarCarreraActionPerformed
        int seleccionado = jTableCarreras.getSelectedRow(); //seleccionar con el ratón un int con la posicion del corredor en la lista de corredores.
        if (seleccionado == -1) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ninguna carrera.");
        } else {
            Carrera carreraModificar = gc.getListaCarreras().get(seleccionado);
            if (carreraModificar.isFinalizada()) {
                JOptionPane.showMessageDialog(this, "La carrera ya está finalizada, no puede modificarse.");
            } else {
                //carreraModificar = gc.getListaCarreras().get(seleccionado);
                CuestionarioAltaCarreras cuestionarioModificar = new CuestionarioAltaCarreras(this, true, carreraModificar);
                cuestionarioModificar.setLocationRelativeTo(null);
                cuestionarioModificar.setVisible(true);
                rellenarTablaCarreras();
            }
        }
    }//GEN-LAST:event_jButtonModificarCarreraActionPerformed

    private void jButtonAddCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCorredoresActionPerformed
        int seleccionado = jTableCarreras.convertRowIndexToModel(jTableCarreras.getSelectedRow());
        if (seleccionado == -1) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ninguna carrera para añadir corredores.");
        } else {
            Carrera carrera = gc.getListaCarreras().get(seleccionado);
            AddCorredoresCarrera corredoresCarrera = new AddCorredoresCarrera(this, true, gc, gestionCorredor, carrera);
            corredoresCarrera.rellenarTablaCorredoresInscritos();
            corredoresCarrera.setVisible(true);
        }
    }//GEN-LAST:event_jButtonAddCorredoresActionPerformed

    private void jButtonBorrarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarCarreraActionPerformed
        int seleccionada = jTableCarreras.getSelectedRow();
        if (seleccionada == -1) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ninguna carrera.");
        } else {
            Carrera carreraSeleccionada = gc.getListaCarreras().get(seleccionada);
            if (carreraSeleccionada.isFinalizada()) {
                JOptionPane.showMessageDialog(this, "La carrera ya está finalizada, no puede borrarse.");
            } else {
                int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea borrar la carrera?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
                if (respuesta != 1) {
                    gc.getListaCarreras().remove(carreraSeleccionada);
                    rellenarTablaCarreras();
                }
            }
        }
    }//GEN-LAST:event_jButtonBorrarCarreraActionPerformed

    private void jButtonIniciarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarCarreraActionPerformed
        int posicionCarreraSeleccionada = jTableCarreras.getSelectedRow();
        if (posicionCarreraSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ninguna carrera.");
        } else {
            Carrera carreraSeleccionada = gc.getListaCarreras().get(posicionCarreraSeleccionada);
            if (carreraSeleccionada.isFinalizada()) {
                JOptionPane.showMessageDialog(this, "Esta carrera ya ha finalizado.");
            } else {
                DialogoIniciarCarrera dialogoIniciarCarrera = new DialogoIniciarCarrera(this, true, gc, carreraSeleccionada);
                dialogoIniciarCarrera.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButtonIniciarCarreraActionPerformed

    private void jButtonClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClasificacionActionPerformed
        //tiene que escribir un csv
        int carreraSeleccionadaParaClasificacion = jTableCarreras.getSelectedRow();
        if (carreraSeleccionadaParaClasificacion == -1) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ninguna carrera.");
        } else {
            Carrera carreraClasificacion = gc.getListaCarreras().get(carreraSeleccionadaParaClasificacion);
            for (Iterator<CorredorCarrera> iterator = carreraClasificacion.getCorredoresCarrera().iterator(); iterator.hasNext();) {
                CorredorCarrera corredorCarrera = iterator.next();
                String tiempoModificar = corredorCarrera.getTiempo();
                String nuevoTiempo = tiempoModificar.replace(":", "");
                int tiempo = Integer.parseInt(nuevoTiempo);
                corredorCarrera.setTiempoParaClasificacion(tiempo);
            }

            Collections.sort(carreraClasificacion.getCorredoresCarrera());
            //aquí ya me devuelve la lista ordenada por orden de llegada.
            //ahora la escribo
            escribirCsvClasificación();
        }
    }//GEN-LAST:event_jButtonClasificacionActionPerformed

    public void escribirCsvClasificación() {
        int carreraSeleccionadaParaClasificacion = jTableCarreras.getSelectedRow();
        Carrera carreraClasificacion = gc.getListaCarreras().get(carreraSeleccionadaParaClasificacion);
        String outputFile = "clasificacion"+carreraClasificacion.getNombreCarrera()+".csv";
        boolean alreadyExists = new File(outputFile).exists();
        

        if (alreadyExists) {
            File ArchivoCorredores = new File(outputFile);
            ArchivoCorredores.delete();
        }

        try {

            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

            csvOutput.write(carreraClasificacion.getNombreCarrera());
             csvOutput.endRecord();
            csvOutput.write(carreraClasificacion.getFechaCarrera() + "\n");
            csvOutput.endRecord();

            for (CorredorCarrera corredor : carreraClasificacion.getCorredoresCarrera()) {

                csvOutput.write(Integer.toString(corredor.getDorsal()));
                csvOutput.write(corredor.getTiempo());
                csvOutput.write(corredor.getCorredor().getNombre());
                csvOutput.write(corredor.getCorredor().getApellido());
                csvOutput.endRecord();
            }

            csvOutput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddCorredores;
    private javax.swing.JButton jButtonAltaCarrera;
    private javax.swing.JButton jButtonAyuda;
    private javax.swing.JButton jButtonBorrarCarrera;
    private javax.swing.JButton jButtonClasificacion;
    private javax.swing.JButton jButtonIniciarCarrera;
    private javax.swing.JButton jButtonModificarCarrera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCarreras;
    // End of variables declaration//GEN-END:variables
}
