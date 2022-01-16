package codigo;
/**
 * 
 * @author Cristian Andres Soto Mancilla
 */
import java.awt.Font;
import javax.swing.JOptionPane;

public interface Constantes {
    
    public final int TAMANO_CELDA = 33;
    public final int ANCHO_ESCENARIO = 22;
    public final int LARGO_ESCENARIO = 21;
    public final int DESPLAZAMIENTO = 30;
    
    public final char CAMINO = 'C'; // Camino o calles del mapa
    public final char DESTINO = 'D'; // Destino donde se baja el pasajero.
    public final char OBSTACULO_NEGRO = 'N'; 
    public final char OBSTACULO_AZUL = 'A'; // Casas del mapa.
    public final char PASAJERO = 'P';
    public final char DESTINO_PASAJERO = 'I'; // Destino o casa del pasajero.
    
    public final Font FUENTE1=new Font("sans-serif",Font.BOLD,15);
    
    default void lanzar_mensaje(String mensaje) {
          JOptionPane.showMessageDialog(null,
            mensaje,
            "Mundo Virtual",
             JOptionPane.PLAIN_MESSAGE);
    }
}
