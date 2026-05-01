/************************************** 
 * Project: FinalProject GUI
 * Programmers: Anousha, Nitasha & Zaynab
 * Date: 11 Nov 2025
 * Program Name: GUI.java
 **************************************/
package finalproject;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import finalproject.menu.*;

public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Profile().setVisible(true));
    }
}

/************* PROFILE WINDOW *************/
class Profile extends JFrame {
    public Profile() {
        setTitle("Create Your Profile");
        setSize(500, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        // Header
        JLabel welcome = new JLabel("<html><center>🎶 <b>Welcome to AI - iTuneAi</b><br>"
                + "I will help you find a song<br>that matches your taste.<br><b>LET'S BEGIN!</b></center></html>");
        welcome.setFont(new Font("Lucida Handwriting", Font.BOLD, 18));
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));

        // Form
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10,30,20,30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        Dimension fieldSize = new Dimension(200,28);
        nameField.setPreferredSize(fieldSize);
        emailField.setPreferredSize(fieldSize);
        phoneField.setPreferredSize(fieldSize);

        JButton save = new JButton("Save Profile");
        save.setBackground(new Color(70,130,180));
        save.setForeground(Color.BLACK);
        save.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));

        // Row 1 - Name
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Row 2 - Email
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);

        // Row 3 - Phone
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Phone (xxx-xxx-xxxx):"), gbc);
        gbc.gridx = 1;
        formPanel.add(phoneField, gbc);

        // Row 4 - Save Button
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(save, gbc);

        add(welcome, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        
     // Inside the Profile() constructor
        JButton skipBtn = new JButton("I already have an account");
        skipBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        skipBtn.setForeground(Color.BLUE);
        skipBtn.setBorderPainted(false);
        skipBtn.setContentAreaFilled(false);

        // Action for the skip button
        skipBtn.addActionListener(e -> {
            File f = new File("Profile.txt");
            if(f.exists()) {
                new MainMenu().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No profile found! Please create one.");
            }
        });

        // Add it to the bottom of your formPanel
        gbc.gridy = 4; // One row below the Save button
        formPanel.add(skipBtn, gbc);

        save.addActionListener(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();

            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(this, "⛔ Invalid Email. Must contain @");
                return;
            }
            if (!phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
                JOptionPane.showMessageDialog(this, "⛔ Invalid phone format. Use xxx-xxx-xxxx");
                return;
            }

            try {
                PrintWriter pw = new PrintWriter(new FileWriter("Profile.txt", true));
                pw.println("Name: " + name);
                pw.println("✉️ Email: " + email);
                pw.println("📞 Phone: " + phone);
                pw.println();
                pw.close();
                JOptionPane.showMessageDialog(this, "Profile Saved Successfully! 😊");
                new MainMenu().setVisible(true);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "⛔ Error saving file!");
            }
        });

        setVisible(true);
    }
}

