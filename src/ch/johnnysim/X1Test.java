package ch.johnnysim;

import org.junit.Test;

import static org.junit.Assert.*;


public class X1Test {

    @Test
    public void test_2_31_durch_6() {
        Ram ram = new Ram()
                .set(121, 2) //zähler x1
                .set(122, 31) //kommastellen zähler x1
                .set(123, 0) //sign(zähler x1)
                .set(112, 6) //2a
                .set(113, 0) //sign(2a)
                ;

        Janik.x1(ram, 0);

        ram.setPrintReg(
                //121, 122, 123, 112, 113,
                127, 128, 129,
                340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350);
        ram.run();

        assertEquals(0, ram.get(127)); //x1
        assertEquals(62, ram.get(128)); //kommastellen x1
        assertEquals(0, ram.get(129)); //sign(x1)
    }
    @Test
    public void test_minus2_durch_minus10() {
        Ram ram = new Ram()
                .set(121, 2) //zähler x1
                .set(122, 0) //kommastellen zähler x1
                .set(123, 1) //sign(zähler x1)
                .set(112, 10) //2a
                .set(113, 1) //sign(2a)
                ;

        Janik.x1(ram, 0);

        ram.setPrintReg(
                //121, 122, 123, 112, 113,
                127, 128, 129,
                133, 134, 135, 136, 137, 138);
        ram.run();

        assertEquals(0, ram.get(127)); //x1
        assertEquals(20, ram.get(128)); //kommastellen x1
        assertEquals(0, ram.get(129)); //sign(x1)
    }
}