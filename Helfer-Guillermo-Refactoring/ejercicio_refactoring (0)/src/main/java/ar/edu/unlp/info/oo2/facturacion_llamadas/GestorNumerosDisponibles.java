package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
//	private String tipoGenerador = "ultimo"; //olor (ver linea 15); borrado, ya no se necesita
	private Strategy tipoGenerador = new UltimoStrategy();

	public SortedSet<String> getLineas() {
		return lineas;
	}

//	public String obtenerNumeroLibre() { 	//olor esto deberia resolverse polimorficamente (SWITCH ST/conditional logic)
//		String linea;						//replace conditional logic with polymorphism (strategy)
//		switch (tipoGenerador) {
//			case "ultimo":
//				linea = lineas.last();
//				lineas.remove(linea);
//				return linea;
//			case "primero":
//				linea = lineas.first();
//				lineas.remove(linea);
//				return linea;
//			case "random":
//				linea = new ArrayList<String>(lineas)
//						.get(new Random().nextInt(lineas.size()));
//				lineas.remove(linea);
//				return linea;
//		}
//		return null;
//	}

	public String obtenerNumeroLibre() {
		String linea = this.tipoGenerador.obtenerNumeroLibre(lineas);
		this.getLineas().remove(linea);
		return linea;
	}

//	public void cambiarTipoGenerador(String valor) { //deberia resolverse con un strategy en general
//		this.tipoGenerador = valor;
//	}
	
	public void cambiarTipoGeneradorUltimo() { 				//un cambio para cada tipo de estrategia
		this.tipoGenerador = new UltimoStrategy();
	}
	public void cambiarTipoGeneradorPrimero() { 
		this.tipoGenerador = new PrimeroStrategy();
	}
	public void cambiarTipoGeneradorRandom() { 
		this.tipoGenerador = new RandomStrategy();
	}

	public boolean isRegistrado(String num) {  //refactorizado (move method empresa linea 36)
		return getLineas().contains(num);
	}
}
