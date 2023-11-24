import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Collage {
    //OVERVIEW: classe che contiene una lista di oggetti di tipo Figura

    //attributes
    ArrayList<Figura> figure = new ArrayList<>();

    //methods
    public void addFigure(Figura f) throws NullPointerException{
        //MODIFIES: this
        //EFFECTS: aggiunge f a this
        //lancia IllegalArgumentException se f == null

        if (f == null)
            throw new NullPointerException("figura == null");
        
        figure.add(f);

        assert repOk();
    }

    public void remFigure(Figura f) throws NullPointerException, NoSuchElementException {
        //MODIFIES: this
        //EFFECTS: rimuove f da this
        //lancia NullPointer Exception se f == null
        //lancia NoSuchElementException se f non è presente nella lista

        if (f == null)
            throw new NullPointerException("figura == null");
        if (!(figure.contains(f))) {
            throw new NoSuchElementException("figura non nella lista");
        }

        figure.remove(f);

        assert repOk();
    }

    public void ordinaPerPerimetro() {
        //MODIFIES: this
        //EFFECTS: ordina gli elementi in this in base al loro perimetro

        figure.sort(null);
    }

    public String toString() {
        String ret = "";
        for (Figura figura : figure) {
            ret +=  figura + "\n";
        }
        return ret;
    }

    public boolean repOk() {
        if (figure == null) 
            return false;
        for (Figura figura : figure) {
            if (figura == null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        
        System.out.println("Inserisci delle figure (Termina con CTRL+D)");
        Scanner s = new Scanner(System.in);

        Collage figure = new Collage();
        while (s.hasNextLine()) {
            String[] elem = s.nextLine().split(" ");
            try {
                switch (elem[0]) {
                    case "Triangolo":
                        Triangolo t = new Triangolo(Double.parseDouble(elem[1]), Double.parseDouble(elem[2]), Double.parseDouble(elem[3]));
                        figure.addFigure(t);
                        break;
                    
                    case "Rettangolo":
                        Rettangolo r = new Rettangolo(Double.parseDouble(elem[1]), Double.parseDouble(elem[2]));
                        figure.addFigure(r);
                        break;
                    
                    case "Quadrato":
                        Quadrato q = new Quadrato(Double.parseDouble(elem[1]));
                        figure.addFigure(q);
                        break;
                    
                    case "Cerchio":
                        Cerchio c = new Cerchio(Double.parseDouble(elem[1]));
                        figure.addFigure(c);
                        break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Input errato");
            } catch (NullPointerException | NoSuchElementException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Ordinati per perimetro: ");
        figure.ordinaPerPerimetro();
        System.out.println(figure);
    }
}