/************* MAIN MENU *************/
class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("iTuneAi - Music Discovery");
        setSize(600, 550);  
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(30, 30, 30));  
        setLayout(new BorderLayout(20, 20));

        // Header Section
        JLabel header = new JLabel("Welcome to iTuneAi", SwingConstants.CENTER);
        header.setFont(new Font("Lucida Handwriting", Font.BOLD, 26));
        header.setForeground(new Color(255, 255, 255));
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(header, BorderLayout.NORTH);

        // Button Grid
        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 20, 20));
        buttonPanel.setBackground(new Color(30, 30, 30));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));

        // Creating Buttons with Modern Colors
        JButton btn1 = createStyledButton("Option 1: Genre", new Color(255, 105, 180));
        JButton btn2 = createStyledButton("Option 2: Artist", new Color(30, 144, 255));
        JButton btn3 = createStyledButton("Option 3: Profile", new Color(255, 140, 0));
        JButton btn4 = createStyledButton("Option 4: Premium", new Color(255, 215, 0));
        JButton btn5 = createStyledButton("Option 5: Review", new Color(50, 205, 50));
        JButton btn6 = createStyledButton("Option 6: Feedback", new Color(138, 43, 226));
        
        // Make the Recommendation Button "Pop"
        JButton btn7 = createStyledButton("✨ AI Recommendation", new Color(0, 206, 209));
        btn7.setFont(new Font("SansSerif", Font.BOLD, 18)); 
        

        btn1.addActionListener(e -> new Option1Window(this));
        btn2.addActionListener(e -> new Option2Window(this));
        btn3.addActionListener(e -> new Option3Window(this));
        btn4.addActionListener(e -> new Option4Window(this));
        btn5.addActionListener(e -> new Option5Window(this));
        btn6.addActionListener(e -> new Option6Window(this));
        btn7.addActionListener(e -> Recommender.getRecommendation());

        buttonPanel.add(btn1); buttonPanel.add(btn2);
        buttonPanel.add(btn3); buttonPanel.add(btn4);
        buttonPanel.add(btn5); buttonPanel.add(btn6);
        buttonPanel.add(btn7);

        add(buttonPanel, BorderLayout.CENTER);

        // Exit Button at the bottom
        JButton exit = new JButton("Exit Program");
        exit.setBackground(new Color(220, 20, 60));
        exit.setForeground(Color.RED);
        exit.setFocusPainted(false);
        exit.addActionListener(e -> System.exit(0));
        add(exit, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JButton createStyledButton(String text, Color color) {
        JButton btn = new JButton(text);
        
        // --- THE MAC FIX STARTS HERE ---
        btn.setOpaque(true); 
        btn.setBorderPainted(false); // This removes the white/black outline
        btn.setContentAreaFilled(true); 
        // --- THE MAC FIX ENDS HERE ---

        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setBackground(color); // Now this will actually show up!
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(color.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(color);
            }
        });
        
        return btn;
    }


    private JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        
     // ADD THESE TWO LINES:
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        
        btn.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
        btn.setFocusPainted(false);
        return btn;
    }
}

class Option1Window extends JFrame {
    private JFrame previousMenu;
    public Option1Window(JFrame previousMenu) {
        this.previousMenu = previousMenu;
        setTitle("Option 1 - Genre");
        setSize(400,250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JButton run = new JButton("Select Genre");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        run.setBackground(new Color(255,182,193));
        run.setFont(new Font("Lucida Handwriting", Font.BOLD,12));

        run.addActionListener(e -> {
            String[] genres = {"Kpop","Classic","Pop","Rap"};
            try {
                Option1.option1(genres);
                previousMenu.dispose();
                new MainMenu().setVisible(true);
                dispose();
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this,"⛔ Error executing option 1!");
            }
        });

        add(run, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);
        setVisible(true);
    }
}

class Option2Window extends JFrame {
    private JFrame previousMenu;
    public Option2Window(JFrame previousMenu) {
        this.previousMenu = previousMenu;
        setTitle("Option 2 - Artist");
        setSize(400,250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JButton run = new JButton("Select an Artist");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        run.setBackground(new Color(135,206,250));
        run.setFont(new Font("Lucida Handwriting", Font.BOLD,12));

        run.addActionListener(e -> {
            String[] artists = {"Jungkook","Weeknd","Drake","Alan Milan"};
            try {
                Option2.option2(artists);
                previousMenu.dispose();
                new MainMenu().setVisible(true);
                dispose();
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this,"⛔ Error executing option 2!");
            }
        });

        add(run, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);
        setVisible(true);
    }
}

// Option3Window uses the same form style as Profile for aesthetic consistency
class Option3Window extends JFrame {
    private JFrame previousMenu;
    public Option3Window(JFrame previousMenu) {
        this.previousMenu = previousMenu;
        setTitle("Update Your Profile");
        setSize(500,420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        JLabel header = new JLabel("<html><center>Update Your Profile<br>Make changes and click Save</center></html>");
        header.setFont(new Font("Lucida Handwriting", Font.BOLD,18));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10,30,20,30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        Dimension fieldSize = new Dimension(200,28);
        nameField.setPreferredSize(fieldSize);
        emailField.setPreferredSize(fieldSize);
        phoneField.setPreferredSize(fieldSize);

        try {
            Scanner scan = new Scanner(new File("Profile.txt"));
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                if(line.startsWith("Name:")) nameField.setText(line.substring(6));
                if(line.startsWith("✉️ Email:")) emailField.setText(line.substring(9));
                if(line.startsWith("📞 Phone:")) phoneField.setText(line.substring(9));
            }
            scan.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"⛔ Error reading profile!");
        }

