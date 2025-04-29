package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONExporter extends VoorheesExporter{
	
	private JSONObject exportar(Socio socio) {
		JSONObject point = new JSONObject();
		point.put("nombre", socio.getNombre());
		point.put("email", socio.getEmail());
		point.put("legajo", socio.getLegajo());
		return point;
	}
	
	@Override
	public String exportar(List<Socio> socios) {
		JSONArray array = new JSONArray();
		socios.stream()
			.forEach(s -> array.add(exportar(s)));
		return array.toJSONString();
	}
	

}
