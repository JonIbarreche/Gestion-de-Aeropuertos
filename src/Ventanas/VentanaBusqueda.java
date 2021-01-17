
package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class VentanaBusqueda extends JFrame {

	private JPanel contentPane1;
	private JTextField txtOrigen1;
	private JTextField txtDestino1;
	private JTextField textFechaIda;
	private JTextField txtFechaVuelta;
	private JTextField textHoraIda;
	private JTextField txtHoraVuelta;

    public VentanaBusqueda() {
		setBackground(new Color(0, 139, 139));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane1 = new JPanel();
		contentPane1.setBackground(new Color(0, 128, 128));
		contentPane1.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JPanel panelOrigen1 = new JPanel();
		panelOrigen1.setBounds(179, 124, 153, 44);
		contentPane1.add(panelOrigen1);
		panelOrigen1.setLayout(null);
		
		txtOrigen1 = new JTextField();
		txtOrigen1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtOrigen1.getText().equals("Origen")) {
					txtOrigen1.setText("");
				} else {
					txtOrigen1.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtOrigen1.getText().equals("")) {
					txtOrigen1.setText("Origen");
				}
			}
		});
		txtOrigen1.setText("");
		txtOrigen1.setBounds(10, 10, 133, 24);
		panelOrigen1.add(txtOrigen1);
		txtOrigen1.setColumns(10);
		
		JPanel panelOrigen2 = new JPanel();
		panelOrigen2.setBounds(179, 211, 153, 44);
		contentPane1.add(panelOrigen2);
		panelOrigen2.setLayout(null);
		
		textFechaIda = new JTextField();
		textFechaIda.setText("");
		textFechaIda.setBounds(10, 10, 133, 24);
		panelOrigen2.add(textFechaIda);
		
		JPanel panelOrigen3 = new JPanel();
		panelOrigen3.setBounds(421, 124, 153, 44);
		contentPane1.add(panelOrigen3);
		panelOrigen3.setLayout(null);
		
		txtDestino1 = new JTextField();
		txtDestino1.setText("");
		txtDestino1.setBounds(10, 10, 133, 24);
		panelOrigen3.add(txtDestino1);
		txtDestino1.setColumns(10);
		
		JPanel panelOrigen4 = new JPanel();
		panelOrigen4.setBounds(421, 211, 153, 44);
		contentPane1.add(panelOrigen4);
		panelOrigen4.setLayout(null);
		
		txtFechaVuelta = new JTextField();
		txtFechaVuelta.setText("");
		txtFechaVuelta.setBounds(10, 10, 133, 24);
		panelOrigen4.add(txtFechaVuelta);
		
		JTextField textHoraIda = new JTextField();
		textHoraIda.setText("");
		textHoraIda.setBounds(456, 291, 84, 21);
		contentPane1.add(textHoraIda);

		JTextField textHoraVuelta = new JTextField();
		// txtHoraVuelta.setText(VentanaInicio.vueloVuelta.getHora());
		txtHoraVuelta.setText("ddddd");
		textHoraVuelta.setBounds(215, 291, 84, 21);
		contentPane1.add(textHoraVuelta);
		
		JPanel panelCompra = new JPanel();
		panelCompra.setBackground(new Color(47, 79, 79));
		panelCompra.setForeground(new Color(47, 79, 79));
		panelCompra.setBounds(213, 358, 327, 60);
		contentPane1.add(panelCompra);
		panelCompra.setLayout(null);
		
		JLabel lblComprar = new JLabel("COMPRAR");
		lblComprar.setForeground(new Color(255, 255, 255));
		lblComprar.setBackground(new Color(255, 255, 255));
		lblComprar.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblComprar.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprar.setBounds(10, 10, 307, 40);
		panelCompra.add(lblComprar);
		
		JLabel lblX_1 = new JLabel("X");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cerrar la aplicacion?", "Confirmacion", JOptionPane.YES_NO_OPTION) == 0) {
					VentanaBusqueda.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX_1.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX_1.setForeground(Color.WHITE);
			}
		});
		lblX_1.setForeground(new Color(255, 255, 255));
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setBounds(727, 0, 23, 21);
		contentPane1.add(lblX_1);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
