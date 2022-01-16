package codigo;

/**
 *
 * @author Cristian Andres Soto Mancilla
 */
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MundoVirtual extends Canvas implements Constantes {

    public Escenario escenario;
    public Micro autobus;
    public int xO, yO;

    public MundoVirtual() {
        escenario = new Escenario();
        autobus = new Micro(0, 0, this, "#1");
        xO = ANCHO_ESCENARIO - 1;
        yO = LARGO_ESCENARIO - 1;
        agregarObstaculos();
        // En caso de que se haga un click (agregue nuevo pasajero) entraremos a esta sección de codigo.
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                buscarCelda(e);
                repaint();
            }
        });
        this.setFocusable(true);
    }

    public void buscarCelda(MouseEvent evento) {

        for (int i = 0; i < ANCHO_ESCENARIO; i++) {
            for (int j = 0; j < LARGO_ESCENARIO; j++) {
                if (escenario.celdas[i][j].contains(evento.getX(), evento.getY())) {
                    xO = i;
                    yO = j;
                    // Pintamos de color amarillo al pasajero.
                    escenario.celdas[xO][yO].tipo = PASAJERO;
                }
            }
        }
    }

    public void paint(Graphics g) {
        escenario.paintComponent(g);
        autobus.paintComponent(g);
    }
    
    // Con esta funcion agregamos obstaculos al centro del mapa.
    public void agregarObstaculos(){
     
        for(int i=2;i<=21;i++){
            escenario.celdas[i][1].tipo = OBSTACULO_NEGRO;
            escenario.celdas[i][2].tipo = OBSTACULO_NEGRO;
            
            switch(i){
                case 3:{
                    escenario.celdas[i][2].tipo = OBSTACULO_AZUL;
                    i += 2;
                    break;
                }
                case 7:{
                    escenario.celdas[i][2].tipo = OBSTACULO_AZUL;
                    i += 2; 
                    break;
                }
                case 11:{
                     escenario.celdas[i][2].tipo = OBSTACULO_AZUL;
                     i += 2;
                     break;
                }
                case 15: {
                     escenario.celdas[i][2].tipo = OBSTACULO_AZUL;
                     i += 2;
                     break;
                }
                case 19:{
                    escenario.celdas[i][2].tipo = OBSTACULO_AZUL;
                    i += 2;
                    break;
                }
            }
        
        }
        
        for(int i=2;i<=21;i++){
            escenario.celdas[i][5].tipo = OBSTACULO_NEGRO;
            escenario.celdas[i][6].tipo = OBSTACULO_NEGRO;
            
            switch(i){
                   case 3:{
                    escenario.celdas[i][6].tipo = OBSTACULO_AZUL;
                    i += 2;
                    break;
                }
                case 7:{
                    escenario.celdas[i][6].tipo = OBSTACULO_AZUL;
                    i += 2; 
                    break;
                }
                case 11:{
                     escenario.celdas[i][6].tipo = OBSTACULO_AZUL;
                     i += 2;
                     break;
                }
                case 15: {
                     escenario.celdas[i][6].tipo = OBSTACULO_AZUL;
                     i += 2;
                     break;
                }
                case 19:{
                    escenario.celdas[i][6].tipo = OBSTACULO_AZUL;
                    i += 2;
                    break;
                }
            }
        }
        
        for(int i=2;i<=21;i++){
            escenario.celdas[i][9].tipo = OBSTACULO_NEGRO;
            escenario.celdas[i][10].tipo = OBSTACULO_NEGRO;
            
            
            switch (i){
                 case 3:{
                    escenario.celdas[i][10].tipo = OBSTACULO_AZUL;
                    i += 2;
                    break;
                }
                case 7:{
                    escenario.celdas[i][10].tipo = OBSTACULO_AZUL;
                    i += 2; 
                    break;
                }
                case 11:{
                     escenario.celdas[i][10].tipo = OBSTACULO_AZUL;
                     i += 2;
                     break;
                }
                case 15: {
                     escenario.celdas[i][10].tipo = OBSTACULO_AZUL;
                     i += 2;
                     break;
                }
                case 19:{
                    escenario.celdas[i][10].tipo = OBSTACULO_AZUL;
                    i += 2;
                    break;
                }
            }
    
        }
           for(int i=2;i<=21;i++){
            escenario.celdas[i][13].tipo = OBSTACULO_NEGRO;
            escenario.celdas[i][14].tipo = OBSTACULO_NEGRO;
            
            switch(i){
                 case 3:{
                    escenario.celdas[i][14].tipo = OBSTACULO_AZUL;
                    i += 2;
                    break;
                }
                case 7:{
                    escenario.celdas[i][14].tipo = OBSTACULO_AZUL;
                    i += 2; 
                    break;
                }
                case 11:{
                     escenario.celdas[i][14].tipo = OBSTACULO_AZUL;
                     i += 2;
                     break;
                }
                case 15: {
                     escenario.celdas[i][14].tipo = OBSTACULO_AZUL;
                     i += 2;
                     break;
                }
                case 19:{
                    escenario.celdas[i][14].tipo = OBSTACULO_AZUL;
                    i += 2;
                    break;
                }
            }
        }
        for(int i=2;i<=21;i++){
            escenario.celdas[i][17].tipo = OBSTACULO_NEGRO;
            escenario.celdas[i][18].tipo = OBSTACULO_NEGRO;
            
            switch(i){
                  case 3:{
                    escenario.celdas[i][18].tipo = OBSTACULO_AZUL;
                    i += 2;
                    break;
                }
                case 7:{
                    escenario.celdas[i][18].tipo = OBSTACULO_AZUL;
                    i += 2; 
                    break;
                }
                case 11:{
                     escenario.celdas[i][18].tipo = OBSTACULO_AZUL;
                     i += 2;
                     break;
                }
                case 15: {
                     escenario.celdas[i][18].tipo = OBSTACULO_AZUL;
                     i += 2;
                     break;
                }
                case 19:{
                    escenario.celdas[i][18].tipo = OBSTACULO_AZUL;
                    i += 2;
                    break;
                }
            }
            
        }
           
    }
}
