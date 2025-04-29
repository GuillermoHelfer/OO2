package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;

public class RandomStrategy implements Strategy{

//	@Override
//	public String obtenerNumeroLibre(SortedSet<String> lineas) {		//olor envidia atributo, rompe encapsulamiento, dejo que gestor maneje
//		String linea = new ArrayList<String>(lineas)					//la eliminacion de la linea usada
//				.get(new Random().nextInt(lineas.size()));
//		lineas.remove(linea);
//		return linea;
//	}
	
	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) {		//refactorizado
		return new ArrayList<String>(lineas)
				.get(new Random().nextInt(lineas.size()));
	}
	
}
