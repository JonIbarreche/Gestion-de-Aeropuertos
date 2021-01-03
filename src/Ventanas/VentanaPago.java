
package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;


public class VentanaPago extends JFrame {

	private JPanel contentPane;
	private JTextField txtTarjeta;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCVV;

    public VentanaPago() {
		setBackground(new Color(0, 139, 139));
		setForeground(new Color(0, 128, 128));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTarjeta = new JPanel();
		panelTarjeta.setBounds(256, 137, 299, 50);
		contentPane.add(panelTarjeta);
		panelTarjeta.setLayout(null);
		
		txtTarjeta = new JTextField();
		txtTarjeta.setText("Tarjeta");
		txtTarjeta.setBounds(10, 10, 279, 30);
		panelTarjeta.add(txtTarjeta);
		txtTarjeta.setColumns(10);
		
		JPanel panelNombre = new JPanel();
		panelNombre.setBounds(256, 197, 95, 51);
		contentPane.add(panelNombre);
		panelNombre.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		txtNombre.setBounds(10, 10, 75, 31);
		panelNombre.add(txtNombre);
		txtNombre.setColumns(10);
		
		JPanel panelApellido = new JPanel();
		panelApellido.setBounds(361, 198, 194, 50);
		contentPane.add(panelApellido);
		panelApellido.setLayout(null);
		
		txtApellido = new JTextField();
		txtApellido.setText("Apellido");
		txtApellido.setBounds(10, 10, 174, 30);
		panelApellido.add(txtApellido);
		txtApellido.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(256, 268, 58, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-", "20", "21", "22", "23", "24", "25"}));
		comboBox_1.setBounds(361, 268, 58, 21);
		contentPane.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(480, 268, 75, 21);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		txtCVV = new JTextField();
		txtCVV.setText("CVV");
		txtCVV.setBounds(0, 0, 75, 21);
		panel_3.add(txtCVV);
		txtCVV.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(220, 20, 60), 2));
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(314, 358, 194, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPagar = new JLabel("PAGAR");
		lblPagar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPagar.setForeground(new Color(255, 255, 255));
		lblPagar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagar.setBounds(10, 10, 174, 41);
		panel.add(lblPagar);
	}

}
