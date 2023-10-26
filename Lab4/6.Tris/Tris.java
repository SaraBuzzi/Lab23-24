import java.util.Scanner;

public class Tris {
    //OVERVIEW: classe Tris che modelli il gioco del tris con due giocatori

    //attributi
    char[][] tabellone;
    char turno;
    int numMosse;

    //construttori
    public Tris() {
        //EFFECTS: crea un nuovo gioco col tabellone vuoto e assegna il turno al giocatore O
        
        this.tabellone = new char[3][3];
        this.turno = 'O';
    
    }

    //metodi
    public char turno() {
        //restituisce il carattere del giocatore di turno (X o O)
        return this.turno;
        
    }

    public void mossa(int x, int y) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inserisce il carattere del giocatore di turno alle coordinate specificate, tiene conto del numerio di mosse effettuate
        //          se la posizione è occupata lancia IllegalArgumentException
        //          se x o y non rientrano nel range [1-3] lancia IllegalArgumentException

        if ( x < 1 || x > 3 || y < 1 || y > 3) {
            throw new IllegalArgumentException("coordinate non valide");
        }
        if (tabellone[x-1][y-1] != 0) {
            throw new IllegalArgumentException("posizione occupata");
        }
        
        this.tabellone[x-1][y-1] = this.turno;
        this.numMosse++;
    }

    public void cambiaTurno() {
        //MODIFIES: this
        //EFFECTS: cambia turno a this

        if (this.turno == 'O') {
            this.turno = 'X';
        } else {
            this.turno = 'O';
        }
    }


    public boolean terminato() {
        //EFFECTS: restituisce true se sono state giocate tutte e 9 le mosse

        return this.numMosse == 9;
    }

    public boolean vittoria() {
        //EFFECTS: restituisce treu se il giocatore di turno ha vinto (tre dei suoi simboli in fila su riga, colonna o diagonale)
        
        if (this.tabellone[0][0] == this.tabellone[1][1] && this.tabellone[1][1] == this.tabellone[2][2]) {
            if (this.tabellone[0][0] == this.turno) {
                return true;
            }
            
        }

        if (this.tabellone[0][2] == this.tabellone[1][1] && this.tabellone[1][1] == this.tabellone[2][0]) {
            if (this.tabellone[0][2] == this.turno) {
                return true;
            }
            
        }

        for (int i = 0; i < tabellone.length; i++) {
            if (this.tabellone[i][1] == this.tabellone[i][0] && this.tabellone[i][0] == this.tabellone[i][2]) {
                if (this.tabellone[i][0] == this.turno) {
                    return true;
                }
            
            }

            if (this.tabellone[0][i] == this.tabellone[1][i] && this.tabellone[0][i] == this.tabellone[2][i]) {
                if (this.tabellone[0][i] == this.turno) {
                    return true;
                }
            
            }
        }
            
        return false;
    }


    @Override
    public String toString() {
        String ret = "-----------------\n";
        ret += "|R\\C| 1 | 2 | 3 |\n";
        ret += "-----------------\n";
            
        for (int i = 0; i < tabellone.length; i++) {
                ret += "| " + (i+1) + " |";
                for (int j = 0; j < tabellone.length; j++) {
                    if (this.tabellone[i][j] == 0 ) {
                        ret += "   |";
                    } else {
                      ret += " " + this.tabellone[i][j] + " |";     
                    }
                    
                }
                ret += "\n-----------------\n";
            }

            return ret;

    }

    public static void main(String[] args) {
        Tris nuovo = new Tris();
            
        Scanner s = new Scanner(System.in);

        while (!nuovo.terminato()) {
            System.out.println("Mossa di " + nuovo.turno);
            System.out.println("Inserisci: x y");
            nuovo.mossa(s.nextInt(), s.nextInt());

            System.out.println(nuovo);

            if (nuovo.vittoria()) {
                System.out.println("Ha vinto " + nuovo.turno);
                System.exit(1);
            }
            nuovo.cambiaTurno();

        } 
        System.out.println("Partita terminata in pareggio");

    }
}
