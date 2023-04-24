    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import config.db_configuration;
import java.awt.BasicStroke;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableModel;
import myapp.residentForm;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mark
 */
public class resident extends javax.swing.JInternalFrame {

    /**
     * Creates new form dolphinList
     */
    public resident() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
     Color addb = new Color(255,204,204);
     Color addB = new Color(240,240,240);
     
     Color hover = new Color(102,102,255);
    Color defButton = new Color(69,193,255);
    
    Border empty = BorderFactory.createEmptyBorder();
    
    void buttonBorderAnimation(JPanel panel){
    panel.setBackground(hover);
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
    
    }
    
    void buttonDefaultColor(JPanel panel){
    panel.setBackground(defButton);
    panel.setBorder(empty);
    }
    
    public void displayData(){
       
        try{
       
            db_configuration dbc = new db_configuration();
            ResultSet rs = dbc.getData("SELECT * FROM tbl_residents");
            res_tbl.setModel(DbUtils.resultSetToTableModel(rs));
       
        }catch(SQLException ex){
            System.out.println("Error Message: "+ex);
       
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

        sex = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        res_tbl = new javax.swing.JTable();
        delete = new javax.swing.JPanel();
        jl3 = new javax.swing.JLabel();
        edit = new javax.swing.JPanel();
        jl2 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jl5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(null);

        res_tbl.setColumnSelectionAllowed(true);
        res_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                res_tblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(res_tbl);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(0, 60, 620, 470);

        delete.setBackground(new java.awt.Color(0, 153, 153));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jl3.setText(" DELETE");
        delete.add(jl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        jPanel2.add(delete);
        delete.setBounds(190, 20, 80, 30);

        edit.setBackground(new java.awt.Color(0, 153, 153));
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editMouseExited(evt);
            }
        });
        edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl2.setText("EDIT");
        edit.add(jl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 30));

        jPanel2.add(edit);
        edit.setBounds(100, 20, 80, 30);

        add.setBackground(new java.awt.Color(0, 153, 153));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.setLayout(null);

        jl5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl5.setText("ADD");
        add.add(jl5);
        jl5.setBounds(10, 0, 60, 30);

        jPanel2.add(add);
        add.setBounds(10, 20, 80, 30);

        jTextField1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        jPanel2.add(jTextField1);
        jTextField1.setBounds(340, 20, 160, 30);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        jButton1.setText("Search");
        jPanel2.add(jButton1);
        jButton1.setBounds(520, 20, 90, 30);

        jTextField2.setBackground(new java.awt.Color(153, 255, 255));
        jTextField2.setBorder(null);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(620, 10, 0, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, -10, 630, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setBackground(new Color(69,193,255));
        buttonDefaultColor(add);
    }//GEN-LAST:event_addMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setBackground(new Color(0,153,255));
        buttonBorderAnimation(add);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
          
      JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        mainFrame.dispose();
         residentForm rf = new  residentForm();      
     rf.setVisible(true);
     rf.action = "add";
     rf.jl5.setText("Save");
    }//GEN-LAST:event_addMouseClicked

    private void editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseExited
        edit.setBackground(new Color(69,193,255));
        buttonDefaultColor(edit);
    }//GEN-LAST:event_editMouseExited

    private void editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseEntered
        edit.setBackground(new Color(0,153,255));
        buttonBorderAnimation(edit);
    }//GEN-LAST:event_editMouseEntered

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
        residentForm rf = new residentForm();
        int rowindex = res_tbl.getSelectedRow();
        if(rowindex < 0){
            JOptionPane.showMessageDialog(null, "Please select a data first!");
        }else{
            rf.setVisible(true);
            TableModel model = res_tbl.getModel();
            residentForm.s_id.setText(""+model.getValueAt(rowindex, 0));
            residentForm.fname.setText(""+model.getValueAt(rowindex, 1));
            residentForm.lname.setText(""+model.getValueAt(rowindex, 2));
            residentForm.bdate.setText(""+model.getValueAt(rowindex, 3));
           
            String cb = model.getValueAt(rowindex, 5).toString();
            if(cb.contains("Single")){
            residentForm.status.setSelectedIndex(1);
            }else if(cb.contains("Married")){
                 residentForm.status.setSelectedIndex(2);
            }else if(cb.contains("Widow")){
                 residentForm.status.setSelectedIndex(3);
            }else{
                 residentForm.status.setSelectedIndex(4);
            }

            String rb = model.getValueAt(rowindex, 4).toString();
            switch(rb){
                case "Male":
                 residentForm.male.setSelected(true);
                break;
                default:
                 residentForm.female.setSelected(true);
                break;
            }

             residentForm.children.setText(""+model.getValueAt(rowindex, 6));
             residentForm.contact.setText(""+model.getValueAt(rowindex, 7));
             residentForm.email.setText(""+model.getValueAt(rowindex, 8));
           
             rf.action = "edit";
             rf.jl5.setText("Update");
             JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
             mainFrame.dispose();
             
             rf.setVisible(true);
        }
    }//GEN-LAST:event_editMouseClicked

    private void res_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_res_tblMouseClicked

    }//GEN-LAST:event_res_tblMouseClicked

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited

        buttonDefaultColor(delete);
    }//GEN-LAST:event_deleteMouseExited

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered

        buttonBorderAnimation(delete);
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked

        int rowIndex = res_tbl.getSelectedRow();
        if(rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select data first from the table!");
        }else{
            TableModel model = res_tbl.getModel();
            Object value = model.getValueAt(rowIndex, 0);
            String id = value.toString();
            int a=JOptionPane.showConfirmDialog(null,"Are you sure to delete ID: " +id+" ?");
            if(a==JOptionPane.YES_OPTION){
                db_configuration db = new db_configuration();
                int r_id = Integer.parseInt(id);
                db.deleteData(Integer.parseInt(id));

                displayData();

            }
        }
    }//GEN-LAST:event_deleteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel add;
    public static javax.swing.JPanel delete;
    public static javax.swing.JPanel edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public static javax.swing.JLabel jl2;
    public static javax.swing.JLabel jl3;
    public static javax.swing.JLabel jl5;
    public static javax.swing.JTable res_tbl;
    public static javax.swing.ButtonGroup sex;
    // End of variables declaration//GEN-END:variables
}