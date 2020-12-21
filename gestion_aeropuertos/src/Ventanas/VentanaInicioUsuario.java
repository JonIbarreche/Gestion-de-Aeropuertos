/*
package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicioUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private JLabel lblBuscarMessage = new JLabel("");

    public VentanaInicioUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(153, 187, 187, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtOrigen = new JTextField();
		txtOrigen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtOrigen.getText().equals("Origen")) {
					txtOrigen.setText("");
				} else {
					txtOrigen.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtOrigen.getText().equals("")) {
					txtOrigen.setText("Origen");
				}
			}
		});
		txtOrigen.setBorder(null);
		txtOrigen.setText("Origen");
		txtOrigen.setBounds(10, 10, 167, 19);
		panel.add(txtOrigen);
		txtOrigen.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(413, 187, 187, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtDestino = new JTextField();
		txtDestino.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtDestino.getText().equals("Destino")) {
					txtDestino.setText("");
				} else {
					txtDestino.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtDestino.getText().equals("")) {
					txtDestino.setText("Destino");
				}
			}
		});
		txtDestino.setBorder(null);
		txtDestino.setText("Destino");
		txtDestino.setColumns(10);
		txtDestino.setBounds(10, 10, 167, 19);
		panel_1.add(txtDestino);
		
		JPanel pnlBtnBuscar = new JPanel();
		pnlBtnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtOrigen.getText().equals("Bilbao") && txtDestino.getText().equals("Madrid") ) {
					// si son correctos
					lblBuscarMessage.setText("");
					JOptionPane.showMessageDialog(null, "Busqueda Realizada");
					// ventana busqueda 
					
					
				} else if (txtOrigen.getText().equals("") || txtOrigen.getText().equals("Origen") ||
						txtDestino.getText().equals("") || txtDestino.getText().equals("Destino")){
					lblBuscarMessage.setText("Por favor, rellena los campos");
				} else {
					lblBuscarMessage.setText("Origen y destino no compatibles");
				}
			}
		});
		pnlBtnBuscar.setBackground(new Color(47, 79, 79));
		pnlBtnBuscar.setBounds(216, 392, 314, 71);
		contentPane.add(pnlBtnBuscar);
		pnlBtnBuscar.setLayout(null);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setFont(new Font("Arial", Font.BOLD, 28));
		lblBuscar.setForeground(new Color(245, 255, 250));
		lblBuscar.setBounds(97, 22, 124, 28);
		pnlBtnBuscar.add(lblBuscar);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cerrar la aplicacion?", "Confirmacion", JOptionPane.YES_NO_OPTION) == 0) {
					VentanaInicioUsuario.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(731, 0, 19, 31);
		contentPane.add(lblX);
		lblBuscarMessage.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblBuscarMessage.setForeground(new Color(255, 105, 180));
		lblBuscarMessage.setBounds(232, 369, 282, 13);
		contentPane.add(lblBuscarMessage);
		
		JComboBox comboBox = new JComboBox();
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ida y Vuelta", "Ida"}));
		comboBox.setToolTipText("");
		comboBox.setName("comboBoxIda");
		comboBox.setBounds(153, 126, 88, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox_1.setToolTipText("");
		comboBox_1.setName("comboBoxIda");
		comboBox_1.setBounds(265, 126, 57, 21);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox_2.setToolTipText("");
		comboBox_2.setName("comboBoxIda");
		comboBox_2.setBounds(353, 126, 57, 21);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox_3.setToolTipText("");
		comboBox_3.setName("comboBoxIda");
		comboBox_3.setBounds(446, 126, 57, 21);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Turista", "Business", "Primera"}));
		comboBox_4.setToolTipText("");
		comboBox_4.setName("comboBoxIda");
		comboBox_4.setBounds(526, 126, 74, 21);
		contentPane.add(comboBox_4);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(153, 234, 187, 126);
		contentPane.add(calendar);
		
		JCalendar calendar_1 = new JCalendar();
		calendar_1.setBounds(413, 234, 187, 126);
		contentPane.add(calendar_1);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();
				if(selectedItem.equals("Ida")){
                    calendar_1.setVisible(false);
                }else{
                    calendar_1.setVisible(true);
                }
			}
		});
		
	}
}
*/