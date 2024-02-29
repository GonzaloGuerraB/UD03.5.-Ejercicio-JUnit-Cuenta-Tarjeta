package gonzalo.ejercicio5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class MovimientoTest {

    private Movimiento movimiento;

    @BeforeEach
    public void setUp() {
        movimiento = new Movimiento();
    }

    @AfterEach
    public void tearDown() {
        movimiento = null;
    }

    @Test
    public void testGetImporte() {
        movimiento.setImporte(100.0);
        assertEquals(100.0, movimiento.getImporte());
    }

    @Test
    public void testGetConcepto() {
        movimiento.setConcepto("Compra en tienda");
        assertEquals("Compra en tienda", movimiento.getConcepto());
    }

    @Test
    public void testGetFecha() {
        Date fecha = new Date();
        movimiento.setFecha(fecha);
        
        assertEquals(fecha, movimiento.getFecha());
    }

    @Test
    public void testSetConcepto() {
        movimiento.setConcepto("Ingreso en cuenta");
        
        assertEquals("Ingreso en cuenta", movimiento.getConcepto());
    }

    @Test
    public void testSetFecha() {
        Date fecha = new Date();
        movimiento.setFecha(fecha);
        
        assertEquals(fecha, movimiento.getFecha());
    }

    @Test
    public void testSetImporte() {
        movimiento.setImporte(50.0);
        
        assertEquals(50.0, movimiento.getImporte(), 0.01);
    }
}