package it.schipani.it.schipani.classes;

public abstract class Elemento implements PlayOrShow {

    private String titolo;
    private ElementiMultimediali el;

    protected Elemento(String title, ElementiMultimediali el) {
        this.titolo = title;
        this.el = el;
    }

    public String getTitolo() {
        return titolo;
    }

    public ElementiMultimediali getEl() {
        return el;
    }

    @Override
    public String toString() {
        return "titolo='" + titolo + '\'' +
                ", el=" + el + ", ";
    }

    @Override
    public abstract void playOrShow();


}
