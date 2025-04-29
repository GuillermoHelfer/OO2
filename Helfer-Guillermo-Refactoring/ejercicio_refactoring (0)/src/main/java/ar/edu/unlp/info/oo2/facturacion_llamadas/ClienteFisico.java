package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class ClienteFisico extends Cliente {

	private String dni;

	private static double descuento = 0;		//agregado por el move variable desde empresa
	
	public ClienteFisico(String nombre, String tel, String data) {
		this.setNombre(nombre);
		this.setNumeroTelefono(tel);
		this.setDNI(data);
		this.setDescuento(descuento);
	}

	public String getDNI() {
		return dni;
	}

	private void setDNI(String dni) {
		this.dni = dni;
	}
	
}
