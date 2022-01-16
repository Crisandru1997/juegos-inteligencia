package codigo;
/**
 * 
 * @author Cristian Andres Soto Mancilla
 * 19.461.599-K
 */
import java.awt.Font;
import javax.swing.JOptionPane;

interface Constantes {
    
    public final int TAMANO_CELDA = 33;
    public final int ANCHO_ESCENARIO = 22;
    public final int LARGO_ESCENARIO = 21;
    public final int DESPLAZAMIENTO = 30;
    
    public final char CAMINO = 'C';
    public final char PASAJERO = 'P';
    public final char OBSTACULO_NEGRO = 'N';
    public final char OBSTACULO_AZUL = 'A';
    
    public final Font FUENTE1=new Font("sans-serif",Font.BOLD,15);
    
    default void lanzar_mensaje(String mensaje) {
          JOptionPane.showMessageDialog(null,
            mensaje,
            "Mundo Virtual",
             JOptionPane.PLAIN_MESSAGE);
    }
}
