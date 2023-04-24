/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import com.mysql.jdbc.Connection;
import config.db_configuration;
import java.awt.BasicStroke;
import java.awt.Color;
import java.sql.DriverManager;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;



/**
 *
 * @author Mark
 */
public class registerPage extends javax.swing.JFrame {
    private Connection con;

    /**
     * Creates new form registerPage
     */
    public registerPage() {
        initComponents();
    }
     Color exited = new Color(69,193,215);
      Color hover = new Color(239,124,239);
    Color defButton = new Color(124,111,207);
    
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
    int validateRegister(){
        int result;
    if(fname.getText().isEmpty() || lname.getText().isEmpty() || bdate.getText().isEmpty() 
            || email.getText().isEmpty() || uname.getText().isEmpty() || pword.getText().isEmpty() ){
            Object message = "All fields are required";
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    result = 0;
    }else{
            result =1;
            }
   
    return result;
    }
    
    public void registerPage (){
        
        String Fname = fname.getText();
        String Lname = lname.getText();
        String Bdate= bdate.getText();
        String Uname= uname.getText();
        String Pword = pword.getText();
        String Email = email.getText();
        String hasedpassword = BCrypt.hashpw(Pword, BCrypt.gensalt());
     
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/brgy_res", "root", "");
            String sql = "insert into tbl_users(u_fname,u_lname,u_bdate,u_username,u_password,u_email)values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, Fname);
        pst.setString(2, Lname);
        pst.setString(3, Bdate);
        pst.setString(4, Uname);
        pst.setString(5,hasedpassword );
        pst.setString(6, Email);
        
       int uprcount = pst.executeUpdate();
       if(uprcount >0){
       JOptionPane.showMessageDialog(this, "SIGN UP SUCCESSFULLY");
      loginForm in= new loginForm();
        in.setVisible(true);
        this. dispose();
        
       }else{
       JOptionPane.showMessageDialog(this, "SIGH UP FAILED");
             
       }
       
    } catch (Exception e) {
    e.printStackTrace();
    }  
    }
    
 public boolean validation (){
     String Fname = fname.getText();
     String Lname = lname.getText();
   String Uname = lname.getText();
   String Pword = lname.getText();
   String Email = email.getText();
         
     
     
    if (Fname.equals("") ){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR FIRST NAME");
 return false;
 }
 if(Lname.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR LAST NAME");
 return false;
 }
if(Uname.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER USERNAME");
 return false;
 }     
if(Pword.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR PASSWORD");
 return false;
 }    
if(Email.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR EMAIL");
 return false;
 }  
return true;
 }
        
 
   
    
     

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        bdate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        pword = new javax.swing.JTextField();
        regsiter = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        mmzPane = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        exitPane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(null);

        fname.setBackground(new java.awt.Color(0, 153, 153));
        fname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnameKeyTyped(evt);
            }
        });
        jPanel1.add(fname);
        fname.setBounds(420, 60, 240, 60);

        lname.setBackground(new java.awt.Color(0, 153, 153));
        lname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(lname);
        lname.setBounds(420, 120, 240, 60);

        bdate.setBackground(new java.awt.Color(0, 153, 153));
        bdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bdate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Birthdate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        bdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdateActionPerformed(evt);
            }
        });
        jPanel1.add(bdate);
        bdate.setBounds(420, 180, 240, 60);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REGISTRATION FORM");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(370, 24, 330, 30);

        uname.setBackground(new java.awt.Color(0, 153, 153));
        uname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        uname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uname.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(uname);
        uname.setBounds(420, 300, 240, 60);

        pword.setBackground(new java.awt.Color(0, 153, 153));
        pword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(pword);
        pword.setBounds(420, 360, 240, 60);

        regsiter.setBackground(new java.awt.Color(0, 153, 153));
        regsiter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regsiterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regsiterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regsiterMouseExited(evt);
            }
        });
        regsiter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("REGISTER");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        regsiter.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        jPanel1.add(regsiter);
        regsiter.setBounds(480, 430, 110, 30);

        mmzPane.setBackground(new java.awt.Color(0, 153, 153));
        mmzPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mmzPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mmzPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mmzPaneMouseExited(evt);
            }
        });
        mmzPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("—");
        mmzPane.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 20, 50));

        jPanel1.add(mmzPane);
        mmzPane.setBounds(640, 0, 30, 30);

        exitPane.setBackground(new java.awt.Color(0, 153, 153));
        exitPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitPaneMouseExited(evt);
            }
        });
        exitPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Corbel Light", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("  x");
        exitPane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel1.add(exitPane);
        exitPane.setBounds(670, 0, 30, 30);

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("REGISTRATION FORM");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(390, -10, 300, 100);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/bglogo.png"))); // NOI18N
        jLabel13.setText("jLabel10");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(0, -30, 370, 550);

        email.setBackground(new java.awt.Color(0, 153, 153));
        email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(420, 240, 240, 60);

        jTextField1.setBackground(new java.awt.Color(69, 193, 215));
        jTextField1.setBorder(null);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(10, 10, 0, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regsiterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regsiterMouseExited
         regsiter.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_regsiterMouseExited

    private void regsiterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regsiterMouseEntered
        regsiter.setBackground(new Color (69,193,215));
    }//GEN-LAST:event_regsiterMouseEntered

    private void regsiterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regsiterMouseClicked
      
        if (validation()==true){
            registerPage();
        }
            
        
        
    }//GEN-LAST:event_regsiterMouseClicked

    private void bdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdateActionPerformed

    private void mmzPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mmzPaneMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_mmzPaneMouseClicked

    private void mmzPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mmzPaneMouseEntered
        mmzPane.setBackground(new Color(69,193,215));
    }//GEN-LAST:event_mmzPaneMouseEntered

    private void mmzPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mmzPaneMouseExited
        mmzPane.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_mmzPaneMouseExited

    private void exitPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPaneMouseClicked
       loginForm lf = new loginForm();
       lf.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_exitPaneMouseClicked

    private void exitPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPaneMouseEntered
        exitPane.setBackground(new Color(204,0,51));
    }//GEN-LAST:event_exitPaneMouseEntered

    private void exitPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPaneMouseExited
        exitPane.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_exitPaneMouseExited

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        
    }//GEN-LAST:event_jPanel1MouseClicked

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void fnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyTyped
           char c=evt.getKeyChar();
           if (Character.isDigit(c)){
           fname.setEditable(false);
           JOptionPane.showMessageDialog(this, "Please Enter Letters Only");
           }else{
               fname.setEditable(true);
           }
         
           
           
           
                   
    }//GEN-LAST:event_fnameKeyTyped

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
            java.util.logging.Logger.getLogger(registerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bdate;
    private javax.swing.JTextField email;
    private javax.swing.JPanel exitPane;
    public static javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lname;
    private javax.swing.JPanel mmzPane;
    private javax.swing.JTextField pword;
    public static javax.swing.JPanel regsiter;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
