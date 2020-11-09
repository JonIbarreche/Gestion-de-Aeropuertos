import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class VentanaInicio extends JFrame {
    
    private JPanel panelInicio;
    
    private JComboBox comboIdaVuelta;
    private JComboBox comboAdutlo;
    private JComboBox comboNinyo;
    private JComboBox comboMaleta;
    private JTextField textOrigen;
    private JTextField textDestino;
    private JTextField textOrigen2;
    private JTextField textDestino2;
    private JButton botonBuscar;
    
    private Dimension frameSize;
    private Dimension sizeBotones;
    private Insets insets;

    public VentanaInicio(){

        setTitle("Encuentra tu vuelo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSize = new Dimension ( 1050, 650 );
        setPreferredSize( new Dimension(frameSize.width, frameSize.height));
        setResizable(false);
        pack();

        panelInicio = new JPanel();
        panelInicio.setLayout(null);
        panelInicio.setVisible(true);
        panelInicio.setBackground(new Color(0, 128, 128));
        setContentPane(panelInicio);
    

        comboIdaVuelta = new JComboBox();
        comboAdutlo =  new JComboBox();
        comboNinyo = new JComboBox();
        comboMaleta = new JComboBox();
        textOrigen = new JTextField(20);
        textDestino = new JTextField(20);
        textOrigen2 = new JTextField(20);
        textDestino2 = new JTextField(20);
        botonBuscar =  new JButton("Buscar");
        JLabel titulo = new JLabel("Encuentra tu vuelo");
        JLabel marco = new JLabel("");
        
        textOrigen.setText("Origen");
        textDestino.setText("Destino");
        textOrigen2.setText(textDestino.getText());
        textDestino2.setText(textOrigen.getText());
        comboIdaVuelta.addItem("Ida");
        comboIdaVuelta.addItem("Ida y vuelta");

        for (int i = 0; i <= 10; i++) {
            comboAdutlo.addItem(i);
            comboNinyo.addItem(i);
            comboMaleta.addItem(i);
        }
        
        insets = panelInicio.getInsets();
        titulo.setBounds(120 + insets.left, 65 +insets.top, 185, 40);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBorder(new LineBorder(new Color(0, 0, 139), 2));

        marco.setBounds(140 + insets.left, 110 +insets.top, 700, 400);
        marco.setBorder(new LineBorder(new Color(0, 0, 139), 2));

        panelInicio.add(titulo);
        panelInicio.add(marco);
    }
}