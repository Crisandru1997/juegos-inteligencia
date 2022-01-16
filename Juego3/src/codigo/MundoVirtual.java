package codigo;

/**
 *
 * @author Cristian Andres Soto Mancilla
 */
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MundoVirtual extends Canvas implements Constantes {

    public Escenario escenario;
    public Micro autobus;
    public int xO, yO;
    public static int contador_1;
    public int numerox, numeroy;
    public ArrayList<Integer> celdaX;
    public ArrayList<Integer> celdaY;
    
    public MundoVirtual() {
        contador_1 = 0;
        escenario = new Escenario();
        autobus = new Micro(0, 0, this);
        xO = ANCHO_ESCENARIO - 1;
        yO = LARGO_ESCENARIO - 1;
        // Agregamos los obstaculos y las casas.
        agregarObstaculos();
        // Guardaremos las cordenadas de las casas.
        celdaX = new ArrayList<>();
        celdaY = new ArrayList<>();
        // Buscamos las casas de color azul dentro del mapa.
        encontrarCasas();
        // En caso de que hagamos click accederemos a esta sección del codigo.
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                buscarCelda(e);
                repaint();
            }
        });
        this.setFocusable(true);
    }
    // Agregamos los obstaculos y las casas.
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
    public void buscarCelda(MouseEvent evento) {

        int click1_x, click1_y;
        int click2_x, click2_y;

        for (int i = 0; i < ANCHO_ESCENARIO; i++) {
            for (int j = 0; j < LARGO_ESCENARIO; j++) {
                if (escenario.celdas[i][j].contains(evento.getX(), evento.getY())) {

                    contador_1 = contador_1 + 1;
                    // Verificamos el primer click
                    if (contador_1 == 1) {
                        click1_x = i;
                        click1_y = j;
                        // Pintamos ese cuadro donde se hizo click con el color del pasajero.
                        escenario.celdas[click1_x][click1_y].tipo = PASAJERO;
                    } else {
                        // Verificamos el segundo click
                        if (contador_1 == 2) {
                            click2_x = i;
                            click2_y = j;
                            // Pintamos ese cuadro donde se hizo click con el color del destino.
                            escenario.celdas[click2_x][click2_y].tipo = DESTINO;
                        } else {
                            // En caso de que se hagan mas de dos click, reiniciamos el contador.
                            if (contador_1 > 2) {
                                contador_1 = 0;
                            }
                        }
                    }
                }
            }
        }
    }
    public void paint(Graphics g) {
        escenario.paintComponent(g);
        autobus.paintComponent(g);
    }
    
    // Buscamos todos las casas que se encuentran en el mapa (casas de color azul)
    public void encontrarCasas(){
        for (int i = 0; i < ANCHO_ESCENARIO; i++) {
            for (int j = 0; j < LARGO_ESCENARIO; j++) {
                if (escenario.celdas[i][j].tipo == OBSTACULO_AZUL) {
                    celdaX.add(i);
                    celdaY.add(j);
                }
            }
        }
    }
    
}
