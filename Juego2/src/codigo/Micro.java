package codigo;

/**
 *
 * @author Cristian Andres Soto Mancilla
 */
import static codigo.Constantes.DESPLAZAMIENTO;
import static codigo.Constantes.TAMANO_CELDA;
import java.awt.Color;
import java.awt.Graphics;
import java.util.TimerTask;

class Micro extends TimerTask implements Constantes {

    public int x, y;
    public MundoVirtual mv;
    public String nombre;
    public static int cantidad_pasajeros;

    public Micro(int x, int y, MundoVirtual mv, String nombre) {
        this.mv = mv;
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.cantidad_pasajeros = 0;
    }

    @Override
    public void run() {
        // En caso de que la posicion de la micro es igual a la del pasajero, subimos al pasajero.
        if (mv.escenario.darCelda(x, y).tipo == PASAJERO) {
            cantidad_pasajeros++;
            System.out.println("Pasajeros: "+cantidad_pasajeros+"\n");
            // Pintamos el lugar donde estaba el pasajero de color del camino nuevamente.
            mv.escenario.darCelda(x, y).tipo = CAMINO;
        }
        
        // Esta sección del codigo se encarga de mover el autobus por todo el borde del mapa.
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
    // Repintamos el escenario para que se aprecie el movimiento del autobus.
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

    // Pintamos al autobus, en este caso sera de color rojo y tendra la cantidad de pasajeros al centro.
    public void paintComponent(Graphics g) {
        g.drawRect(x * TAMANO_CELDA + DESPLAZAMIENTO, y * TAMANO_CELDA + DESPLAZAMIENTO, TAMANO_CELDA, TAMANO_CELDA);
        g.setColor(Color.RED);//cambiamos color
        g.fillRect(x * TAMANO_CELDA + DESPLAZAMIENTO, y * TAMANO_CELDA + DESPLAZAMIENTO, TAMANO_CELDA, TAMANO_CELDA);
        g.setColor(Color.BLACK);//volvemos a cambiar 
        g.setFont(FUENTE1);
        g.drawString(cantidad_pasajeros+"", (x * TAMANO_CELDA + DESPLAZAMIENTO) + 5, (y * TAMANO_CELDA + DESPLAZAMIENTO) + 28);
    }

}
