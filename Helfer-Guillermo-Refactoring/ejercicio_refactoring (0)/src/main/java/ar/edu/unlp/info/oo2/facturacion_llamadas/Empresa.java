package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
//	private List<Llamada> llamadas = new ArrayList<Llamada>();		//olor clase larga, no hace falta que la empresa lleve registro de las llamadas, delegeado al cliente
	GestorNumerosDisponibles guia = new GestorNumerosDisponibles();
	
//	static double descuentoJur = 0.15; //olor feature envy esto deberia ser propio del correspondiente cliente, move variable
//	static double descuentoFis = 0;

//	public boolean agregarNumeroTelefono(String str) { 				//olor metodo largo?, decompose conditional
//		boolean encontre = guia.getLineas().contains(str); 			//olor nombre parametro, rename variable
//		if (!encontre) {
//			guia.getLineas().add(str);
//			encontre= true;
//			return encontre;
//		}
//		else {
//			encontre= false;
//			return encontre;
//		}
//	}
	
	public boolean agregarNumeroTelefono(String numeroAgregar) { 	//solucion refactorizada
		if (!this.guia.isRegistrado(numeroAgregar)) {
			guia.getLineas().add(numeroAgregar);
			return true;
		}
		return false;
	}
	
	
//	public boolean isRegistrado(String num) { 				//olor esto no le corresponde a esta clase (feature envy), move method a guia. 
//		return this.guia.getLineas().contains(num); 
//	}
	
	public String obtenerNumeroLibre() { 							
		return guia.obtenerNumeroLibre();
	}

//	public Cliente registrarUsuario(String data, String nombre, String tipo) {
//		Cliente var = new Cliente();
//		if (tipo.equals("fisica")) { 				//olor esto deberia ser polimorfico, replace conditional with polymorphism
//			var.setNombre(nombre);
//			String tel = this.obtenerNumeroLibre(); //olor nombre de variable cliente, rename variable
//			var.setTipo(tipo);
//			var.setNumeroTelefono(tel);
//			var.setDNI(data);
//		}
//		else if (tipo.equals("juridica")) {
//			String tel = this.obtenerNumeroLibre();
//			var.setNombre(nombre);
//			var.setTipo(tipo);
//			var.setNumeroTelefono(tel);
//			var.setCuit(data);
//		}
//		clientes.add(var);
//		return var;
//	}
	
	public ClienteJuridico registrarUsuarioJuridico(String data, String nombre) {
		String tel = this.obtenerNumeroLibre();
		ClienteJuridico cli = new ClienteJuridico(nombre,tel,data);
		clientes.add(cli);
		return cli;
	}
	
	public ClienteFisico registrarUsuarioFisico(String data, String nombre) {
		String tel = this.obtenerNumeroLibre();
		ClienteFisico cli = new ClienteFisico(nombre,tel,data);
		clientes.add(cli);
		return cli;
	}

//	public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
//		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion); 	//este metodo se deberia resolver polimorficamente debido al replace conditional with polym. 
//		llamadas.add(llamada);																					//realizado en el metodo calcularMontoLlamada de esta clase.
//		origen.llamadas.add(llamada);																			//ademas ya no se necesita agregar la llamada debido al move method
//		return llamada;
//	}
	
	public LlamadaNacional registrarLlamadaNacional(Cliente origen, Cliente destino, int duracion) {			//ya no se necesita la variable del tipo por la solucion polimorfica
		LlamadaNacional llamada = new LlamadaNacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		origen.llamadas.add(llamada);
		return llamada;
	}
	
	public LlamadaInternacional registrarLlamadaInternacional(Cliente origen, Cliente destino, int duracion) {
		LlamadaInternacional llamada = new LlamadaInternacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		origen.llamadas.add(llamada);
		return llamada;
	}

//	public double calcularMontoTotalLlamadas(Cliente cliente) {  //olor esto lo deberia calcular cada tipo polimorficamente
//		double c = 0;											//olor nombre de variable confuso, rename varibale c -> count
//		for (Llamada l : cliente.llamadas) {
//			double auxc = 0;
//			if (l.getTipoDeLlamada() == "nacional") {			//olor metodo largo, reemplazar condicional por polimorfismo
//				// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
//				auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
//			} else if (l.getTipoDeLlamada() == "internacional") {
//				// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
//				auxc += l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
//			}
//
//			if (cliente.getTipo() == "fisica") {   //olor metodo largo reemplazar condicional por polimorfismo
//				auxc -= auxc*descuentoFis;
//			} else if(cliente.getTipo() == "juridica") {
//				auxc -= auxc*descuentoJur;
//			}
//			c += auxc;
//		}
//		return c;
//	}
																//el metodo de abajo es la refactorizacion del metodo de arriba
//	public double calcularMontoTotalLlamadas(Cliente cliente) { //olor le envidia los atributos al cliente, move method hacia cliente
//		double count = 0;
//		for (Llamada l : cliente.llamadas) {
//			double auxCount = 0;
//			auxCount = l.calcularMontoLlamada();
//			auxCount -= auxCount * cliente.getDescuento();
//			count += auxCount;
//		}
//		return count;
//	}
	
	public double calcularMontoTotalLlamadas(Cliente cliente) { 
		return cliente.calcularMontoTotalLlamadas();
	}
	
	public int cantidadDeUsuarios() {
		return clientes.size();
	}

	public boolean existeUsuario(Cliente persona) {
		return clientes.contains(persona);
	}

	public GestorNumerosDisponibles getGestorNumeros() { 	//olor no me parece muy fiable que se pueda obtener la lista de los 
		return this.guia;									//numeros disponibles de manera publica pero debe ser para el test
	}
	
}
