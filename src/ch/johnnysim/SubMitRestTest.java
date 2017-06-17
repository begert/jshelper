package ch.johnnysim;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubMitRestTest {
    @Test
    public void test_sub_mit_rest_negativ() throws Exception {
        Ram ram = new Ram()
                .set(20, 789)
                .set(21, 2356);

        JSHelper.sub_mit_rest(ram, 0);

        ram.setPrintReg(20, 21, 22, 23);
        ram.run();
        assertEquals(1567, ram.get(22));
        assertEquals(1, ram.get(23));
    }

    @Test
    public void test_sub_mit_rest_positiv() throws Exception {
        Ram ram = new Ram()
                .set(20, 14)
                .set(21, 8);

        JSHelper.sub_mit_rest(ram, 0);

        ram.setPrintReg(20, 21, 22, 23);
        ram.run();
        assertEquals(6, ram.get(22));
        assertEquals(0, ram.get(23));
    }

    @Test
    public void test_sub_mit_rest_genau_null() throws Exception {
        Ram ram = new Ram()
                .set(20, 14)
                .set(21, 14);

        JSHelper.sub_mit_rest(ram, 0);

        ram.setPrintReg(20, 21, 22, 23);
        ram.run();
        assertEquals(0, ram.get(22));
        assertEquals(0, ram.get(23));
    }
}