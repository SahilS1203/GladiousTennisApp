/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladioustennisapp;

import com.mydia.cs.Utility;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author salga
 */
public class ViewStudentClassesC extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public ViewStudentClassesC() {
        initComponents();
        getContentPane().setBackground(new Color(220,20,60));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        classesBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameTxtField1 = new javax.swing.JTextField();
        studentNameRdBtn = new javax.swing.JRadioButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        dateRdBtn = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(220, 20, 60));
        setForeground(java.awt.Color.red);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gladioustennisapp/Webp.net-resizeimage (1).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student Classes Data ");

        searchBtn.setBackground(new java.awt.Color(0, 0, 0));
        searchBtn.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        classesBtn.setBackground(new java.awt.Color(0, 0, 0));
        classesBtn.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        classesBtn.setForeground(new java.awt.Color(255, 255, 255));
        classesBtn.setText("Show all Classes");
        classesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classesBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(0, 0, 0));
        backBtn.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Search");

        nameTxtField1.setText("Enter Student Name...");
        nameTxtField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtField1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(studentNameRdBtn);

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        buttonGroup1.add(dateRdBtn);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class ID", "Student Name", "Date", "Start Time", "End Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(424, 424, 424)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(434, 434, 434)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(214, 214, 214)
                                    .addComponent(classesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(studentNameRdBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(dateRdBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(186, 186, 186))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addComponent(jLabel2)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateRdBtn)
                    .addComponent(studentNameRdBtn)
                    .addComponent(nameTxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(searchBtn)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(classesBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
        tblModel.setRowCount(0);
        String dbaseid="";
        String dbasename="";
        try
        {   
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+Utility.dbport+"/tennis",Utility.dbusername,Utility.dbpassword);
            
                if (studentNameRdBtn.isSelected()){
                String query = "select fullname, studentid from student where fullname LIKE '%"+nameTxtField1.getText()+"%'";
                PreparedStatement statement = con.prepareStatement(query);
                ResultSet result = statement.executeQuery();
                while (result.next()){
                    dbasename=result.getString("fullname");
                    dbaseid=result.getString("studentid");
                    
                   String qry = "select classid from class_student where studentid LIKE '%"+dbaseid+"%'";
                   PreparedStatement stat = con.prepareStatement(qry);
                   ResultSet res = stat.executeQuery();
                   while (res.next()){
                        String classid= res.getString("classid");
                   
                        String sql="select * from class where classid LIKE '%"+classid+"%'";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery(sql);
            
                   while (rs.next()){
                    String date = rs.getString("date");
                    String starttime = rs.getString("starttime");
                    String endtime = rs.getString("endtime");
                    String tbData[] = {classid, dbasename, date, starttime, endtime};
                    tblModel.addRow(tbData);  
                }
                }
   
            }
                }
                if (dateRdBtn.isSelected()){
                String dateString = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
                Statement st = con.createStatement();
                String sql="select * from class where date LIKE '%"+dateString+"%'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    String classid = String.valueOf(rs.getInt("classid"));
                    String date = rs.getString("date");
                    String starttime = rs.getString("starttime");
                    String endtime = rs.getString("endtime");
                    
                    String qry = "select studentid from class_student where classid LIKE '%"+classid+"%'";
                    PreparedStatement stat = con.prepareStatement(qry);
                    ResultSet res = stat.executeQuery();
                    while (res.next()){
                        String studentid= String.valueOf(res.getInt("studentid"));
                        String query = "select fullname from student where studentid LIKE '%"+studentid+"%'";
                        PreparedStatement statement = con.prepareStatement(query);
                        ResultSet result = statement.executeQuery();
                        while (result.next()){
                            dbasename=result.getString("fullname").toString().trim();
                    }
                            String tbData[] = {classid, dbasename, date, starttime, endtime};
                            tblModel.addRow(tbData);  
                }   
                }
            }
        
            con.close();
        }
        catch(SQLException se){
             se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();     
        } 
    }//GEN-LAST:event_searchBtnActionPerformed

    private void classesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classesBtnActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
        tblModel.setRowCount(0);
        String dbasename="";
        String names="";
        try
        {   
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+Utility.dbport+"/tennis",Utility.dbusername,Utility.dbpassword);
            Statement st = con.createStatement();
            String sql="select * from class";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                String classid = String.valueOf(rs.getInt("classid"));
                String date = rs.getString("date");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                
                String qry = "select studentid from class_student where classid LIKE '%"+classid+"%'";
                PreparedStatement stat = con.prepareStatement(qry);
                ResultSet res = stat.executeQuery();
                while (res.next()){
                String studentid= res.getString("studentid");
                String query = "select fullname from student where studentid LIKE '%"+studentid+"%'";
                PreparedStatement statement = con.prepareStatement(query);
                ResultSet result = statement.executeQuery();
                while (result.next()){
                    dbasename=result.getString("fullname").toString().trim();
                }   
                    String tbData[] = {classid, dbasename, date, starttime, endtime};
                    tblModel.addRow(tbData);  
                }
            }
            
            
            con.close();
        }
        catch(SQLException se){
             se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();     
        } 
    }//GEN-LAST:event_classesBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        try {
            new CoachDashboard().setVisible(true);
        } catch (MessagingException ex) {
            Logger.getLogger(ViewStudentClassesC.class.getName()).log(Level.SEVERE, null, ex);
        }
     this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_backBtnActionPerformed

    private void nameTxtField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtField1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewStudentClassesC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStudentClassesC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStudentClassesC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStudentClassesC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStudentClassesC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton classesBtn;
    private javax.swing.JRadioButton dateRdBtn;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameTxtField1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JRadioButton studentNameRdBtn;
    // End of variables declaration//GEN-END:variables
}
