package InterfaceHotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Utilisateur:");
        usernameLabel.setBounds(160,13,260,100);
        JLabel passwordLabel = new JLabel("Mot de passe:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton LoginButton = new JButton("Login");
        LoginButton.setBackground(Color.BLACK);
        LoginButton.setForeground(Color.WHITE);
        LoginButton.setBounds(50,320,150,30);
        
        LoginButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); 
        add(LoginButton);

        setVisible(true);
    }

    private void performLogin() {
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

       
        if ("admin".equals(username) && "password".equals(password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            new Pageprincipale().setVisible(true);
            this.setVisible(false);
            
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
         
            public void run() {
                new Login();
            }
        });
    }
}