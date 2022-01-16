package codigo;

/**
 *
 * @author Cristian Andres Soto Mancilla
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class Celda extends JComponent implements Constantes {

    public int x, y;
    public char tipo;
    public Rectangle rectanguloCelda;

    public Celda(int x, int y, char tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        rectanguloCelda = new Rectangle(this.x, this.y, TAMANO_CELDA, TAMANO_CELDA);
    }

    @Override
    public void paintComponent(Graphics g) {

        // Verificamos que tipo de celda es.
        switch (tipo) {
            case CAMINO:
                g.drawRect(x, y, TAMANO_CELDA, TAMANO_CELDA);
                break;
            case PASAJERO:
                g.setColor(Color.ORANGE);
                g.fillRect(x, y, TAMANO_CELDA, TAMANO_CELDA);
                g.setColor(Color.black);
                g.drawRect(x, y, TAMANO_CELDA, TAMANO_CELDA);
                break;
            case OBSTACULO_AZUL:
                g.setColor(Color.BLUE);
                g.fillRect(x, y, TAMANO_CELDA, TAMANO_CELDA);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, TAMANO_CELDA, TAMANO_CELDA);
                break;
            case OBSTACULO_NEGRO:
                g.setColor(Color.BLACK);
                g.fillRect(x, y, TAMANO_CELDA, TAMANO_CELDA);
                g.drawRect(x, y, TAMANO_CELDA, TAMANO_CELDA);
                break;

        }
    }
    // Esto sirve para identificar si se hizo click en una celda en especifico.
    public boolean contains(int clickX, int clickY) {
        return rectanguloCelda.contains(new Point(clickX, clickY));
    }
}
