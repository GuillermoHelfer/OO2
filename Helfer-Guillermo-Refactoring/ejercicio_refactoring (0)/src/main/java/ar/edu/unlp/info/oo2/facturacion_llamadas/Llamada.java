package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class Llamada {									//olor data class, puede haber envidia de atributo en otra clase (resuelto)
	private String origen;
	private String destino;
	private int duracion;
	private double costoSegundo;
	private static final double IVA = 0.21;
//	private String tipo; 												//no se utiliza por el cambio a polimorfismo

	protected Llamada(String origen, String destino, int duracion) { 	//inappropriate intimacy, public a protected; sacar la variable de tipo
		this.origen= origen;
		this.destino= destino;
		this.duracion = duracion;
	}
	
	public abstract double calcularMontoLlamada();
	
	protected double calcularMontoLlamadaAux() {				//template method
		return this.getDuracion() * this.getCostoSegundo() 
				+ calcularPrecioConIva();						//olor metodo largo, extract method
	}
	
//	private double calcularPrecioConIva () {							//consecuencia del anterior extract method
//		return this.getDuracion() * this.getCostoSegundo() * 0.21;		//olor numero magico, reemplazar por constante
//	}
	private double calcularPrecioConIva () {
		return this.getDuracion() * this.getCostoSegundo() * IVA;
	}

	public String getRemitente() {
		return destino;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public String getOrigen() {
		return origen;
	}

	public double getCostoSegundo() {
		return costoSegundo;
	}

	protected void setCostoSegundo(int costoSegundo) {		//inappropriate intimacy, public a protected
		this.costoSegundo = costoSegundo;
	}
	
}
