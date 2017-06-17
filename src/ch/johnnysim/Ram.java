package ch.johnnysim;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ram {

    static final MCDef NULL = new MCDef(9, "NULL", ram -> ram.reg.set(ram.current(), new RegPos(0)));
    static final MCDef TAKE = new MCDef(1, "TAKE", ram -> ram.acc = ram.currentRef());
    static final MCDef SAVE = new MCDef(4, "SAVE", ram -> ram.reg.set(ram.current(), new RegPos(ram.acc)));
    static final MCDef ADD = new MCDef(2, "ADD", ram -> ram.acc = Math.min(ram.acc + ram.currentRef(), 19999));
    static final MCDef SUB = new MCDef(3, "SUB", ram -> ram.acc = Math.max(ram.acc - ram.currentRef(), 0));
    static final MCDef INC = new MCDef(7, "INC", ram -> ram.reg.get(ram.current()).low = Math.min(ram.reg.get(ram.current()).low + 1, 19999));
    static final MCDef DEC = new MCDef(8, "DEC", ram -> ram.reg.get(ram.current()).low = Math.max(ram.reg.get(ram.current()).low - 1, 0));
    static final MCDef TST = new MCDef(6, "TST", ram -> ram.counter.skipNext = ram.currentRef() == 0);
    static final MCDef JMP = new MCDef(5, "JMP", ram -> ram.counter.value = ram.current() - 1);
    static final MCDef HLT = new MCDef(10, "HLT", ram -> ram.counter.halt = true);

    private static final int MAX_ADR = 1000;
    private final List<RegPos> reg = new ArrayList<>(MAX_ADR);
    private Counter counter = new Counter();
    private int acc;

    private List<Integer> printReg = new ArrayList<>(MAX_ADR);

    Ram() {
        for(int i = 0; i < MAX_ADR; i++) {
            reg.add(new RegPos(0));
            printReg.add(i);
        }
    }

    Ram set(int adr, MCDef hi, int low) {
        reg.set(adr, new RegPos(hi, low));
        return this;
    }

    Ram set(int adr, int low) {
        reg.set(adr, new RegPos(low));
        return this;
    }

    int get(int adr) {
        return reg.get(adr).low;
    }

    void step() {
        if(counter.halt) {
            return;
        }
        RegPos regPos = reg.get(counter.value);

        if(regPos.hi != null) {
            regPos.hi.cmd.run(this);
            counter.value++;
            if (counter.skipNext) {
                counter.value++;
                counter.skipNext = false;
            }
            logStep(regPos);
        } else {
            System.out.println("no hi at " + counter.value + ", halting");
            counter.halt = true;
        }
    }

    private void logStep(RegPos regPos) {
        System.out.print(String.format("%3d %4s %3d", reg.indexOf(regPos), regPos.hi.text,regPos.low));
        System.out.print(String.format(" acc: %3d", acc));
        for(int i = 0; i < MAX_ADR; i++) {
            if (printReg.contains(i)) {
                System.out.print(String.format(" %d:%d ", i, reg.get(i).low));
            }
        }
        System.out.println();
    }

    void run() {
        counter = new Counter();
        while (!counter.halt) {
            step();
        }
    }

    void save(String filename) {
        try(FileWriter w = new FileWriter(filename)) {
            for (RegPos pos : reg) {
                w.write(pos.hi == null ? "" : ""+pos.hi.n);
                w.write(String.format("%03d\n", pos.low));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    int current() {
        return reg.get(counter.value).low;
    }

    int currentRef() {
        return reg.get(current()).low;
    }

    void setPrintReg(int... regs) {
        printReg.clear();
        for(int reg : regs) {
            printReg.add(reg);
        }
    }
}

class RegPos {
    MCDef hi;
    int low;

    RegPos(MCDef hi, int low) {
        this.hi = hi;
        this.low = low;
    }

    RegPos(int low) {
        this(null, low);
    }
}

class Counter {
    int value;
    boolean skipNext;
    boolean halt;
}

class MCDef {
    int n;
    String text;
    MicroCommand cmd;

    public MCDef(int n, String text, MicroCommand cmd) {
        this.n = n;
        this.text = text;
        this.cmd = cmd;
    }
}

interface MicroCommand {
    void run(Ram ram);
}