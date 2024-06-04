package MainView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import mainControllers.MainRegisterController;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainRegister extends JFrame {

    private JTextField textField;
    private JTextField emailField;
    private JTextField passwordField;

    private MainRegisterController registerController;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                MainRegister window = new MainRegister();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainRegister() {
        initialize();
        registerController = new MainRegisterController();
    }

    public void initialize() {
        setTitle("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 550);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(148, 121, 150));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(panel);
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblTitle = new JLabel("Registrarse");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 56));
        lblTitle.setForeground(new Color(144, 45, 65));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);

        JLabel lblNewLabel = new JLabel("Únete a nuestra comunidad");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        gbc.gridy = 1;
        panel.add(lblNewLabel, gbc);

        JLabel lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(lblNewLabel_1, gbc);

        textField = new JTextField();
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, gbc);
        textField.setColumns(10);

        JLabel lblEmail = new JLabel("Correo electrónico");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblEmail.setForeground(new Color(255, 255, 255));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblEmail, gbc);

        emailField = new JTextField();
        gbc.gridx = 1;
        panel.add(emailField, gbc);
        emailField.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPassword.setForeground(new Color(255, 255, 255));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblPassword, gbc);

        passwordField = new JTextField();
        gbc.gridx = 1;
        panel.add(passwordField, gbc);
        passwordField.setColumns(10);

        JButton btnRegister = new JButton("Registrarse");
        btnRegister.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegister.setBackground(new Color(100, 149, 237));
        btnRegister.setForeground(new Color(144, 45, 65));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(btnRegister, gbc);

        JButton btnToMainPanel = new JButton("Salir");
        btnToMainPanel.setFont(new Font("Arial", Font.BOLD, 18));
        btnToMainPanel.setBackground(new Color(100, 149, 237));
        btnToMainPanel.setForeground(new Color(144, 45, 65));
        gbc.gridy = 6;
        panel.add(btnToMainPanel, gbc);

        btnToMainPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainPanel mainPanel = new MainPanel();
                mainPanel.setVisible(true);
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = passwordField.getText();
                String email = emailField.getText();

                boolean registered = registerController.registerUser(username, password, email);
                if (registered) {
                    JOptionPane.showMessageDialog(MainRegister.this, "Usuario registrado exitosamente.");
                    dispose();
                    MainWindows mainWindows = new MainWindows();
                    mainWindows.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(MainRegister.this, "Error al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
