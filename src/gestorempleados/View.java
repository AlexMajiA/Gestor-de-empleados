/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestorempleados;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author amjpa
 */
public class View extends javax.swing.JFrame {

    EmployeeManagement EM;
    
    public View() {
        EM = new EmployeeManagement();
        initComponents();
    }

    public JTextField getTf_salary() {
        return Tf_salary;
    }
    
    Employee employee = new Employee();

    //Método para limpiar campos.
    public void clearFields() {
        Tf_name.setText("");
        Tf_department.setText("");
        Tf_salary.setText("");
        Tf_code.setText("");
    }
    //Método para limpiar el TextArea.
    public void clearTextArea(){
        Ta_txtArea.setText("");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Bt_hire = new javax.swing.JButton();
        Bt_dismiss = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ta_txtArea = new javax.swing.JTextArea();
        Tf_name = new javax.swing.JTextField();
        Tf_department = new javax.swing.JTextField();
        Tf_salary = new javax.swing.JTextField();
        Bt_exist = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Bt_order = new javax.swing.JButton();
        Bt_consult = new javax.swing.JButton();
        Cbox_order = new javax.swing.JComboBox<>();
        Lb_error = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Tf_code = new javax.swing.JTextField();
        Bt_clean = new javax.swing.JButton();
        Bt_cleanFields = new javax.swing.JButton();
        Bt_search = new javax.swing.JButton();
        Bt_modify = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Gestor de empleados");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre empleado:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Departamento:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Salario:");

