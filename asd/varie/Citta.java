package it.uniroma1.dis.ACME;

public class Citta {
    private final String nome;
    private final String regione;
    
    public Citta(String nome, String regione) {
        this.nome = nome;
        this.regione = regione;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getRegione() {
        return regione;
    }
}
