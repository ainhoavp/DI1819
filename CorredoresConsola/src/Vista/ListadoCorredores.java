package Vista;

import Controlador.GestionCorredor;
import Modelo.Corredor;
import Modelo.MiTablaCorredores;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;
import org.openide.util.Exceptions;

/**
 *
 * @author Ainhoa
 */
public class ListadoCorredores extends javax.swing.JDialog implements Serializable {

    /**
     * Creates new form ListadoCorredores
     */
    private GestionCorredor gestionCorredor;

    public ListadoCorredores(java.awt.Frame parent, boolean modal, GestionCorredor gc) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        this.gestionCorredor = gc;
        ponerAyuda();
        rellenarTablaCorredores();
    }

    public ListadoCorredores(java.awt.Dialog parent, boolean modal, GestionCorredor gestionCorredor) {
        super(parent, modal);
        initComponents();
        this.gestionCorredor = gestionCorredor;
        rellenarTablaCorredores();
    }

    private void ponerAyuda() {
        try {
            File ficheroAyuda = new File("help" + File.separator + "help_set.hs");
            URL hsURL = ficheroAyuda.toURI().toURL();

            //Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            hb.enableHelpOnButton(jButtonAyuda, "ventanaCorredores", helpset);
            //Al pulsar F1 salta la ayuda
            hb.enableHelpKey(getRootPane(), "ventanaCorredores", helpset);

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCorredores = new javax.swing.JTable();
        jButtonDardeAlta = new javax.swing.JButton();
        jButtonGuardarCorredores = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jLabelTituloListadoCorredores = new javax.swing.JLabel();
        jButtonAyuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableCorredores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableCorredores);

        jButtonDardeAlta.setText("<html><center>ALTA<br> CORREDOR</center></html>");
        jButtonDardeAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDardeAltaActionPerformed(evt);
            }
        });

        jButtonGuardarCorredores.setText("<html><center>GUARDAR <br>CORREDORES</center></html>");
        jButtonGuardarCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarCorredoresActionPerformed(evt);
            }
        });

        jButtonModificar.setText("<html><center>MODIFICAR<br>CORREDOR</center></html>");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonBorrar.setText("BORRAR");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButtonDardeAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardarCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGuardarCorredores)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonDardeAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelTituloListadoCorredores.setFont(new java.awt.Font("Calibri Light", 3, 36)); // NOI18N
        jLabelTituloListadoCorredores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloListadoCorredores.setText("LISTADO CORREDORES");

        jButtonAyuda.setText("AYUDA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTituloListadoCorredores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAyuda)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAyuda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTituloListadoCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDardeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDardeAltaActionPerformed
        CuestionarioAltaCorredor cuestionarioAlta = new CuestionarioAltaCorredor(this, true, gestionCorredor);
        cuestionarioAlta.setVisible(true);
        rellenarTablaCorredores();
    }//GEN-LAST:event_jButtonDardeAltaActionPerformed

    private void jButtonGuardarCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarCorredoresActionPerformed
        gestionCorredor.escribirCsvCorredores();
        JOptionPane.showMessageDialog(this, "Se han guardado los corredores", "Guardado", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonGuardarCorredoresActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        //tiene que llevar al jdialog de cuestionario de alta, cargar los datos del corredor y cuando le das a enviar
        //tienen que modificar la persona de la lista
        int seleccionado = jTableCorredores.getSelectedRow(); //seleccionar con el ratón un int con la posicion del corredor en la lista de corredores.
        Corredor corredorSeleccionado = gestionCorredor.getListaCorredores().get(seleccionado);
        CuestionarioAltaCorredor cuestionarioModificar = new CuestionarioAltaCorredor(this, true, corredorSeleccionado);
        cuestionarioModificar.setLocationRelativeTo(null);
        cuestionarioModificar.setVisible(true);
        rellenarTablaCorredores();


    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        //tienen que borrar la persona de la lista
        int seleccionado = jTableCorredores.getSelectedRow(); //seleccionar con el ratón un int con la posicion del corredor en la lista de corredores.
        Corredor corredorSeleccionado = gestionCorredor.getListaCorredores().remove(seleccionado);
        rellenarTablaCorredores();

    }//GEN-LAST:event_jButtonBorrarActionPerformed

    public void rellenarTablaCorredores() {
        jTableCorredores.setModel(new MiTablaCorredores(gestionCorredor.getListaCorredores()));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAyuda;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonDardeAlta;
    private javax.swing.JButton jButtonGuardarCorredores;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabelTituloListadoCorredores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCorredores;
    // End of variables declaration//GEN-END:variables
}
