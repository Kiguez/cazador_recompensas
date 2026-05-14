package ar.edu.unahur.obj2.empresa;

import ar.edu.unahur.obj2.cazadores.*;
import ar.edu.unahur.obj2.profugos.*;
import ar.edu.unahur.obj2.zonas.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class EmpresaTest {

    CazadorSigiloso cazadorSigiloso = new CazadorSigiloso(50);
    CazadorRural cazadorRural = new CazadorRural(50);
    CazadorUrbano cazadorUrbano = new CazadorUrbano(50);
    Zona ponte = new Zona("Pontevedra");
    Empresa empresa = Empresa.getInstance();
    Profugo profugonervioso = new Profugo(40, 40, Boolean.TRUE);
    Profugo profugoNoNerviosoHabilidoso = new Profugo(40, 51, Boolean.FALSE);

    @BeforeEach
    void init() {
        empresa.getCazadores().clear();
        empresa.contratarCazador(cazadorRural);
        empresa.contratarCazador(cazadorSigiloso);
        empresa.contratarCazador(cazadorUrbano);
    }

    @Nested
    class TestEnvioDeCazadoresACiudad {

        @Test
        void testEmpresaNoPuedeEnviarCazadorNoContratado() {
            Cazador cazadorNoContratado = new CazadorSigiloso(50);
            assertThrows(
                    RuntimeException.class,
                    () -> {
                        empresa.enviarCazadorAZona(cazadorNoContratado, ponte);
                    });
        }

        @Test
        void testEfectosDeCapturas() {
            Profugo profugoDeExtraHabilidad = new Profugo(40, 60, Boolean.TRUE);
            ponte.agregarProfugo(profugoDeExtraHabilidad);
            ponte.agregarProfugo(profugonervioso);
            ponte.agregarProfugo(profugonervioso);
            ponte.agregarProfugo(profugoNoNerviosoHabilidoso);
            empresa.enviarCazadorAZona(cazadorSigiloso, ponte);
            assertAll(
                    () -> assertEquals(2, cazadorSigiloso.getCapturados().size()), // El cazador sigiloso solo puede
                                                                                   // capturar a 2 de los 3 profugos
                    () -> assertEquals(2, ponte.getProfugos().size()), // Los 2 profugos capturados salen de la ciudad
                    () -> assertEquals(46, profugoNoNerviosoHabilidoso.getHabilidad()), // Se vuelve nervioso por la
                                                                                        // intimidacion
                    () -> assertEquals(100, cazadorSigiloso.getExperiencia()) // Experiencia adquirida por las capturas
            );
        }

        @Test
        void testCapturaDeCazadorUrbano() {
            ponte.agregarProfugo(profugonervioso);
            ponte.agregarProfugo(profugoNoNerviosoHabilidoso);
            ponte.agregarProfugo(profugoNoNerviosoHabilidoso);
            empresa.enviarCazadorAZona(cazadorUrbano, ponte);
            assertEquals(2, cazadorUrbano.getCapturados().size());
        }

        @Test
        void testCapturaDeCazadorRural() {
            ponte.agregarProfugo(profugonervioso);
            ponte.agregarProfugo(profugonervioso);
            ponte.agregarProfugo(profugoNoNerviosoHabilidoso);
            empresa.enviarCazadorAZona(cazadorRural, ponte);
            assertEquals(2, cazadorRural.getCapturados().size());
        }
    }

    @Nested
    class TestReporteria {

        Profugo profugoSuperHabilidoso = new Profugo(40, 100, Boolean.FALSE);
        List<Profugo> profugos1 = new ArrayList<>(Arrays.asList(profugonervioso , profugonervioso));
        List<Profugo> profugos2 = new ArrayList<>(Arrays.asList(profugoNoNerviosoHabilidoso , profugoNoNerviosoHabilidoso , profugoSuperHabilidoso));

        @BeforeEach
        void init() {
            cazadorSigiloso.capturarProfugos(profugos1);
            cazadorUrbano.capturarProfugos(profugos2);
            cazadorRural.capturarProfugos(profugos1);
    }

        @Test
        void testTotalDeCapturados() {
            assertEquals(7,empresa.profugosCapturados().size());
        }

        @Test
        void testProfugoMasHabilCapturado() {
            assertEquals(profugoSuperHabilidoso, empresa.profugoMasHabilCapturado());
        }

        @Test
        void testCazadorConMasCapturas() {
            assertTrue(empresa.cazadorConMasCapturas() instanceof CazadorUrbano);
        }

    }

} 
