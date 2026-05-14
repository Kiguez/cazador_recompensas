package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

public class CazadorTest {

    CazadorSigiloso cazadorSigiloso = new CazadorSigiloso(50);
    CazadorRural cazadorRural = new CazadorRural(50);
    CazadorUrbano cazadorUrbano = new CazadorUrbano(50);
    Profugo profugonervioso = new Profugo(40, 40, Boolean.TRUE);
    Profugo profugoNoNerviosoHabilidoso = new Profugo(40, 51, Boolean.FALSE);

    @Nested
    class TestCapturas {

        @Test
        void testCazadorSigiloso() {
            assertTrue(cazadorSigiloso.puedeCapturarProfugo(profugonervioso));
        }

        @Test
        void testCazadorSigiloso2() {
            assertFalse(cazadorSigiloso.puedeCapturarProfugo(profugoNoNerviosoHabilidoso));
        }

        @Test
        void testCazadorRural() {
            assertTrue(cazadorRural.puedeCapturarProfugo(profugonervioso));
        }

        @Test
        void testCazadorRural2() {
            assertFalse(cazadorRural.puedeCapturarProfugo(profugoNoNerviosoHabilidoso));
        }

        @Test
        void testCazadorUrbano() {
            assertFalse(cazadorUrbano.puedeCapturarProfugo(profugonervioso));
        }

        @Test
        void testCazadorUrbano2() {
            assertTrue(cazadorUrbano.puedeCapturarProfugo(profugoNoNerviosoHabilidoso));
        }

        @Test
        void testCazadorGeneral() {
            Profugo profugoNadaInocente = new Profugo(60, 51, Boolean.TRUE);
            Profugo profugoNadaInocenteSinHabilidad = new Profugo(60, 49, Boolean.FALSE);
            assertAll(
                () -> assertFalse(cazadorSigiloso.puedeCapturarProfugo(profugoNadaInocenteSinHabilidad)),
                () -> assertFalse(cazadorRural.puedeCapturarProfugo(profugoNadaInocente)),
                () -> assertFalse(cazadorUrbano.puedeCapturarProfugo(profugoNadaInocenteSinHabilidad))
            );
        }
    }

    @Nested
    class TestIntimidacion {

        @BeforeEach
        void init() {
            cazadorSigiloso.intimidarProfugo(profugoNoNerviosoHabilidoso);
            cazadorUrbano.intimidarProfugo(profugonervioso);
            cazadorRural.intimidarProfugo(profugoNoNerviosoHabilidoso);
        }

        @Test
        void testIntimidacionEnGeneral() {
            assertAll(
                () -> assertEquals(36, profugoNoNerviosoHabilidoso.getInocencia()), //Perdio 4 de inocencia porque fue intimidado 2 veces 
                () -> assertEquals(38, profugonervioso.getInocencia())
            );
        }

        @Test
        void testInitimidacionCazadorSigiloso() {
            assertEquals(46, profugoNoNerviosoHabilidoso.getHabilidad());
        }

        @Test
        void testInitimidacionCazadorUrbano() {
            assertFalse(profugonervioso.esNervioso());
        }

        @Test
        void testInitimidacionCazadorRural() {
            assertTrue(profugoNoNerviosoHabilidoso.esNervioso());
        }
    }
} 
