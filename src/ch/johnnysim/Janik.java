package ch.johnnysim;

import static ch.johnnysim.Ram.*;

public class Janik {

    static int mult_2a(Ram ram, int startAdr) {
        int adr = startAdr;

        ram
                .set(adr++, NULL, 112) // Multiplikation 112
                .set(adr++, TAKE, 100)
                .set(adr++, ADD, 100)
                .set(adr++, SAVE, 112)
                .set(adr++, NULL, 113) // Signatur 113
                .set(adr++, TAKE, 101)
                .set(adr++, SAVE, 113)
        ;

        return adr;
    }

    static int x1(Ram ram, int startAdr) {
        int adr = startAdr;
        int mk1;
        int mk2;
        int mk3;

        ram
                .set(133, 100)

                //ganzzahlige division
                .set(adr++, TAKE, 121)
                .set(adr++, SAVE, 134) // kopie des zählers
                .set(adr++, NULL, 135) // zählvariable (wieviel mal hat's platz...)
                .set(mk1 = adr++, TAKE, 134)
                .set(adr++, SAVE, 136) // rest zwischenspeichern, vor subtraktion
                .set(adr++, SUB, 112)
                .set(adr++, SAVE, 134)
                .set(adr++, TST, 134) // wenn noch grösser 0
                .set(adr++, INC, 135) // inkrementier zählvariable
                .set(adr++, TST, 134) // wenn noch grösser 0
                .set(adr++, JMP, mk1) // nochmal

                //falls kein Rest
                .set(adr++, TAKE, 112)
                .set(adr++, SUB, 136)
                .set(adr++, SAVE, 138)
                .set(adr++, TST, 138)
                .set(adr++, JMP, adr+2)
                .set(adr++, INC, 135)
                .set(adr++, NULL, 136)

                .set(adr++, TAKE, 135)
                .set(adr++, SAVE, 127)

                // rest * 100
                .set(adr++, NULL, 137)
                .set(mk2 = adr++, TST, 136)
                .set(adr++, JMP, adr+1)
                .set(adr++, JMP, adr+5) // kein rest (mehr)
                .set(adr++, TAKE, 137)
                .set(adr++, ADD, 133)
                .set(adr++, SAVE, 137)
                .set(adr++, DEC, 136)
                .set(adr++, JMP, mk2)

                //division für kommastellen (rest*100+kommastellen)
                .set(adr++, TAKE, 137)
                .set(adr++, ADD, 122) // kommastellen des ursprungs-zählers hinzu
                .set(adr++, SAVE, 134) // kopie des zählers
                .set(adr++, NULL, 135) // zählvariable (wieviel mal hat's platz...)
                .set(mk3 = adr++, TAKE, 134)
                .set(adr++, SAVE, 136) // rest zwischenspeichern, vor subtraktion
                .set(adr++, SUB, 112)
                .set(adr++, SAVE, 134)
                .set(adr++, TST, 134) // wenn noch grösser 0
                .set(adr++, INC, 135) // inkrementier zählvariable
                .set(adr++, TST, 134) // wenn noch grösser 0
                .set(adr++, JMP, mk3) // nochmal

                //falls kein Rest für Kommastellen
                .set(adr++, TAKE, 112)
                .set(adr++, SUB, 136)
                .set(adr++, SAVE, 138)
                .set(adr++, TST, 138)
                .set(adr++, JMP, adr+1)
                .set(adr++, INC, 135)

                .set(adr++, TAKE, 135)
                .set(adr++, SAVE, 128)

                //sign für division
                .set(adr++, TAKE, 113)
                .set(adr++, TST, 113)
                .set(adr++, JMP, adr+2)
                .set(adr++, ADD, 123)
                .set(adr++, JMP, adr+1)
                .set(adr++, SUB, 123)
                .set(adr++, SAVE, 129)

        ;
        return adr;
    }
}
