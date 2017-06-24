package ch.johnnysim;

import java.util.stream.IntStream;

import static ch.johnnysim.Ram.*;

public class JSHelper {

    public static void main(String... args) {

        int a = 0;
        int b = 0;
        int c = 0;

        Ram ram = new Ram()
                .set(100, Math.abs(a))
                .set(101, Math.signum(a) < 0 ? 1 : 0)
                .set(102, Math.abs(b))
                .set(103, Math.signum(b) < 0 ? 1 : 0)
                .set(104, Math.abs(c))
                .set(105, Math.signum(c) < 0 ? 1 : 0)
                .set(0, NULL, 106)
                .set(1, NULL, 107)
                .set(2, NULL, 108)
                .set(3, NULL, 109)
                .set(4, NULL, 110)
                .set(5, NULL,111)
                .set(6, JMP, 200)
                ;

        int adr = 200;

        adr = Janik.mult_2a(ram, adr);
        adr = Maethu.mult_4ac(ram, adr);

        adr = Joenu.bquadrat(ram, adr);
        adr = Joenu.subb2minus4ac(ram, adr);
        adr = Joenu.wurzelv3(ram, adr);

        adr = Joenu.zaehler_x1(ram, adr);
        adr = Maethu.zaehler_x2(ram, adr);
        adr = Janik.x1(ram, adr);
        adr = Maethu.x2(ram, adr);

        adr = Joenu.werte_x_rauf(ram, adr);

        ram.set(adr, HLT, 0);

        System.out.println(adr);
        ram.setPrintReg(IntStream.rangeClosed(100, 132).toArray());
        ram.run();

        printResult(a, b, c, ram);

        ram.save("mitternachtsformel.ram");
    }

    private static void printResult(int a, int b, int c, Ram ram) {
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("x1,2=["
                + (ram.get(108) == 1 ? "-": "") + (ram.get(106)+ram.get(107)/100d) + ", "
                + (ram.get(111) == 1 ? "-": "") + (ram.get(109)+ram.get(110)/100d) + "]");
    }
}

