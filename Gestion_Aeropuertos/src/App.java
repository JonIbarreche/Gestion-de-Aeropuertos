import javax.swing.SwingUtilities;
import java.awt.EventQueue;

public class App {
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				VentanaLogin frameLogin = new VentanaLogin();
				frameLogin.setVisible(true);
				VentanaInicio frameInicio = new VentanaInicio();
				frameInicio.setVisible(true);
					//locations Locations = new ocations();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
