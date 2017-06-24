package ch.johnnysim;

import org.junit.Test;

import static org.junit.Assert.*;

public class Sub4acb2Test {

    @Test
    public void test_4ac_groesser() throws Exception {
        Ram ram = new Ram()
                .set(114, 9) // 4ac
                .set(115, 0) // sign(4ac)
                .set(116, 8) // b**2
                ;
        Joenu.subb2minus4ac(ram, 0);

        ram.setPrintReg(114, 115, 116, 117, 118);
        ram.run();

        assertEquals(1, ram.get(117));
        assertEquals(1, ram.get(118));
    }

    @Test
    public void test_4ac_kleiner() throws Exception {
        Ram ram = new Ram()
                .set(114, 7) // 4ac
                .set(115, 0) // sign(4ac)
                .set(116, 8) // b**2
                ;
        Joenu.subb2minus4ac(ram, 0);

        ram.setPrintReg(114, 115, 116, 117, 118);
        ram.run();

        assertEquals(1, ram.get(117));
        assertEquals(0, ram.get(118));
    }

    @Test
    public void test_4ac_gleich() throws Exception {
        Ram ram = new Ram()
                .set(114, 8) // 4ac
                .set(115, 0) // sign(4ac)
                .set(116, 8) // b**2
                ;
        Joenu.subb2minus4ac(ram, 0);

        ram.setPrintReg(114, 115, 116, 117, 118);
        ram.run();

        assertEquals(0, ram.get(117));
        assertEquals(0, ram.get(118));
    }

    @Test
    public void test_4ac_negativ() throws Exception {
        Ram ram = new Ram()
                .set(114, 9) // 4ac
                .set(115, 1) // sign(4ac)
                .set(116, 8) // b**2
                ;
        Joenu.subb2minus4ac(ram, 0);

        ram.setPrintReg(114, 115, 116, 117, 118);
        ram.run();

        assertEquals(17, ram.get(117));
        assertEquals(0, ram.get(118));
    }

}