        Bt_hire.setText("Contratar");
        Bt_hire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_hireActionPerformed(evt);
            }
        });

        Bt_dismiss.setText("Despedir");
        Bt_dismiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_dismissActionPerformed(evt);
            }
        });

        Ta_txtArea.setColumns(20);
        Ta_txtArea.setRows(5);
        jScrollPane1.setViewportView(Ta_txtArea);

        Bt_exist.setText("Salir");
        Bt_exist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_existActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Ordenar por:");

        Bt_order.setText("Ordenar");
        Bt_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_orderActionPerformed(evt);
            }
        });

        Bt_consult.setText("Consultar");
        Bt_consult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_consultActionPerformed(evt);
            }
        });

        Cbox_order.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Salario", "Departamento" }));
        Cbox_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbox_orderActionPerformed(evt);
            }
        });

        Lb_error.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Código Empleado:");

        Bt_clean.setText("Limpiar");
        Bt_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_cleanActionPerformed(evt);
            }
        });

        Bt_cleanFields.setText("Limpiar");
        Bt_cleanFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_cleanFieldsActionPerformed(evt);
            }
        });

        Bt_search.setText("Buscar");
        Bt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_searchActionPerformed(evt);
            }
        });

        Bt_modify.setText("Modificar");
        Bt_modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_modifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lb_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Bt_consult)
                                .addGap(39, 39, 39)
                                .addComponent(Bt_clean))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tf_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Tf_code, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Bt_cleanFields))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Tf_department, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Bt_search)
                                        .addGap(31, 31, 31)
                                        .addComponent(Bt_hire)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Bt_modify)
                                    .addComponent(Cbox_order, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(Bt_order))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(Bt_dismiss))))
                            .addComponent(Bt_exist))
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Tf_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bt_cleanFields))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tf_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Tf_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(Lb_error)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Bt_hire)
                            .addComponent(Bt_dismiss)
                            .addComponent(Bt_search)
                            .addComponent(Bt_modify))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Cbox_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bt_order))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Bt_consult)
                            .addComponent(Bt_exist)
                            .addComponent(Bt_clean))
                        .addGap(50, 50, 50))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Cbox_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbox_orderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbox_orderActionPerformed

    private void Bt_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_orderActionPerformed

        try {
            //Obtengo la opción seleccionada del ComboBox
            String order = Cbox_order.getSelectedItem().toString();

            //Llamo al método pasándole el valor seleccionado
            Ta_txtArea.setText(EM.orderCode(order));
            
            //Limpio el campo de errores.
            Lb_error.setText("");
        } catch (SQLException ex) {
            Ta_txtArea.setText("Error al ordenar empleados: " + ex.getMessage());
        }


    }//GEN-LAST:event_Bt_orderActionPerformed

    private void Bt_hireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_hireActionPerformed

        //Obtengo los valores de los JTextFields de tipo String
        int code = 0;
        String name = Tf_name.getText();
        String department = Tf_department.getText();
        double salary = 0.0;

        //Valido que los campos no estén vacíos, en caso contrario muestro el error.
        if (name.isEmpty() || department.isEmpty()) {
            Lb_error.setText("Error: No puedes dejar campos vacíos.");
            return;
        }

        try {
            //Convierto los datos obtenidos en los tipos correctos.
            salary = Double.parseDouble(Tf_salary.getText());
            code = Integer.parseInt(Tf_code.getText());

            //Una vez que obtengo los campos, compruebo que no sean cero y ni estén vacíos.
            if (code <= 0) {
                Lb_error.setText("Error: Código no puede ser 0 o estár vacío.");
                return;
            }

            if (salary <= 0) {
                Lb_error.setText("Error: Salario no puede ser 0 o estár vacío.");
                return;
            }

        } catch (NumberFormatException e) {
            Lb_error.setText("Error: Salario y Código no pueden estar vacíos y deben ser números válidos.");
            return;
        }

        //Guardo en una variable, los valores que devuelve el método.
        String result = EM.newEmployee(code, name, salary, department);

        if (result != null && !result.isEmpty()) {
            // Limpiar los campos de entrada solo si la operación fue exitosa
            clearFields();
            Lb_error.setText("Empleado agregado correctamente");
        }

    }//GEN-LAST:event_Bt_hireActionPerformed

    private void Bt_dismissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_dismissActionPerformed
        // Obtengo el valor del código del empleado a despedir.
        String code = Tf_code.getText();

        //Compruebo que el código sea válido.
        if (code.trim().isEmpty()) {
            Lb_error.setText("El código no puede ser cero ni estar vacío.");
            return;
        }

        //Declaro variable.
        int newCode; 
        
        try {
            //Obtengo el valor introducido.
            newCode = Integer.parseInt(code);

            //Validación de que el codigo sea válido.
            if (newCode <= 0) {
                Lb_error.setText("el código debe ser mayor que cero.");
                return;
            }

        } catch (NumberFormatException e) {
            Lb_error.setText("Error: El código debe ser un número entero válido.");
            return;
            
        }
        
        //Declaro variable y la instancio a null por estar fuera del Try.
        String result = null;
        try {
            result = EM.dissmisEmployee(newCode);
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Verifico si es nulo o está vacío.
        if (result != null && !result.isEmpty()) {
            clearFields();
             Lb_error.setText("Empleado despedido correctamente");
        }
    }//GEN-LAST:event_Bt_dismissActionPerformed

    private void Bt_consultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_consultActionPerformed
        
        try {
            //Llamada al método de listar para obtener una lista de los empleados por textArea.
            Ta_txtArea.setText(EM.list());
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
            Lb_error.setText("No se ha podido realizar la consulta.");
        }
        
        
    }//GEN-LAST:event_Bt_consultActionPerformed

    private void Bt_existActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_existActionPerformed
        
        //Llamada al método salir para cerrar la ventana. 
        EM.salir();
    }//GEN-LAST:event_Bt_existActionPerformed

    private void Bt_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_cleanActionPerformed
        
        // Limpiador del textArea
        clearTextArea();
        Lb_error.setText("");
    }//GEN-LAST:event_Bt_cleanActionPerformed

    private void Bt_cleanFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_cleanFieldsActionPerformed
       
        // Limpiador de campos.
        clearFields();
        Lb_error.setText("");
    }//GEN-LAST:event_Bt_cleanFieldsActionPerformed

    private void Bt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_searchActionPerformed
        
        //Obtengo el valor del código.
        String code = Tf_code.getText();
        
        if (!code.isBlank()) {
            EM.searchEmployee(code);
            Ta_txtArea.setText(EM.searchEmployee(code));
            Lb_error.setText("");
        }else {
            Lb_error.setText("Debes introducir un número en código.");
           return; 
        }
        
    }//GEN-LAST:event_Bt_searchActionPerformed

    private void Bt_modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_modifyActionPerformed
        
    //Obtengo el valor del código.
    String code = Tf_code.getText();
    
        if (!code.isBlank()) {
            
            String name = Tf_name.getText();
            Double salary = Double.parseDouble(Tf_salary.getText());
            String department = Tf_department.getText();
            
            
            String result = EM.modifyEmployees(Integer.parseInt(code), name, salary, department);
            Ta_txtArea.setText(result);
        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_Bt_modifyActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
        
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bt_clean;
    private javax.swing.JButton Bt_cleanFields;
    private javax.swing.JButton Bt_consult;
    private javax.swing.JButton Bt_dismiss;
    private javax.swing.JButton Bt_exist;
    private javax.swing.JButton Bt_hire;
    private javax.swing.JButton Bt_modify;
    private javax.swing.JButton Bt_order;
    private javax.swing.JButton Bt_search;
    private javax.swing.JComboBox<String> Cbox_order;
    private javax.swing.JLabel Lb_error;
    private javax.swing.JTextArea Ta_txtArea;
    private javax.swing.JTextField Tf_code;
    private javax.swing.JTextField Tf_department;
    private javax.swing.JTextField Tf_name;
    private javax.swing.JTextField Tf_salary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
