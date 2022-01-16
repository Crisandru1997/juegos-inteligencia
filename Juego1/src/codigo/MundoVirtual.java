package codigo;
/**
 * 
 * @author Cristian Andres Soto Mancilla
 */
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MundoVirtual extends Canvas implements Constantes {

    public Escenario escenario;
    public Jugador jugador;
    public Sopaipilla sopaipilla1;
    public Sopaipilla sopaipilla2;

    public MundoVirtual() {
        // Agregamos las entidades que interactuaran en el mapa.
        escenario = new Escenario();
        jugador = new Jugador(0, 0);
        sopaipilla1 = new Sopaipilla(9, 0, this, "#1"); //(pos_x, pos_y, sopaipilla, nombre)
        sopaipilla2 = new Sopaipilla(9, 9, this, "#2");
        // En caso de que se presione una tecla ingresaremos a esta sección.
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                identificarTecla(e);
                repaint();
            }
        });
        this.setFocusable(true);
    }

    public void identificarTecla(KeyEvent e) {
        
        switch (e.getKeyCode()) {
                // Movimiento hacia arriba.
                case KeyEvent.VK_UP:
                    if (jugador.y > 0) {
                        jugador.moverArriba();
                    }
                    break;
                // Movimiento hacia abajo.
                case KeyEvent.VK_DOWN:
                    if (jugador.y < LARGO_ESCENARIO - 1) {
                        jugador.moverAbajo();
                    }
                    break;
        }
    }

    // Pintamos y agregamos las entidades al mundo virtual.
    public void paint(Graphics g) {
        escenario.paintComponent(g);
        jugador.paintComponent(g);
        sopaipilla1.paintComponent(g);
        sopaipilla2.paintComponent(g);
    }


}
