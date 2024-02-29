package gonzalo.ejercicio5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {

    private Cuenta cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new Cuenta("1111", "Juanfran");
    }

    @Test
    public void testIngresarConCantidadNegativa() {
        assertThrows(Exception.class, () -> cuenta.ingresar(-50.0));
    }

    @Test
    public void testRetirarConCantidadNegativa() {
        assertThrows(Exception.class, () -> cuenta.retirar(-30.0));
    }

    @Test
    public void testRetirarConSaldoInsuficiente() {
        assertThrows(Exception.class, () -> cuenta.retirar(50.0));
    }

    @Test
    public void testIngresarConConceptoYCantidadNegativa() {
        assertThrows(Exception.class, () -> cuenta.ingresar("Ingreso por transferencia", -30.0));
    }

    @Test
    public void testRetirarConConceptoYCantidadNegativa() {
        assertThrows(Exception.class, () -> cuenta.retirar("Retiro en cajero", -20.0));
    }

    @Test
    public void testRetirarConConceptoYSaldoInsuficiente() {
        assertThrows(Exception.class, () -> cuenta.retirar("Retiro en cajero", 30.0));
    }

    @Test
    public void testRetirar() throws Exception {
        cuenta.ingresar(500.0);
        cuenta.retirar(200.0);
        assertEquals(300.0, cuenta.getSaldo());
    }

    @Test
    public void testIngresarConConcepto() throws Exception {
        cuenta.ingresar("Ingreso por transferencia", 300.0);
        assertEquals(300.0, cuenta.getSaldo());
    }

    @Test
    public void testRetirarConConcepto() throws Exception {
        cuenta.ingresar(500.0);
        cuenta.retirar("Retiro en cajero", 200.0);
        assertEquals(300.0, cuenta.getSaldo());
    }
    
    
    @Test
    public void testGetSaldoDespuesDeVariosMovimientos() throws Exception {
        cuenta.ingresar(200.0);
        cuenta.retirar("Compra con tarjeta", 50.0);
        cuenta.ingresar("Transferencia", 100.0);
        assertEquals(250.0, cuenta.getSaldo());
    }

    @Test
    public void testAddMovimientoConImporteNegativo() {
        Movimiento movimiento = new Movimiento();
        movimiento.setConcepto("Retiro en cajero");
        movimiento.setImporte(-30.0);
        assertThrows(Exception.class, () -> cuenta.addMovimiento(movimiento));
    }

    @Test
    public void testAddMovimientoConImportePositivo() throws Exception {
        Movimiento movimiento = new Movimiento();
        movimiento.setConcepto("Ingreso en efectivo");
        movimiento.setImporte(50.0);
        cuenta.addMovimiento(movimiento);
        assertEquals(50.0, cuenta.getSaldo(), 0.01);
    }
    
}