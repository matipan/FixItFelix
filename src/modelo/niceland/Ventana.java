package modelo.niceland;

import modelo.direcciones.*;
import modelo.util.RandomAcotado;

public class Ventana {
    protected Panel[] paneles;
    private int martillazos_recibidos;
    
    public int getMartillazosRecibidos(){
        return this.martillazos_recibidos;
    }

    public void setMartillazosRecibidos(int martillazos_recibidos){
        this.martillazos_recibidos = martillazos_recibidos;
    }

    /*
     * Los paneles se arreglan solo cada dos golpes, por ende
     * si estoy en el golpe numero 2 tengo que arreglar el primero
     * el cual esta en la posicion 0, entonces: 2/1 - 1 = 0.
     * Caso golpes = 4: 4/2 - 1 = 1.
     * La cantidad de golpes depende de la cantidad de paneles, por ende
     * cada subclase de Ventana hace un Override donde solo arregla si
     * no supero la cantidad maxima de golpes, y luego llama a este metodo.
     * NOTE: Este metodo puede llegar a cambiar, dependiendo de como vayamos a
     * hacer la implementacion grafica, por ahora lo dejamos asi para que al menos
     * funcione
     */
    public void arreglarPanel(){
        if ((this.getMartillazosRecibidos() % 2 == 0) && (this.getMartillazosRecibidos() != 0)) {
            if(paneles[(this.getMartillazosRecibidos()/2) - 1].arreglar()){
                paneles[(this.getMartillazosRecibidos()/2) - 1].arreglar();
            }
        }
        this.setMartillazosRecibidos(this.getMartillazosRecibidos()+ 1);
    }

	/*
	 * Esto va a devolver true si la ventana a la
	 * que se esta llamando es puerta o semicircular.
	 * En caso de que sea irrompible o simple, se va a acceder
	 * al metodo de la clase correspondiente
     * @params direccion La direccion adonde se esta queriendo mover
	 * @return boolean
	 */
	protected boolean pasarHabilitado(Direccion direccion){
		return true;
	}

    /*
     * Setea cada panel de la ventana, con un estado aleatorio
     * @params cantidad : Cantidad de paneles que tiene que setear
     */
    protected void setearPaneles(int cantidad){
        paneles = new Panel[cantidad];
        for (int i = 0; i < cantidad; i++) {
        	RandomAcotado nuevoRandom = new RandomAcotado (0,2);
            this.paneles[i] = new Panel(nuevoRandom.getValor());
        }
    }

    /*
     * Devuelve true solo si todos los paneles estan completamente sanos
     * @return boolean Devuelve true si la ventana entera esta sana
     */
    public boolean estaSana(){
        for (int i = 0; i < paneles.length; i++) {
            if (!paneles[i].estaSano()) {
            	System.out.println("El panel "+i+" "+paneles[i].getEstado().to_string());
                return false;
            }
        }
        return true;
    }

    /*
     * Devuelve un numero random entre min y max inclusive
     * @param min Rango inicial
     * @param max Rango maximo
     * @return int
     */
   
}
