package codigo;
/**
 * 
 * @author Cristian Andres Soto Mancilla
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Jugador extends JComponent implements Constantes {

    public int x, y;
    public static int totalComido;
    public Jugador(int x, int y) {
        this.x = x;
        this.y = y;
        this.totalComido = 0;
    }

    public void moverArriba() {
        y -= 1;
    }

    public void moverAbajo() {
        y += 1;
    }

    // Pintamos al jugador (Cuadrado de color verde y con una letra 'J' al medio)
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x * TAMANO_CELDA + DESPLAZAMIENTO, y * TAMANO_CELDA + DESPLAZAMIENTO, TAMANO_CELDA, TAMANO_CELDA);
        g.setColor(Color.BLACK);
        g.setFont(FUENTE1);
        g.drawString("J", (x*TAMANO_CELDA+DESPLAZAMIENTO)+17, (y*TAMANO_CELDA+DESPLAZAMIENTO)+33);
        g.drawRect(x * TAMANO_CELDA + DESPLAZAMIENTO, y * TAMANO_CELDA + DESPLAZAMIENTO, TAMANO_CELDA, TAMANO_CELDA);
        g.setColor(Color.WHITE);
        g.fillRect(x * TAMANO_CELDA + DESPLAZAMIENTO, (y * TAMANO_CELDA + DESPLAZAMIENTO)-16, TAMANO_CELDA, TAMANO_CELDA/3);
        g.setColor(Color.BLACK);
        g.setFont(FUENTE2);
        g.drawString(totalComido+"", (x*TAMANO_CELDA+DESPLAZAMIENTO)+21, (y*TAMANO_CELDA+DESPLAZAMIENTO)-3);
    }
}
