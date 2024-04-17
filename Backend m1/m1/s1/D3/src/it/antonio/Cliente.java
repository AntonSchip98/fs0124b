package it.antonio;

public class Cliente {
    private int codiceCliente;
    private String nomeCognome;
    private String email;
    private String dataIscrizione;

    public Cliente(int codice, String nomeCognome, String email, String dataIscrizione){
        this.codiceCliente = codice;
        this.nomeCognome = nomeCognome;
        this.email = email;
        this.dataIscrizione = dataIscrizione;
    }

    public int getCodiceCliente() {
        return codiceCliente;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public String getEmail() {
        return email;
    }

    public String getDataIscrizione() {
        return dataIscrizione;
    }
}
