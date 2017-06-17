package ch.johnnysim;

import java.util.stream.IntStream;

import static ch.johnnysim.Ram.*;

public class JSHelper {

    public static void main(String... args) {
        Ram ram = new Ram()
                .set(20, 5)
                .set(21, 3)
                ;

        int adr = 0;

        adr = sub_mit_rest(ram, adr);
        ram.set(adr, HLT, 0);

        System.out.println(adr);
        ram.setPrintReg(IntStream.rangeClosed(0, 20).toArray());
        ram.run();

        ram.save("ram.ram");
    }

    static int sub_mit_rest(Ram ram, int startAdr) {
        int adr = startAdr;

        ram
                .set(adr++, TAKE, 20)
                .set(adr++, SUB,  21)
                .set(adr++, SAVE, 22)
                .set(adr++, TST,  22)
                .set(adr++, HLT,   0)
                .set(adr++, INC,  23)
                .set(adr++, TAKE, 21)
                .set(adr++, SUB,  20)
                .set(adr++, SAVE, 22)
                .set(adr++, TST,  22)
                .set(adr++, HLT,   0)
                .set(adr++, DEC,  23);
        return adr;
    }
}

