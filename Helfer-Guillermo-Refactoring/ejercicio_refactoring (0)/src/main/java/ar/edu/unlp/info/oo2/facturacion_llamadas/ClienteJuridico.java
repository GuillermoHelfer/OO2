package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class ClienteJuridico extends Cliente {

	private String cuit;

	private static double descuento = 0.15;			//agregado por el move variable desde empresa
	

	public ClienteJuridico(String nombre, String tel, String data) {
		this.setNombre(nombre);
		this.setNumeroTelefono(tel);
		this.setCuit(data);
		this.setDescuento(descuento);
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	

}
