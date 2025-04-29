package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaInternacional extends Llamada {
	
	private double adicional;

	public LlamadaInternacional(String origen, String destino, int duracion) {
		super(origen, destino, duracion);
		setCostoSegundo(150);
		setAdicional(50);
	}

	@Override
	public double calcularMontoLlamada() {
		return calcularMontoLlamadaAux() + getAdicional();
	}

	public double getAdicional() {
		return adicional;
	}

	private void setAdicional(double adicional) {
		this.adicional = adicional;
	}

}
