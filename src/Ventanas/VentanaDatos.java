package Ventanas;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import BDAPI.BDAPI;
import Jerarquias.Aeropuerto;
import Jerarquias.Billete;
import Jerarquias.Vuelo;

public class VentanaDatos extends JFrame {

    //VARIABLES VENTANA
    private BDAPI bd = new BDAPI();

    private JPanel panelDatos;
    private Dimension frameSize;
    
    private Dimension sizeBotones;
    private Insets insets;

    private boolean hilo;

    // VARIABLES PANEL INICIO

    //VARIABLES PANEL DATOS
    private JTextField textOrigenDatos;
    private JTextField textDestinoDatos;
    private JTextField textFechaIdaDatos;
    private JTextField textFechaVueltaDatos;
    private JTextField textHoraIdaDatos;
    private JTextField textHoraVueltaDatos;

    private JButton botonComprar;

    private float precioIda;
    private float precioVuelta;
    private float precioTotal;
    
    // VENTANA INICIOS
    public VentanaDatos() {

    setTitle("Ventana de compra");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameSize = new Dimension(950, 650);
    setPreferredSize(new Dimension(frameSize.width, frameSize.height));
    setResizable(false);
    pack();

    panelDatos = new JPanel();
    panelDatos.setLayout(null);
    panelDatos.setVisible(true);
    panelDatos.setBackground(new Color(0, 139, 139));

    JMenuBar menu = new JMenuBar();
    JMenu menuOpciones= new JMenu("Opciones");
    JMenuItem volver = new JMenuItem("Volver");
    
    menuOpciones.add(volver);
    menu.add(menuOpciones);
    setJMenuBar(menu);
    menu.setVisible(true);
        
    insets = panelDatos.getInsets();
    
    textOrigenDatos = new JTextField(20);
    textDestinoDatos = new JTextField(20);
    textFechaIdaDatos = new JTextField(10);
    textFechaVueltaDatos = new JTextField(10);
    textHoraIdaDatos = new JTextField(10);
    textHoraVueltaDatos = new JTextField(10);
    botonComprar = new JButton("Comprar");

    precioIda = (VentanaInicio.vueloIda.getPrecioBaseAdulto() * VentanaInicio.opcionesVuelo[0]) + (VentanaInicio.vueloIda.getPrecioBaseNinyio() * VentanaInicio.opcionesVuelo[1]) + (VentanaInicio.vueloIda.getPrecioBaseAdulto() * VentanaInicio.opcionesVuelo[2]) + (VentanaInicio.vueloIda.getPrecioBaseAdulto() * VentanaInicio.opcionesVuelo[3]);

    precioVuelta = (VentanaInicio.vueloVuelta.getPrecioBaseAdulto() * VentanaInicio.opcionesVuelo[0]) + (VentanaInicio.vueloVuelta.getPrecioBaseNinyio() * VentanaInicio.opcionesVuelo[1]) + (VentanaInicio.vueloVuelta.getPrecioBaseAdulto() * VentanaInicio.opcionesVuelo[2]) + (VentanaInicio.vueloVuelta.getPrecioBaseAdulto() * VentanaInicio.opcionesVuelo[3]);

    textOrigenDatos.setBounds(200 + insets.left, 175 + insets.top, 240, 40);
    textDestinoDatos.setBounds(475 + insets.left, 175 + insets.top, 240, 40);
    textFechaIdaDatos.setBounds(200 + insets.left, 240 + insets.top, 240, 40);
    textFechaVueltaDatos.setBounds(475 + insets.left, 240 + insets.top, 240, 40);
    textHoraIdaDatos.setBounds(275 + insets.left, 305 + insets.top, 95, 40);
    textHoraVueltaDatos.setBounds(550 + insets.left, 305 + insets.top, 95, 40);
    botonComprar.setBounds(410 + insets.left, 470 + insets.top, 95, 40);
    
    if (VentanaInicio.opcionesVuelo[4] == 1) {
        
        textOrigenDatos.setText(VentanaInicio.vueloIda.getAeropuertOrigen().getCiudad());
        textDestinoDatos.setText(VentanaInicio.vueloIda.getAeropuertOrigen().getCiudad());
        textFechaIdaDatos.setText(VentanaInicio.vueloIda.getFecha());
        textHoraIdaDatos = new JTextField(VentanaInicio.vueloIda.getHora());
        textFechaVueltaDatos.setVisible(false);
        textHoraIdaDatos.setVisible(false);
        textHoraVueltaDatos.setVisible(false);

    } else {

        textOrigenDatos.setText(VentanaInicio.vueloIda.getAeropuertOrigen().getCiudad());
        textDestinoDatos.setText(VentanaInicio.vueloIda.getAeropuertOrigen().getCiudad());
        textFechaIdaDatos.setText(VentanaInicio.vueloIda.getFecha());
        textFechaVueltaDatos.setText(VentanaInicio.vueloVuelta.getFecha());
        textHoraIdaDatos.setText(VentanaInicio.vueloIda.getHora());
        textHoraVueltaDatos.setText(VentanaInicio.vueloVuelta.getHora());
        textFechaVueltaDatos.setVisible(true);
        textHoraIdaDatos.setVisible(true);
        textHoraVueltaDatos.setVisible(true);
    }
    
    volver.addActionListener(new ActionListener() {
        
        @Override
			public void actionPerformed(ActionEvent e) {
                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
                setVisible(false);
			}
    });
    
    botonComprar.addActionListener(new ActionListener() {

        @Override
			public void actionPerformed(ActionEvent e) {
                if(VentanaInicio.opcionesVuelo[4] == 1){
                    bd.editarBillete(new Billete(bd.getClienteEspecifico(VentanaLogin.usuario), VentanaInicio.vueloIda, VentanaInicio.opcionesVuelo[0], VentanaInicio.opcionesVuelo[1], VentanaInicio.opcionesVuelo[2], VentanaInicio.opcionesVuelo[3], precioIda), VentanaLogin.usuario);
                    precioTotal = precioIda;
            } else {
                bd.editarBillete(
                        new Billete(bd.getClienteEspecifico(VentanaLogin.usuario), VentanaInicio.vueloIda,
                                VentanaInicio.opcionesVuelo[0], VentanaInicio.opcionesVuelo[1],
                                VentanaInicio.opcionesVuelo[2], VentanaInicio.opcionesVuelo[3], precioIda),
                        VentanaLogin.usuario);
                System.out.println("Billete editado");
                bd.editarBillete(
                        new Billete(bd.getClienteEspecifico(VentanaLogin.usuario), VentanaInicio.vueloVuelta,
                                VentanaInicio.opcionesVuelo[0], VentanaInicio.opcionesVuelo[1],
                                VentanaInicio.opcionesVuelo[2], VentanaInicio.opcionesVuelo[3], precioVuelta),
                        VentanaLogin.usuario);
                precioTotal = precioIda + precioVuelta;
            }
                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
                setVisible(false);
			}
    });
    
    panelDatos.add(textOrigenDatos);
    panelDatos.add(textDestinoDatos);
    panelDatos.add(textFechaIdaDatos);
    panelDatos.add(textFechaVueltaDatos);
    panelDatos.add(textHoraIdaDatos);
    panelDatos.add(textHoraVueltaDatos);
    panelDatos.add(botonComprar);

    
    add(panelDatos);
    }
}