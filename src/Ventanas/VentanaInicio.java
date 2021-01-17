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
import Jerarquias.Vuelo;

public class VentanaInicio extends JFrame {

    //VARIABLES VENTANA
    private BDAPI bd = new BDAPI();
    private JPanel panelInicio;
    private JPanel panelDatos;
    private Dimension frameSize;
    
    private Dimension sizeBotones;
    private Insets insets;

    private boolean hilo;

    // VARIABLES PANEL INICIO
    private JComboBox comboIdaVuelta;
    private JComboBox comboAdulto;
    private JComboBox comboNinyo;
    private JComboBox comboMaleta;
    private JComboBox comboClase;
    private JTextField textOrigen;
    private JTextField textDestino;
    private JTextField textOrigen2;
    private JTextField textDestino2;
    private JTextField textFechaIda;
    private JTextField textFechaVuelta;
    private JButton botonBuscar;

    public static Vuelo vueloIda;
    public static Vuelo vueloVuelta;
    public static int[] opcionesVuelo = new int[5];

    //VARIABLES PANEL DATOS
    private JTextField textOrigenDatos;
    private JTextField textDestinoDatos;
    private JTextField textFechaIdaDatos;
    private JTextField textFechaVueltaDatos;
    private JTextField textHoraIdaDatos;
    private JTextField textHoraVueltaDatos;

    private JButton botonComprar;
    
