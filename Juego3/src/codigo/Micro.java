package codigo;

/**
 *
 * @author Cristian Andres Soto Mancilla
 */
import static codigo.Constantes.DESPLAZAMIENTO;
import static codigo.Constantes.TAMANO_CELDA;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

class Micro extends TimerTask implements Constantes {

    public int x, y;
    public MundoVirtual mv;
    public static int cantidad_pasajeros;
    public Pasajero pasajero;
    public Timer lanzaTarea;

    public Micro(int x, int y, MundoVirtual mv) {
        this.mv = mv;
        this.x = x;
        this.y = y;
        this.cantidad_pasajeros = 0;
        lanzaTarea = new Timer();
    }
    
    @Override
    public void run() {
        
        // En caso de que el autobus llege al destino del pasajero, el pasajero se bajara del autobus.
        if (mv.escenario.darCelda(x, y).tipo == DESTINO) {
            
            cantidad_pasajeros--;
            mv.escenario.darCelda(x, y).tipo = CAMINO;
            // Creamos un nuevo pasajero el cual se bajara del autobus.
            pasajero = new Pasajero(x, y, mv);
            // Ejecutamos la inteligencia para que el pasajero busque su casa.
            pasajero.inteligencia();
            // Comenzara a moverse el pasajero.
            lanzaTarea.scheduleAtFixedRate(pasajero, 0, 300);
            
        }else{
            // En caso de que el autobus recoja al pasajero.
            if (mv.escenario.darCelda(x, y).tipo == PASAJERO) {
                cantidad_pasajeros++;
                mv.escenario.darCelda(x, y).tipo = CAMINO; // Pintamos la celda en la cual estaba el pasajero.
            }
        }
        
        // Esta sección del codigo se encarga del movimiento del autobus.
        if (y < LARGO_ESCENARIO - 1 && x < ANCHO_ESCENARIO-1 && x == 0) {
            actualizarEntidad();
            moverAbajo();
            actualizarEntidad();
        } else {
            if (x < ANCHO_ESCENARIO - 1 && y+1 == LARGO_ESCENARIO) {
                actualizarEntidad();
                moverDerecha();
                actualizarEntidad();
            }else{
                if (y > 0) {
                    actualizarEntidad();
                    moverArriba();
                    actualizarEntidad();
                }else{
                    if (x > 0) {
                        actualizarEntidad();
                        moverIzquierda();
                        actualizarEntidad();
                    }
                }
            }
        }
    }
    // En caso que el pasajero exista lo pintamos.
    public void pintarEscenario(Graphics g){
        if (pasajero != null) {
            pasajero.paintCelda(g);
        }
    }

    public void actualizarEntidad() {
        mv.repaint();
    }

    public void moverAbajo() {
        y += 1;
    }

    private void moverDerecha() {
        x += 1;
    }
    
    private void moverArriba() {
        y -= 1;
    }
    
    private void moverIzquierda() {
        x -= 1;
    }
    
    public void pintarPasajero(Graphics g){
        if (pasajero != null) {
            pasajero.paintCelda(g);
        }
    }

    public void paintComponent(Graphics g) {
        g.drawRect(x * TAMANO_CELDA + DESPLAZAMIENTO, y * TAMANO_CELDA + DESPLAZAMIENTO, TAMANO_CELDA, TAMANO_CELDA);
        g.setColor(Color.RED);//cambiamos color
        g.fillRect(x * TAMANO_CELDA + DESPLAZAMIENTO, y * TAMANO_CELDA + DESPLAZAMIENTO, TAMANO_CELDA, TAMANO_CELDA);
        g.setColor(Color.BLACK);//volvemos a cambiar 
        g.setFont(FUENTE1);
        g.drawString(cantidad_pasajeros+"", (x * TAMANO_CELDA + DESPLAZAMIENTO) + 5, (y * TAMANO_CELDA + DESPLAZAMIENTO) + 28);
        pintarPasajero(g);
    }

}
