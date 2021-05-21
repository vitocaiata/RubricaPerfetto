package models;

import java.util.UUID;

public class Account {

    private UUID uid;
    private String nome;
    private String cognome;
    private String email;
    private String tel;

    public Account() {
        this.uid = UUID.randomUUID();
    }

    public Account(UUID uid, String nome, String cognome, String email, String tel) {
        this.uid = uid;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.tel = tel;
    }

    public Account(String uid, String nome, String cognome, String email, String tel) {
        this.uid = UUID.fromString(uid) ;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.tel = tel;
    }

    public Account(String nome, String cognome, String email, String tel) {
        this.uid = UUID.randomUUID();
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.tel = tel;
    }

    public Account(String cognome, String tel) {
        this("",cognome,"",tel);
    }

    public UUID getUid() {
        return uid;
    }

    public String getStringUid() {
        return getUid().toString();
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
