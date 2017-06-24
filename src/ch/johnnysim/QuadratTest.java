package ch.johnnysim;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QuadratTest {

    @Test
    public void test_quad9() {
        Ram ram = new Ram()
                .set(102, 9) //b
                ;

        Joenu.bquadrat(ram, 0);

        ram.setPrintReg(
                //102,
                116,
                600);
        ram.run();

        assertEquals(81, ram.get(116)); //ergebnis
    }

    @Test
    public void test_quad141() {
        Ram ram = new Ram()
                .set(102, 141) //b
                ;

        Joenu.bquadrat(ram, 0);

        ram.setPrintReg(
                //102,
                116,
                600);
        ram.run();

        assertEquals(19881, ram.get(116)); //ergebnis
    }
}