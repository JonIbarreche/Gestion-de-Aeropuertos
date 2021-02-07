// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.text.DateFormat;
// import java.util.Calendar;
// import java.util.Properties;
// import java.util.logging.Level;

// public class Propiedades {
//     Properties properties = new Properties();
//     final String PROPERTIES_FILE = "app.properties";
//     String language = "ES";
//     Calendar lastAccess = null;

//     try{
//         properties.load(new BufferedReader(new FileReader(PROPERTIES_FILE)));
//         language = properties.getProperty("language", "ES");
//         long lastAccessInMillis = Long.valueOf(properties.getProperty("lastAccess"));
//         lastAccess = Calendar.getInstance();
//         lastAccess.setTimeInMillis(lastAccessInMillis);
//     }catch(Exception e){
//         logger.Log.getLOGGER().log(Level.SEVERE, e.toString());
//     }
//     System.out.println("Idioma: "+language);
//     if(lastAccess!=null){
//         String strLastAccess = (DateFormat.getDateTimeInstance()).format(lastAccess.getTime());
//         System.out.println("Ultimo acceso: " + strLastAccess);
//     }else{
//         System.out.println("Es la primera vez que usa esta aplicación");
//     }
    
//     properties.setProperty("language",language);
//     lastAccess=Calendar.getInstance();
//     String lastAccessInMillis = String.valueOf(lastAccess.getTimeInMillis());properties.setProperty("lastAccess",lastAccessInMillis);
//     try{
//         properties.store(new BufferedWriter(new FileWriter(PROPERTIES_FILE)), "Ejemplo Properties");
//     }catch(IOException ex){
//         logger.Log.getLOGGER().log(Level.SEVERE, ex.toString());
//     }
// }}