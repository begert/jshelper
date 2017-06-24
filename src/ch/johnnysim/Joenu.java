package ch.johnnysim;

import static ch.johnnysim.Ram.*;

public class Joenu {

        static int bquadrat(Ram ram, int startAdr) {

            int adr = startAdr;
            int mk1;

            ram
                    .set(adr++, TAKE, 102)
                    .set(adr++, SAVE, 153)  //Im Zwischenspeicher ablegen
                    .set(adr++, NULL, 116)
                    .set(mk1 = adr++, TAKE, 116)
                    .set(adr++, ADD, 102)
                    .set(adr++, SAVE, 116)
                    .set(adr++, DEC, 153)
                    .set(adr++, TST, 153)
                    .set(adr++, JMP, mk1)
            ;
            return adr;
        }

        static int wurzel(Ram ram, int startAdr) {

            int adr = startAdr;
            int mk1, mk2, mk3, mk4, mk5;

            ram
                    .set(199, 100)
                    .set(198, 10)
                    .set(adr++, TAKE, 199)
                    .set(adr++, SAVE, 145)  // um 100 zu dekrementieren
                    .set(adr++, TAKE, 198)
                    .set(adr++, SAVE, 146) // um 10 zu dekrementieren
                    .set(adr++, TST, 117)  // Wurzel aus 0 ziehen?
                    .set(adr++, JMP, adr+3)
                    .set(adr++, NULL, 119)
                    .set(adr++, NULL, 120)
                    .set(adr++, JMP, adr+98)
                    .set(adr++, TST, 118)  //Vorzeichen b*b-4ac testen
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+3)
                    .set(adr++, INC, 108)  // x1 und x2 werden auf -0 gesetzt, da keine Wurzel aus negativer Zahl gezogen werden kann.
                    .set(adr++, INC, 111)
                    .set(adr++, HLT, 0)
                    .set(adr++, NULL, 147)

                    // * 100 für die Wurzelberechnung - Einschränkung in Johnny: Zahl kann nicht grösser als 199 sein.
                    .set(mk1=adr++, TAKE, 147)
                    .set(adr++, ADD, 117)
                    .set(adr++, SAVE, 147)
                    .set(adr++, DEC, 145)
                    .set(adr++, TST, 145)
                    .set(adr++, JMP, mk1)

