package voting.management;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class hyrje extends javax.swing.JFrame {
    // Color constants based on the specification
    private static final Color LIGHT_GOLD_BEIGE = new Color(210, 180, 140); // Light Gold/Beige
    private static final Color LIGHT_GREY = new Color(200, 200, 200); // Light Grey
    private static final Color DARK_GREY = new Color(100, 100, 100); // Dark Grey
    private static final Color VERY_DARK_GREY = new Color(30, 30, 30); // Black/Very Dark Grey
    private static final Color WHITE = Color.WHITE;
    
    // Valid admin passwords
    private static final String[] ADMIN_PASSWORDS = {"admin123", "zgjedhjet2025", "securepass"};
    // Track voted User IDs
    private static final Set<String> votedUserIds = new HashSet<>();

    public hyrje() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_GOLD_BEIGE); // Using Light Gold/Beige as background

        // Welcome label
        JLabel welcomeLabel = new JLabel("Voto25");
        welcomeLabel.setFont(new Font("Calibri", Font.BOLD, 24));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(VERY_DARK_GREY); // Using Black/Very Dark Grey for text
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        buttonPanel.setBackground(LIGHT_GOLD_BEIGE); // Matching main panel background

        JButton adminButton = new JButton("Administrator");
        JButton voterButton = new JButton("Votues");

        // Style buttons
        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        adminButton.setFont(buttonFont);
        voterButton.setFont(buttonFont);
        adminButton.setBackground(DARK_GREY); // Using Dark Grey for admin button
        adminButton.setForeground(WHITE);
        voterButton.setBackground(DARK_GREY); // Using Dark Grey for voter button
        voterButton.setForeground(WHITE);

        // Add action listeners
        adminButton.addActionListener(e -> handleAdminLogin());
        voterButton.addActionListener(e -> showVoterInterface());

        buttonPanel.add(adminButton);
        buttonPanel.add(voterButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Frame settings
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setTitle("Sistemi i Zgjedhjeve 2025");
    }

    private void handleAdminLogin() {
        String password = JOptionPane.showInputDialog(this, 
            "Ju lutem shkruani fjalëkalimin:", 
            "Autentikimi i Administratorit", 
            JOptionPane.PLAIN_MESSAGE);

        if (password != null && !password.isEmpty()) {
            if (Arrays.asList(ADMIN_PASSWORDS).contains(password)) {
                new Home().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Fjalëkalim i gabuar!", 
                    "Gabim", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showVoterInterface() {
        String userId = JOptionPane.showInputDialog(
            this,
            "Ju lutem shkruani User ID:",
            "Identifikimi i Votuesit",
            JOptionPane.PLAIN_MESSAGE
        );

        if (userId == null) {
            return; // User clicked cancel
        } 
        else if (userId.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "User ID nuk mund të jetë bosh!",
                "Gabim",
                JOptionPane.ERROR_MESSAGE
            );
            System.exit(0);
        }

        // Check if ID exists in registered voters list
        if (!Addvoter.votersMap.containsKey(userId)) {
            JOptionPane.showMessageDialog(
                this,
                "ID e votuesit nuk ekziston në sistem!",
                "Gabim",
                JOptionPane.ERROR_MESSAGE
            );
            System.exit(0);
        }

        // Check if already voted
        if (votedUserIds.contains(userId)) {
            JOptionPane.showMessageDialog(
                this,
                "Ky përdorues ka votuar tashmë!",
                "Gabim",
                JOptionPane.ERROR_MESSAGE
            );
            System.exit(0);
        }

        JFrame voterFrame = new JFrame("Lista e Kandidatëve");
        voterFrame.setSize(600, 400);
        voterFrame.setLocationRelativeTo(null);
        voterFrame.getContentPane().setBackground(LIGHT_GOLD_BEIGE); // Light Gold/Beige background

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(LIGHT_GOLD_BEIGE); // Light Gold/Beige background

        JLabel titleLabel = new JLabel("Zgjidhni kandidatin tuaj:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(VERY_DARK_GREY); // Black/Very Dark Grey text
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));

        // Get parties from addcondidate class
        Map<String, addcondidate.Party> parties = addcondidate.getParties();

        if (parties.isEmpty()) {
            JLabel noCandidatesLabel = new JLabel("Nuk ka kandidatë të regjistruar ende!");
            noCandidatesLabel.setForeground(VERY_DARK_GREY);
            mainPanel.add(noCandidatesLabel);
        } else {
            for (Map.Entry<String, addcondidate.Party> entry : parties.entrySet()) {
                JPanel partyPanel = new JPanel(new BorderLayout());
                partyPanel.setBorder(BorderFactory.createLineBorder(DARK_GREY)); // Dark Grey border
                partyPanel.setBackground(WHITE); // White background for party panels

                JLabel infoLabel = new JLabel("<html>Partia: " + entry.getKey()
                    + "<br/>Kryetari: " + entry.getValue().getLeader()
                    + "<br/>Shenja: " + entry.getValue().getSign() + "</html>");
                infoLabel.setForeground(VERY_DARK_GREY); // Black/Very Dark Grey text

                JButton voteButton = new JButton("Voto");
                voteButton.setBackground(DARK_GREY); // Dark Grey button
                voteButton.setForeground(WHITE);

                // Capture userId for the action listener
                final String currentUserId = userId;
                voteButton.addActionListener(e -> {
                    // 1. Record user vote in tracking system
                    votedUserIds.add(currentUserId);
                    
                    // 2. Update vote count in counting system
                    Counting.incrementVote(entry.getKey());
                    
                    // 3. Show confirmation message
                    JOptionPane.showMessageDialog(
                        voterFrame,
                        "Vota juaj u regjistrua për " + entry.getKey() + "!",
                        "Faleminderit",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    
                    // 4. Close voting interface
                    voterFrame.dispose();
                    
                    // 5. Return to main voting interface
                    new hyrje().setVisible(true);
                });

                partyPanel.add(infoLabel, BorderLayout.CENTER);
                partyPanel.add(voteButton, BorderLayout.EAST);
                mainPanel.add(partyPanel);
                mainPanel.add(Box.createVerticalStrut(10));
            }
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.getViewport().setBackground(LIGHT_GOLD_BEIGE); // Light Gold/Beige background
        voterFrame.add(scrollPane);
        voterFrame.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new hyrje().setVisible(true);
        });
    }
}