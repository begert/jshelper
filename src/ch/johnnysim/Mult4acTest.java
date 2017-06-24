package ch.johnnysim;

import org.junit.Test;

import static org.junit.Assert.*;

public class Mult4acTest {

    @Test
    public void test_a_und_c_positiv() {
        Ram ram = new Ram()
                .set(100, 5)
                .set(101, 0)
                .set(104, 4)
                .set(105, 0)
                ;
        Maethu.mult_4ac(ram, 0);

        ram.setPrintReg(100, 101, 102, 103, 104, 105, 114, 115, 500);
        ram.run();

        assertEquals(80, ram.get(114));
        assertEquals(0, ram.get(115));
    }

    @Test
    public void test_a_negativ() {
        Ram ram = new Ram()
                .set(100, 5)
                .set(101, 1)
                .set(104, 4)
                .set(105, 0)
                ;
        Maethu.mult_4ac(ram, 0);

        ram.setPrintReg(100, 101, 102, 103, 104, 105, 114, 115, 500);
        ram.run();

        assertEquals(80, ram.get(114));
        assertEquals(1, ram.get(115));
    }

    @Test
    public void test_c_negativ() {
        Ram ram = new Ram()
                .set(100, 5)
                .set(101, 0)
                .set(104, 4)
                .set(105, 1)
                ;
        Maethu.mult_4ac(ram, 0);

        ram.setPrintReg(100, 101, 102, 103, 104, 105, 114, 115, 500);
        ram.run();

        assertEquals(80, ram.get(114));
        assertEquals(1, ram.get(115));
    }

    @Test
    public void test_a_und_c_negativ() {
        Ram ram = new Ram()
                .set(100, 5)
                .set(101, 1)
                .set(104, 4)
                .set(105, 1)
                ;
        Maethu.mult_4ac(ram, 0);

        ram.setPrintReg(100, 101, 102, 103, 104, 105, 114, 115, 500);
        ram.run();

        assertEquals(80, ram.get(114));
        assertEquals(0, ram.get(115));
    }
}