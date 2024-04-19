package it.schipani.classes;

public abstract class Dipendente implements Check {
    private int matricola;
    private double stipendio;
    private Dipartimento dipartimento;

    public Dipendente(int matricola, double stipendio, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }

    public int getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }
    public abstract void calculateSalary();

    @Override
    public String toString() {
        return "Dipendente{" +
                "matricola=" + matricola +
                ", stipendio=" + stipendio +
                ", dipartimento=" + dipartimento +
                '}';
    }

    @Override
    public void checkIn() {
        if (this instanceof Dirigente) {
            System.out.println("Benvenuto, Dirigente!");
        } else if (this instanceof DipendenteFullTime){
            System.out.println("Il full-time inizia a lavorare alle 9");
        } else if (this instanceof DipendentePartTime) {
            System.out.println("Il part-time inizia a lavorare alle 13");
        }
    }
}
