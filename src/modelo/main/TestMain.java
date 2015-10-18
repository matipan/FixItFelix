package modelo.main;
import modelo.dinamica.personajes.*;
import modelo.dinamica.*;
import modelo.direcciones.*;
import modelo.niceland.*;

public class TestMain {

	public static void main(String[] args) {
		Main juego = new Main(true);
		juego.jugar();
        // Seteamos ambos personajes creados
        Felix felix = juego.dvp.getFelix();
        Ralph ralph = juego.dvp.getRalph(); // Santi no borr� esta l�nea porque supone se usar� m�s adelante
        // El loop sigue hasta que ralph se quede sin ladrillos, o felix se quede sin vida
        while (ralph.hayLadrillos()) {
            ralph.tirarLadrillos();
            Ventana ventana = juego.getNiceland().getVentana(felix.getPosicion());
            if (!ventana.estaSana()) {
                // Si la ventana no esta sana ralph tiene que dar 4 martillazos
                for (int i = 0; i < 4; i++) {
                    felix.martillar(ventana);
                }
            }else{
                mover_a(felix);
            }
            if (gameOver(felix)) {
                break;
            }
        }
	}
    
    public static void mover_a(Felix felix){
        // Hacemos el recorrido de felix
        felix.mover(Direccion.DERECHA);
    }
    
    public static boolean gameOver(Felix felix){
        // fila, columna, seccion
        Posicion pos_final = new Posicion(0,4,1);
        if (felix.getPosicion().equal_to(pos_final) || felix.getVida() == 0) {
            return true;
        }
        return false;
    }

}
