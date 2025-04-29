package ar.edu.unlp.info.oo2.facturacion_llamadas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTest {
	Empresa sistema;

	@BeforeEach
	public void setUp() {
		this.sistema = new Empresa();
		this.sistema.agregarNumeroTelefono("2214444554");
		this.sistema.agregarNumeroTelefono("2214444555");
		this.sistema.agregarNumeroTelefono("2214444556");
		this.sistema.agregarNumeroTelefono("2214444557");
		this.sistema.agregarNumeroTelefono("2214444558");
		this.sistema.agregarNumeroTelefono("2214444559");
	}

	@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarUsuarioFisico("11555666", "Brendan Eich");		//se adecuo la firma de la llamada al conctructor
		Cliente remitentePersonaFisica = sistema.registrarUsuarioFisico("00000001", "Doug Lea");		//debido al replace cond. with polym. de la registracion
		Cliente emisorPersonaJuridica = sistema.registrarUsuarioJuridico("17555222", "Nvidia Corp");
		Cliente remitentePersonaJuridica = sistema.registrarUsuarioJuridico("25765432", "Sun Microsystems");

		this.sistema.registrarLlamadaNacional(emisorPersonaJuridica, remitentePersonaFisica, 10);		//se adecuo la firma de la llamada al conctructor
		this.sistema.registrarLlamadaInternacional(emisorPersonaJuridica, remitentePersonaFisica, 8);	//debido al replace cond. with polym. de la registracion
		this.sistema.registrarLlamadaNacional(emisorPersonaJuridica, remitentePersonaJuridica, 5);
		this.sistema.registrarLlamadaInternacional(emisorPersonaJuridica, remitentePersonaJuridica, 7);
		this.sistema.registrarLlamadaNacional(emisorPersonaFisca, remitentePersonaFisica, 15);
		this.sistema.registrarLlamadaInternacional(emisorPersonaFisca, remitentePersonaFisica, 45);
		this.sistema.registrarLlamadaNacional(emisorPersonaFisca, remitentePersonaJuridica, 13);
		this.sistema.registrarLlamadaInternacional(emisorPersonaFisca, remitentePersonaJuridica, 17);

		assertEquals(11454.64, emisorPersonaFisca.calcularMontoTotalLlamadas(), 0.01);
		assertEquals(2445.40, emisorPersonaJuridica.calcularMontoTotalLlamadas(), 0.01);
		assertEquals(0, remitentePersonaFisica.calcularMontoTotalLlamadas());
		assertEquals(0, remitentePersonaJuridica.calcularMontoTotalLlamadas());
	}

	@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeUsuarios(), 0);											//aca podria dar vuelta la posicion de los valores para que tenga mas sentido la comparacion
		this.sistema.agregarNumeroTelefono("2214444558"); 
		Cliente nuevaPersona = this.sistema.registrarUsuarioFisico("2444555","Alan Turing");		//se adecuo la firma de la llamada al conctructor
		assertEquals(1, this.sistema.cantidadDeUsuarios());											//debido al replace cond. with polym. de la registracion
		assertTrue(this.sistema.existeUsuario(nuevaPersona));
	}

	@Test
	void obtenerNumeroLibre() {
		// por defecto es el ultimo
		assertEquals("2214444559", this.sistema.obtenerNumeroLibre());

		this.sistema.getGestorNumeros().cambiarTipoGeneradorPrimero();
		assertEquals("2214444554", this.sistema.obtenerNumeroLibre());

		this.sistema.getGestorNumeros().cambiarTipoGeneradorRandom();
		assertNotNull(this.sistema.obtenerNumeroLibre());
	}
}
