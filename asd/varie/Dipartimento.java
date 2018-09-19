package it.uniroma1.dis.ACME;

public class Dipartimento {

    private String nome;
    private String telefono;
    private Citta citta;
    
    private Dipendente dirigente;

    public Dipartimento(String nome, String telefono) {
        this.telefono = telefono;
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public Dipendente getDirigente() {
        return dirigente;
    }
    
    public void setDirigente(Dipendente dirigente) {
        this.dirigente = dirigente;
    }

    public Citta getLinkHaSede() throws EccezionePrecondizioni {

        if (citta == null)
            throw new EccezionePrecondizioni("Molteplicita minima non verificata");

        return citta;
    }

    public void setLinkHaSede(Citta citta) {
        this.citta = citta;
    }

    public int quantiLinkHaSede() {
		if (citta == null) return 0;
		else return 1;
		//oppure
		//return (citta == null)? 0 : 1;
    }
}
