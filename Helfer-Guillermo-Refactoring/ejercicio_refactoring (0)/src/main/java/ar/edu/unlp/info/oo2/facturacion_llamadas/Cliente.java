package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	public List<Llamada> llamadas = new ArrayList<Llamada>(); 	//olor el cliente no usa su lista de llamadas (data class)
																//deberia haber envidia de atributo en otra clase
	private String nombre;		
	private String numeroTelefono;
	private double descuento;
//	private String tipo;		//la variable de tipo ya no se utiliza por el cambio a polimorfismo
//	private String dni			//move variable en consecuencia del replace conditional with polymorphism en empresa (linea 44)
//	private String cuit;		//sobre la registracion del usuario
	
//	public String getTipo() {	//ya no se necesitan estos metodos en consecuencia de la conversion polimorfica
//		return tipo;
//	}
//	public void setTipo(String tipo) {
//		this.tipo = tipo;
//	}
	public String getNombre() {
		return nombre;
	}
//	public void setNombre(String nombre) { 	 //olor innapropiate intimacy, cambio de public a protected
//		this.nombre = nombre;
//	}
	protected void setNombre(String nombre) { 	 //olor innapropiate intimacy, cambio de public a protected
		this.nombre = nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
//	public void setNumeroTelefono(String numeroTelefono) {	//olor innapropiate intimacy, cambio de public a protected
//		this.numeroTelefono = numeroTelefono;
//	}
	protected void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
//	public String getCuit() {				//move method o push down del get y set hacia las clases ClienteFisico y ClienteJuridico
//		return cuit;						//respectivamente en consecuencia del replace conditional with polymorphism en empresa
//	}										//linea 44 sobre el metodo de registrarUsuaruio.
//
//	public void setCuit(String cuit) {
//		this.cuit = cuit;
//	}
//	public String getDNI() {
//		return dni;
//	}
//	public void setDNI(String dni) {
//		this.dni = dni;
//	}
	
	public double getDescuento() {
		return this.descuento;
	}
	protected void setDescuento(double desc) {	//olor innapropiate intimacy, cambio de public a protected // aplicado directamente
		this.descuento = desc;
	}
	
	public double calcularMontoTotalLlamadas() { //resultado del move method desde la clase empresa, no se necesita el parametro Empresa
		double count = 0;
		for (Llamada l : llamadas) {
			double auxCount = 0;
			auxCount = l.calcularMontoLlamada();
			auxCount -= auxCount * getDescuento();
			count += auxCount;
		}
		return count;
	}
	
	
}
