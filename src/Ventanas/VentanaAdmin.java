package Ventanas;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
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
import BDAPI.DBException;
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
    private JTextField textPasajeros;
    private JButton botonPasajeros;
    private JButton botonGuardar;

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

        panelEditar = new JPanel();
        panelEditar.setLayout(new BorderLayout());
        panelEditar.setVisible(false);
        panelEditar.setBounds(0 + insets.left, 0 +insets.top, frameSize.width, frameSize.height - 40);
          
        JMenuBar menu = new JMenuBar();
        JMenu menuOpciones= new JMenu("Opciones");
        JMenuItem importar = new JMenuItem("Importar");
        
        menuOpciones.add(importar);
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

        panelMapa = new JPanel();
        panelMapa.setLayout(null);
        panelMapa.setBackground(Color.RED);
        
        botonBorrar =  new JButton("Borrar");
        botonEditar = new JButton("Editar");
    
        botonEditar.setBounds(590 + insetsAdmin.left, 525 +insetsAdmin.top, 80, 40);
        botonBorrar.setBounds(740 + insetsAdmin.left, 525 + insetsAdmin.top, 80, 40);
        panelScroll.setBounds(10 + insetsAdmin.left, 40 + insetsAdmin.top, 460, 450);
        panelMapa.setBounds(520 + insetsAdmin.left, 40 + insetsAdmin.top, 400, 450);


        
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
                
            }
        });
        cp.add(panelAdmin);
        //PanelEditar

        // importar.addActionListener(new ActionListener() {
			
		// 	@Override
		// 	public void actionPerformed(ActionEvent arg0) {
		// 		JFileChooser fileChooser = new JFileChooser();
		// 		FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheros CSV", "csv");
		// 		fileChooser.setFileFilter(filter); 	
                
        //         File selectedFile = fileChooser.getSelectedFile();                        
        //         bd.editarVuelo(readData(selectedFile));
        //         updateUI();
		// 	}
		// });

        // public ArrayList<Vuelo> readData(File file) throws IOException { 
        //     List<Vuelo> listaVuelos = new ArrayList<>();
        //     try(BufferedReader br = new BufferedReader(new FileReader(file))) {
        //         String line = "";
        //         while ((line = br.readLine()) != null) {  
        //             // lee el .csv separado por comas
        //             String[] vueloCsv = line.split(",");  
             
        //             // Crea el objeto estrella y lo guarda  
        //             Vuelo vuelo = new Vuelo(parseString(vueloCsv[0]), parseString(vueloCsv[1]), vueloCsv[2], vueloCsv[3], parseFloat(vueloCsv[4]), parseFloat(vueloCsv[5]), parseFloat(vueloCsv[6]), parseString(vueloCsv[7]), parseString(vueloCsv[8]), parseInt(vueloCsv[9]), parseInt(vueloCsv[10]), parseInt(vueloCsv[11]));  
    
        //             // Añade el objeto a la lista  
        //             listaVuelos.add(vuelo);         
        //      } 
        //     } catch (IOException e) {
        //         JOptionPane.showMessageDialog(AstronomicViewer.this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        //     }
        //     return listaVuelos;
        // }

        
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