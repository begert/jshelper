package ch.johnnysim;


import static ch.johnnysim.Ram.*;

public class Maethu {


    /** nur als beispiel **/
    static void sub_mit_rest(Ram ram, int startAdr) {

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
                .set(adr++, DEC,  23)
                .set(adr++, HLT,   0);
    }

    static int zaehler_x2(Ram ram, int startAdr) {

        int adr = startAdr;
        ram
                .set(199, 100)

                //-(102)-(119)
                .set(adr++, TAKE, 120) // kommastellen der wurzel = ...
                .set(adr++, SAVE, 125) // ... kommastellen des reslutats
                .set(adr++, NULL, 126)
                .set(adr++, TST, 103) // teste ob b negativ
                .set(adr++, JMP, adr+5) // überspringe ersten teil

                //b ist positiv
                .set(adr++, TAKE, 102) // nimm b
                .set(adr++, ADD, 119) // + wurzel
                .set(adr++, SAVE, 124)
                .set(adr++, INC, 126) // sign = 1 wenn b positiv
                .set(adr++, JMP, adr+19) // überspringe 2ten teil

                //b ist negativ
                .set(adr++, TAKE, 102) // nimm b
                .set(adr++, SUB, 119) // - wurzel
                .set(adr++, SAVE, 124)
                .set(adr++, TST, 124) // wenn subtraktion > 0 ergeben hat
                .set(adr++, JMP, adr+4) // spring zu kommastellen (after DEC 126)
                .set(adr++, INC, 126) // sonst: sign=1 (subtraktion wird negativ oder 0)
                .set(adr++, TAKE, 119) // nimm wurzel
                .set(adr++, SUB, 102) // - b
                .set(adr++, SAVE, 124)

                .set(adr++, TST, 120) // wenn kommastellen vorhanden
                .set(adr++, JMP, adr+1)
                .set(adr++, JMP, adr+7) //überspringe kommastellen teil
                .set(adr++, TST, 126) // wenn resultat negativ
                .set(adr++, JMP, adr+2)
                .set(adr++, DEC, 124) // dekrementiere resultat
                .set(adr++, JMP, adr+3)
                .set(adr++, TAKE, 199) // nimm 100
                .set(adr++, SUB, 120) // kommastellen abziehen
                .set(adr++, SAVE, 125)

                //wenn -0.0
                .set(adr++, TST, 124)
                .set(adr++, JMP, adr+4)
                .set(adr++, TST, 125)
                .set(adr++, JMP, adr+2)
                .set(adr++, TST, 126)
                .set(adr++, DEC, 126) // sign=0
        ;
        return adr;
    }

    static int mult_4ac(Ram ram, int startAdr) {
        int adr = startAdr;
        int mk1;

        ram
                //a*c * 4
                .set(adr++, NULL, 114)
                .set(adr++, TAKE, 100)
                .set(adr++, SAVE, 139) // Dekrementiertes a
                .set(mk1 = adr++, TAKE, 114)
                .set(adr++, ADD, 104)
                .set(adr++, SAVE, 114)
                .set(adr++, DEC, 139)
                .set(adr++, TST, 139)
                .set(adr++, JMP, mk1)
                .set(adr++, TAKE, 114)
                .set(adr++, ADD, 114)
                .set(adr++, ADD, 114)
                .set(adr++, ADD, 114)
                .set(adr++, SAVE, 114)

                //sign 4ac
                .set(adr++, TAKE, 101)
                .set(adr++, TST, 101)
                .set(adr++, JMP, adr+2)
                .set(adr++, ADD, 105)
                .set(adr++, JMP, adr+1)
                .set(adr++, SUB, 105)
                .set(adr++, SAVE, 115)
        ;

        return adr;
    }

    static int x2(Ram ram, int startAdr) {
        int adr = startAdr;
        int mk1;
        int mk2;
        int mk3;

        ram
                .set(199, 100)

                //ganzzahlige division
                .set(adr++, TAKE, 124)
                .set(adr++, SAVE, 140) // kopie des zählers
                .set(adr++, NULL, 141) // zählvariable (wieviel mal hat's platz...)
                .set(mk1 = adr++, TAKE, 140)
                .set(adr++, SAVE, 142) // rest zwischenspeichern, vor subtraktion
                .set(adr++, SUB, 112)
                .set(adr++, SAVE, 140)
                .set(adr++, TST, 140) // wenn noch grösser 0
                .set(adr++, INC, 141) // inkrementier zählvariable
                .set(adr++, TST, 140) // wenn noch grösser 0
                .set(adr++, JMP, mk1) // nochmal

                //falls kein Rest
                .set(adr++, TAKE, 112)
                .set(adr++, SUB, 142)
                .set(adr++, SAVE, 144)
                .set(adr++, TST, 144)
                .set(adr++, JMP, adr+2)
                .set(adr++, INC, 141)
                .set(adr++, NULL, 142)

                .set(adr++, TAKE, 141)
                .set(adr++, SAVE, 130)

                // rest * 100
                .set(adr++, NULL, 143)
                .set(mk2 = adr++, TST, 142)
                .set(adr++, JMP, adr+1)
                .set(adr++, JMP, adr+5) // kein rest (mehr)
                .set(adr++, TAKE, 143)
                .set(adr++, ADD, 199)
                .set(adr++, SAVE, 143)
                .set(adr++, DEC, 142)
                .set(adr++, JMP, mk2)

                //division für kommastellen (rest*100+kommastellen)
                .set(adr++, TAKE, 143)
                .set(adr++, ADD, 125) // kommastellen des ursprungs-zählers hinzu
                .set(adr++, SAVE, 140) // kopie des zählers
                .set(adr++, NULL, 141) // zählvariable (wieviel mal hat's platz...)
                .set(mk3 = adr++, TAKE, 140)
                .set(adr++, SAVE, 142) // rest zwischenspeichern, vor subtraktion
                .set(adr++, SUB, 112)
                .set(adr++, SAVE, 140)
                .set(adr++, TST, 140) // wenn noch grösser 0
                .set(adr++, INC, 141) // inkrementier zählvariable
                .set(adr++, TST, 140) // wenn noch grösser 0
                .set(adr++, JMP, mk3) // nochmal

                //falls kein Rest für Kommastellen
                .set(adr++, TAKE, 112)
                .set(adr++, SUB, 142)
                .set(adr++, SAVE, 144)
                .set(adr++, TST, 144)
                .set(adr++, JMP, adr+1)
                .set(adr++, INC, 141)

                .set(adr++, TAKE, 141)
                .set(adr++, SAVE, 131)

                //sign für division
                .set(adr++, TAKE, 113)
                .set(adr++, TST, 113)
                .set(adr++, JMP, adr+2)
                .set(adr++, ADD, 126)
                .set(adr++, JMP, adr+1)
                .set(adr++, SUB, 126)
                .set(adr++, SAVE, 132)

        ;
        return adr;
    }
}
