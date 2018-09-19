package it.uniroma1.dis.ACME;

import java.util.HashSet;
import java.util.Set;

public class Dipendente {

    private final String nome;
    private final String cognome;
    private final String codiceFiscale;
    
    private final HashSet<Dipartimento> afferisce;
    private final HashSet<Progetto> partecipa;
    
    public Dipendente(String nome, String cognome, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        
        this.afferisce = new HashSet<Dipartimento>();
        this.partecipa = new HashSet<Progetto>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    public void inserisciLinkAfferisce(Dipartimento c) {
        if (c != null)  //serve a non inserire null nel set
            afferisce.add(c);
    }

    public void eliminaLinkAfferisce(Progetto c) {
        if (c != null)  //nota opzionale: il nostro set non contiene null per costruzione
           afferisce.remove(c);
    }

    public Set<Dipartimento> getLinkAfferisce() {
        return (HashSet<Dipartimento>) afferisce.clone();
    }
    
    public void inserisciLinkPartecipa(Progetto c) {
        if (c != null) //serve a non inserire null nel set
            partecipa.add(c);
    }

    public void eliminaLinkPartecipa(Progetto c) {
        if (c != null) //nota opzionale: il nostro set non contiene null per costruzione
	        partecipa.remove(c);
    }

    public Set<Progetto> getLinkPartecipa() {
        return (HashSet<Progetto>) partecipa.clone();
    }
}
