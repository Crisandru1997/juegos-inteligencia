package anchura;

import codigo.Constantes;
import codigo.Pasajero;
import java.util.ArrayList;
import java.util.Collections;

public class Busqueda_Anchura implements Constantes{
    public ArrayList<Estado> colaEstados;
    public ArrayList<Estado> registroEstados;
    public ArrayList<String> pasos;
    public Estado inicial;
    public Estado meta;
    public Estado actual;
    public boolean exito;
    
    public Pasajero ent;

    public Busqueda_Anchura(Pasajero ent, int x_o,int y_o,int x_f, int y_f) {
        this.ent=ent;
        colaEstados = new ArrayList<>();
        registroEstados=new ArrayList<>();
        pasos=new ArrayList<>();
        inicial=new Estado(x_o,y_o,"inicial",null);
        meta=new Estado(x_f,y_f,"",null);
        System.out.println(" ESTADO INICIAL = "+inicial.toString());
        System.out.println(" ESTADO FINAL = "+meta.toString());
        exito=false;
    }
    
    public void busqueda () {
        
        if ( inicial.equals(meta)) {
            System.out.println("inicial es meta");
            exito=true;
        }else {
            colaEstados.add(inicial);
            registroEstados.add(inicial);
            int n_iteraciones=0;
            while ( !colaEstados.isEmpty() && !exito) {
                actual=colaEstados.get(0);
                System.out.println(" ITERACION ["+n_iteraciones+"] = "+actual.toString());
                colaEstados.remove(0);
                procesarSucesores(actual);
                ++n_iteraciones;
            }
            System.out.println(" Iteraciones anchura = "+n_iteraciones);
        }
    }
    
    public void procesarSucesores(Estado actual) {
        
        if ( actual.equals(meta)) {
            meta=actual;
            reconstruirSolucion();
            exito=true;
        }else {
            abajo(actual);
            arriba(actual);
            derecha(actual);
            izquierda(actual);
        }
    }
    
    public void reconstruirSolucion() {
        
        ArrayList<Estado> solucion=new ArrayList<>();
        Estado aux=meta;
        while( aux != null) {
            solucion.add(aux);
            aux=aux.pred;
        }
        Collections.reverse(solucion);
        for(int i=0; i < solucion.size(); i++)
            pasos.add(solucion.get(i).mov);
    }
    
    public void arriba(Estado e) {
        
        if ( e.y > 0 ) {
           if ( ent.mv.escenario.celdas[e.x][e.y-1].tipo!=OBSTACULO_NEGRO) {
              Estado arriba=new Estado(e.x,e.y-1,"arriba",e);
              if ( !registroEstados.contains(arriba)) {
                colaEstados.add(arriba);
                registroEstados.add(arriba);
              }
           }
        }
    }
    
    public void abajo(Estado e) {
        if ( e.y < LARGO_ESCENARIO-1 ) {
            
           if ( ent.mv.escenario.celdas[e.x][e.y+1].tipo!=OBSTACULO_NEGRO) {
            Estado abajo=new Estado(e.x,e.y+1,"abajo",e);
            if ( !registroEstados.contains(abajo)) {
                colaEstados.add(abajo);
                registroEstados.add(abajo);
            }
           }
        }
    }
    
    public void izquierda(Estado e) {
        if ( e.x > 0) {
            
          if ( ent.mv.escenario.celdas[e.x-1][e.y].tipo!=OBSTACULO_NEGRO) {
             Estado izquierda=new Estado(e.x-1,e.y,"izquierda",e);
             if ( !registroEstados.contains(izquierda)) {
                colaEstados.add(izquierda);
                registroEstados.add(izquierda);
             }
          }
        }
    }
    
    public void derecha(Estado e) {
        
        if ( e.x < ANCHO_ESCENARIO-1  ) {
         if ( ent.mv.escenario.celdas[e.x+1][e.y].tipo!=OBSTACULO_NEGRO) {
           Estado derecha=new Estado(e.x+1,e.y,"derecha",e);
           if ( !registroEstados.contains(derecha)) {
               colaEstados.add(derecha);
                registroEstados.add(derecha);
           }
         }
        }
    }
}
