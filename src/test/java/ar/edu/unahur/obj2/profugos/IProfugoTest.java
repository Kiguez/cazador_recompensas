package ar.edu.unahur.obj2.profugos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IProfugoTest {

    @Test
    void testProfugoDe40DeHabilidadLaDuplicaConArtesMarciales() {
        IProfugo profugoArtistaMarcial = new ArteMarcial(new Profugo(10, 40, Boolean.TRUE));
        assertEquals(80, profugoArtistaMarcial.getHabilidad());
    }

    @Test
    void testProfugoAprendeArtesMarcialesPeroSuHabilidadNoPasaDe100() {
        IProfugo profugoArtistaMarcial = new ArteMarcial(new Profugo(10, 60, Boolean.TRUE));
        assertEquals(100, profugoArtistaMarcial.getHabilidad());
    }

    @Test
    void testProfugoConEntrenamientoDeEliteDejaDeSerNervioso() {
        IProfugo profugoEntrenado = new EntrenamientoDeElite(new Profugo(10, 60, Boolean.TRUE));
        assertFalse(profugoEntrenado.esNervioso());
    }

    @Test
    void testProfugoConEntrenamientoDeEliteNoPuedeSerNervioso() {
        IProfugo profugoEntrenado = new EntrenamientoDeElite(new Profugo(10, 60, Boolean.TRUE));
        profugoEntrenado.volverseNervioso();
        assertFalse(profugoEntrenado.esNervioso());
    }

    @Test
    void testProfugoConProteccionLegalAumentaSuInocenciaA40() {
        IProfugo profugoProtegido = new ProteccionLegal(new Profugo(10, 60, Boolean.TRUE));
        assertEquals(40, profugoProtegido.getInocencia());
    }

    @Test
    void testProfugoConProteccionLegalNoPuedeBajarSuInocenciaAMenosDe40() {
        IProfugo profugoProtegido = new ProteccionLegal(new Profugo(41, 60, Boolean.TRUE));
        profugoProtegido.disminuirInocencia();
        assertEquals(40, profugoProtegido.getInocencia());
    }

    @Test
    void testProfugoPuedeObtenerMultiplesDecoradores() {
        IProfugo profugoDebil = new Profugo(10, 50, Boolean.TRUE);
        IProfugo profugoBruceLee = new ArteMarcial(profugoDebil);
        IProfugo profugoEntrenado = new EntrenamientoDeElite(profugoBruceLee);
        IProfugo profugoRePulenta = new ProteccionLegal(profugoEntrenado);
        assertAll(
            () -> assertEquals(100, profugoRePulenta.getHabilidad()),
            () -> assertEquals(40, profugoRePulenta.getInocencia()),
            () -> assertFalse(profugoRePulenta.esNervioso())
        );

    }
} 
