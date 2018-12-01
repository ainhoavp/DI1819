package Vista;

import Controlador.GestionCarrera;
import Controlador.GestionCorredor;
import Modelo.Carrera;
import Modelo.Corredor;
import Modelo.CorredorCarrera;
import Modelo.MiTablaCorredores;
import Modelo.MiTablaCorredoresCarrera;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ainhoa
 */
public class AddCorredoresCarrera extends javax.swing.JDialog implements Serializable {

    private GestionCarrera gc;
    private GestionCorredor gestionCorredor;
    private Carrera carreraSeleccionada;

    public AddCorredoresCarrera(java.awt.Dialog parent, boolean modal, GestionCarrera gc, GestionCorredor gestionCorredor, Carrera carreraSeleccionada) {
        super(parent, modal);
        this.gc = gc;
        this.gestionCorredor = gestionCorredor;
        this.carreraSeleccionada = carreraSeleccionada;
        initComponents();
        setLocationRelativeTo(this);
        rellenarTablaCorredoresDisponibles();
        // rellenarTablaCorredoresInscritos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCorredoresInscritos = new javax.swing.JTable();
        jButtonAddCorredores = new javax.swing.JButton();
        jButtonBorrarCorredores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCorredoresDisponibles = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(org.openide.util.NbBundle.getMessage(AddCorredoresCarrera.class, "AddCorredoresCarrera.jLabel1.text")); // NOI18N

        jTableCorredoresInscritos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableCorredoresInscritos);

        jButtonAddCorredores.setText(org.openide.util.NbBundle.getMessage(AddCorredoresCarrera.class, "AddCorredoresCarrera.jButtonAddCorredores.text")); // NOI18N
        jButtonAddCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCorredoresActionPerformed(evt);
            }
        });

        jButtonBorrarCorredores.setText(org.openide.util.NbBundle.getMessage(AddCorredoresCarrera.class, "AddCorredoresCarrera.jButtonBorrarCorredores.text")); // NOI18N
        jButtonBorrarCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarCorredoresActionPerformed(evt);
            }
        });

        jTableCorredoresDisponibles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableCorredoresDisponibles);
        if (jTableCorredoresDisponibles.getColumnModel().getColumnCount() > 0) {
            jTableCorredoresDisponibles.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(AddCorredoresCarrera.class, "AddCorredoresCarrera.jTableCorredoresDisponibles.columnModel.title0")); // NOI18N
            jTableCorredoresDisponibles.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(AddCorredoresCarrera.class, "AddCorredoresCarrera.jTableCorredoresDisponibles.columnModel.title1")); // NOI18N
            jTableCorredoresDisponibles.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(AddCorredoresCarrera.class, "AddCorredoresCarrera.jTableCorredoresDisponibles.columnModel.title2")); // NOI18N
            jTableCorredoresDisponibles.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(AddCorredoresCarrera.class, "AddCorredoresCarrera.jTableCorredoresDisponibles.columnModel.title3")); // NOI18N
        }

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(org.openide.util.NbBundle.getMessage(AddCorredoresCarrera.class, "AddCorredoresCarrera.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButtonAddCorredores)
                        .addGap(90, 90, 90)
                        .addComponent(jButtonBorrarCorredores)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddCorredores)
                    .addComponent(jButtonBorrarCorredores))
                .addGap(75, 75, 75))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCorredoresActionPerformed
        int selec = jTableCorredoresDisponibles.getSelectedRow(); //posicion en la que está el corredor en la tabla
        int dorsal = gc.generarDorsal(carreraSeleccionada);
        Corredor corredorSeleccionado = gestionCorredor.getListaCorredores().get(selec);
        CorredorCarrera corredorCarrera = new CorredorCarrera(corredorSeleccionado, dorsal);
        //comprobar antes de añadir el numero maximo de participantes de la carrera y si el corredor ya está en la carrera apuntado.
        if (carreraSeleccionada.getCorredoresCarrera().size() >= carreraSeleccionada.getNumeroParticipantes()) {
            JOptionPane.showMessageDialog(this, "Ya hay inscritos el número maximo de participantes.");
        } else {
            List<Corredor> listaCorredores = new ArrayList<>();
            for (CorredorCarrera corCar : carreraSeleccionada.getCorredoresCarrera()) {
                listaCorredores.add(corCar.getCorredor());
            }
            if (listaCorredores.contains(corredorSeleccionado)) {
                JOptionPane.showMessageDialog(this, "El corredor ya está inscrito en la carrera.");
            } else {
                carreraSeleccionada.getCorredoresCarrera().add(corredorCarrera);
            }
            rellenarTablaCorredoresInscritos();
        }
    }//GEN-LAST:event_jButtonAddCorredoresActionPerformed

    private void jButtonBorrarCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarCorredoresActionPerformed
         int selec = jTableCorredoresDisponibles.getSelectedRow();
         CorredorCarrera corredorCarreraSeleccionado = carreraSeleccionada.getCorredoresCarrera().get(selec);
         carreraSeleccionada.getCorredoresCarrera().remove(corredorCarreraSeleccionado);
         
         rellenarTablaCorredoresInscritos();
         
    }//GEN-LAST:event_jButtonBorrarCorredoresActionPerformed

    public void rellenarTablaCorredoresDisponibles() {
        jTableCorredoresDisponibles.setModel(new MiTablaCorredores(gestionCorredor.getListaCorredores()));
    }

    public void rellenarTablaCorredoresInscritos() {
        jTableCorredoresInscritos.setModel(new MiTablaCorredoresCarrera(carreraSeleccionada.getCorredoresCarrera()));
        // Mostrar: carreraSeleccionada.getCorredoresCarrera();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCorredores;
    private javax.swing.JButton jButtonBorrarCorredores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCorredoresDisponibles;
    private javax.swing.JTable jTableCorredoresInscritos;
    // End of variables declaration//GEN-END:variables
}