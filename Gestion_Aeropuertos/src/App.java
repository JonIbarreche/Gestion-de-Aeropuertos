import javax.swing.SwingUtilities;
import java.awt.EventQueue;

public class App {
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				Login frameLogin = new Login();
				frameLogin.setVisible(true);
				//Inicio frameInicio = new Inicio();
				//frameInicio.setVisible(true);
					//locations Locations = new ocations();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
