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


public class VentanaInicio extends JFrame {
    
    private JPanel panelInicio;
    private JPanel panelPago;
    
    // PanelInicio
    private JComboBox comboIdaVuelta;
    private JComboBox comboAdutlo;
    private JComboBox comboNinyo;
    private JComboBox comboMaleta;
    private JComboBox comboClase;
    private JTextField textOrigen;
    private JTextField textDestino;
    private JTextField textOrigen2;
    private JTextField textDestino2;
    private JButton botonBuscar;
    
    private Dimension frameSize;
    private Dimension sizeBotones;
    private Insets insets;

    private boolean hilo;

    // PanelPago


    public VentanaInicio(){

        setTitle("Encuentra tu vuelo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSize = new Dimension ( 950, 650 );
        setPreferredSize( new Dimension(frameSize.width, frameSize.height));
        setResizable(false);
        pack();

        panelInicio = new JPanel();
        panelInicio.setLayout(null);
        panelInicio.setVisible(true);

        setContentPane(panelInicio);
    
        comboIdaVuelta = new JComboBox();
        comboAdutlo =  new JComboBox();
        comboNinyo = new JComboBox();
        comboMaleta = new JComboBox();
        comboClase = new JComboBox();
        textOrigen = new JTextField(20);
        textDestino = new JTextField(20);
        textOrigen2 = new JTextField(20);
        textDestino2 = new JTextField(20);
        botonBuscar =  new JButton("Buscar");
        JLabel labelTitulo = new JLabel("Encuentra tu vuelo");
        JLabel labelIdaVuelta = new JLabel("Tipo de  billete: ");
        JLabel labelAdulto = new JLabel("Adultos: ");
        JLabel labelNinyo = new JLabel("Ninyos: ");
        JLabel labelMaleta = new JLabel("Maletas: ");
        JLabel labelClase = new JLabel("Clase:  ");
        JLabel marco = new JLabel("");
        
        textOrigen.setText("Origen");
        textDestino.setText("Destino");
        textOrigen2.setText("");
        textDestino2.setText("");
        comboIdaVuelta.addItem("Ida");
        comboIdaVuelta.addItem("Ida y Vuelta");
        comboClase.addItem("Turista");
        comboClase.addItem("Business");
        comboClase.addItem("Primera");

        for (int i = 0; i <= 10; i++) {
            comboAdutlo.addItem(i);
            comboNinyo.addItem(i);
            comboMaleta.addItem(i);
        }
        
        insets = panelInicio.getInsets();

        labelTitulo.setBounds(120 + insets.left, 65 +insets.top, 185, 40);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setBorder(new LineBorder(new Color(0, 0, 139), 2));

        marco.setBorder(new LineBorder(new Color(0, 0, 139), 2));
        marco.setBorder(new LineBorder(new Color(0, 0, 139), 2));

        labelIdaVuelta.setBounds(120 + insets.left, 180 +insets.top, 90, 20);
        comboIdaVuelta.setBounds(220 + insets.left, 180 +insets.top, 80, 20);
        labelAdulto.setBounds(320 + insets.left, 180 +insets.top, 50, 20);
        comboAdutlo.setBounds(370 + insets.left, 180 +insets.top, 40, 20);
        labelNinyo.setBounds(430 + insets.left, 180 +insets.top, 50, 20);
        comboNinyo.setBounds(480 + insets.left, 180 +insets.top, 40, 20);
        labelMaleta.setBounds(540 + insets.left, 180 +insets.top, 60, 20);
        comboMaleta.setBounds(600 + insets.left, 180 +insets.top, 40, 20);
        labelClase.setBounds(660 + insets.left, 180 +insets.top, 50, 20);
        comboClase.setBounds(700 + insets.left, 180 +insets.top, 80, 20);
        textOrigen.setBounds(200 + insets.left, 275 +insets.top, 240, 40);
        textDestino.setBounds(475 + insets.left, 275 +insets.top, 240, 40);
        textOrigen2.setBounds(200 + insets.left, 340 +insets.top, 240, 40);
        textDestino2.setBounds(475 + insets.left, 340 +insets.top, 240, 40);
        botonBuscar.setBounds(410 + insets.left, 405 +insets.top, 95, 40);

        panelInicio.add(labelTitulo);
        panelInicio.add(marco);
        panelInicio.add(labelIdaVuelta);
        panelInicio.add(comboIdaVuelta);
        panelInicio.add(labelAdulto);
        panelInicio.add(comboAdutlo);
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
        panelInicio.add(botonBuscar);

        hilo = true;
        Runnable text = new Runnable() {
            @Override
            public void run() {
                while(hilo == true){
                    textOrigen2.setText(textDestino.getText());
                    textDestino2.setText(textOrigen.getText());
                }
            }
        };
        Thread textThread = new Thread(text);
        textThread.start();
        
        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textThread.interrupt();
            }
        });

        textOrigen2.setVisible(false);
        textDestino2.setVisible(false);

        JComboBox comboIdaVuelta1 = comboIdaVuelta;
        comboIdaVuelta1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String selectedItem = (String) comboIdaVuelta1.getSelectedItem();
                if(selectedItem.equals("Ida y Vuelta")){
                    textOrigen2.setVisible(true);
                    textDestino2.setVisible(true);
                }else{
                    textOrigen2.setVisible(false);
                    textDestino2.setVisible(false);
                }
            }
        });
    }
}