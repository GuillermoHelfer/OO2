package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;

public class UltimoStrategy implements Strategy {

//	@Override		
//	public String obtenerNumeroLibre(SortedSet<String> lineas) { 		//olor envidia de atributo, rompe encapsulamiento. dejo que la clase
//		String linea = lineas.last();									//gestorNumerosDisponibles maneje la eliminacion de la linea usada.
//		lineas.remove(linea);
//		return linea;
//	}
	
	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) { 		//refactorizado
		return lineas.last();
	}
	
}
