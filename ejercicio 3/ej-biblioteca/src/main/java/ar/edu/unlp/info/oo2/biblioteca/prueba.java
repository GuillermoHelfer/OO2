package ar.edu.unlp.info.oo2.biblioteca;

public class prueba {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
		biblioteca.agregarSocio(new Socio("Guillermo Helfer", "guillemail@mail.com", "19285/7"));
		biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com",  "2345-2"));
		System.out.println(biblioteca.exportarSocios());
	}

}
