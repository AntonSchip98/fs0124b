package it.antonio;

public class Articolo {

    private int codice;
    private String descrizione;
    private double prezzo;
    private int pezziDisponibili;

  public Articolo(int codice, String descrizione, double prezzo, int pezziDisponibili){
      this.codice = codice;
      this.descrizione = descrizione;
      this.prezzo = prezzo;
      this.pezziDisponibili = pezziDisponibili;
  }

    public int getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getPezziDisponibili() {
        return pezziDisponibili;
    }

    public void setPezziDisponibili(int pezziDisponibili) {
        this.pezziDisponibili = pezziDisponibili;
    }
}
