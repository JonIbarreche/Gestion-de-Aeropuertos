package Controladores;

import java.util.ArrayList;
import java.util.HashMap;

import BDAPI.BDAPI;



public class ControladorVuelos extends Controlador{
    
    protected static BDAPI bd;

    public ControladorVuelos() {
        super(bd);
		//TODO Auto-generated constructor stub
	}

	//Buscar Vuelo por origen
    // public ArrayList<HashMap<String, String>> showAllVuelos() {
    //     ArrayList<HashMap<String, String>> allVuelos = bd.getAllVuelos();
    //     if(allVuelos.length = 0){
    //         //Mostrar Ventana no se encontraron resultados
    //     }else{
    //         //Mostrar Ventana con resulatados
    //     }
        
    //     return null;
    // }
   

}
