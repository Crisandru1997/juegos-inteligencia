package codigo;
/**
 * 
 * @author Cristian Andres Soto Mancilla
 * 19.461.599-K
 */
import java.awt.Graphics;
import javax.swing.JComponent;

public class Escenario extends JComponent implements Constantes{
    
    public Celda[][] celdas;

    //Creamos el escenario con las celdas.
    public Escenario() {
        celdas = new Celda[ANCHO_ESCENARIO][LARGO_ESCENARIO];
        for (int i = 0; i < ANCHO_ESCENARIO; i++) {
            for (int j = 0; j < LARGO_ESCENARIO; j++) {
                // Todas las celdas por defecto seran de tipo camino.
                celdas[i][j] = new Celda(i*TAMANO_CELDA+DESPLAZAMIENTO, 
                        j*TAMANO_CELDA+DESPLAZAMIENTO, CAMINO);
            }
        }
    }
    
    public Celda darCelda(int x, int y){
        Celda resultado = null;
        for (int i = 0; i < ANCHO_ESCENARIO; i++) {
            for (int j = 0; j < LARGO_ESCENARIO; j++) {
                if (i == x && j == y) {
                    resultado = celdas[i][j];
                }
            }
        }
        return resultado;
    }
    
    @Override
    public void paintComponent(Graphics g){
        for (int i = 0; i < ANCHO_ESCENARIO; i++) {
            for (int j = 0; j < LARGO_ESCENARIO; j++) {
                celdas[i][j].paintComponent(g);
            }
        }
    }
}
