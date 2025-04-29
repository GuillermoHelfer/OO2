package ar.edu.unlp.info.oo2.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BibliotecaTest {
	
	private Biblioteca biblioteca;
	private Socio socio_uno;
	private Socio socio_dos;
	JSONParser parseo;

	@BeforeEach
	void setUp () throws Exception{
		biblioteca = new Biblioteca ();
		socio_uno = new Socio ("Guillermo Helfer", "guillemail@yo.org", "19285/7");
		socio_dos = new Socio ("Manuel Rosiano", "manuelmail@yo.org", "75829/1");
		parseo = new JSONParser();
	}
	
	@Test
	void agregarSocioTest () {
		biblioteca.agregarSocio(socio_uno);
		String separator = System.lineSeparator();
		String salida = "[" + separator
				+ "\t{" + separator
				+ "\t\t\"nombre\": \"" + socio_uno.getNombre() + "\"," + separator
				+ "\t\t\"email\": \"" + socio_uno.getEmail() + "\"," + separator
				+ "\t\t\"legajo\": \"" + socio_uno.getLegajo() + "\"" + separator
				+ "\t}" + separator
				+ "]";
		assertEquals(salida, biblioteca.exportarSocios());
	}
	
	@Test
	void agregarVariosSociosTest () {
		biblioteca.agregarSocio(socio_uno);
		biblioteca.agregarSocio(socio_dos);
		String separator = System.lineSeparator();
		String salida = "[" + separator
				+ "\t{" + separator
				+ "\t\t\"nombre\": \"" + socio_uno.getNombre() + "\"," + separator
				+ "\t\t\"email\": \"" + socio_uno.getEmail() + "\"," + separator
				+ "\t\t\"legajo\": \"" + socio_uno.getLegajo() + "\"" + separator
				+ "\t}," + separator
				+ "\t{" + separator
				+ "\t\t\"nombre\": \"" + socio_dos.getNombre() + "\"," + separator
				+ "\t\t\"email\": \"" + socio_dos.getEmail() + "\"," + separator
				+ "\t\t\"legajo\": \"" + socio_dos.getLegajo() + "\"" + separator
				+ "\t}" + separator
				+ "]";
		assertEquals(salida, biblioteca.exportarSocios());
	}
	
	@Test
	void testJSONSimple() throws ParseException {
		biblioteca.agregarSocio(socio_uno);
		biblioteca.agregarSocio(socio_dos);
		VoorheesExporter adapter = new JSONExporter();
		String salida = "[\n"
				+ "	{\n"
				+ "		\"nombre\": \"Guillermo Helfer\",\n"
				+ "		\"email\": \"guillemail@yo.org\",\n"
				+ "		\"legajo\": \"19285/7\"\n"
				+ "	},\n"
				+ "	{\n"
				+ "		\"nombre\": \"Manuel Rosiano\",\n"
				+ "		\"email\": \"manuelmail@yo.org\",\n"
				+ "		\"legajo\": \"75829/1\"\n"
				+ "	}\n"
				+ "]\n"
				+ "";
		biblioteca.setExporter(adapter);
		assertEquals(parseo.parse(salida), parseo.parse(this.biblioteca.exportarSocios()));
	}
	
}
