package gonzalo.ejercicio5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class CreditoTest {

    private Credito credito;

    @BeforeEach
    public void setUp() {
        credito = new Credito("1234", "Juanfran", new Date(), 1000.0);
    }

    @Test
    public void testRetirarConCreditoSuficiente() throws Exception {
        credito.retirar(500.0);

        assertEquals(500.0, credito.getSaldo());
        assertEquals(500.0, credito.getCreditoDisponible());
    }

    @Test
    public void testRetirarConCreditoInsuficiente() {
        assertThrows(Exception.class, () -> credito.retirar(1500.0));
    }

    @Test
    public void testIngresar() throws Exception {
        credito.ingresar(200.0);

        assertEquals(200.0, credito.getSaldo());
        assertEquals(1200.0, credito.getCreditoDisponible());
    }

    @Test
    public void testPagoEnEstablecimiento() throws Exception {
        credito.pagoEnEstablecimiento("Tienda", 300.0);

        assertEquals(300.0, credito.getSaldo());
        assertEquals(700.0, credito.getCreditoDisponible());
    }

    @Test
    public void testLiquidarConMovimientos() {
        credito.liquidar(1, 2024);
        assertEquals(0.0, credito.getCreditoDisponible());
    }

    @Test
    public void testLiquidarSinMovimientos() {
        credito.liquidar(2, 2024);

        assertEquals(1000.0, credito.getCreditoDisponible());
    }
}