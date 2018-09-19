package it.uniroma1.dis.ACME;

public class Progetto {
    private final String nome;
    
    private Citta realizzatoA;

    private double budget;
    
    public Progetto(String nome) {
        this.budget = 0;
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setRealizzatoA(Citta citta) {
        realizzatoA = citta;
    }

    public Citta getRealizzatoA() {
        return realizzatoA;
    }

    public double getBudget() {
        return budget;
    }
    
    public void setBudget(double budget) {
        this.budget = budget;
    }
}
