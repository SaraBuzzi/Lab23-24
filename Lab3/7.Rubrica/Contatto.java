public class Contatto {
    // OVERVIEW: classe Contatto che rappresenta un elemento di una rubrica e
    // contiene il nome, cognome, il numero di telefono (se presente) e l'indirizzo
    // mail (se presente) della persona

    //attributi
    String nome, cognome, telefono, email;

    //construttori
    public Contatto(String nome, String cognome, String telefono, String email) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza this, sono presenti anche nTelefono e email
        // lancia IllegalArgumentException se nome o cognome sono vuoti o null
        if (nome == null || cognome == null || nome.isEmpty() || cognome.isEmpty()) {
            throw new IllegalArgumentException("Inserire nome/cognome validi");
        }

        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
    }

    public Contatto(String nome, String cognome) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this, non sono presenti nTelefono e email
        // lancia IllegalArgumentException se nome o cognome sono vuoti o null

        if (nome == null || cognome == null || nome.isEmpty() || cognome.isEmpty()) {
            throw new IllegalArgumentException("Inserire nome/cognome validi");
        }
        this.nome = nome;
        this.cognome = cognome;
    }

    //metodi
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("inserire nome valido");
        }
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        if (cognome == null || cognome.isEmpty()) {
            throw new IllegalArgumentException("inserire cognome valido");
        }
        this.cognome = cognome;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return (this.nome + " " + this.cognome + " " + this.email + " " + this.telefono);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contatto other = (Contatto) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cognome == null) {
            if (other.cognome != null)
                return false;
        } else if (!cognome.equals(other.cognome))
            return false;
        if (telefono == null) {
            if (other.telefono != null)
                return false;
        } else if (!telefono.equals(other.telefono))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    


    
    
}
