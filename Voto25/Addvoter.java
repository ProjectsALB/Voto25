package voting.management;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.*;

public class Addvoter extends javax.swing.JFrame {
    // Color constants based on the specification
    private static final Color LIGHT_GOLD_BEIGE = new Color(210, 180, 140); // Light Gold/Beige
    private static final Color LIGHT_GREY = new Color(200, 200, 200); // Light Grey
    private static final Color DARK_GREY = new Color(100, 100, 100); // Dark Grey
    private static final Color VERY_DARK_GREY = new Color(30, 30, 30); // Black/Very Dark Grey
    private static final Color WHITE = Color.WHITE;

    public static final Map<String, Voter> votersMap = new HashMap<>();
    
    public static class Voter {
        private final String voterId;
        private final String password;
        private final String name;
        private final String fatherName;
        private final String address;
        private final String sex;
        private final int age;

        public Voter(String voterId, String password, String name, String fatherName, 
                    String address, String sex, int age) {
            this.voterId = voterId;
            this.password = password;
            this.name = name;
            this.fatherName = fatherName;
            this.address = address;
            this.sex = sex;
            this.age = age;
        }
        public String getVoterId() { return voterId; }
        public String getPassword() { return password; }
        public String getName() { return name; }
        public String getFatherName() { return fatherName; }
        public String getAddress() { return address; }
        public String getSex() { return sex; }
        public int getAge() { return age; }
    }

    public Addvoter() {
        initComponents();
        this.setLocationRelativeTo(null);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jvoterid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jfathername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jaddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jsex = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jage = new javax.swing.JTextField();
        jpassword = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jadd = new javax.swing.JButton();
        jclear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Right panel (form panel)
        jPanel1.setBackground(WHITE);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Configure all text fields
        JTextField[] textFields = {jvoterid, jname, jfathername, jaddress, jsex, jage};
        for (JTextField field : textFields) {
            field.setForeground(VERY_DARK_GREY);
            field.setBorder(BorderFactory.createLineBorder(DARK_GREY));
        }
        
        jvoterid.setForeground(VERY_DARK_GREY);
        jPanel1.add(jvoterid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 180, 30));

        // Configure all labels
        JLabel[] labels = {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7};
        for (JLabel label : labels) {
            label.setForeground(VERY_DARK_GREY);
        }
        
        jLabel1.setText("Voter Id");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jPanel1.add(jname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 180, 30));

        jLabel4.setText("Father Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jPanel1.add(jfathername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 180, 30));

        jLabel5.setText("Address");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jPanel1.add(jaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 180, 30));

        jLabel6.setText("Sex");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jPanel1.add(jsex, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 180, 30));

        jLabel7.setText("Age");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jPanel1.add(jage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 180, 30));

        jpassword.setBorder(BorderFactory.createLineBorder(DARK_GREY));
        jpassword.setForeground(VERY_DARK_GREY);
        jPanel1.add(jpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 180, 30));

        // Button panel
        jPanel4.setBackground(LIGHT_GOLD_BEIGE);
        jPanel4.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, DARK_GREY));

        jadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voting/management/add.png")));
        jadd.setBorder(null);
        jadd.setContentAreaFilled(false);
        jadd.addActionListener(this::jaddActionPerformed);

        jclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voting/management/cached.png")));
        jclear.setBorder(null);
        jclear.setContentAreaFilled(false);
        jclear.addActionListener(this::jclearActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jadd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jclear, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jclear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jadd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 250, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 250, 500));

        // Left panel (header panel)
        jPanel2.setBackground(LIGHT_GOLD_BEIGE);
        jPanel2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, DARK_GREY));

        jLabel11.setFont(new java.awt.Font("Calibri", Font.BOLD, 36));
        jLabel11.setForeground(VERY_DARK_GREY);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Shto Votues");

        jPanel3.setBackground(LIGHT_GOLD_BEIGE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voting/management/back.png")));
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voting/management/ic_fingerprint_white_24dp.png")));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addGap(193, 193, 193))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 500));

        pack();
    }

    // [Rest of the methods remain exactly the same]
    private void jaddActionPerformed(java.awt.event.ActionEvent evt) {                                     
        try {
            String voterId = jvoterid.getText().trim().toUpperCase();
            char[] passwordChars = jpassword.getPassword();
            String password = new String(passwordChars).trim();
            String name = jname.getText().trim();
            String fatherName = jfathername.getText().trim();
            String address = jaddress.getText().trim();
            String sex = jsex.getText().trim().toUpperCase();
            String ageStr = jage.getText().trim();

            if (voterId.isEmpty() || password.isEmpty() || name.isEmpty() || 
                fatherName.isEmpty() || address.isEmpty() || sex.isEmpty() || ageStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Ju lutem plotësoni të gjitha fushat!", 
                    "Fusha të paplota", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!voterId.matches("^[A-Z0-9]{8,12}$")) {
                JOptionPane.showMessageDialog(this,
                    "ID jo valide! Duhet të jetë 8-12 karaktere (shkronja dhe numra)",
                    "Gabim në ID",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageStr);
                if (age < 18 || age > 120) {
                    JOptionPane.showMessageDialog(this,
                        "Mosha duhet të jetë midis 18 dhe 120 vjeç",
                        "Mosha jo valide",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                    "Mosha duhet të jetë një numër i plotë",
                    "Format i gabuar",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!sex.matches("^[MF]$")) {
                JOptionPane.showMessageDialog(this,
                    "Gjinia duhet të jetë 'M' ose 'F'",
                    "Gjini jo valide",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!name.matches("^[A-Za-z\\s]{3,30}$")) {
                JOptionPane.showMessageDialog(this,
                    "Emri duhet të përmbajë vetëm shkronja (3-30 karaktere)",
                    "Emër jo valid",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (votersMap.containsKey(voterId)) {
                JOptionPane.showMessageDialog(this,
                    "ID-ja e votuesit ekziston tashmë në sistem!",
                    "ID e dublikuar",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            String hashedPassword = Integer.toString(password.hashCode());

            Voter newVoter = new Voter(
                voterId,
                hashedPassword,
                name,
                fatherName,
                address,
                sex,
                age
            );

            votersMap.put(voterId, newVoter);

            String confirmationMessage = String.format(
                "Votuesi u regjistrua me sukses!\n\nDetaje:\n"
                + "ID: %s\nEmri: %s\nMosha: %d\nGjinia: %s\nAdresa: %s",
                voterId, name, age, sex, address
            );

            JOptionPane.showMessageDialog(this,
                confirmationMessage,
                "Regjistrim i suksesshëm",
                JOptionPane.INFORMATION_MESSAGE);

            jclearActionPerformed(evt);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gabim i papritur: " + e.getMessage(),
                "Gabim sistemi",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            jpassword.setText("");
        }
    }                               

    private void jclearActionPerformed(java.awt.event.ActionEvent evt) {                                       
        jvoterid.setText("");
        jpassword.setText("");
        jname.setText("");
        jfathername.setText("");
        jaddress.setText("");
        jsex.setText("");
        jage.setText("");
    }                                      

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new Home().setVisible(true);
        this.dispose();
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addvoter().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jadd;
    private javax.swing.JTextField jaddress;
    private javax.swing.JTextField jage;
    private javax.swing.JButton jclear;
    private javax.swing.JTextField jfathername;
    private javax.swing.JTextField jname;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JTextField jsex;
    private javax.swing.JTextField jvoterid;
}