package codigo;
/**
 * 
 * @author Cristian Andres Soto Mancilla
 * 19.461.599-K
 */
import static codigo.Constantes.DESPLAZAMIENTO;
import static codigo.Constantes.TAMANO_CELDA;
import java.awt.Color;
import java.awt.Graphics;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

class Sopaipilla extends TimerTask implements Constantes {

    public int x, y;
    public MundoVirtual mv;
    public String nombre;

    public Sopaipilla(int x, int y, MundoVirtual mv, String nombre) {
        this.mv = mv;
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }

    @Override
    public void run() {

        if (!fin()) {
            // Movemos a la sopaipilla y repintamos el escenario para que se vea reflejado el cambio.
            mv.repaint();
            moverIzquierda();
            mv.repaint();
        } else {
            // Cuando un jugador se coma una sopaipilla aumentara el total comido y saldra un mensaje por pantalla.
            lanzar_mensaje("YUMI YUMI");
            mv.jugador.totalComido++;
            // Ejecutamos nuevamente el mover izquierda para realizar un movimiento aleatorio.
            moverIzquierda();
        }
    }

    public void moverIzquierda() {
        // Si esta dentro del mapa
        if (x > 0) {
            x -= 1;
        } else {
            x = LARGO_ESCENARIO - 1;
            // Verificamos que sopaipilla debe moverse.
            // Sopaipilla #1 o Sopaipilla #2 
            if (nombre.equals("#1")) {
                int mov = posYAleatorio(0, LARGO_ESCENARIO - 1);
                y = mov;
            }else{
                int mov = posYAleatorio(0, LARGO_ESCENARIO - 1);
                y = mov;
            }
        }
    }
    // Pintamos y dibujamos la sopaipilla (Circular de color rojo y con una letra 'B' al centro)
    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x * TAMANO_CELDA + DESPLAZAMIENTO, y * TAMANO_CELDA + DESPLAZAMIENTO, TAMANO_CELDA, TAMANO_CELDA);
        g.setColor(Color.white);
        g.fillRect((x * TAMANO_CELDA + DESPLAZAMIENTO), (y * TAMANO_CELDA + DESPLAZAMIENTO) - 15, TAMANO_CELDA, TAMANO_CELDA / 2);
        g.setColor(Color.BLACK);
        g.setFont(FUENTE1);
        g.drawString("B", (x*TAMANO_CELDA+DESPLAZAMIENTO)+14, (y*TAMANO_CELDA+DESPLAZAMIENTO)+38);
        g.setColor(Color.BLACK);
        g.setFont(FUENTE2);
        g.drawString(nombre, (x * TAMANO_CELDA + DESPLAZAMIENTO) + 15, (y * TAMANO_CELDA + DESPLAZAMIENTO));
    }
    // Devolvemos un numero aleatorio dentro del rango del mapa.
    private int posYAleatorio(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
    // En caso de que el jugador se coma una sopaipilla devuelve true.
    private boolean fin() {
        return x == mv.jugador.x && y == mv.jugador.y;
    }

}
