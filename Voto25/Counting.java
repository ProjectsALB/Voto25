package voting.management;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Counting extends javax.swing.JFrame {
    // Color constants based on the specification
    private static final Color LIGHT_GOLD_BEIGE = new Color(210, 180, 140); // Light Gold/Beige
    private static final Color LIGHT_GREY = new Color(200, 200, 200); // Light Grey
    private static final Color DARK_GREY = new Color(100, 100, 100); // Dark Grey
    private static final Color VERY_DARK_GREY = new Color(30, 30, 30); // Black/Very Dark Grey
    private static final Color WHITE = Color.WHITE;

    // Map to store vote counts (Party Name -> Vote Count)
    private static final Map<String, Integer> votes = new HashMap<>();
    public static Map<String, Integer> getVotes() {
        return new HashMap<>(votes);
    }
    
    // GUI components
    private javax.swing.JButton jButton21;  // Refresh button

    public Counting() {
        initComponents();
        this.setLocationRelativeTo(null);
        initializeData();
    }

    private void initializeData() {
        loadCandidates();
        refreshVoteCounts();
    }

    private void loadCandidates() {
        DefaultTableModel model = (DefaultTableModel) jcounting.getModel();
        model.setRowCount(0);
        
        Map<String, addcondidate.Party> parties = addcondidate.getParties();
        parties.forEach((partyName, party) -> {
            model.addRow(new Object[] {
                partyName,
                party.getLeader(),
                party.getSex(),
                party.getHeadquarters(),
                party.getSign()
            });
            votes.putIfAbsent(partyName, 0);
        });
    }

    private void refreshVoteCounts() {
        DefaultTableModel model = (DefaultTableModel) jcounttable.getModel();
        model.setRowCount(0);
        
        votes.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> model.addRow(new Object[] {
                entry.getKey(), 
                entry.getValue()
            }));
    }

    public static void incrementVote(String partyName) {
        votes.compute(partyName, (k, v) -> (v == null) ? 1 : v + 1);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jcounting = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jcounttable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(LIGHT_GOLD_BEIGE);
        jPanel2.setBorder(BorderFactory.createLineBorder(DARK_GREY));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Configure candidates table
        jcounting.setAutoCreateRowSorter(true);
        jcounting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Emri i partise", "Kryetari", "Gjinia", "Party Headquarters", "Logoja e partise"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jcounting.setBackground(WHITE);
        jcounting.setForeground(VERY_DARK_GREY);
        jcounting.setGridColor(DARK_GREY);
        jcounting.setSelectionBackground(LIGHT_GOLD_BEIGE);
        jcounting.setSelectionForeground(VERY_DARK_GREY);
        jcounting.getTableHeader().setBackground(DARK_GREY);
        jcounting.getTableHeader().setForeground(WHITE);
        jScrollPane1.setViewportView(jcounting);
        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 640, 239));

        // Configure vote count table
        jcounttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Emri i partise", "Numri i votave"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jcounttable.setBackground(WHITE);
        jcounttable.setForeground(VERY_DARK_GREY);
        jcounttable.setGridColor(DARK_GREY);
        jcounttable.setSelectionBackground(LIGHT_GOLD_BEIGE);
        jcounttable.setSelectionForeground(VERY_DARK_GREY);
        jcounttable.getTableHeader().setBackground(DARK_GREY);
        jcounttable.getTableHeader().setForeground(WHITE);
        jScrollPane2.setViewportView(jcounttable);
        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 150, 150));

        jLabel1.setFont(new java.awt.Font("Calibri", Font.BOLD, 24));
        jLabel1.setForeground(VERY_DARK_GREY);
        jLabel1.setText("Numerimi i votave");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voting/management/back.png")));
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jButton21.setText("Refresh");
        jButton21.setBackground(DARK_GREY);
        jButton21.setForeground(WHITE);
        jButton21.setFocusPainted(false);
        jButton21.setBorder(BorderFactory.createLineBorder(DARK_GREY));
        jButton21.addActionListener(this::jButton2ActionPerformed);
        jPanel2.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        new Home().setVisible(true);
        this.dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        loadCandidates();
        refreshVoteCounts();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Counting().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton211;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jcounting;
    private javax.swing.JTable jcounttable;
}