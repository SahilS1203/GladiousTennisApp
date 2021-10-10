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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author salga
 */
public class StudentDashboard extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public StudentDashboard() {
        String uname = "";
        String fname = "";
        String studentid="";
        String classid="";
        String amt="";
        
        try {
            
            initComponents();
            getContentPane().setBackground(new Color(220,20,60));
            DefaultTableModel tblModel = (DefaultTableModel)statsTable.getModel();
            tblModel.setRowCount(0);
            DefaultTableModel tblModel1 = (DefaultTableModel)classTable.getModel();
            tblModel1.setRowCount(0);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:"+Utility.dbport+"/tennis",Utility.dbusername,Utility.dbpassword);
            String query = "select username from logintracker order by logintrackerid DESC LIMIT 1";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                 uname = rs.getString("username");
            }
            
            String qry = "select * from student where username LIKE '%"+uname+"%'";
            PreparedStatement stm = con.prepareStatement(qry);
            ResultSet r = stm.executeQuery();
            if (r.next()){
                    fname = r.getString("fullname");
                    studentid= r.getString("studentid");
            }
            String sql = "select matchesplayed, wins, tournamentvictories from progress where studentid LIKE '%"+studentid+"%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            
            if (res.next()){
                String matchesplayed = res.getString("matchesplayed");
                String wins = res.getString("wins");
                String tournamentvictories = res.getString("tournamentvictories");
                String tbData[] = {matchesplayed, wins, tournamentvictories};
                tblModel.addRow(tbData);  
            }
            
            String q = "select classid from class_student where studentid LIKE '%"+studentid+"%'";
            PreparedStatement s = con.prepareStatement(q);
            ResultSet set = s.executeQuery();
            
            if (set.next()){
                classid=set.getString("classid");
            }
            
            String classdet = "select * from class where classid LIKE '%"+classid+"%'";
            PreparedStatement prep = con.prepareStatement(classdet);
            ResultSet result = prep.executeQuery();
            
            if (result.next()){
                String date = result.getString("date");
                String starttime = result.getString("starttime");
                String endtime = result.getString("endtime");
                String employeenamesearch = "select fullname from employee where employeeid LIKE '%"+result.getInt("employeeid")+"%'";
                PreparedStatement prepstatement = con.prepareStatement(employeenamesearch);
                ResultSet setr = prepstatement.executeQuery();
                if (setr.next()){
                    String dbasename=setr.getString("fullname").toString().trim();
                    String tbData1[] = {classid, dbasename, date, starttime, endtime};
                    tblModel1.addRow(tbData1);  
                }   
            }
            String feesearch = "select * from payment where studentid LIKE '%"+studentid+"%'";
            PreparedStatement stat = con.prepareStatement(feesearch);
            ResultSet resu = stat.executeQuery();
            if (resu.next()){
                int paidstatus = Integer.parseInt(resu.getString("paid"));
                if (paidstatus==1){
                    amt="0";
                }
                else{
                    amt = resu.getString("totalamount");
                }
                feeTxtField.setText(amt);
            }
            

                
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(StudentDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel3.setText("Welcome to your dashboard "+fname+"! Have a great day!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        viewCalendarBtn = new javax.swing.JButton();
        viewClassesBtn = new javax.swing.JButton();
        payFeesBtn = new javax.swing.JButton();
        viewProgressBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        statsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        feeTxtField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(220, 20, 60));
        setForeground(java.awt.Color.red);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gladioustennisapp/Webp.net-resizeimage (1).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("text");

        viewCalendarBtn.setBackground(new java.awt.Color(0, 0, 0));
        viewCalendarBtn.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        viewCalendarBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewCalendarBtn.setText("View Calendar");
        viewCalendarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCalendarBtnActionPerformed(evt);
            }
        });

        viewClassesBtn.setBackground(new java.awt.Color(0, 0, 0));
        viewClassesBtn.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        viewClassesBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewClassesBtn.setText("View Classes");
        viewClassesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewClassesBtnActionPerformed(evt);
            }
        });

        payFeesBtn.setBackground(new java.awt.Color(0, 0, 0));
        payFeesBtn.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        payFeesBtn.setForeground(new java.awt.Color(255, 255, 255));
        payFeesBtn.setText("Pay Fees");
        payFeesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payFeesBtnActionPerformed(evt);
            }
        });

        viewProgressBtn.setBackground(new java.awt.Color(0, 0, 0));
        viewProgressBtn.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        viewProgressBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewProgressBtn.setText("View Progress");
        viewProgressBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProgressBtnActionPerformed(evt);
            }
        });

        classTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Class ID", "Coach Name", "Date", "Start Time", "End Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(classTable);
        if (classTable.getColumnModel().getColumnCount() > 0) {
            classTable.getColumnModel().getColumn(0).setResizable(false);
            classTable.getColumnModel().getColumn(1).setResizable(false);
            classTable.getColumnModel().getColumn(2).setResizable(false);
            classTable.getColumnModel().getColumn(3).setResizable(false);
            classTable.getColumnModel().getColumn(4).setResizable(false);
        }

        statsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Matches Played", "Wins", "Tournament Wins"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(statsTable);
        if (statsTable.getColumnModel().getColumnCount() > 0) {
            statsTable.getColumnModel().getColumn(0).setResizable(false);
            statsTable.getColumnModel().getColumn(1).setResizable(false);
            statsTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("My Statistics");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fees Due");

        feeTxtField.setEditable(false);
        feeTxtField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Menu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("View");

        jMenuItem10.setText("Calendar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem11.setText("Classes");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuItem12.setText("Progress");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Pay Fees");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(283, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewProgressBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewCalendarBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewClassesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payFeesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(314, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(feeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(feeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewCalendarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewClassesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewProgressBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payFeesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewCalendarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCalendarBtnActionPerformed
     new ViewStudentSchedulesS().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_viewCalendarBtnActionPerformed

    private void viewClassesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewClassesBtnActionPerformed
     new ViewStudentClassesS().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_viewClassesBtnActionPerformed

    private void payFeesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payFeesBtnActionPerformed
     new PayFees().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_payFeesBtnActionPerformed

    private void viewProgressBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProgressBtnActionPerformed
     new ViewProgressS().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_viewProgressBtnActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     new Interface().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
     new ViewStudentSchedulesS().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
    new ViewStudentClassesS().setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
     new ViewProgressS().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
     new PayFees().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     new Interface().setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable classTable;
    private javax.swing.JTextField feeTxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton payFeesBtn;
    private javax.swing.JTable statsTable;
    private javax.swing.JButton viewCalendarBtn;
    private javax.swing.JButton viewClassesBtn;
    private javax.swing.JButton viewProgressBtn;
    // End of variables declaration//GEN-END:variables
}
