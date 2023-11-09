import java.util.ArrayList;
import java.util.Iterator;

public class Contatto implements Iterable<String>{
    // OVERVIEW: classe che rappresenta un elemento di una rubrica specificato da
    // nome, cognome, numeri di telefono e email della persona

    //attributi
    String nome, cognome;
    ArrayList<String> telefoni;
    ArrayList<String> email;

    //costruttore
    public Contatto(String nome, String cognome) {
        //MODIFIES: this
        //EFFECTS: inizializza this con nome e cognome dati
        //lancia IllegalArgumentException se nome == null o vuoto
        //lancia IllegalArgumentException se cognome == null o vuoto

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Nome inserito non valido");
        }

        if (cognome == null || cognome.equals("")) {
            throw new IllegalArgumentException("Cognome inserito non valido");
        }

        this.nome = nome;
        this.cognome = cognome;
        telefoni = new ArrayList<>();
        email = new ArrayList<>();
    }


    //metodi
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public ArrayList<String> getTelefoni() {
        return this.telefoni;
    }

    public ArrayList<String> getEmail() {
        return this.email;
    }

    public void addTelefono(String t) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: aggiunge s alla lista di numeri di telefono del contatto
        //lancia IllegalArgumentException se t == null, è vuoto o non è composto da soli numeri

        if (t == null || t.equals("") ) {
            throw new IllegalArgumentException("Numero di telefono inserito non valido");
        } 
        for (int i = 0; i < t.length(); i++) {
            if (!Character.isDigit(t.charAt(i))) {
                throw new IllegalArgumentException("Numero di telefono inserito non valido");
            }
        }

        this.telefoni.add(t);

    }

    public void addEmail(String e) {
        //MODIFIES: this
        //EFFECTS: aggiunge e alla lista di email del contatto
        //lancia IllegalArgumentException se e == null, è vuoto

        if (e == null || e.equals("")) {
            throw new IllegalArgumentException("Email inserita non valida");
        }

        this.email.add(e);
    }


    public Iterator<String> iterator(String t) {
        //EFFECTS: restituisce un iteratore per scorrere i numeri di telefono di un certo contatto
        //lancia IllegalArgumentException se t != telefono e != email

        if (t.equals("telefono")) {
            return new Iterator<String>() {

                int curr = 0;
                @Override
                public boolean hasNext() {
                    curr++;
                    if (curr != telefoni.size()) {
                        return true;
                    }
                    return false;
                }

                @Override
                public String next() {
                    return telefoni.get(curr-1);
                }
                
            };
        } else if (t.equals("email")){
            return new Iterator<String>() {

                int curr = 0;
                @Override
                public boolean hasNext() {
                    curr++;
                    if (curr != email.size()) {
                        return true;
                    }
                    return false;
                }

                @Override
                public String next() {
                    return email.get(curr-1);
                }
                
            };
        } else {
            throw new IllegalArgumentException();
        }
    }


    



    

}
