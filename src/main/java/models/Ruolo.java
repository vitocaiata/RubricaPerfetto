package models;

import java.util.UUID;

public class Ruolo {

    String tipo;

    public Ruolo() {
    }

    public Ruolo(String tipo){
        this.tipo = tipo;
    }


    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
