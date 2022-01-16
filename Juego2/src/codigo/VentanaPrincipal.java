package codigo;
/**
 * 
 * @author Cristian Andres Soto Mancilla
 */
import java.awt.Color;
import java.util.Timer;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{

    
    public MundoVirtual mv;
    public Timer lanzarTarea;
    
    public VentanaPrincipal() {
        
        mv = new MundoVirtual();
        this.getContentPane().add(mv);
        
        lanzarTarea = new Timer();
        lanzarTarea.scheduleAtFixedRate(mv.autobus, 0, 200);
        this.setTitle("Autobus recogiendo pasajeros");
        this.setSize(800, 800);
        this.getContentPane().setBackground(Color.GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
}
