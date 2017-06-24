package ch.johnnysim;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZaehlerX1Test {

    @Test
    public void test_zaehler_x1_b_negativ_mit_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 1) // sign(b)
                .set(119, 8) // resultat der wurzel
                .set(120, 50) // kommastellen der wurzel
                ;
        Joenu.zaehler_x1(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 121, 122, 123);
        ram.run();

        assertEquals(diag_zaeler_x1(ram), 15, ram.get(121));
        assertEquals(diag_zaeler_x1(ram), 50, ram.get(122));
        assertEquals(diag_zaeler_x1(ram), 0, ram.get(123));
    }

    @Test
    public void test_zaehler_x1_b_negativ_ohne_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 1) // sign(b)
                .set(119, 8) // resultat der wurzel
                .set(120, 0) // kommastellen der wurzel
                ;
        Joenu.zaehler_x1(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 121, 122, 123);
        ram.run();

        assertEquals(diag_zaeler_x1(ram), 15, ram.get(121));
        assertEquals(diag_zaeler_x1(ram), 0, ram.get(122));
        assertEquals(diag_zaeler_x1(ram), 0, ram.get(123));
    }

    @Test
    public void test_zaehler_x1_b_positiv_wurzel_kleiner_mit_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 0) // sign(b)
                .set(119, 6) // resultat der wurzel
                .set(120, 50) // kommastellen der wurzel
                ;
        Joenu.zaehler_x1(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 121, 122, 123);
        ram.run();

        assertEquals(diag_zaeler_x1(ram), 0, ram.get(121));
        assertEquals(diag_zaeler_x1(ram), 50, ram.get(122));
        assertEquals(diag_zaeler_x1(ram), 1, ram.get(123));
    }

    @Test
    public void test_zaehler_x1_b_positiv_wurzel_kleiner_ohne_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 0) // sign(b)
                .set(119, 6) // resultat der wurzel
                .set(120, 0) // kommastellen der wurzel
                ;
        Joenu.zaehler_x1(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 121, 122, 123);
        ram.run();
        assertEquals(diag_zaeler_x1(ram), 1, ram.get(121));
        assertEquals(diag_zaeler_x1(ram), 0, ram.get(122));
        assertEquals(diag_zaeler_x1(ram), 1, ram.get(123));
    }


    @Test
    public void test_zaehler_x1_b_positiv_wurzel_gleich_mit_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 0) // sign(b)
                .set(119, 7) // resultat der wurzel
                .set(120, 50) // kommastellen der wurzel
                ;
        Joenu.zaehler_x1(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 121, 122, 123);
        ram.run();

        assertEquals(diag_zaeler_x1(ram), 0, ram.get(121));
        assertEquals(diag_zaeler_x1(ram), 50, ram.get(122));
        assertEquals(diag_zaeler_x1(ram), 0, ram.get(123));
    }

    @Test
    public void test_zaehler_x1_b_positiv_wurzel_groesser_mit_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 0) // sign(b)
                .set(119, 8) // resultat der wurzel
                .set(120, 50) // kommastellen der wurzel
                ;
        Joenu.zaehler_x1(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 121, 122, 123);
        ram.run();

        assertEquals(diag_zaeler_x1(ram), 1, ram.get(121));
        assertEquals(diag_zaeler_x1(ram), 50, ram.get(122));
        assertEquals(diag_zaeler_x1(ram), 0, ram.get(123));
    }

    @Test
    public void test_zaehler_x1_b_positiv_wurzel_groesser_ohne_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 0) // sign(b)
                .set(119, 8) // resultat der wurzel
                .set(120, 0) // kommastellen der wurzel
                ;
        Joenu.zaehler_x1(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 121, 122, 123);
        ram.run();
        assertEquals(diag_zaeler_x1(ram), 1, ram.get(121));
        assertEquals(diag_zaeler_x1(ram), 0, ram.get(122));
        assertEquals(diag_zaeler_x1(ram), 0, ram.get(123));
    }

    @Test
    public void test_zaehler_x1_b_negativ_wurzel_gleich_ohne_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 1) // sign(b)
                .set(119, 7) // resultat der wurzel
                .set(120, 0) // kommastellen der wurzel
                ;
        Joenu.zaehler_x1(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 121, 122, 123);
        ram.run();
        assertEquals(diag_zaeler_x1(ram), 14, ram.get(121));
        assertEquals(diag_zaeler_x1(ram), 0, ram.get(122));
        assertEquals(diag_zaeler_x1(ram), 0, ram.get(123));
    }

    private String diag_zaeler_x1(Ram ram) {
        return "-(" + (ram.get(103) == 1 ? "-": "") + ram.get(102) + ")+" +
                "(" + (ram.get(119)+ram.get(120)/100d) + ")" +
                "=?" + (ram.get(123) == 1 ? "-": "") + (ram.get(121)+ram.get(122)/100d);
    }
}