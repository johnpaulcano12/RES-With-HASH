/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import config.db_configuration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableModel;
import static myapp.viewPage.displayPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mark
 */
public final class puroksTbl extends javax.swing.JInternalFrame {
db_configuration db,db1;
PreparedStatement pst,pst1;

public Connection connerction;

ResultSet rst , rst1;
int res_id[],id;
    /**
     * Creates new form dolphinList
     * @throws java.sql.SQLException
     */
    public puroksTbl() throws SQLException {
         db = new db_configuration();
        db1 = new db_configuration();
        res_id = new int[10]; 
        fillRES();
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    public void fillRES() throws SQLException{
            try{
              int index1=0;
   pst1 =db1.connection.prepareStatement("Select res_id,res_id FROM tbl_residents");
 
                try (ResultSet rst1 = pst1.executeQuery()) {
                    while(rst1.next())
                    {
                        res_id[index1]=rst1.getInt(1);
                        index1++;
                        cb_res.addItem(rst1.getString(1));
                    }      }
       }catch(SQLException e){
           System.out.println(""+e);
       }
          //      db1.connection.close();
        }
     public void fillPurok() throws SQLException{
        
    db_configuration dbc = new db_configuration();
    ResultSet rs = dbc.getData("SELECT*FROM puroks_tbl");
    puroksTbl pt = new puroksTbl();
    displayPane.add(pt).setVisible(true);
    puroksTbl.ptbl.setModel(DbUtils.resultSetToTableModel(rs));
    }
     
     public void displayData(){
       
        try{
       
            db_configuration dbc = new db_configuration();
            ResultSet rs = dbc.getData("SELECT * FROM puroks_tbl");
            ptbl.setModel(DbUtils.resultSetToTableModel(rs));
       
        }catch(SQLException ex){
            System.out.println("Error Message: "+ex);
       
        }
      }
      int validateRegister(){
        int result;
    if( j1.getText().isEmpty() || j3.getText().isEmpty() || cb_res.getSelectedItem().equals("Resident ID")){
            Object message = "All fields are required";
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    result = 0;
    }else{
            result =1;
            }
   
    return result;
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ptbl = new javax.swing.JTable();
        jla1 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        j1 = new javax.swing.JTextField();
        jla3 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        j3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cb_res = new javax.swing.JComboBox<>();

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(null);

        jScrollPane2.setViewportView(ptbl);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 80, 600, 200);

        jla1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jla1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.add(jla1);
        jla1.setBounds(40, 300, 180, 20);

        l1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        l1.setForeground(new java.awt.Color(153, 153, 153));
        l1.setText(" Purok Name");
        jPanel2.add(l1);
        l1.setBounds(40, 310, 180, 20);

        j1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j1MouseClicked(evt);
            }
        });
        jPanel2.add(j1);
        j1.setBounds(40, 300, 250, 40);

        jla3.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jla3.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.add(jla3);
        jla3.setBounds(40, 360, 160, 20);

        l3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        l3.setForeground(new java.awt.Color(153, 153, 153));
        l3.setText(" Purok Description");
        jPanel2.add(l3);
        l3.setBounds(40, 370, 190, 20);

        j3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                j3MouseEntered(evt);
            }
        });
        j3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j3ActionPerformed(evt);
            }
        });
        j3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                j3KeyPressed(evt);
            }
        });
        jPanel2.add(j3);
        j3.setBounds(40, 360, 250, 40);

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jButton3.setText("Save");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(330, 360, 250, 40);

        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        jButton1.setText("Delete");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(490, 30, 120, 40);

        jButton2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        jButton2.setText("Edit");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        jPanel2.add(jButton2);
        jButton2.setBounds(360, 30, 120, 40);

        cb_res.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        cb_res.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Resident ID", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", " " }));
        cb_res.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_resActionPerformed(evt);
            }
        });
        jPanel2.add(cb_res);
        cb_res.setBounds(330, 300, 250, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void j1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j1MouseClicked
       l1.setText("");
       jla1.setText("  Purok Name");
    }//GEN-LAST:event_j1MouseClicked

    private void j3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_j3MouseEntered

    private void j3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j3MouseClicked
         l3.setText("");
          jla3.setText("  Purok Description");
    }//GEN-LAST:event_j3MouseClicked

    private void j3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
          int check = validateRegister();
           
           if(check == 1){
        int rowindex = ptbl.getSelectedRow();
          TableModel model = ptbl.getModel();
          db_configuration dbc = new db_configuration();
          dbc.insertData("INSERT INTO puroks_tbl(purok_name, purok_desc ,res_id)VALUES"
                + "('"+j1.getText()+"','"+j3.getText()+ "','"
                +cb_res.getSelectedItem().toString()+"')");
       // + "res_id = '"+model.getValueAt(rowindex, 0)+"'");
      
       j1.setText("");
       j3.setText("");
       jla1.setText("");
       jla3.setText("");
       l1.setText("  Purok Name");
       l3.setText("  Purok Description");
       cb_res.setSelectedIndex(0);
     
        
      
         try{
            fillPurok();
        }catch(SQLException e)
        {
            System.out.println("Error is: "+e);
        }  JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY");
           }else{
               System.out.println("Saving data failed!");
           }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void j3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_j3KeyPressed
        l3.setText("");
          jla3.setText("  Purok Description");
    }//GEN-LAST:event_j3KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rowIndex = ptbl.getSelectedRow();
        if(rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select data first from the table!");
        }else{
            TableModel model = ptbl.getModel(); 
            Object value = model.getValueAt(rowIndex, 0);
            String id = value.toString();
            int a=JOptionPane.showConfirmDialog(null,"Are you sure to delete ID: " +id+" ?");
            if(a==JOptionPane.YES_OPTION){
                db_configuration db = new db_configuration();
                int r_id = Integer.parseInt(id);
                db.deletePurok(Integer.parseInt(id));
                
                displayData();
            }}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_resActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_resActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_resActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> cb_res;
    public static javax.swing.JTextField j1;
    public static javax.swing.JTextField j3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel jla1;
    public static javax.swing.JLabel jla3;
    public static javax.swing.JLabel l1;
    public static javax.swing.JLabel l3;
    public static javax.swing.JTable ptbl;
    // End of variables declaration//GEN-END:variables
}
