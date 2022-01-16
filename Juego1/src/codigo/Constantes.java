package codigo;
/**
 * 
 * @author Cristian Andres Soto Mancilla
 * 19.461.599-K
 */
import java.awt.Font;
import javax.swing.JOptionPane;

interface Constantes {
    
    public final int TAMANO_CELDA = 48; // Tamaño de la celda.
    public final int ANCHO_ESCENARIO = 10; // Ancho y Largo del escenario.
    public final int LARGO_ESCENARIO = 10;
    public final int DESPLAZAMIENTO = 30; // Desplazamiento del borde del mapa.
    
    public final char CAMINO = 'C'; // Identificamos las celdas de tipo camino con una 'C'
    
    public final Font FUENTE1=new Font("sans-serif",Font.BOLD,33);
    public final Font FUENTE2=new Font("Times New Roman",Font.BOLD,13);
    
    default void lanzar_mensaje(String mensaje) {
          JOptionPane.showMessageDialog(null,
            mensaje,
            "Mundo Virtual",
             JOptionPane.PLAIN_MESSAGE);
    }
}
