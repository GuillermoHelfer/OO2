package ar.edu.unlp.info.oo2.accesobd;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProxyDataBase implements DatabaseAccess{
	
	private DatabaseRealAccess realDB;
	private boolean autenticado;

	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (isAutenticado())
			return realDB.getSearchResults(queryString);
		else
			System.out.println("el usuario no esta autenticado, proceda con la autenticacion previo al uso de la db");
		return Collections.emptyList();
	}
	
	

	@Override
	public int insertNewRow(List<String> rowData) {
		if (isAutenticado())
			return realDB.insertNewRow(rowData);
		else
			System.out.println("el usuario no esta autenticado, proceda con la autenticacion previo al uso de la db");
		return -1;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void autenticarUsuario() { //plain, falta implementacion
		this.autenticado = true;
	}
	
	

}
