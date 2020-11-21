import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class VentanaAdmin extends JFrame {
    
    private JPanel panelPrincipal;
    private JPanel panelAdmin;
    private JPanel panelEditar;

    //PanelAdmin
    private JPanel panelTabla;
    private JPanel panelMapa;
    
    private JButton botonEditar;
    private JButton botonBorrar;
    
    private Dimension frameSize;
    private Dimension sizeBotones;
    private Insets insets;

    private boolean hilo;

    //PanelEditar
    private JPanel panelEditarIzq;
    private JPanel panelEditarAbajo;
    private JTextField textOrigen;
    private JTextField textDestino;
    private JTextField textFecha;
    private JTextField textHora;
    private JTextField textPasajeros;
    private JButton botonPasajeros;
    private JButton botonGuardar;

    public VentanaAdmin(){
        
        setTitle("PanelAdmin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSize = new Dimension ( 950, 650 );
        setPreferredSize( new Dimension(frameSize.width, frameSize.height));
        setResizable(false);
        pack();

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setVisible(true);
      
        //PanelAdmin
        panelAdmin = new JPanel();
        panelAdmin.setLayout(null);
        panelAdmin.setVisible(true);
    
        panelMapa = new JPanel();
        panelMapa.setLayout(null);
        
        botonBorrar =  new JButton("Borrar");
        botonEditar = new JButton("Editar");
    
        insets = panelPrincipal.getInsets();
        
        botonEditar.setBounds(700 + insets.left, 525 +insets.top, 80, 40);
        botonBorrar.setBounds(550 + insets.left, 525 +insets.top, 80, 40);
        panelMapa.setBounds(450 + insets.left, 40 + insets.top, 450, 450);
        panelMapa.setBackground(Color.CYAN);
        
        panelAdmin.add(botonEditar);
        panelAdmin.add(botonBorrar);
        //panelAdmin.add(panelTabla);
        panelAdmin.add(panelMapa);
        
        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                panelEditar.setVisible(true);
                panelAdmin.setVisible(false);
            }
        });

        //PanelEditar
        panelEditar = new JPanel();
        panelEditar.setLayout(new BorderLayout());
        panelEditar.setVisible(false);
        
        panelEditarIzq = new JPanel(new GridLayout(5,2));
        panelEditarIzq.setVisible(true);

        panelEditarAbajo = new JPanel(new GridLayout(2,1));
        panelEditarAbajo.setVisible(true);

        panelEditar.add(panelEditarIzq, BorderLayout.WEST);
        panelEditar.add(panelEditarAbajo, BorderLayout.SOUTH);

        textOrigen = new JTextField(20);
        JLabel labelOrigen = new JLabel("Origen: ");
        textDestino = new JTextField(20);
        JLabel labelDestino= new JLabel("Destion: ");
        textFecha = new JTextField(20);
        JLabel labelFecha = new JLabel("Fecha: ");
        textHora = new JTextField(20);
        JLabel labelHora = new JLabel("Hora: ");
        textPasajeros = new JTextField(20);
        JLabel labelPasajeros = new JLabel("Número de pasajeros: ");
        botonPasajeros = new JButton("Pasajeros");
        botonGuardar = new JButton("Guardar");

        panelEditarIzq.add(labelOrigen);
        panelEditarIzq.add(textOrigen);
        panelEditarIzq.add(labelDestino);
        panelEditarIzq.add(textDestino);
        panelEditarIzq.add(labelFecha);
        panelEditarIzq.add(textFecha);
        panelEditarIzq.add(labelHora);
        panelEditarIzq.add(textHora);
        panelEditarIzq.add(labelPasajeros);
        panelEditarIzq.add(textPasajeros);

        panelEditarAbajo.add(botonPasajeros);
        panelEditarAbajo.add(botonGuardar);
        
        panelPrincipal.add(panelAdmin);
        panelPrincipal.add(panelEditar);
        setContentPane(panelPrincipal);
        //
        
    }
}