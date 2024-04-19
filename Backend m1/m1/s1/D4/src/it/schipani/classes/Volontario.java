package it.schipani.classes;

public class Volontario implements Check {
    private String nome;
    private int età;
    private String cv;

    public Volontario(String nome, int età, String cv) {
        this.nome = nome;
        this.età = età;
        this.cv = cv;
    }

    @Override
    public void checkIn() {
System.out.println("Il volontario deve andare a trovarsi un lavoro");
    }
}
