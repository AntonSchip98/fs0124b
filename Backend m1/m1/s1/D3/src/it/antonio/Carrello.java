package it.antonio;

import java.util.Arrays;

public class Carrello {
    private Cliente cliente;
    private Articolo[] articoli;
    private double costoArticoli;

    public Carrello(Cliente cliente) {
        this.cliente = cliente;
        this.articoli = new Articolo[0];
        this.costoArticoli = 0.0;
    }

    public void aggiungiArticolo(Articolo articolo, int quantita) {
        int quanitaDisponibile = articolo.getPezziDisponibili();
        if (quanitaDisponibile > 0 && quantita <= quanitaDisponibile) {
            articolo.setPezziDisponibili(quanitaDisponibile - quantita);
            Articolo[] nuovoArray = Arrays.copyOf(articoli, articoli.length + quantita); // Creazione di un nuovo array con dimensione adeguata
            for (int i = 0; i < quantita; i++) {
                nuovoArray[articoli.length + i] = articolo; // Aggiunta dell'articolo all'array
            }
            articoli = nuovoArray; // Aggiornamento dell'array dell'istanza del carrello
            costoArticoli += articolo.getPrezzo() * quantita;
        }

    }


    public void rimuoviArticolo(Articolo articolo) {
        int index = -1;
        for (int i = 0; i < articoli.length; i++) {
            if (articoli[i] == articolo) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Articolo[] nuovoArray = new Articolo[articoli.length - 1];
            System.arraycopy(articoli, 0, nuovoArray, 0, index);
            System.arraycopy(articoli, index + 1, nuovoArray, index, articoli.length - index - 1);
            articoli = nuovoArray;
            costoArticoli -= articolo.getPrezzo();
        }
    }

    // Metodo per calcolare il costo totale degli articoli nel carrello
    public double calcolaCostoTotale() {
        return costoArticoli;
    }

    // Metodo per svuotare il carrello
    public void svuotaCarrello() {
        articoli = new Articolo[0];
        costoArticoli = 0.0;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setArticoli(Articolo[] articoli) {
        this.articoli = articoli;
    }

    public void setCostoArticoli(double costoArticoli) {
        this.costoArticoli = costoArticoli;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Articolo[] getArticoli() {
        return articoli;
    }

    public double getCostoArticoli() {
        return costoArticoli;
    }
}
