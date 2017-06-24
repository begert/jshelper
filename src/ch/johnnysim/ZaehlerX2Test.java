package ch.johnnysim;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZaehlerX2Test {

    @Test
    public void test_zaehler_x2_b_positiv_mit_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 0) // sign(b)
                .set(119, 6) // resultat der wurzel
                .set(120, 50) // kommastellen der wurzel
                ;
        Maethu.zaehler_x2(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 124, 125, 126);
        ram.run();

        assertEquals(diag_zaeler_x2(ram), 13, ram.get(124));
        assertEquals(diag_zaeler_x2(ram), 50, ram.get(125));
        assertEquals(diag_zaeler_x2(ram), 1, ram.get(126));
    }

    @Test
    public void test_zaehler_x2_b_positiv_ohne_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 0) // sign(b)
                .set(119, 6) // resultat der wurzel
                .set(120, 0) // kommastellen der wurzel
                ;
        Maethu.zaehler_x2(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 124, 125, 126);
        ram.run();

        assertEquals(diag_zaeler_x2(ram), 13, ram.get(124));
        assertEquals(diag_zaeler_x2(ram), 0, ram.get(125));
        assertEquals(diag_zaeler_x2(ram), 1, ram.get(126));
    }

    @Test
    public void test_zaehler_x2_b_negativ_wurzel_kleiner_mit_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 1) // sign(b)
                .set(119, 6) // resultat der wurzel
                .set(120, 50) // kommastellen der wurzel
        ;
        Maethu.zaehler_x2(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 124, 125, 126);
        ram.run();

        assertEquals(diag_zaeler_x2(ram), 0, ram.get(124));
        assertEquals(diag_zaeler_x2(ram), 50, ram.get(125));
        assertEquals(diag_zaeler_x2(ram), 0, ram.get(126));
    }

    @Test
    public void test_zaehler_x2_b_negativ_wurzel_kleiner_ohne_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 1) // sign(b)
                .set(119, 6) // resultat der wurzel
                .set(120, 0) // kommastellen der wurzel
                ;
        Maethu.zaehler_x2(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 124, 125, 126);
        ram.run();
        assertEquals(diag_zaeler_x2(ram), 1, ram.get(124));
        assertEquals(diag_zaeler_x2(ram), 0, ram.get(125));
        assertEquals(diag_zaeler_x2(ram), 0, ram.get(126));
    }


    @Test
    public void test_zaehler_x2_b_negativ_wurzel_gleich_mit_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 1) // sign(b)
                .set(119, 7) // resultat der wurzel
                .set(120, 50) // kommastellen der wurzel
                ;
        Maethu.zaehler_x2(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 124, 125, 126);
        ram.run();

        assertEquals(diag_zaeler_x2(ram), 0, ram.get(124));
        assertEquals(diag_zaeler_x2(ram), 50, ram.get(125));
        assertEquals(diag_zaeler_x2(ram), 1, ram.get(126));
    }

    @Test
    public void test_zaehler_x2_b_negativ_wurzel_groesser_mit_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 1) // sign(b)
                .set(119, 8) // resultat der wurzel
                .set(120, 50) // kommastellen der wurzel
                ;
        Maethu.zaehler_x2(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 124, 125, 126);
        ram.run();

        assertEquals(diag_zaeler_x2(ram), 1, ram.get(124));
        assertEquals(diag_zaeler_x2(ram), 50, ram.get(125));
        assertEquals(diag_zaeler_x2(ram), 1, ram.get(126));
    }

    @Test
    public void test_zaehler_x2_b_negativ_wurzel_groesser_ohne_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 1) // sign(b)
                .set(119, 8) // resultat der wurzel
                .set(120, 0) // kommastellen der wurzel
                ;
        Maethu.zaehler_x2(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 124, 125, 126);
        ram.run();
        assertEquals(diag_zaeler_x2(ram), 1, ram.get(124));
        assertEquals(diag_zaeler_x2(ram), 0, ram.get(125));
        assertEquals(diag_zaeler_x2(ram), 1, ram.get(126));
    }

    @Test
    public void test_zaehler_x2_b_negativ_wurzel_gleich_ohne_kommastellen() throws Exception {
        Ram ram = new Ram()
                .set(102, 7) // b
                .set(103, 1) // sign(b)
                .set(119, 7) // resultat der wurzel
                .set(120, 0) // kommastellen der wurzel
                ;
        Maethu.zaehler_x2(ram, 0);

        ram.setPrintReg(102, 103, 119, 120, 124, 125, 126);
        ram.run();
        assertEquals(diag_zaeler_x2(ram), 0, ram.get(124));
        assertEquals(diag_zaeler_x2(ram), 0, ram.get(125));
        assertEquals(diag_zaeler_x2(ram), 0, ram.get(126));
    }

    private String diag_zaeler_x2(Ram ram) {
        return "-(" + (ram.get(103) == 1 ? "-": "") + ram.get(102) + ")" +
                        "-(" + (ram.get(119)+ram.get(120)/100d) + ")" +
                        "=?" + (ram.get(126) == 1 ? "-": "") + (ram.get(124)+ram.get(125)/100d);
    }
}