        JButton save = new JButton("Save Profile");
        save.setBackground(new Color(70,130,180));
        save.setForeground(Color.WHITE);
        save.setFont(new Font("Lucida Handwriting", Font.BOLD,12));

        gbc.gridx=0; gbc.gridy=0;
        formPanel.add(new JLabel("Name:"),gbc);
        gbc.gridx=1;
        formPanel.add(nameField,gbc);

        gbc.gridx=0; gbc.gridy=1;
        formPanel.add(new JLabel("Email:"),gbc);
        gbc.gridx=1;
        formPanel.add(emailField,gbc);

        gbc.gridx=0; gbc.gridy=2;
        formPanel.add(new JLabel("Phone (xxx-xxx-xxxx):"),gbc);
        gbc.gridx=1;
        formPanel.add(phoneField,gbc);

        gbc.gridx=0; gbc.gridy=3; gbc.gridwidth=2;
        gbc.anchor=GridBagConstraints.CENTER;
        formPanel.add(save,gbc);

        add(header,BorderLayout.NORTH);
        add(formPanel,BorderLayout.CENTER);

        save.addActionListener(e -> {
            try {
                PrintWriter pw = new PrintWriter(new FileWriter("Profile.txt"));
                pw.println("Name: " + nameField.getText());
                pw.println("✉️ Email: " + emailField.getText());
                pw.println("📞 Phone: " + phoneField.getText());
                pw.close();

                JOptionPane.showMessageDialog(this,"Profile Updated!");
                previousMenu.dispose();
                new MainMenu().setVisible(true);
                dispose();
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this,"⛔ Error saving profile!");
            }
        });

        setVisible(true);
    }
}

// Option4, Option5, Option6 aesthetic changes similar to above
class Option4Window extends JFrame {
    private JFrame previousMenu;
    public Option4Window(JFrame previousMenu) {
        this.previousMenu = previousMenu;
        setTitle("Option 4 - Premium");
        setSize(400,250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JButton run = new JButton("Activate Premium");
        run.setFont(new Font("Lucida Handwriting", Font.BOLD,12));
        run.setBackground(new Color(255,255,102));

        JTextArea output = new JTextArea();
        output.setEditable(false);

        run.addActionListener(e -> {
            Option4.option4();
            previousMenu.dispose();
            new MainMenu().setVisible(true);
            dispose();
        });

        add(run, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);
        setVisible(true);
    }
}

class Option5Window extends JFrame {
    private JFrame previousMenu;
    public Option5Window(JFrame previousMenu) {
        this.previousMenu = previousMenu;
        setTitle("Option 5 - Review");
        setSize(400,250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JButton run = new JButton("Write a review");
        run.setFont(new Font("Lucida Handwriting", Font.BOLD,12));
        run.setBackground(new Color(144,238,144));

        JTextArea output = new JTextArea();
        output.setEditable(false);

        run.addActionListener(e -> {
            Option5.option5();
            previousMenu.dispose();
            new MainMenu().setVisible(true);
            dispose();
        });

        add(run, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);
        setVisible(true);
    }
}

class Option6Window extends JFrame {
    private JFrame previousMenu;
    public Option6Window(JFrame previousMenu) {
        this.previousMenu = previousMenu;
        setTitle("Option 6 - Feedback");
        setSize(400,250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JButton run = new JButton("Previous Feedback");
        run.setFont(new Font("Lucida Handwriting", Font.BOLD,12));
        run.setBackground(new Color(221,160,221));

        JTextArea output = new JTextArea();
        output.setEditable(false);

        run.addActionListener(e -> {
            Option6.option6();
            previousMenu.dispose();
            new MainMenu().setVisible(true);
            dispose();
        });

        add(run, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);
        setVisible(true);
    }
}
