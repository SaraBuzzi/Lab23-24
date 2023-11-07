

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Evento implements Cloneable{
    //OVERVIEW: modella un Evento con data e nome. Astrazione immutabile

    //attributi
    Date data;
    String nome;


    //construttori
    public Evento(Date data, String nome) throws IllegalArgumentException, NullPointerException{
        //MODIFIES: this
        //EFFECTS: inizializza un oggetto Evento
        //          se data null lancia NullPointerException
        //          se nome null lancia NullPointerExcpetion
        //          se nome vuoto lanica IllegalArgumentException

        if (data == null) {
            throw new NullPointerException("data nulla");
        }

        if (nome == null) {
            throw new NullPointerException("nome nullo");
        }

        if (nome.equals("")) {
            throw new IllegalArgumentException("nome vuoto");
        }

        this.nome = nome;
        this.data = (Date) data.clone();

        assert repOk();
    }

    public boolean repOk() {
        if (this.data == null) {
            return false;
        }

        if (this.nome == null) {
            return false;
        }

        if (this.nome.equals("")) {
            return false;
        }

        return true;

    }


    //metodi
    public Evento copiaEvento(int n) throws IllegalArgumentException{
        //EFFECTS: creare un nuovo evento con this.nome e this.data+n
        //         se n<=0 lancia IllegalArgumentException

        if (n<=0) {
            throw new IllegalArgumentException("n <= 0");
        }   

        Evento nuovo = (Evento) this.clone();
        nuovo.data = new Date(nuovo.data.getTime() + TimeUnit.DAYS.toMillis(n));

        return nuovo;
    }

    @Override
    public String toString() {
        return this.data + " " + this.nome;
    }

    @Override
    public Object clone() {
       Evento nuovo = null;
        try {
            nuovo = (Evento) super.clone(); 
        } catch (CloneNotSupportedException e) {
            nuovo = new Evento(data, nome);
        }
        nuovo.data = (Date) this.data.clone();
        return nuovo;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Evento other = (Evento) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    public Date getData() {
        return (Date)data.clone();
    }

    public String getNome() {
        return nome;
    }

    

}