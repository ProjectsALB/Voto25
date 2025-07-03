package voting.management;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Dispalyvoterlist extends javax.swing.JFrame {
    // Color constants based on the specification
    private static final Color LIGHT_GOLD_BEIGE = new Color(210, 180, 140); // Light Gold/Beige
    private static final Color LIGHT_GREY = new Color(200, 200, 200); // Light Grey
    private static final Color DARK_GREY = new Color(100, 100, 100); // Dark Grey
    private static final Color VERY_DARK_GREY = new Color(30, 30, 30); // Black/Very Dark Grey
    private static final Color WHITE = Color.WHITE;

    public final Map<String, Addvoter.Voter> votersMap = Addvoter.votersMap; 

    public Dispalyvoterlist() {
        initComponents();
        this.setLocationRelativeTo(null);
        showVoters();
        setLocationRelativeTo(null);
    }

    private ArrayList<Addvoter.Voter> getVoterList() {
        return new ArrayList<>(votersMap.values());
    }

    private void showVoters() {
        ArrayList<Addvoter.Voter> list = getVoterList();
        DefaultTableModel model = (DefaultTableModel) jtableaddvoter.getModel();
        model.setRowCount(0);
        
        for (Addvoter.Voter voter : list) {
            Object[] row = {
                voter.getVoterId(),
                voter.getPassword(),
                voter.getName(),
                voter.getFatherName(),
                voter.getAddress(),
                voter.getSex(),
                voter.getAge()
            };
            model.addRow(row);
        }
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableaddvoter = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(LIGHT_GOLD_BEIGE);
        jPanel1.setBorder(BorderFactory.createLineBorder(DARK_GREY));

        jtableaddvoter.setAutoCreateRowSorter(true);
        jtableaddvoter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Id i votuesit", "Pasuordi", "Emir", "Atesia", "Adresa", "Gjinia", "Mosha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        // Customize table appearance
        jtableaddvoter.setBackground(WHITE);
        jtableaddvoter.setForeground(VERY_DARK_GREY);
        jtableaddvoter.setGridColor(DARK_GREY);
        jtableaddvoter.setSelectionBackground(LIGHT_GOLD_BEIGE);
        jtableaddvoter.setSelectionForeground(VERY_DARK_GREY);
        jtableaddvoter.getTableHeader().setBackground(DARK_GREY);
        jtableaddvoter.getTableHeader().setForeground(WHITE);
        jtableaddvoter.setFont(new Font("Calibri", Font.PLAIN, 12));
        
        jScrollPane2.setViewportView(jtableaddvoter);

        jLabel1.setFont(new java.awt.Font("Calibri", Font.BOLD, 18));
        jLabel1.setForeground(VERY_DARK_GREY);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista e Votuesve");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voting/management/back.png")));
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(264, 264, 264)
                        .addComponent(jLabel1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 310));
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new Home().setVisible(true);
        dispose();
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Dispalyvoterlist().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtableaddvoter;
    // End of variables declaration                   
}