package Vista;

import Controlador.GestionCorredor;
import Modelo.Corredor;
import java.io.Serializable;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author Ainhoa
 */
public class CuestionarioAltaCorredor extends javax.swing.JDialog implements Serializable {

    /**
     * Creates new form CuestionarioAltaCorredor
     */
    private GestionCorredor gc;
    private Corredor corredorModificar;

    /* Para pasar de una pantalla a otra SOLO PUEDE HABER UN MAIN en la app, borramos el main del jdialog para que no de problemas.
     En este constructor se pasa como parametro la gestion corredor para no tener que volver a instanciar NUNCA MÁS a lo largo de la aplicación
     después, asignamos a lal instacia gc de arribla con this la clase que le pasamos como parametro y luego en la clase pantalla principal hay que programar
     el boton que pusimos en el jdialog, crear una instancia del jdialog y hacer setVisible(true) para que se vea la pantalla secundiaria (jdialog).
     */
    public CuestionarioAltaCorredor(java.awt.Dialog parent, boolean modal, GestionCorredor gc) {
        super(parent, modal);
        this.gc = gc;
        initComponents();
        jButtonEnviar.setEnabled(false);
        setLocationRelativeTo(null);
        validarFormulario();

    }

    public CuestionarioAltaCorredor(java.awt.Dialog parent, boolean modal, Corredor corredorModificar) {
        super(parent, modal);
        this.corredorModificar = corredorModificar;
        initComponents();
        jButtonEnviar.setEnabled(true);
        jTextFieldNombre.setText(this.corredorModificar.getNombre());
        jTextFieldApellidos.setText(this.corredorModificar.getApellido());
        jTextFieldDNI.setText(this.corredorModificar.getDni());
        jTextFieldDireccion.setText(this.corredorModificar.getDireccion());
        jTextFieldTel.setText(Integer.toString(this.corredorModificar.getTelefono()));
        jDateChooserFechaNac.setDate(this.corredorModificar.getfNac());
        validarFormulario();
    }

    public void validarFormulario() {
        ValidationGroup group = validationPanel.getValidationGroup();
        group.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldApellidos, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldDNI, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldDireccion, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldTel, StringValidators.REQUIRE_VALID_NUMBER, StringValidators.REQUIRE_NON_EMPTY_STRING);

        validationPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanel.getProblem() == null) {
                    jButtonEnviar.setEnabled(true);
                } else {
                    jButtonEnviar.setEnabled(false);
                }
            }
        });
    }

    private void limpiarPantalla() {
        jTextFieldNombre.setText("");
        jTextFieldApellidos.setText("");
        jTextFieldDNI.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldTel.setText("");
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
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelApellidos = new javax.swing.JLabel();
        validationPanel = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldDNI = new javax.swing.JTextField();
        jLabelDNI = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabelFechaNac = new javax.swing.JLabel();
        jLabelTel = new javax.swing.JLabel();
        jTextFieldTel = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jLabelAlta = new javax.swing.JLabel();
        jDateChooserFechaNac = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setForeground(new java.awt.Color(60, 63, 65));

        jLabelNombre.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabelNombre.setText("Nombre: ");

        jTextFieldNombre.setName("Nombre"); // NOI18N
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabelApellidos.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabelApellidos.setText("Apellidos: ");

        jTextFieldApellidos.setName("Apellidos"); // NOI18N
        jTextFieldApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidosActionPerformed(evt);
            }
        });

        jLabelDireccion.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabelDireccion.setText("Dirección: ");

        jTextFieldDNI.setName("DNI"); // NOI18N

        jLabelDNI.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabelDNI.setText("DNI: ");

        jTextFieldDireccion.setName("Dirección"); // NOI18N

        jLabelFechaNac.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabelFechaNac.setText("Fecha nac.: ");

        jLabelTel.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jLabelTel.setText("Teléfono: ");

        jTextFieldTel.setName("Teléfono"); // NOI18N

        jButtonEnviar.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButtonEnviar.setText("GUARDAR");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jButtonLimpiar.setText("LIMPIAR FORMULARIO");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jLabelAlta.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabelAlta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAlta.setText("ALTA CORREDOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelFechaNac)
                                    .addComponent(jLabelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooserFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonLimpiar)
                                        .addGap(79, 79, 79))))
                            .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelNombre)
                                        .addComponent(jLabelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(47, 47, 47)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(19, 19, 19)
                                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnviar)
                    .addComponent(jButtonLimpiar))
                .addGap(605, 605, 605))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        if (jDateChooserFechaNac.getDate() == null) {
            JOptionPane.showMessageDialog(this, "La fecha no puede estar vacía", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String nombre = jTextFieldNombre.getText();
            String apellidos = jTextFieldApellidos.getText();
            String dni = jTextFieldDNI.getText();
            String dir = jTextFieldDireccion.getText();
            String telf = jTextFieldTel.getText();
            Date fecha = jDateChooserFechaNac.getDate();

            if (corredorModificar == null) {
                gc.anadirCorredor(nombre, apellidos, dir, dni, fecha, Integer.parseInt(telf));
                JOptionPane.showMessageDialog(this, "Corredor dado de alta", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                corredorModificar.setNombre(nombre);
                corredorModificar.setApellido(apellidos);
                corredorModificar.setDni(dni);
                corredorModificar.setDireccion(dir);
                corredorModificar.setTelefono(Integer.parseInt(telf));
                corredorModificar.setfNac(fecha);
            }

//de esta clase: "java.awt.Frame parent"     
            //pp.rellenarListaCorredores();
            limpiarPantalla();
            dispose(); //para cerrar la pantalla secundaria
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiarPantalla();
        JOptionPane.showMessageDialog(this, "No se ha dado de alta ningun corredor", "Limpiando...", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jTextFieldApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonLimpiar;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNac;
    private javax.swing.JLabel jLabelAlta;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFechaNac;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTel;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanel;
    // End of variables declaration//GEN-END:variables
}
