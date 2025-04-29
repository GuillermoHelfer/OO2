package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;

public class PrimeroStrategy implements Strategy {

//	@Override															//envidia de atributo rompe encapsulamiento, dejar que gestor lo maneje
//	public String obtenerNumeroLibre(SortedSet<String> lineas) {
//		String linea = lineas.first();
//		lineas.remove(linea);
//		return linea;
//	}
	
	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) {		//refactorizado
		return lineas.first();
	}

}
