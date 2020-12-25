package Ventanas;

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
import javax.swing.text.AttributeSet.ColorAttribute;

public class VentanaAdmin extends JFrame {
    
    private JPanel panelPrincipal;
    private JPanel panelAdmin;
    private JPanel panelEditar;
    private Dimension frameSize;
    private Dimension sizeBotones;
    private Insets insets;
    private Insets insetsAdmin;
    private boolean hilo;
    
    //PanelAdmin
    private JPanel panelTabla;
    private JPanel panelMapa;   
    private JButton botonEditar;
    private JButton botonBorrar;

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
        
        Container cp = getContentPane();
        setTitle("PanelAdmin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSize = new Dimension ( 950, 650 );
        setSize( new Dimension(frameSize.width, frameSize.height));
        setResizable(false);
        
        cp.setLayout(null);

        insets = cp.getInsets();
        
        panelAdmin = new JPanel();
        panelAdmin.setLayout(null);
        panelAdmin.setVisible(true);
        panelAdmin.setBounds(0 + insets.left, 0 +insets.top, frameSize.width, frameSize.height);
        insetsAdmin = panelAdmin.getInsets();

        panelEditar = new JPanel();
        panelEditar.setLayout(new BorderLayout());
        panelEditar.setVisible(false);
        panelEditar.setBounds(0 + insets.left, 0 +insets.top, frameSize.width, frameSize.height - 40);
          
        // //PanelAdmin
        panelMapa = new JPanel();
        panelMapa.setLayout(null);
        panelMapa.setBackground(Color.RED);
        
        botonBorrar =  new JButton("Borrar");
        botonEditar = new JButton("Editar");
    
        botonEditar.setBounds(700 + insetsAdmin.left, 525 +insetsAdmin.top, 80, 40);
        botonBorrar.setBounds(550 + insetsAdmin.left, 525 +insetsAdmin.top, 80, 40);
        panelMapa.setBounds(450 + insetsAdmin.left, 40 + insetsAdmin.top, 450, 450);
        panelMapa.setBackground(Color.CYAN);
        
        panelAdmin.add(botonEditar);
        panelAdmin.add(botonBorrar);
        panelAdmin.add(panelMapa);
        //panelAdmin.add(panelTabla);
        
        
        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelAdmin.setVisible(false);
                panelEditar.setVisible(true);
                
            }
        });
        cp.add(panelAdmin);
        //PanelEditar
        
        panelEditarIzq = new JPanel(new GridLayout(5,2));
        panelEditarIzq.setVisible(true);

        panelEditarAbajo = new JPanel(new GridLayout(2,1));
        panelEditarAbajo.setVisible(true);

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
        
        panelEditar.add(panelEditarIzq, BorderLayout.WEST);
        panelEditar.add(panelEditarAbajo, BorderLayout.SOUTH);

         cp.add(panelEditar);
        

        
    }
}