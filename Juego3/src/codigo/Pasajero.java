package codigo;
/**
 *
 * @author Cristian Andres Soto Mancilla
 */
import anchura.Busqueda_Anchura;
import static codigo.Constantes.DESPLAZAMIENTO;
import static codigo.Constantes.FUENTE1;
import static codigo.Constantes.TAMANO_CELDA;
import java.awt.Color;
import java.awt.Graphics;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class Pasajero extends TimerTask implements Constantes {

    public int xMov, yMov;
    public MundoVirtual mv;
    public Busqueda_Anchura ia;
    public int proximo_mov;
    public int desX, desY;

    public Pasajero(int x, int y, MundoVirtual mv) {
        xMov = x;
        yMov = y;
        this.mv = mv;
        proximo_mov = 1;
        destino();
        mv.escenario.darCelda(desX, desY).tipo = DESTINO_PASAJERO;
        ia = new Busqueda_Anchura(this, xMov, yMov, desX, desY);
    }

    public void inteligencia() {
        // Realizamos la busqueda desde el pasajero hacia el destino.
        ia.busqueda();
        // Mostraremos los pasos a realizar.
        System.out.println(ia.pasos);
        // Reseteamos el proximo moviemiento en caso de que se ejecute nuevamente la inteligencia.
        proximo_mov = 1;
    }

    public void moverArriba() {
        if (yMov > 0) {
            if (mv.escenario.celdas[xMov][yMov - 1].tipo != OBSTACULO_NEGRO) {
                yMov -= 1;
            }
        }
    }

    public void moverAbajo() {
        if (yMov < LARGO_ESCENARIO - 1) {
            if (mv.escenario.celdas[xMov][yMov + 1].tipo != OBSTACULO_NEGRO) {
                yMov += 1;
            }
        }
    }

    public void moverIzquierda() {
        if (xMov != 0) {
            if (mv.escenario.celdas[xMov - 1][yMov].tipo != OBSTACULO_NEGRO) {
                xMov -= 1;
            }
        }
    }

    public void moverDerecha() {
        if (xMov < ANCHO_ESCENARIO - 1) {
            if (mv.escenario.celdas[xMov + 1][yMov].tipo != OBSTACULO_NEGRO) {
                xMov += 1;
            }
        }
    }

    // Pintamos al pasajero.
    public void paintCelda(Graphics g) {

        g.drawRect(xMov * TAMANO_CELDA + DESPLAZAMIENTO, yMov * TAMANO_CELDA + DESPLAZAMIENTO, TAMANO_CELDA, TAMANO_CELDA);
        g.setColor(Color.green);//cambiamos color
        g.fillRect(xMov * TAMANO_CELDA + DESPLAZAMIENTO, yMov * TAMANO_CELDA + DESPLAZAMIENTO, TAMANO_CELDA, TAMANO_CELDA);
        g.setColor(Color.BLACK);//volvemos a cambiar 
        g.setColor(Color.BLACK);//volvemos a cambiar 
        g.setFont(FUENTE1);
        g.drawString("E", (xMov * TAMANO_CELDA + DESPLAZAMIENTO) + 5, (yMov * TAMANO_CELDA + DESPLAZAMIENTO) + 28);
    }

    @Override
    public void run() {
        String mov = "";
        // Recorreremos los pasos obtenidos por la inteligencia artificial.
        if (proximo_mov < ia.pasos.size()) {
            // Obtenemos el movimiento a realizar.
            mov = ia.pasos.get(proximo_mov);
            System.out.println(mov);
            actualizarEntidad();
            realizar_Movimiento(mov);
            actualizarEntidad();
            proximo_mov++;
        } else {
            lanzar_mensaje("El pasajero llego a su destino!");
            this.mv.escenario.celdas[xMov][yMov].tipo = OBSTACULO_AZUL;
            this.cancel();
        }
    }

    private void realizar_Movimiento(String mov) {

        switch (mov) {
            case "arriba":
                moverArriba();
                break;
            case "abajo":
                moverAbajo();
                break;
            case "izquierda":
                moverIzquierda();
                break;
            case "derecha":
                moverDerecha();
                break;
        }
    }
    
    private void actualizarEntidad() {
        mv.repaint();
    }

    public boolean fin() {
        return proximo_mov > ia.pasos.size();
    }
    // El destino sera cualquier casa azul (random) a la cual se dirigira el pasajero.
    public void destino(){
        int numRandom = getNumeroRandom(0,25);
        for (int i = 0; i < 25; i++) {
            if (numRandom == i) {
                desX = mv.celdaX.get(i);
                desY = mv.celdaY.get(i);
            }
        }
    }
    
    private int getNumeroRandom(int min, int max){
       return ThreadLocalRandom.current().nextInt(min, max);
   }
}
