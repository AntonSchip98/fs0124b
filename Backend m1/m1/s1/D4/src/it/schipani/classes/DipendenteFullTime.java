package it.schipani.classes;

public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(int matricola, double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    @Override
    public void calculateSalary() {
        System.out.println("Il dipendente full-time con matricola: " + getMatricola() + ", ha uno stipendio mensile di " + getStipendio());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