                    //Optimierung: Prüfung x <= 100, dann kann der Prüfnenner (148) bei x-1 beginnen, ansonsten beginnt er bei 99
                    .set(adr++, TAKE, 117)
                    .set(adr++, SUB, 199)
                    .set(adr++, SAVE, 154)
                    .set(adr++, TST, 154)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+3)
                    .set(adr++, TAKE, 199)
                    .set(adr++, SAVE, 148)
                    .set(adr++, JMP, adr+2)
                    .set(adr++, TAKE, 117)
                    .set(adr++, SAVE, 148)
                    .set(adr++, DEC, 148)

                    // Division bis Nenner (148 zwischengespeichert) = Anzahl (150 zwischengespeichert)
                    .set(mk3 = adr++, NULL, 149)
                    .set(adr++, NULL, 150)
                    .set(adr++, NULL, 151)
                    .set(adr++, NULL, 152)
                    .set(adr++, INC, 148)
                    .set(adr++, TAKE, 147)
                    .set(adr++, SAVE, 151)
                    .set(mk2 = adr++, TAKE, 149)
                    .set(adr++, ADD, 148)
                    .set(adr++, SAVE, 149)
                    .set(adr++, INC, 150)
                    .set(adr++, TAKE, 151)
                    .set(adr++, SUB, 148)
                    .set(adr++, SAVE, 151)
                    .set(adr++, TST, 151)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+6)
                    .set(adr++, TAKE, 150)
                    .set(adr++, SUB, 148)
                    .set(adr++, SAVE, 152)
                    .set(adr++, TST, 152)
                    .set(adr++, JMP, mk3)
                    .set(adr++, JMP, mk2)
                    .set(adr++, TAKE, 149)
                    .set(adr++, SUB, 147)
                    .set(adr++, SAVE, 152)
                    .set(adr++, TST, 152)
                    .set(adr++, DEC, 150)
                    .set(adr++, TAKE, 150)  // Prüfung Anz minus Nenner
                    .set(adr++, SUB, 148)
                    .set(adr++, SAVE, 152)
                    .set(adr++, TST, 152)
                    .set(adr++, JMP, mk3)

                    //Division durch 10 mit Rest, wenn Nenner = Anzahl
                    .set(adr++, NULL, 149)
                    .set(adr++, NULL, 150)
                    .set(adr++, NULL, 151)
                    .set(adr++, NULL, 152)
                    .set(adr++, TAKE, 148)
                    .set(adr++, SAVE, 151)
                    .set(mk4 = adr++, TAKE, 149)
                    .set(adr++, ADD, 146)
                    .set(adr++, SAVE, 149)
                    .set(adr++, INC, 150)
                    .set(adr++, TAKE, 151)
                    .set(adr++, SUB, 146)
                    .set(adr++, SAVE, 151)
                    .set(adr++, TST, 151)
                    .set(adr++, JMP, mk4)
                    .set(adr++, TAKE, 149)
                    .set(adr++, SUB, 148)
                    .set(adr++, SAVE, 152)
                    .set(adr++, TST, 152)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+4)
                    .set(adr++, DEC, 150)
                    .set(adr++, TAKE, 149)
                    .set(adr++, SUB, 146)
                    .set(adr++, SAVE, 149)
                    .set(adr++, TAKE, 148)
                    .set(adr++, SUB, 149)
                    .set(adr++, SAVE, 148)  // Kommastelle, muss noch mit 10 multipliziert werden
                    .set(adr++, TAKE, 150)
                    .set(adr++, SAVE, 119)  // Zahl Wurzelberechnung
                    .set(adr++, TST, 148)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+7)
                    .set(adr++, NULL, 147)
                    .set(adr++, TAKE, 147)
                    .set(mk5=adr++, ADD, 148)
                    .set(adr++, DEC, 146)
                    .set(adr++, TST, 146)
                    .set(adr++, JMP, mk5)
                    .set(adr++, SAVE, 120) // Kommastelle Wurzelberechnung
            ;
            return adr;
        }

        static int wurzelv2(Ram ram, int startAdr) {

            int adr = startAdr;
            int mk1, mk2, mk3, mk4, mk5;

            ram
                    .set(199, 100)
                    .set(198, 10)
                    .set(adr++, TAKE, 199)
                    .set(adr++, SAVE, 145)  // um 100 zu dekrementieren
                    .set(adr++, TAKE, 198)
                    .set(adr++, SAVE, 146) // um 10 zu dekrementieren
                    .set(adr++, TST, 117)  // Wurzel aus 0 ziehen?
                    .set(adr++, JMP, adr+3)
                    .set(adr++, NULL, 119)
                    .set(adr++, NULL, 120)
                    .set(adr++, JMP, adr+108)
                    .set(adr++, TST, 118)  //Vorzeichen b*b-4ac testen
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+3)
                    .set(adr++, INC, 108)  // x1 und x2 werden auf -0 gesetzt, da keine Wurzel aus negativer Zahl gezogen werden kann.
                    .set(adr++, INC, 111)
                    .set(adr++, HLT, 0)
                    .set(adr++, NULL, 147)

                    // * 100 für die Wurzelberechnung - Einschränkung in Johnny: Zahl kann nicht grösser als 199 sein.
                    .set(mk1=adr++, TAKE, 147)
                    .set(adr++, ADD, 117)
                    .set(adr++, SAVE, 147)
                    .set(adr++, DEC, 145)
                    .set(adr++, TST, 145)
                    .set(adr++, JMP, mk1)

                    //Optimierung: Prüfung x >= 100, dann kann der Prüfnenner (148) bei x beginnen, ansonsten beginnt er bei 98
                    .set(adr++, TAKE, 199)
                    .set(adr++, SUB, 117)
                    .set(adr++, SAVE, 154)
                    .set(adr++, TST, 154)
                    .set(adr++, JMP, adr+5)
                    .set(adr++, TAKE, 199)
                    .set(adr++, SAVE, 148)
                    .set(adr++, DEC, 148)
                    .set(adr++, DEC, 148)
                    .set(adr++, JMP, adr+2)
                    .set(adr++, TAKE, 117)
                    .set(adr++, SAVE, 148)

                    // Division bis Nenner (148 zwischengespeichert) = Anzahl (150 zwischengespeichert)
                    .set(adr++, NULL, 149)
                    .set(adr++, NULL, 150)
                    .set(adr++, NULL, 151)
                    .set(adr++, NULL, 152)
                    .set(adr++, TAKE, 147)
                    .set(adr++, SAVE, 151)
                    .set(mk2 = adr++, TAKE, 149)
                    .set(adr++, ADD, 148)
                    .set(adr++, SAVE, 149)
                    .set(adr++, INC, 150)
                    .set(adr++, TAKE, 151)
                    .set(adr++, SUB, 148)
                    .set(adr++, SAVE, 151)
                    .set(adr++, TAKE, 150)  // Prüfung Anz minus Nenner
                    .set(adr++, SUB, 148)
                    .set(adr++, SAVE, 152)
                    .set(adr++, TST, 152)
                    .set(adr++, JMP, adr+1)  // Anz - Nenner != 0, also Anz > Nenner
                    .set(adr++, JMP, mk2)  // Anz - Nenner = 0, also Nenner >= Anz (erster Berechnungsschritt)

                    .set(adr++, TST, 151)  // Prüfvariable testen, wenn = 0, nächster Schritt überspringen, wenn != 0, Nenner und Anz gleichzeitig +1
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+21)
                    .set(adr++, INC, 148)
                    .set(adr++, TAKE, 149)
                    .set(adr++, ADD, 150)
                    .set(adr++, SAVE, 149)
                    .set(adr++, TAKE, 147)
                    .set(adr++, SUB, 149)
                    .set(adr++, SAVE, 151)
                    .set(adr++, TST, 151)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+11)

                    // Zweiter Berechnungsschritt: Jeweils Nenner und Anz um eins erhöhen (dann gilt immer Nenner = Anz) und Rest testen
                    .set(mk3 = adr++, INC, 150)
                    .set(adr++, TAKE, 149)
                    .set(adr++, ADD, 148)
                    .set(adr++, ADD, 150)
                    .set(adr++, SAVE, 149)
                    .set(adr++, INC, 148)
                    .set(adr++, TAKE, 147)
                    .set(adr++, SUB, 149)
                    .set(adr++, SAVE, 151)
                    .set(adr++, TST, 151)
                    .set(adr++, JMP, mk3)

                    //Division durch 10 mit Rest, wenn Nenner = Anzahl
                    .set(adr++, NULL, 149)
                    .set(adr++, NULL, 150)
                    .set(adr++, NULL, 151)
                    .set(adr++, NULL, 152)
                    .set(adr++, TAKE, 148)
                    .set(adr++, SAVE, 151)
                    .set(mk4 = adr++, TAKE, 149)
                    .set(adr++, ADD, 146)
                    .set(adr++, SAVE, 149)
                    .set(adr++, INC, 150)
                    .set(adr++, TAKE, 151)
                    .set(adr++, SUB, 146)
                    .set(adr++, SAVE, 151)
                    .set(adr++, TST, 151)
                    .set(adr++, JMP, mk4)
                    .set(adr++, TAKE, 149)
                    .set(adr++, SUB, 148)
                    .set(adr++, SAVE, 152)
                    .set(adr++, TST, 152)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+4)
                    .set(adr++, DEC, 150)
                    .set(adr++, TAKE, 149)
                    .set(adr++, SUB, 146)
                    .set(adr++, SAVE, 149)
                    .set(adr++, TAKE, 148)
                    .set(adr++, SUB, 149)
                    .set(adr++, SAVE, 148)  // Kommastelle, muss noch mit 10 multipliziert werden
                    .set(adr++, TAKE, 150)
                    .set(adr++, SAVE, 119)  // Zahl Wurzelberechnung
                    .set(adr++, TST, 148)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+7)
                    .set(adr++, NULL, 147)
                    .set(adr++, TAKE, 147)
                    .set(mk5=adr++, ADD, 148)
                    .set(adr++, DEC, 146)
                    .set(adr++, TST, 146)
                    .set(adr++, JMP, mk5)
                    .set(adr++, SAVE, 120) // Kommastelle Wurzelberechnung
            ;
            return adr;
        }

        static int wurzelv3(Ram ram, int startAdr) {

            int adr = startAdr;
            int mk1, mk2, mk3, mk4, mk5;

            ram
                    .set(199, 100)
                    .set(198, 10)
                    .set(adr++, TAKE, 199)
                    .set(adr++, SAVE, 145)  // um 100 zu dekrementieren
                    .set(adr++, TAKE, 198)
                    .set(adr++, SAVE, 146) // um 10 zu dekrementieren
                    .set(adr++, TST, 117)  // Wurzel aus 0 ziehen?
                    .set(adr++, JMP, adr+3)
                    .set(adr++, NULL, 119)
                    .set(adr++, NULL, 120)
                    .set(adr++, JMP, adr+90)
                    .set(adr++, TST, 118)  //Vorzeichen b*b-4ac testen
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+3)
                    .set(adr++, INC, 108)  // x1 und x2 werden auf -0 gesetzt, da keine Wurzel aus negativer Zahl gezogen werden kann.
                    .set(adr++, INC, 111)
                    .set(adr++, HLT, 0)
                    .set(adr++, NULL, 147)

                    // * 100 für die Wurzelberechnung - Einschränkung in Johnny: Zahl kann nicht grösser als 199 sein.
                    .set(mk1=adr++, TAKE, 147)
                    .set(adr++, ADD, 117)
                    .set(adr++, SAVE, 147)
                    .set(adr++, DEC, 145)
                    .set(adr++, TST, 145)
                    .set(adr++, JMP, mk1)

                    //Optimierung: Prüfung x <= 100, dann kann der Prüfnenner (148) bei x beginnen, ansonsten beginnt er bei 100
                    .set(adr++, TAKE, 117)
                    .set(adr++, SUB, 199)
                    .set(adr++, SAVE, 154)
                    .set(adr++, TST, 154)
                    .set(adr++, JMP, adr+3)
                    .set(adr++, TAKE, 117)
                    .set(adr++, SAVE, 148)
                    .set(adr++, JMP, adr+2)
                    .set(adr++, TAKE, 199)
                    .set(adr++, SAVE, 148)

                    // Division bis Nenner (148 zwischengespeichert) = Anzahl (150 zwischengespeichert)
                    .set(adr++, NULL, 149)
                    .set(adr++, NULL, 150)
                    //.set(adr++, NULL, 151)
                    //.set(adr++, NULL, 152)
                    //.set(adr++, TAKE, 147)
                    //.set(adr++, SAVE, 151)
                    .set(mk2 = adr++, TAKE, 149)
                    .set(adr++, ADD, 148)
                    .set(adr++, SAVE, 149)
                    .set(adr++, INC, 150)
                    //.set(adr++, TAKE, 151)
                    //.set(adr++, SUB, 148)
                    //.set(adr++, SAVE, 151)
                    .set(adr++, TAKE, 148)  // Prüfung Nenner minus Anz
                    .set(adr++, SUB, 150)
                    .set(adr++, SAVE, 152)
                    .set(adr++, TST, 152)
                    .set(adr++, JMP, mk2)  // Nenner - Anz != 0, also Anz < Nenner
                    // Nenner - Anz = 0, also Nenner = Anz (erster Berechnungsschritt fertig)

                    // Zweiter Berechnungsschritt: Jeweils Nenner und Anz um eins erhöhen (dann gilt immer Nenner = Anz) und Rest testen
                    .set(mk3 = adr++, INC, 150)
                    .set(adr++, TAKE, 149)
                    .set(adr++, ADD, 148)
                    .set(adr++, ADD, 150)
                    .set(adr++, SAVE, 149)
                    .set(adr++, INC, 148)
                    .set(adr++, TAKE, 147)
                    .set(adr++, SUB, 149)
                    .set(adr++, SAVE, 151)
                    .set(adr++, TST, 151)
                    .set(adr++, JMP, mk3)

                    //Test Nenner**2 = D**100
                    .set(adr++, TAKE, 149)
                    .set(adr++, SUB, 147)
                    .set(adr++, SAVE, 151)
                    .set(adr++, TST, 151)
                    .set(adr++, DEC, 148)

                    //Division durch 10 mit Rest, wenn Nenner = Anzahl
                    .set(adr++, NULL, 149)
                    .set(adr++, NULL, 150)
                    .set(adr++, NULL, 151)
                    .set(adr++, NULL, 152)
                    .set(adr++, TAKE, 148)
                    .set(adr++, SAVE, 151)
                    .set(mk4 = adr++, TAKE, 149)
                    .set(adr++, ADD, 146)
                    .set(adr++, SAVE, 149)
                    .set(adr++, INC, 150)
                    .set(adr++, TAKE, 151)
                    .set(adr++, SUB, 146)
                    .set(adr++, SAVE, 151)
                    .set(adr++, TST, 151)
                    .set(adr++, JMP, mk4)
                    .set(adr++, TAKE, 149)
                    .set(adr++, SUB, 148)
                    .set(adr++, SAVE, 152)
                    .set(adr++, TST, 152)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+4)
                    .set(adr++, DEC, 150)
                    .set(adr++, TAKE, 149)
                    .set(adr++, SUB, 146)
                    .set(adr++, SAVE, 149)
                    .set(adr++, TAKE, 148)
                    .set(adr++, SUB, 149)
                    .set(adr++, SAVE, 148)  // Kommastelle, muss noch mit 10 multipliziert werden
                    .set(adr++, TAKE, 150)
                    .set(adr++, SAVE, 119)  // Zahl Wurzelberechnung
                    .set(adr++, TST, 148)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+7)
                    .set(adr++, NULL, 147)
                    .set(adr++, TAKE, 147)
                    .set(mk5=adr++, ADD, 148)
                    .set(adr++, DEC, 146)
                    .set(adr++, TST, 146)
                    .set(adr++, JMP, mk5)
                    .set(adr++, SAVE, 120) // Kommastelle Wurzelberechnung
            ;
            return adr;
        }

        static int subb2minus4ac(Ram ram, int startAdr) {
            int adr = startAdr;

            ram

                    .set(adr++, NULL, 117)
                    .set(adr++, NULL, 118)
                    .set(adr++, TST, 115)
                    .set(adr++, JMP, adr+13)

                    // sign(4ac) = 0
                    .set(adr++, TAKE, 116)
                    .set(adr++, SUB, 114)
                    .set(adr++, SAVE, 117)
                    .set(adr++, TST, 117)
                    .set(adr++, JMP, adr+10)  // Ende

                    // Test, ob 4ac > b**2
                    .set(adr++, TAKE, 114)
                    .set(adr++, SUB, 116)
                    .set(adr++, SAVE, 117)
                    .set(adr++, TST, 117)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+4) // 4ac = b**2 Ende

                    // 4ac > b**2
                    .set(adr++, INC, 118) // Ende
                    .set(adr++, JMP, adr+2)

                    // sgn(4ac)=1
                    .set(adr++, TAKE, 116)
                    .set(adr++, ADD, 114)
                    .set(adr++, SAVE, 117)

            ;
            return adr;
        }

        static int zaehler_x1(Ram ram, int startAdr) {
            int adr = startAdr;

            ram
                    .set(199, 100)

                    .set(adr++, TST, 103)
                    .set(adr++, JMP, adr+20)

                    // wenn b positiv
                    .set(adr++, TAKE, 119)
                    .set(adr++, SUB, 102)
                    .set(adr++, SAVE, 121)  //Zahl Zähler x1, kriegt evtl. noch ein DEC, je nach Kommastelle
                    .set(adr++, TST, 121)
                    .set(adr++, JMP, adr+18)

                    // wenn 119 - b <= 0: Umgekehrter Test
                    .set(adr++, TAKE, 102)
                    .set(adr++, SUB, 119)
                    .set(adr++, SAVE, 121)
                    .set(adr++, TST, 121)
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+12)

                    // wenn b - 119 > 0
                    .set(adr++, INC, 123)  // Vorzeichen Zähler x1 wird auf 1 gesetzt, da Ergebnis negativ
                    .set(adr++, TST, 120)  // Kommastellen bei Wurzel vorhanden?
                    .set(adr++, JMP, adr+1)
                    .set(adr++, JMP, adr+10)  // Ans Ende hüpfen, x1 ist fertig hier

                    // Wenn Kommastelle vorhanden, Zähler x1 anpassen
                    .set(adr++, DEC, 121)
                    .set(adr++, TAKE, 199)  // 100 holen
                    .set(adr++, SUB, 120)
                    .set(adr++, SAVE, 122)
                    .set(adr++, JMP, adr+5)  // Ans Ende hüpfen...

                    // Wenn Vorzeichen von b minus: 119 + b = Ergebnis
                    .set(adr++, TAKE, 119)
                    .set(adr++, ADD, 102)
                    .set(adr++, SAVE, 121)
                    .set(adr++, TAKE, 120)
                    .set(adr++, SAVE, 122)
            ;
            return adr;
        }

        static int werte_x_rauf(Ram ram, int startAdr) {
            int adr = startAdr;

            ram

                    .set(adr++, TAKE, 127)  // x1 nehmen
                    .set(adr++, SAVE, 106)
                    .set(adr++, TAKE, 128)
                    .set(adr++, SAVE, 107)
                    .set(adr++, TAKE, 129)
                    .set(adr++, SAVE, 108)

                    .set(adr++, TAKE, 130)  // x2 nehmen
                    .set(adr++, SAVE, 109)
                    .set(adr++, TAKE, 131)
                    .set(adr++, SAVE, 110)
                    .set(adr++, TAKE, 132)
                    .set(adr++, SAVE, 111)
            ;
            return adr;
        }
}
