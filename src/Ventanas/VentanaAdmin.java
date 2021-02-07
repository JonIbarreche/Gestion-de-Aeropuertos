package Ventanas;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;

import BDAPI.BDAPI;
import Jerarquias.Cliente;
import Jerarquias.Vuelo;

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
    private JScrollPane panelScroll;
    private JTable tabla;
    private DefaultTableModel model;
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
    private JTextField textAdulto;
    private JTextField textNinyio;
    private JTextField textMaleta;
    private JButton botonPasajeros;
    private JButton botonGuardar;

    //PanelPasajeros
    private JScrollPane panelScrollPasajeros;
    private JPanel panelPasajeros;
    private JTable tablaPasajeros;
    private DefaultTableModel modelPasajeros;
      
    private Vuelo vueloAdmin;

    private BDAPI bd = new BDAPI();

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
        panelAdmin.setBackground(new Color(0, 139, 139));

        panelEditar = new JPanel();
        panelEditar.setLayout(new BorderLayout());
        panelEditar.setVisible(false);
        panelEditar.setBounds(0 + insets.left, 0 + insets.top, frameSize.width - 100, frameSize.height - 100);
        panelEditar.setBackground(new Color(0, 139, 139));

        panelPasajeros = new JPanel();
        panelPasajeros.setLayout(null);
        panelPasajeros.setVisible(true);
        panelPasajeros.setBounds(0 + insets.left, 0 +insets.top, frameSize.width, frameSize.height);
        panelPasajeros.setBackground(new Color(0, 139, 139));
          
        JMenuBar menu = new JMenuBar();
        JMenu menuOpciones= new JMenu("Opciones");
        JMenuItem exportar = new JMenuItem("Exportar");
        JMenuItem volver = new JMenuItem("Volver");
        
        menuOpciones.add(exportar);
        menuOpciones.add(volver);
        menu.add(menuOpciones);
        setJMenuBar(menu);
        menu.setVisible(true);

        String[] columnas = { "Origen", "Destino", "Fecha", "Hora", "Asientos Disponibles"};
        model = new DefaultTableModel(null, columnas);
        
        List<Vuelo> listaVuelos = bd.getListaVuelos();
                
        for (Vuelo vuelo : listaVuelos) {
            Object[] i = { vuelo.getAeropuertOrigen().getCiudad(), vuelo.getAeropuertoDestino().getCiudad(),
                    vuelo.getFecha(), vuelo.getHora(),
                    String.valueOf(vuelo.getAsientosClase1() + vuelo.getAsientosClase2() + vuelo.getAsientosClase3()) };
            model.addRow(i);
            System.out.println(vuelo.getAeropuertOrigen().getCiudad());
        }
                
        tabla = new JTable(model);

        panelScroll = new JScrollPane();
        panelScroll.setViewportView(tabla);

        // panelMapa = new JPanel();
        ImagePanel panelMapa = new ImagePanel("img/mapa.jpg");
        panelMapa.setLayout(null);
        // panelMapa.setBackground(Color.RED);
        
        botonBorrar =  new JButton("Borrar");
        botonEditar = new JButton("Editar");
    
        botonEditar.setBounds(590 + insetsAdmin.left, 525 +insetsAdmin.top, 80, 40);
        botonBorrar.setBounds(740 + insetsAdmin.left, 525 + insetsAdmin.top, 80, 40);
        panelScroll.setBounds(10 + insetsAdmin.left, 40 + insetsAdmin.top, 460, 450);
        panelMapa.setBounds(520 + insetsAdmin.left, 40 + insetsAdmin.top, 400, 450);

        //////////////////////////////////////////////////////////////
        
		
        //////////////////////////////////////////////////////////////////
        // Imagen mapa = new Imagen();
        // panelMapa.add(mapa);
        panelAdmin.add(botonEditar);
        panelAdmin.add(botonBorrar);
        panelAdmin.add(panelScroll);
        panelAdmin.add(panelMapa);
        //panelAdmin.add(panelTabla);
        
        
        //Vuelos de la tabla 
        
        
        botonEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelAdmin.setVisible(false);
                panelEditar.setVisible(true);
                
                final int fila = tabla.getSelectedRow();
                vueloAdmin = bd.getVueloEspecifico((String) tabla.getValueAt(fila, 0), (String)tabla.getValueAt(fila, 1),
                        (String) tabla.getValueAt(fila, 2));              
            }
        });

        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final int fila = tabla.getSelectedRow();
                vueloAdmin = bd.getVueloEspecifico((String) tabla.getValueAt(fila, 0), (String)tabla.getValueAt(fila, 1),
                        (String) tabla.getValueAt(fila, 2));
                                                
                if (bd.getAdminEspecifico(VentanaLogin.usuario).getNivel() == 1) {
                    bd.eliminarVuelo(vueloAdmin);
                } else {
                    logger.Log.getLOGGER().info("No tiene permisos suficientes");
                }

            }
        });
        exportar.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("vuelos.csv");
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter buff = new BufferedWriter(writer);
                    buff.write("Vuelos actuales: ");
                    buff.newLine();

                    for (Vuelo vuelo : listaVuelos) {
                        buff.write(vuelo.getAeropuertOrigen().getCiudad() + ", " + vuelo.getAeropuertoDestino().getCiudad() + ", " + vuelo.getFecha() + ", " + vuelo.getHora() + ", " + String.valueOf(vuelo.getAsientosClase1() + vuelo.getAsientosClase2() + vuelo.getAsientosClase3()));
                        buff.newLine();
                    }

                    buff.flush();
                    buff.close();
                    writer.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            
            }
        });

        volver.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            panelEditar.setVisible(false);
            panelAdmin.setVisible(true);
            }
        });

        cp.add(panelAdmin);
        //PanelEditar

        panelEditarIzq = new JPanel(new GridLayout(5,2));
        panelEditarIzq.setVisible(true);

        panelEditarAbajo = new JPanel(new GridLayout(2,1));
        panelEditarAbajo.setVisible(true);
        
        
        textFecha = new JTextField(20);
        JLabel labelFecha = new JLabel("Fecha: ");
        textHora = new JTextField(20);
        JLabel labelHora = new JLabel("Hora: ");
        textAdulto = new JTextField(20);
        JLabel labelAdulto = new JLabel("Precio Adulto");
        textNinyio = new JTextField(20);
        JLabel labelNinyio = new JLabel("Precio Ninyio");
        textMaleta = new JTextField(20);
        JLabel labelMaleta = new JLabel("Precio Maleta");
        botonPasajeros = new JButton("Pasajeros");
        botonGuardar = new JButton("Guardar");
        
        //  textOrigen.setText(vueloAdmin.getAeropuertOrigen().getCiudad()); 
        //  textDestino.setText(vueloAdmin.getAeropuertoDestino().getCiudad());
        //  textFecha.setText(vueloAdmin.getFecha());  
        //  textHora.setText(vueloAdmin.getHora());

        botonGuardar.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
                vueloAdmin.setFecha(textFecha.getText());
                vueloAdmin.setHora(textHora.getText());
                vueloAdmin.setPrecioBaseAdulto((float) Double.parseDouble(textAdulto.getText()));
                vueloAdmin.setPrecioBaseNinyio((float) Double.parseDouble(textNinyio.getText()));
                vueloAdmin.setPrecioMaleta((float)Double.parseDouble(textMaleta.getText()));
                bd.editarVuelo(vueloAdmin);
            }
        });
         
        panelEditarIzq.add(labelFecha);
        panelEditarIzq.add(textFecha);
        panelEditarIzq.add(labelHora);
        panelEditarIzq.add(textHora);
        panelEditarIzq.add(labelAdulto);
        panelEditarIzq.add(textAdulto);
        panelEditarIzq.add(labelNinyio);
        panelEditarIzq.add(textNinyio);
        panelEditarIzq.add(labelMaleta);
        panelEditarIzq.add(textMaleta);

        panelEditarAbajo.add(botonPasajeros);
        panelEditarAbajo.add(botonGuardar);
        
        panelEditar.add(panelEditarIzq, BorderLayout.WEST);
        panelEditar.add(panelEditarAbajo, BorderLayout.EAST);

        botonPasajeros.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
                panelEditar.setVisible(false);
                panelPasajeros.setVisible(true);
        }});
        

        cp.add(panelEditar);

        // String[] columnasPasajeros = { "Dni", "Username", "Nombre", "Apellido", "Email"};
        // modelPasajeros = new DefaultTableModel(null, columnasPasajeros);
        
        // List<Cliente> listaClientes = bd.getClientesVuelo(vueloAdmin);
                
        // for (Cliente cliente : listaClientes) {
        //     Object[] i = { cliente.getDni(), cliente.getUsername(), cliente.getNombre(),
        //             cliente.getApellido(), cliente.getEmail() };
        //     model.addRow(i);
        // }
                
        // tablaPasajeros = new JTable(modelPasajeros);

        // panelScrollPasajeros = new JScrollPane();
        // panelScrollPasajeros.setViewportView(tablaPasajeros);

        // panelPasajeros.add(panelScrollPasajeros);

        // cp.add(panelPasajeros);
    }
}