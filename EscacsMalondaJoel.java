package escacsmalondajoel;
//Joel Malonda Beltrán
public class EscacsMalondaJoel {
    
    static boolean esPeça(char car) {
        return car == 'T' || car == 'R' || car == 'A' || car == 'C' || car == 'D';
    }

    public static void main(String[] args) {
        
        //Paràmetres del tauler
        
        System.out.println("TAULER");
        System.out.println("");

        int llargT = Teclat.lligInt("Dis-me el llarg del tauler: ");

        while (llargT > 9 || llargT < 5) {
            System.out.println("");
            System.out.println("No es un rang vàlid");
            System.out.println("");
            llargT = Teclat.lligInt("Dis-me una altura vàlida: ");
        }

        System.out.println("");

        int ampleT = Teclat.lligInt("Dis-me el ample del tauler: ");

        while (ampleT > 9 || ampleT < 5) {
            System.out.println("");
            System.out.println("No es un rang vàlid");
            System.out.println("");
            ampleT = Teclat.lligInt("Dis-me una amplitud vàlida: ");
        }
        System.out.println("");
        System.out.println("S'ha creat el tauler");
        System.out.println("");

        final char BUIT = '-'; 
        
        //Definim tauler
        
        char escacs[][] = new char[llargT + 1][ampleT + 1]; 
        for (int fil = 1; fil <= llargT; fil++) {
            for (int col = 1; col <= ampleT; col++) {
                escacs[fil][col] = BUIT;
            }
        }

        final char MOV = '*'; 

        boolean continuar = true;

        while (continuar) {

            // numerets de les columnes de dalt
            for (int i = 1; i <= ampleT; i++) {
                System.out.print("  " + i);

            }
            System.out.println("");

            // RECORREM CADA FILA
            for (int fil = 1; fil <= llargT; fil++) {
                // num fila sense intro
                System.out.print(fil);

                // mostrar cada posició d'eixa fila de la matriu
                for (int col = 1; col <= ampleT; col++) {
                    System.out.print(" " + escacs[fil][col] + " ");  // sense intro       
                }

                // num fila amb intro
                System.out.println(fil);
            }
            // numerets de les columnes de baix
            for (int i = 1; i <= ampleT; i++) {
                System.out.print("  " + i);
            }
            
            System.out.println("");
            System.out.println("");
            System.out.println("-------MENÚ-------");
            System.out.println("1. Posar una peça");
            System.out.println("2. Mostrar moviments d'una peça");
            System.out.println("3. Esborrar moviments");
            System.out.println("4. Esborrar tauler");
            System.out.println("5. Eixir");
            System.out.println("------------------");

            int opcio = Teclat.lligInt("Quina opció vols?: ", 1,5);

            System.out.println("");

            switch (opcio) {

                case 1: //Posar peça
                    
                    System.out.println("Tenim les peçes: Torre, Alfil, Dama, Rei i Cavall");
                    System.out.println("");
                    char peça = Teclat.lligChar("Dis-me quina peça vols: ", "TADRC");

                    int posfila = Teclat.lligInt("En quina fila vols posar-ho?: ");

                    while (posfila > escacs.length) {
                        posfila = Teclat.lligInt("No es una fila vàlida, dis-me un altra: ");
                    }

                    int poscol = Teclat.lligInt("En quina columna vols posar-ho?: ");

                    while (poscol > escacs.length) {
                        poscol = Teclat.lligInt("No es una columna vàlida, dis-me un altra: ");
                    }
                    System.out.println("");
                    if (!(esPeça(escacs[posfila][poscol]))) {
                        escacs[posfila][poscol] = peça;
                    } else {
                        System.out.println("Ja hi ha una peça!");
                        System.out.println("");
                    }

                    break;

                case 2: //Mostrar moviments

                    int fil = Teclat.lligInt("En quina fila està la peça?: ", 1, llargT);
                    int col = Teclat.lligInt("En quina columna està la peça?: ", 1, ampleT);
                    System.out.println("");
                    if (esPeça(escacs[fil][col])) {
                        switch (escacs[fil][col]) {
                            case 'T': //Moviments de Torre
                                
                                //Moviment dreta
                                for (poscol = col + 1; poscol <= ampleT; poscol++) { 
                                    if (esPeça(escacs[fil][poscol])) {
                                        break;
                                    }
                                    escacs[fil][poscol] = MOV;
                                }
                                //Moviment esquerre
                                for (poscol = col - 1; poscol >= 1; poscol--) {
                                    if (esPeça(escacs[fil][poscol])) {
                                        break;
                                    }
                                    escacs[fil][poscol] = MOV;
                                }
                                //Moviment cap a baix
                                for (posfila = fil + 1; posfila <= llargT; posfila++) {
                                    if (esPeça(escacs[posfila][col])) {
                                        break;
                                    }
                                    escacs[posfila][col] = MOV;
                                }
                                //Moviment cap a dalt
                                for (posfila = fil - 1; posfila >= 1; posfila--) {
                                    if (esPeça(escacs[posfila][col])) {
                                        break;
                                    }
                                    escacs[posfila][col] = MOV;
                                }
                                break;

                            case 'A'://Moviments d'Alfil
                                
                                //Moviment dalt a la dreta
                                for (poscol = (col + 1), posfila = (fil - 1); poscol <= ampleT && posfila >= 1; poscol++, posfila--) {
                                    if (esPeça(escacs[posfila][poscol])) {
                                        break;
                                    }
                                    escacs[posfila][poscol] = MOV;
                                }
                                //Moviment baix a l'esquerre
                                for (poscol = (col - 1), posfila = (fil + 1); poscol >= 1 && posfila <= llargT; poscol--, posfila++) {
                                    if (esPeça(escacs[posfila][poscol])) {
                                        break;
                                    }
                                    escacs[posfila][poscol] = MOV;
                                }
                                //Moviment baix a la dreta
                                for (poscol = (col + 1), posfila = (fil + 1); poscol <= ampleT && posfila <= llargT; poscol++, posfila++) {
                                    if (esPeça(escacs[posfila][poscol])) {
                                        break;
                                    }
                                    escacs[posfila][poscol] = MOV;
                                }
                                //Moviment dalt a l'esquerre
                                for (poscol = (col - 1), posfila = (fil - 1); poscol >= 1 && posfila >= 1; poscol--, posfila--) {
                                    if (esPeça(escacs[posfila][poscol])) {
                                        break;
                                    }
                                    escacs[posfila][poscol] = MOV;
                                }
                                break;

                            case 'D'://Moviments de Dama
                                
                                //Moviment dreta
                                for (poscol = col + 1; poscol <= ampleT; poscol++) {
                                    if (esPeça(escacs[fil][poscol])) {
                                        break;
                                    }
                                    escacs[fil][poscol] = MOV;
                                }
                                //Moviment esquerre
                                for (poscol = col - 1; poscol >= 1; poscol--) {
                                    if (esPeça(escacs[fil][poscol])) {
                                        break;
                                    }
                                    escacs[fil][poscol] = MOV;
                                }
                                //Moviment cap a baix
                                for (posfila = fil + 1; posfila <= llargT; posfila++) {
                                    if (esPeça(escacs[posfila][col])) {
                                        break;
                                    }
                                    escacs[posfila][col] = MOV;
                                }
                                //Moviment cap a dalt
                                for (posfila = fil - 1; posfila >= 1; posfila--) {
                                    if (esPeça(escacs[posfila][col])) {
                                        break;
                                    }
                                    escacs[posfila][col] = MOV;
                                }
                                //Moviment dalt a la dreta
                                for (poscol = (col + 1), posfila = (fil - 1); poscol <= ampleT && posfila >= 1; poscol++, posfila--) {
                                    if (esPeça(escacs[posfila][poscol])) {
                                        break;
                                    }
                                    escacs[posfila][poscol] = MOV;
                                }
                                //Moviment baix a l'esquerre
                                for (poscol = (col - 1), posfila = (fil + 1); poscol >= 1 && posfila <= llargT; poscol--, posfila++) {
                                    if (esPeça(escacs[posfila][poscol])) {
                                        break;
                                    }
                                    escacs[posfila][poscol] = MOV;
                                }
                                //Moviment baix a la dreta
                                for (poscol = (col + 1), posfila = (fil + 1); poscol <= ampleT && posfila <= llargT; poscol++, posfila++) {
                                    if (esPeça(escacs[posfila][poscol])) {
                                        break;
                                    }
                                    escacs[posfila][poscol] = MOV;
                                }
                                //Moviment dalt a l'esquerre
                                for (poscol = (col - 1), posfila = (fil - 1); poscol >= 1 && posfila >= 1; poscol--, posfila--) {
                                    if (esPeça(escacs[posfila][poscol])) {
                                        break;
                                    }
                                    escacs[posfila][poscol] = MOV;
                                }
                                break;

                            case 'R'://Moviments de Rei
                                
                                //Moviment cap a baix
                                if ((fil + 1) <= llargT && (fil + 1) >= 1 && (col) <= ampleT && (col) >= 1){
                                    if(!(esPeça(escacs[fil + 1][col]))) {
                                        escacs[fil + 1][col] = MOV;
                                    }
                                }
                                //Moviment dreta
                                if ((fil) <= llargT && (fil ) >= 1 && (col + 1) <= ampleT && (col + 1) >= 1){
                                    if (!(esPeça(escacs[fil][col + 1]))) {
                                        escacs[fil][col + 1] = MOV;
                                    }
                                }
                                //Moviment cap a dalt
                                if ((fil - 1) <= llargT && (fil - 1) >= 1 && (col) <= ampleT && (col) >= 1){
                                    if (!(esPeça(escacs[fil - 1][col]))) {
                                        escacs[fil - 1][col] = MOV;
                                    }
                                }
                                //Moviment esquerre
                                if ((fil) <= llargT && (fil) >= 1 && (col - 1) <= ampleT && (col - 1) >= 1){
                                    if (!(esPeça(escacs[fil][col - 1]))) {
                                        escacs[fil][col - 1] = MOV;
                                    }
                                }
                                //Moviment baix dreta
                                if ((fil + 1) <= llargT && (fil + 1) >= 1 && (col + 1) <= ampleT && (col + 1) >= 1){
                                    if (!(esPeça(escacs[fil + 1][col + 1]))) {
                                        escacs[fil + 1][col + 1] = MOV;
                                    }
                                }
                                //Moviment dalt esquerre
                                if ((fil - 1) <= llargT && (fil - 1) >= 1 && (col - 1) <= ampleT && (col - 1) >= 1){
                                    if (!(esPeça(escacs[fil - 1][col - 1]))) {
                                        escacs[fil - 1][col - 1] = MOV;
                                    }
                                }
                                //Moviment dalt dreta
                                if ((fil - 1) <= llargT && (fil - 1) >= 1 && (col + 1) <= ampleT && (col + 1) >= 1){
                                    if (!(esPeça(escacs[fil - 1][col + 1]))) {
                                        escacs[fil - 1][col + 1] = MOV;
                                    }
                                }
                                //Moviment baix esquerre
                                if ((fil + 1) <= llargT && (fil + 1) >= 1 && (col - 1) <= ampleT && (col - 1) >= 1){
                                    if (!(esPeça(escacs[fil + 1][col - 1]))) {
                                        escacs[fil + 1][col - 1] = MOV;
                                    }
                                }

                                break;

                            case 'C'://Moviments de Cavall
                                
                                if ((fil + 2) <= llargT && (fil + 2) >= 1 && (col + 1) <= ampleT && (col + 1) >= 1){
                                    if (!(esPeça(escacs[fil + 2][col + 1]))) {
                                        escacs[fil + 2][col + 1] = MOV;
                                    }
                                }
                                
                                if ((fil - 2) <= llargT && (fil - 2) >= 1 && (col - 1) <= ampleT && (col - 1) >= 1){
                                    if (!(esPeça(escacs[fil - 2][col - 1]))) {
                                        escacs[fil - 2][col - 1] = MOV;
                                    }
                                }
                                
                                if ((fil - 2) <= llargT && (fil - 2) >= 1 && (col + 1) <= ampleT && (col + 1) >= 1){
                                    if (!(esPeça(escacs[fil - 2][col + 1]))) {
                                        escacs[fil - 2][col + 1] = MOV;
                                    }
                                }
                                
                                if ((fil + 2) <= llargT && (fil + 2) >= 1 && (col - 1) <= ampleT && (col - 1) >= 1){
                                    if (!(esPeça(escacs[fil + 2][col - 1]))) {
                                        escacs[fil + 2][col - 1] = MOV;
                                    }
                                }
                                
                                if ((fil + 1) <= llargT && (fil + 1) >= 1 && (col - 2) <= ampleT && (col - 2) >= 1){
                                    if (!(esPeça(escacs[fil + 1][col - 2]))) {
                                        escacs[fil + 1][col - 2] = MOV;
                                    }
                                }
                                
                                if ((fil + 1) <= llargT && (fil + 1) >= 1 && (col + 2) <= ampleT && (col + 2) >= 1){
                                    if (!(esPeça(escacs[fil + 1][col + 2]))) {
                                        escacs[fil + 1][col + 2] = MOV;
                                    }
                                }
                                
                                if ((fil - 1) <= llargT && (fil - 1) >= 1 && (col + 2) <= ampleT && (col + 2) >= 1){
                                    if (!(esPeça(escacs[fil - 1][col + 2]))) {
                                        escacs[fil - 1][col + 2] = MOV;
                                    }
                                }
                                
                                if ((fil - 1) <= llargT && (fil - 1) >= 1 && (col - 2) <= ampleT && (col - 2) >= 1){
                                    if (!(esPeça(escacs[fil - 1][col - 2]))) {
                                        escacs[fil - 1][col - 2] = MOV;
                                    }
                                }

                                break;
                        }
                    } 
                    
                    else {
                        System.out.println("No hi ha ninguna peça!");
                        System.out.println("");
                    }

                    break;

                case 3: //Esborrar moviments
                    
                    int esborrarmov = 0; //Comptador dels moviments esborrats

                    for (fil = 1; fil <= llargT; fil++) {
                        for (col = 1; col <= ampleT; col++) {
                            if (escacs[fil][col] == MOV){
                                escacs[fil][col] = BUIT;
                                esborrarmov ++ ;
                            }
                        }
                    }
                    
                    System.out.println("S'ha esborrat un total de " + esborrarmov + " moviments");
                    System.out.println("");
                    break;

                case 4: //Buidar el tauler

                    for (fil = 1; fil <= llargT; fil++) {
                        for (col = 1; col <= ampleT; col++) {
                            escacs[fil][col] = BUIT;
                        }
                    }

                    break;

                case 5: //Eixir del programa
                    
                    char resposta = Teclat.lligChar("Segur que vols eixir del programa?", "SN");
                    System.out.println("");
                    if (resposta == 'S' || resposta == 's') {
                        continuar = false;
                        System.out.println("Programa finalitzat!");
                        System.out.println("");
                    } 
                    else {
                        continuar = true;
                    }
                    break;
            }   
        }
    }
}
