package ch.johnnysim;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class X2Test {
    @Test
    public void test_12_durch_4() {
        Ram ram = new Ram()
                .set(124, 12) //zähler x1
                .set(125, 0) //kommastellen zähler x1
                .set(126, 0) //sign(zähler x1)
                .set(112, 4) //2a
                .set(113, 0) //sign(2a)
                ;

        Maethu.x2(ram, 0);

        ram.setPrintReg(
                124, 125, 126, 112, 113,
                130, 131, 132,
                140, 141, 142, 143, 144);
        ram.run();

        assertEquals(3, ram.get(130)); //x1
        assertEquals(0, ram.get(131)); //kommastellen x1
        assertEquals(0, ram.get(132)); //sign(x1)
    }

    @Test
    public void test_11_durch_3() {
        Ram ram = new Ram()
                .set(124, 11) //zähler x1
                .set(125, 0) //kommastellen zähler x1
                .set(126, 0) //sign(zähler x1)
                .set(112, 3) //2a
                .set(113, 0) //sign(2a)
                ;

        Maethu.x2(ram, 0);

        ram.setPrintReg(
                124, 125, 126, 112, 113,
                130, 131, 132,
                140, 141, 142, 143, 144);
        ram.run();

        assertEquals(3, ram.get(130)); //x1
        assertEquals(66, ram.get(131)); //kommastellen x1
        assertEquals(0, ram.get(132)); //sign(x1)
    }

    @Test
    public void test_11_34_durch_3() {
        Ram ram = new Ram()
                .set(124, 11) //zähler x1
                .set(125, 34) //kommastellen zähler x1
                .set(126, 0) //sign(zähler x1)
                .set(112, 3) //2a
                .set(113, 0) //sign(2a)
                ;

        Maethu.x2(ram, 0);

        ram.setPrintReg(
                124, 125, 126, 112, 113,
                130, 131, 132,
                140, 141, 142, 143, 144);
        ram.run();

        assertEquals(3, ram.get(130)); //x1
        assertEquals(78, ram.get(131)); //kommastellen x1
        assertEquals(0, ram.get(132)); //sign(x1)
    }

    @Test
    public void test_12_durch_minus4() {
        Ram ram = new Ram()
                .set(124, 12) //zähler x1
                .set(125, 0) //kommastellen zähler x1
                .set(126, 0) //sign(zähler x1)
                .set(112, 4) //2a
                .set(113, 1) //sign(2a)
                ;

        Maethu.x2(ram, 0);

        ram.setPrintReg(
                124, 125, 126, 112, 113,
                130, 131, 132,
                140, 141, 142, 143, 144);
        ram.run();

        assertEquals(3, ram.get(130)); //x1
        assertEquals(0, ram.get(131)); //kommastellen x1
        assertEquals(1, ram.get(132)); //sign(x1)
    }

    @Test
    public void test_minus12_durch_minus4() {
        Ram ram = new Ram()
                .set(124, 12) //zähler x1
                .set(125, 0) //kommastellen zähler x1
                .set(126, 1) //sign(zähler x1)
                .set(112, 4) //2a
                .set(113, 1) //sign(2a)
                ;

        Maethu.x2(ram, 0);

        ram.setPrintReg(
                124, 125, 126, 112, 113,
                130, 131, 132,
                140, 141, 142, 143, 144);
        ram.run();

        assertEquals(3, ram.get(130)); //x1
        assertEquals(0, ram.get(131)); //kommastellen x1
        assertEquals(0, ram.get(132)); //sign(x1)
    }

    @Test
    public void test_minus12_durch_4() {
        Ram ram = new Ram()
                .set(124, 12) //zähler x1
                .set(125, 0) //kommastellen zähler x1
                .set(126, 1) //sign(zähler x1)
                .set(112, 4) //2a
                .set(113, 0) //sign(2a)
                ;

        Maethu.x2(ram, 0);

        ram.setPrintReg(
                124, 125, 126, 112, 113,
                130, 131, 132,
                140, 141, 142, 143, 144);
        ram.run();

        assertEquals(3, ram.get(130)); //x1
        assertEquals(0, ram.get(131)); //kommastellen x1
        assertEquals(1, ram.get(132)); //sign(x1)
    }

    @Test
    public void test_0_durch_0() {
        Ram ram = new Ram()
                .set(124, 0) //zähler x1
                .set(125, 0) //kommastellen zähler x1
                .set(126, 0) //sign(zähler x1)
                .set(112, 0) //2a
                .set(113, 0) //sign(2a)
                ;

        Maethu.x2(ram, 0);

        ram.setPrintReg(
                124, 125, 126, 112, 113,
                130, 131, 132,
                140, 141, 142, 143, 144);
        ram.run();

        assertEquals(0, ram.get(130)); //x1
        assertEquals(0, ram.get(131)); //kommastellen x1
        assertEquals(0, ram.get(132)); //sign(x1)
    }
}