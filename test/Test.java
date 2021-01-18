import java.awt.Dimension;
import org.junit.jupiter.api.Test;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BDAPI.BDAPI;
import Jerarquias.Cliente;

class Test {
    BDAPI bd = new BDAPI();
    
    @Test
    public void clienteEspecifico() {
        Cliente clienteReal = new Cliente("ssc1999", "1234", "72858016L", "sergio", "Salgado", "ssc1099.csmm@gmail.com", "67867894");
        Cliente clienteBd = bd.getClienteEspecifico(ssc1999);

        boolean iguales = (clienteReal).equals(clienteBd);
		assertTrue(iguales);
    }
}

