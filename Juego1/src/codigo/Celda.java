package codigo;
/**
 * 
 * @author Cristian Andres Soto Mancilla
 * 19.461.599-K
 */
import java.awt.Graphics;
import javax.swing.JComponent;

public class Celda extends JComponent implements Constantes{
    
    public int x, y;
    public char tipo;

    public Celda(int x, int y, char tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }
    
    @Override
    public void paintComponent(Graphics g){
        // Celdas seran de este tipo.
        switch(tipo){
            case CAMINO:
                g.drawRect(x, y, TAMANO_CELDA, TAMANO_CELDA);
                break;
        }
    }
}
