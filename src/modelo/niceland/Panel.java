package modelo.niceland;

public class Panel {
	private Estado estado;

    public Panel(Estado estado){
        this.estado = estado;
    }

	public Estado getEstado(){
		return this.estado;
	}

	public void setEstado(Estado estado){
		this.estado = estado;
	}

    /*
     * Si el panel que estamos queriendo arreglar esta sano, entonces
     * devolvemos false, ya que ya no se puede arreglar. Caso contrario 
     * se devuelve true.
     * @return boolean
     *
     */
	protected boolean arreglar(){
        if (!this.estaSano()) {
            this.getEstado().arreglar();
            return true;
        }else{
            return false;
        }
    }

	/*
	 * Si this.estado es una instancia de Roto, se devuelve true
	 * caso contrario se devuelve false
	 * @return boolean
	 */
	protected boolean estaRoto(){
		if(this.getEstado() instanceof Roto){
			return true;
		} else {
			return false;
		}
	}
    
    private boolean estaSano(){
        if (this.getEstado() instanceof Sano) {
            return true;
        }else{
            return false;
        }
    }
}