    // VENTANA INICIOS
    public VentanaInicio() {

        setTitle("Encuentra tu vuelo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSize = new Dimension(950, 650);
        setPreferredSize(new Dimension(frameSize.width, frameSize.height));
        setResizable(false);
        pack();

        panelInicio = new JPanel();
        panelInicio.setLayout(null);
        panelInicio.setVisible(true);
        panelInicio.setBackground(new Color(0, 139, 139));

        panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.setVisible(false);
        panelDatos.setBackground(new Color(0, 139, 139));

               //PANEL INICIO

        comboIdaVuelta = new JComboBox();
        comboAdulto = new JComboBox();
        comboNinyo = new JComboBox();
        comboMaleta = new JComboBox();
        comboClase = new JComboBox();
        textOrigen = new JTextField(20);
        textDestino = new JTextField(20);
        textOrigen2 = new JTextField(20);
        textDestino2 = new JTextField(20);
        textFechaIda = new JTextField(10);
        textFechaVuelta = new JTextField(10);
        botonBuscar = new JButton("Buscar");
        JLabel labelTitulo = new JLabel("Encuentra tu vuelo");
        JLabel labelIdaVuelta = new JLabel("Tipo de  billete: ");
        JLabel labelAdulto = new JLabel("Adultos: ");
        JLabel labelNinyo = new JLabel("Ninyos: ");
        JLabel labelMaleta = new JLabel("Maletas: ");
        JLabel labelClase = new JLabel("Clase:  ");

        textOrigen.setText("Origen");
        textDestino.setText("Destino");
        textOrigen2.setText("");
        textDestino2.setText("");
        textFechaIda.setText("dd/mm/aaaa");
        textFechaVuelta.setText("dd/mm/aaaa");
        comboIdaVuelta.addItem("Ida");
        comboIdaVuelta.addItem("Ida y Vuelta");
        comboClase.addItem("Turista");
        comboClase.addItem("Business");
        comboClase.addItem("Primera");

        for (int i = 0; i <= 10; i++) {
            comboAdulto.addItem(i);
            comboNinyo.addItem(i);
            comboMaleta.addItem(i);
        }

        insets = panelInicio.getInsets();

        labelTitulo.setBounds(120 + insets.left, 65 + insets.top, 185, 40);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setBorder(new LineBorder(new Color(0, 0, 139), 2));

        labelIdaVuelta.setBounds(120 + insets.left, 180 + insets.top, 90, 20);
        comboIdaVuelta.setBounds(210 + insets.left, 180 + insets.top, 100, 20);
        labelAdulto.setBounds(320 + insets.left, 180 + insets.top, 50, 20);
        comboAdulto.setBounds(370 + insets.left, 180 + insets.top, 40, 20);
        labelNinyo.setBounds(430 + insets.left, 180 + insets.top, 50, 20);
        comboNinyo.setBounds(480 + insets.left, 180 + insets.top, 40, 20);
        labelMaleta.setBounds(540 + insets.left, 180 + insets.top, 60, 20);
        comboMaleta.setBounds(600 + insets.left, 180 + insets.top, 40, 20);
        labelClase.setBounds(660 + insets.left, 180 + insets.top, 50, 20);
        comboClase.setBounds(700 + insets.left, 180 + insets.top, 80, 20);
        textOrigen.setBounds(200 + insets.left, 275 + insets.top, 240, 40);
        textDestino.setBounds(475 + insets.left, 275 + insets.top, 240, 40);
        textOrigen2.setBounds(200 + insets.left, 340 + insets.top, 240, 40);
        textDestino2.setBounds(475 + insets.left, 340 + insets.top, 240, 40);
        textFechaIda.setBounds(275 + insets.left, 405 + insets.top, 95, 40);
        textFechaVuelta.setBounds(550 + insets.left, 405 + insets.top, 95, 40);
        botonBuscar.setBounds(410 + insets.left, 470 + insets.top, 95, 40);

        panelInicio.add(labelTitulo);
        panelInicio.add(labelIdaVuelta);
        panelInicio.add(comboIdaVuelta);
        panelInicio.add(labelAdulto);
        panelInicio.add(comboAdulto);
        panelInicio.add(labelNinyo);
        panelInicio.add(comboNinyo);
        panelInicio.add(labelMaleta);
        panelInicio.add(comboMaleta);
        panelInicio.add(labelClase);
        panelInicio.add(comboClase);
        panelInicio.add(textOrigen);
        panelInicio.add(textDestino);
        panelInicio.add(textOrigen2);
        panelInicio.add(textDestino2);
        panelInicio.add(textFechaIda);
        panelInicio.add(textFechaVuelta);

        panelInicio.add(botonBuscar);

        hilo = true;
        Runnable text = new Runnable() {
            @Override
            public void run() {
                while (hilo == true) {
                    textOrigen2.setText(textDestino.getText());
                    textDestino2.setText(textOrigen.getText());
                }
            }
        };
        Thread textThread = new Thread(text);
        textThread.start();

        try {
            botonBuscar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
    
                    String selectedItem = (String) comboIdaVuelta.getSelectedItem();
                    if (selectedItem.equals("Ida")) {
                        String origen = textOrigen.getText();
                        String destino = textDestino.getText();
                        String fecha = textFechaIda.getText();
                        
                        vueloIda = bd.getVueloEspecifico(origen, destino, fecha);
    
                        opcionesVuelo[4] = 1;
                    } else {
                        String origen = textOrigen.getText();
                        String destino = textDestino.getText();
                        String fecha = textFechaIda.getText();
    
                        String origenVuelta = textOrigen2.getText();
                        String destinoVuelta = textDestino2.getText();
                        String fechaVuelta = textFechaVuelta.getText();
    
                        vueloIda = bd.getVueloEspecifico(origen, destino, fecha);
                        vueloVuelta = bd.getVueloEspecifico(origenVuelta, destinoVuelta, fechaVuelta);
    
                        opcionesVuelo[4] = 2;
                    }
                    opcionesVuelo[0] = (int) comboAdulto.getSelectedItem();
                    opcionesVuelo[1] = (int) comboNinyo.getSelectedItem();
                    opcionesVuelo[2] = (int) comboMaleta.getSelectedItem();
                    
                    if ((String)comboClase.getSelectedItem() == "Turista") {
                        opcionesVuelo[3] = 1;
                    } else if ((String) comboClase.getSelectedItem() == "Business") {
                        opcionesVuelo[3] = 2;
                    } else {
                        opcionesVuelo[3] = 3;
                    }
                    System.out.println(vueloIda);
                    System.out.println(vueloVuelta);
                    
                    VentanaDatos ventanaDatos = new VentanaDatos();
                    ventanaDatos.setVisible(true);
                    setVisible(false);
                    
                    textThread.interrupt();
                }
            });
        } catch (Exception e) {
            //TODO: handle exception
        }
        

        textOrigen2.setVisible(false);
        textDestino2.setVisible(false);
        textFechaVuelta.setVisible(false);
        comboIdaVuelta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboIdaVuelta.getSelectedItem();
                if (selectedItem.equals("Ida y Vuelta")) {
                    textOrigen2.setVisible(true);
                    textDestino2.setVisible(true);
                    textFechaVuelta.setVisible(true);
                } else {
                    textOrigen2.setVisible(false);
                    textDestino2.setVisible(false);
                    textFechaVuelta.setVisible(false);
                }
            }
        });

    //PANEL DATOS
        
    // insets = panelInicio.getInsets();
    

    // textOrigenDatos = new JTextField(20);
    // textDestinoDatos = new JTextField(20);
    // textFechaIdaDatos = new JTextField(10);
    // textFechaVueltaDatos = new JTextField(10);
    // textHoraIdaDatos = new JTextField(10);
    // textHoraVueltaDatos = new JTextField(10);
    // botonComprar = new JButton("Comprar");
    
    // if (opcionesVuelo[4] == 1) {
        
    //     textOrigenDatos.setText(vueloIda.getAeropuertOrigen().getCiudad());
    //     textDestinoDatos.setText(vueloIda.getAeropuertOrigen().getCiudad());
    //     textFechaIdaDatos.setText(vueloIda.getFecha());
    //     textHoraIdaDatos = new JTextField(vueloIda.getHora());

    // } else {

    //     textOrigenDatos.setText(vueloIda.getAeropuertOrigen().getCiudad());
    //     textDestinoDatos.setText(vueloIda.getAeropuertOrigen().getCiudad());
    //     textFechaIdaDatos.setText(vueloIda.getFecha());
    //     textFechaVueltaDatos.setText(vueloVuelta.getFecha());
    //     textHoraIdaDatos.setText(vueloIda.getHora());
    //     textHoraVueltaDatos.setText(vueloVuelta.getHora());
    // }
    
    // textOrigenDatos.setBounds(200 + insets.left, 275 + insets.top, 240, 40);
    // textDestinoDatos.setBounds(475 + insets.left, 275 + insets.top, 240, 40);
    // textOrigenDatos.setBounds(200 + insets.left, 340 + insets.top, 240, 40);
    // textDestinoDatos.setBounds(475 + insets.left, 340 + insets.top, 240, 40);
    // textFechaIdaDatos.setBounds(275 + insets.left, 405 + insets.top, 95, 40);
    // textFechaVueltaDatos.setBounds(550 + insets.left, 405 + insets.top, 95, 40);
    // botonComprar.setBounds(410 + insets.left, 470 + insets.top, 95, 40);
    
    // panelDatos.add(textOrigenDatos);
    // panelDatos.add(textDestinoDatos);
    // panelDatos.add(textFechaIdaDatos);
    // panelDatos.add(textFechaVueltaDatos);
    // panelDatos.add(textHoraIdaDatos);
    // panelDatos.add(textHoraVueltaDatos);
    // panelDatos.add(botonComprar);

    add(panelInicio);
    // add(panelDatos);
    }
}