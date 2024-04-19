package it.schipani.it.schipani.classes;

/*Creo una classe astratta, con i metodi che le effettive classi dovranno implementare*/
public abstract class ElementoMultimediale implements EM{

    private String titolo;
    private int durata;

    public ElementoMultimediale(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }


    public String getTitolo() {
        return titolo;
    }

    public int getDurata() {
        return durata;
    }

}
