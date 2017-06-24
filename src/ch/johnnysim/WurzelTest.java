package ch.johnnysim;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class WurzelTest {

    @Test
    public void test_wurzel105() {
        Ram ram = new Ram()
                .set(117, 105) //b**2-4ac
                .set(118, 0) //Vorzeichen 117
                .set(0, Ram.JMP, 200)
                ;

        Joenu.wurzelv2(ram, 200);

        ram.setPrintReg(
                //117, 118,
                119, 120,
                147, 145, 148, 149, 150, 151, 152);
        ram.run();

        assertEquals(10, ram.get(119)); //zahl wurzel
        assertEquals(30, ram.get(120)); //kommastelle wurzel
    }

    @Test
    public void test_wurzel50() {
        Ram ram = new Ram()
                .set(117, 50) //b**2-4ac
                .set(118, 0) //Vorzeichen 117
                .set(0, Ram.JMP, 200)
                ;

        Joenu.wurzelv2(ram, 200);

        ram.setPrintReg(
                //117, 118,
                119, 120,
                147, 145, 148, 149, 150, 151, 152);
        ram.run();

        assertEquals(7, ram.get(119)); //zahl wurzel
        assertEquals(10, ram.get(120)); //kommastelle wurzel
    }


    @Test
    public void test_wurzel1() {
        Ram ram = new Ram()
                .set(117, 1) //b**2-4ac
                .set(118, 0) //Vorzeichen 117
                .set(0, Ram.JMP, 200)
                ;

        Joenu.wurzelv2(ram, 200);

        ram.setPrintReg(
                //117, 118,
                119, 120,
                147, 145, 148, 149, 150, 151, 152);
        ram.run();

        assertEquals(1, ram.get(119)); //zahl wurzel
        assertEquals(0, ram.get(120)); //kommastelle wurzel
    }

    @Test
    public void test_negativesVorz() {
        Ram ram = new Ram()
                .set(117, 7) //b**2-4ac
                .set(118, 1) //Vorzeichen 117
                .set(0, Ram.JMP, 200)
                ;

        Joenu.wurzelv2(ram, 200);

        ram.setPrintReg(
                //117, 118,
                108, 111, 119, 120,
                147, 145, 148, 149, 150, 151, 152);
        ram.run();

        assertEquals(1, ram.get(108)); //vorzeichen x1
        assertEquals(1, ram.get(111)); //vorzeichen x2
    }

    @Test
    public void test_Wurzel16() {
        Ram ram = new Ram()
                .set(117, 16) //b**2-4ac
                .set(118, 0) //Vorzeichen 117
                .set(0, Ram.JMP, 200)
                ;

        Joenu.wurzelv2(ram, 200);

        ram.setPrintReg(
                //117, 118,
                119, 120,
                147, 145, 148, 149, 150, 151, 152);
        ram.run();

        assertEquals(4, ram.get(119)); //zahl wurzel
        assertEquals(0, ram.get(120)); //kommastelle wurzel
    }

    @Test
    public void test_Wurzel99() {
        Ram ram = new Ram()
                .set(117, 99) //b**2-4ac
                .set(118, 0) //Vorzeichen 117
                .set(0, Ram.JMP, 200)
                ;

        Joenu.wurzelv2(ram, 200);

        ram.setPrintReg(
                //117, 118,
                119, 120,
                147, 145, 148, 149, 150, 151, 152);
        ram.run();

        assertEquals(9, ram.get(119)); //zahl wurzel
        assertEquals(90, ram.get(120)); //kommastelle wurzel
    }

    @Test
    public void test_Wurzel98() {
        Ram ram = new Ram()
                .set(117, 98) //b**2-4ac
                .set(118, 0) //Vorzeichen 117
                .set(0, Ram.JMP, 200)
                ;

        Joenu.wurzelv2(ram, 200);

        ram.setPrintReg(
                //117, 118,
                119, 120,
                147, 145, 148, 149, 150, 151, 152);
        ram.run();

        assertEquals(9, ram.get(119)); //zahl wurzel
        assertEquals(90, ram.get(120)); //kommastelle wurzel
    }

    @Test
    public void test_Wurzel100() {
        Ram ram = new Ram()
                .set(117, 100) //b**2-4ac
                .set(118, 0) //Vorzeichen 117
                .set(0, Ram.JMP, 200)
                ;

        Joenu.wurzelv2(ram, 200);

        ram.setPrintReg(
                //117, 118,
                119, 120,
                147, 145, 148, 149, 150, 151, 152);
        ram.run();

        assertEquals(10, ram.get(119)); //zahl wurzel
        assertEquals(0, ram.get(120)); //kommastelle wurzel
    }

    @Test
    public void test_Wurzel0() {
        Ram ram = new Ram()
                .set(117, 0) //b**2-4ac
                .set(118, 0) //Vorzeichen 117
                .set(0, Ram.JMP, 200)
                ;

        Joenu.wurzelv2(ram, 200);

        ram.setPrintReg(
                117, 118,
                119, 120,
                147, 145, 148, 149, 150, 151, 152);
        ram.run();

        assertEquals(0, ram.get(119)); //zahl wurzel
        assertEquals(0, ram.get(120)); //kommastelle wurzel
    }
}