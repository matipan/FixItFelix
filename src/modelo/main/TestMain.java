package modelo.main;
import modelo.dinamica.objetos.*;
import modelo.dinamica.personajes.*;
import modelo.dinamica.*;
import modelo.direcciones.*;
import modelo.niceland.*;
import modelo.util.*;

public class TestMain {

	public static void main(String[] args) {
		Main juego = new Main(true);
		juego.jugar();
        // Seteamos ambos personajes creados
        Felix felix = juego.dvp.getFelix();
        Ralph ralph = juego.dvp.getRalph(); // Santi no borr� esta l�nea porque supone se usar� m�s adelante
        System.out.println("La posicion de Ralph es: " + ralph.getPosicion().to_string());
        System.out.println("La posicion de Felix es: " + felix.getPosicion().to_string());
        System.out.println();
        // El loop sigue hasta que ralph se quede sin ladrillos, o felix se quede sin vida
        while (ralph.hayLadrillos()) {
            ralph.tirarLadrillos();
            System.out.println("La posicion de ralph: " + ralph.getPosicion().to_string());
            System.out.println("La posicion de felix: " + felix.getPosicion().to_string());
            Ventana ventana = juego.getNiceland().getVentana(felix.getPosicion());
            System.out.println();
            if (!ventana.estaSana() && !(ventana instanceof Irrompible)) {
               // Si la ventana no esta sana felix tiene que dar 4 martillazos
                for (int i = 0; i < 4; i++) {
                    felix.martillar(ventana);
                }
                System.out.println();
            }   
            mover_a_felix(felix);
            mover_a_ralph(ralph);
            System.out.println();
            if (gameOver(felix, ralph)) 
            	break;
        }
        print_stats(felix, ralph);
    }

    
    public static void mover_a_felix(Felix felix){
        // Hacemos el recorrido de felix
    	if((felix.getPosicion().getColumna() != 4) && (felix.getPosicion().getFila() % 2 == 0)){
    		felix.mover(Direccion.DERECHA);
        }else{
      		if ((felix.getPosicion().getColumna() != 0) && (felix.getPosicion().getFila() % 2 == 1)){
      			felix.mover(Direccion.IZQUIERDA);
      		}else{
      			felix.mover(Direccion.ARRIBA);
      		}
      	}
    }
    
    public static void mover_a_ralph(Ralph ralph){
        RandomAcotado random = new RandomAcotado(0,2);
        switch (random.getValor()) {
            case 0: ralph.mover(Direccion.IZQUIERDA);
                    break;
            case 1: ralph.mover(Direccion.DERECHA);
                    break;
            default: break;
        }
    }
    
    public static boolean gameOver(Felix felix, Ralph ralph){
        Ladrillo[] ladrillos = ralph.getLadrillosLanzados();
        for (int i = 0; i < ralph.getTotalLadrillosLanzados(); i++) {
            Ladrillo ladrillo = ladrillos[i];
            if (ladrillo.getPosicion().equal_to(felix.getPosicion())) {
                felix.golpeadoPorLadrillo();
            }
            if (felix.getVida() == 0) {
                return true;
            }
            ladrillo.caer();
        }
        // fila, columna, seccion
        Posicion pos_final = new Posicion(2,4,0);
        if (felix.getPosicion().equal_to(pos_final) || felix.getVida() == 0) {
            return true;
        }
        return false;
    }
    
    public static void print_stats(Felix felix, Ralph ralph){
        System.out.println();
        System.out.println("======== STATS ========");
        System.out.println("Ralph lanzo " + ralph.getTotalLadrillosLanzados() + " ladrillos.");
        if (felix.getVida() == 0) {
            System.out.println("Felix perdio!!");
        }else{
            System.out.println("A felix le pegaron: " + (3 - felix.getVida()));
        }
    }
}
