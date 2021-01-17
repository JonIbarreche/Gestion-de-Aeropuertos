package Ventanas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import BDAPI.BDAPI;
import Jerarquias.Admin;
import Jerarquias.Cliente;
import Jerarquias.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaLogin extends JFrame {

	public BDAPI bd = new BDAPI();
	public Admin admin;
	public Cliente cliente;
	public static String usuario;
	public static String password;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblVentanaLoginMessage = new JLabel("");

	public VentanaLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(173, 146, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("Usuario")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals(""))
					txtUsername.setText("Usuario");
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.BOLD, 14));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 10, 170, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblImagenMan = new JLabel("");

		Image img_user = new ImageIcon("Gestion_Aeropuertos" + File.separator + "img" + File.separator + "man.png").getImage();
		lblImagenMan.setIcon(new ImageIcon(img_user));
		lblImagenMan.setBounds(218, -2, 32, 32);
		panel.add(lblImagenMan);

		JPanel lblIconPassword = new JPanel();
		lblIconPassword.setBackground(Color.WHITE);
		lblIconPassword.setBounds(173, 213, 250, 40);
		contentPane.add(lblIconPassword);
		lblIconPassword.setLayout(null);

		txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.setBounds(10, 10, 170, 20);
		lblIconPassword.add(txtPassword);

		JPanel pnlBtnVentanaLogin = new JPanel();
		pnlBtnVentanaLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tempUsuario = txtUsername.getText();
				String tempPassword = txtPassword.getText();
				try {
					List<Cliente> listaClientes = new ArrayList<Cliente>();
					List<Admin> listaAdmins = new ArrayList<Admin>();
					listaClientes = bd.getListaClientes();
					listaAdmins = bd.getListaAdmins();
					
					for (Cliente cliente : listaClientes) {
						if (cliente.getUsername().equals(tempUsuario)) {
							if (cliente.getPassword().equals(tempPassword)) {
								usuario = tempUsuario;
								password = tempPassword;
								VentanaInicio ventanaInicio = new VentanaInicio();
								ventanaInicio.setVisible(true);
								setVisible(false);
								break;
							}
						}
					}
					for (Admin admin : listaAdmins) {
						if (admin.getUsername().equals(tempUsuario)) {
							if (admin.getPassword().equals(tempPassword)) {
								usuario = tempUsuario;
								password = tempPassword;
								VentanaAdmin ventanaAdmin = new VentanaAdmin();
								ventanaAdmin.setVisible(true);
								setVisible(false);
								break;
							}
						}
					}
					if (usuario == null || password == null) {
						lblVentanaLoginMessage.setText("Usuario y contraseña no coinciden");
					}
					System.out.println(usuario);
					System.out.println(password);
				} catch (Exception ee) {
					
				}
				// 	lblVentanaLoginMessage.setText("Por favor rellena los campos!");
				// } else {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnVentanaLogin.setBackground(new Color(20, 30, 40));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnVentanaLogin.setBackground(new Color(47, 79, 79));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnVentanaLogin.setBackground(new Color(60, 80, 90));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnVentanaLogin.setBackground(new Color(20, 30, 40));
			}
		});
		pnlBtnVentanaLogin.setBackground(new Color(47, 79, 79));
		pnlBtnVentanaLogin.setBounds(173, 290, 250, 51);
		contentPane.add(pnlBtnVentanaLogin);
		pnlBtnVentanaLogin.setLayout(null);

		JLabel lblVentanaLogin = new JLabel("LOG IN");
		lblVentanaLogin.setForeground(Color.WHITE);
		lblVentanaLogin.setFont(new Font("Arial", Font.BOLD, 14));
		lblVentanaLogin.setBounds(116, 10, 69, 31);
		pnlBtnVentanaLogin.add(lblVentanaLogin);

		JLabel lblImageLlave = new JLabel("");
		//
		Image img_llave = new ImageIcon("Gestion_Aeropuertos" + File.separator + "img" + File.separator + "llave.png").getImage();
		lblImageLlave.setIcon(new ImageIcon(img_llave));
		lblImageLlave.setBounds(74, 10, 32, 32);
		pnlBtnVentanaLogin.add(lblImageLlave);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Seguro que quieres salir de la aplicacion?", "Confirmar",
						JOptionPane.YES_NO_OPTION) == 0) {
					VentanaLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 25));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(563, 0, 37, 34);
		contentPane.add(lblX);

		lblVentanaLoginMessage.setForeground(new Color(128, 0, 0));
		lblVentanaLoginMessage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblVentanaLoginMessage.setBounds(173, 263, 250, 19);
		contentPane.add(lblVentanaLoginMessage);

		JLabel lblImageAirplane = new JLabel("");
		Image img = new ImageIcon("Gestion_Aeropuertos" + File.separator + "img" + File.separator + "airplane1.png").getImage();
		lblImageAirplane.setIcon(new ImageIcon(img));
		lblImageAirplane.setBounds(232, 10, 128, 128);
		contentPane.add(lblImageAirplane);

		JLabel lblImageCerradura = new JLabel("");
		Image img_Cerradura = new ImageIcon("Gestion_Aeropuertos" + File.separator + "img" + File.separator + "cerradura.png").getImage();
		lblImageCerradura.setBounds(391, 213, 32, 32);
		contentPane.add(lblImageCerradura);
		lblImageCerradura.setIcon(new ImageIcon(img_Cerradura));
		
		
		try {
			Files.list(new File(".").toPath()).limit(10).forEach(path -> {
				System.out.println(path);
			});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
