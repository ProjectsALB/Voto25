package voting.management;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class addcondidate extends javax.swing.JFrame {
    // Color constants based on the specification
    private static final Color LIGHT_GOLD_BEIGE = new Color(210, 180, 140); // Light Gold/Beige
    private static final Color LIGHT_GREY = new Color(200, 200, 200); // Light Grey
    private static final Color DARK_GREY = new Color(100, 100, 100); // Dark Grey
    private static final Color VERY_DARK_GREY = new Color(30, 30, 30); // Black/Very Dark Grey
    private static final Color WHITE = Color.WHITE;

    // In-memory storage for parties
    private static final Map<String, Party> parties = new HashMap<>();
    
    // Party data class
    public static class Party {
        private final String leader;
        private final String sex;
        private final int age;
        private final String headquarters;
        private final String sign;

        public Party(String leader, String sex, int age, String headquarters, String sign) {
            this.leader = leader;
            this.sex = sex;
            this.age = age;
            this.headquarters = headquarters;
            this.sign = sign;
        }

        // Getters
        public String getLeader() { return leader; }
        public String getSex() { return sex; }
        public int getAge() { return age; }
        public String getHeadquarters() { return headquarters; }
        public String getSign() { return sign; }
    }

    public addcondidate() {
        initComponents();
        this.setLocationRelativeTo(null);
        partysign();
    }

    private void partysign() {
        jpsign.removeAll();
        jpsign.addItem("");
        jpsign.addItem("Lotus");
        jpsign.addItem("Hand");
        jpsign.addItem("Elephant");
        jpsign.addItem("CPI");
        jpsign.addItem("NCP");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel5 = new javax.swing.JPanel();
        a = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jpname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jpleader = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jpsex = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jpage = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jpheadquater = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jpsign = new java.awt.Choice();
        jpadd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Right panel (form panel)
        jPanel5.setBackground(WHITE);

        a.setBackground(LIGHT_GOLD_BEIGE);
        a.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, DARK_GREY));

        // Configure all labels
        JLabel[] labels = {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7};
        for (JLabel label : labels) {
            label.setForeground(VERY_DARK_GREY);
        }

        jLabel3.setText("Emri i Partise");

        jpname.setBorder(BorderFactory.createLineBorder(DARK_GREY));
        jpname.setForeground(VERY_DARK_GREY);

        jLabel4.setText("Kryetari");

        jpleader.setBorder(BorderFactory.createLineBorder(DARK_GREY));
        jpleader.setForeground(VERY_DARK_GREY);
        jpleader.addActionListener(this::jpleaderActionPerformed);

        jLabel5.setText("Gjinia");

        jpsex.setBorder(BorderFactory.createLineBorder(DARK_GREY));
        jpsex.setForeground(VERY_DARK_GREY);

        jLabel6.setText("Mosha");

        jpage.setBorder(BorderFactory.createLineBorder(DARK_GREY));
        jpage.setForeground(VERY_DARK_GREY);
        jpage.addActionListener(this::jpageActionPerformed);

        jLabel7.setText("Logoja e patise");

        jpheadquater.setBorder(BorderFactory.createLineBorder(DARK_GREY));
        jpheadquater.setForeground(VERY_DARK_GREY);

        jLabel2.setText("Party HeadQuater");

        jpsign.setForeground(VERY_DARK_GREY);
        jpsign.setBackground(WHITE);

        jpadd.setText("Shto");
        jpadd.setBackground(DARK_GREY);
        jpadd.setForeground(WHITE);
        jpadd.setBorder(BorderFactory.createLineBorder(DARK_GREY));
        jpadd.addActionListener(this::jpaddActionPerformed);

        javax.swing.GroupLayout aLayout = new javax.swing.GroupLayout(a);
        a.setLayout(aLayout);
        aLayout.setHorizontalGroup(
            aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpheadquater, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpage, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpsex, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpleader, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jpname, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jpsign, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aLayout.createSequentialGroup()
                            .addComponent(jpadd, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        aLayout.setVerticalGroup(
            aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpleader, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpsex, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpheadquater, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpsign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jpadd, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 280, 510));

        // Left panel (header panel)
        jPanel1.setBackground(LIGHT_GOLD_BEIGE);
        jPanel1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, DARK_GREY));

        jLabel1.setFont(new java.awt.Font("Calibri", Font.BOLD, 20));
        jLabel1.setForeground(VERY_DARK_GREY);
        jLabel1.setText("Shto partite");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voting/management/back.png")));
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 510));

        pack();
    }

    private void jpleaderActionPerformed(java.awt.event.ActionEvent evt) {
        // Empty event handler
    }

    private void jpaddActionPerformed(java.awt.event.ActionEvent evt) {
        String partyName = jpname.getText().trim();
        String leader = jpleader.getText().trim();
        String sex = jpsex.getText().trim();
        String ageStr = jpage.getText().trim();
        String headquarters = jpheadquater.getText().trim();
        String sign = jpsign.getSelectedItem();

        // Validate inputs
        if (partyName.isEmpty() || leader.isEmpty() || sex.isEmpty() || 
            ageStr.isEmpty() || headquarters.isEmpty() || sign.isEmpty()) {
            showError("Ploteso te gjitha fushat!");
            return;
        }

        // Validate age
        int age;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 18) {
                showError("Kryetari duhet te jete mbi 18 vjec!");
                return;
            }
        } catch (NumberFormatException e) {
            showError("Format i papershtatshem i moshes.");
            return;
        }

        // Check for existing party
        if (parties.containsKey(partyName)) {
            showError("Kjo parti eshte rregjistruar njehere!");
            return;
        }

        // Add to storage
        parties.put(partyName, new Party(leader, sex, age, headquarters, sign));
        JOptionPane.showMessageDialog(this, 
            "Partia u rregjistrua me sukses: " + parties.size(), 
            "Sukses", JOptionPane.INFORMATION_MESSAGE);
        clearFields();
    }

    private void jpageActionPerformed(java.awt.event.ActionEvent evt) {
        // Empty event handler
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (parties.size() < 2) {
            JOptionPane.showMessageDialog(this, 
                "Duhet te shtosh me shume se 1 parti.\nCurrently added: " + parties.size(), 
                "Minimumi i nr qe duhet", 
                JOptionPane.WARNING_MESSAGE
            );
        } else {
            new Home().setVisible(true);
            this.dispose();
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void clearFields() {
        jpname.setText("");
        jpleader.setText("");
        jpsex.setText("");
        jpage.setText("");
        jpheadquater.setText("");
        jpsign.select(0);
    }

    public static Map<String, Party> getParties() {
        return new HashMap<>(parties);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new addcondidate().setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JPanel a;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jpadd;
    private javax.swing.JTextField jpage;
    private javax.swing.JTextField jpheadquater;
    private javax.swing.JTextField jpleader;
    private javax.swing.JTextField jpname;
    private javax.swing.JTextField jpsex;
    private java.awt.Choice jpsign;
}